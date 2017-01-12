package CustomerAPI;

/**
 * Created by Nahuel on 10/1/2017.
 */

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import DTOs.InsumoDTO;
import DTOs.SectorDTO;
import DTOs.TipoInsumoDTO;
import DTOs.TokenDTO;
import sergioc6.stockserverandroid.TokenApplication;

import static android.content.ContentValues.TAG;

public class CustomerInsumos extends CustomerAPI {

    //ATRIBUTOS
    private static String insertar_insumo = "API_Insumos/insertarInsumo";
    private static String obtener_sectores = "API_Insumos/obtenerSectores";
    private static String obtener_tipos_insumos = "API_Insumos/obtenerTiposInsumos";
    private static String consultar_stock = "API_Insumos/consultarStock";
    private String token;
    private Context mContext;

    //METODOS
    public CustomerInsumos(String token, Context context) {
        this.token = token;
        this.mContext = context;
    }

    public void insertarInsumo(String nombre_insumo, String descripcion, int stock_min, int stock_max, String sector, String tipo_insumo) throws JSONException
    {
        //Armo el Json
        JSONObject json = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        json.put("nombre_insumo",nombre_insumo);
        json.put("descripcion", descripcion);
        json.put("stock_min", stock_min);
        json.put("stock_max", stock_max);
        json.put("sector", sector);
        json.put("tipo_insumo", tipo_insumo);

        jsonArray.put(json);

        //Genero la Petición
        JsonObjectRequest jsArrayRequest = new JsonObjectRequest(
                Request.Method.POST, // init método
                this.URL_BASE + insertar_insumo, // URL API
                json, // Parámetos a enviar en el POST
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(mContext, "¡Insumo insertado con éxito", Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() { //Tratamiento del error
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(mContext, "¡Error al insertar el nuevo insumo!", Toast.LENGTH_SHORT).show();
                    }
                }
        ) {//Seteo los headers
            @Override
            public HashMap<String, String> getHeaders() {
                HashMap<String, String> params = new HashMap<>();
                params.put("Content-Type", "application/json;charset=UTF-8");
                params.put("Accept", "application/json");
                params.put("token", token);
                return params;
            }
        };

        //Agrego la Petición a la cola de peticiones
        RequestQueue queue = CustomerSingleton.getInstance(this.mContext).getRequestQueue();
        queue.add(jsArrayRequest);
    }

    public void obtenerSectoresInsumosYTiposInsumos () {
        //Genero la Petición
        JsonArrayRequest jsArrayRequest = new JsonArrayRequest(
                Request.Method.POST, // init método
                this.URL_BASE + obtener_sectores, // URL API
                null, // Parámetos a enviar en el POST
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        JsonParser parser = new JsonParser();
                        JsonElement mJson =  parser.parse(response.toString());
                        Gson gson = new Gson();

                        Type collectionType = new TypeToken<ArrayList<SectorDTO>>() {}.getType();

                        ArrayList<SectorDTO> listaObtenidaSectores = gson.fromJson(mJson, collectionType);
                        obtenerTiposDeInsumos(listaObtenidaSectores);
                    }
                },
                new Response.ErrorListener() { //Tratamiento del error
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(mContext, "¡Error al obtener Sectores!", Toast.LENGTH_LONG).show();
                    }
                }
        ) {//Seteo los headers
            @Override
            public HashMap<String, String> getHeaders() {
                HashMap<String, String> params = new HashMap<>();
                params.put("Content-Type", "application/json;charset=UTF-8");
                params.put("Accept", "application/json");
                params.put("token", token);
                return params;
            }
        };

        //Agrego la Petición a la cola de peticiones
        RequestQueue queue = CustomerSingleton.getInstance(this.mContext).getRequestQueue();
        queue.add(jsArrayRequest);
    }


    public void obtenerTiposDeInsumos (final ArrayList<SectorDTO> listaObtenidaSectores) {
        //Genero la Petición
        JsonArrayRequest jsArrayRequest = new JsonArrayRequest(
                Request.Method.POST, // init método
                this.URL_BASE + obtener_tipos_insumos, // URL API
                null, // Parámetos a enviar en el POST
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        JsonParser parser = new JsonParser();
                        JsonElement mJson =  parser.parse(response.toString());
                        Gson gson = new Gson();

                        Type collectionType = new TypeToken<ArrayList<TipoInsumoDTO>>() {}.getType();

                        ArrayList<TipoInsumoDTO> listaObtenidaTipos = gson.fromJson(mJson, collectionType);
                        cargarVistaRegistrarInsumo(listaObtenidaSectores, listaObtenidaTipos);
                    }
                },
                new Response.ErrorListener() { //Tratamiento del error
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(mContext, "¡Error al obtener Tipos de Insumos!", Toast.LENGTH_LONG).show();
                    }
                }
        ) {//Seteo los headers
            @Override
            public HashMap<String, String> getHeaders() {
                HashMap<String, String> params = new HashMap<>();
                params.put("Content-Type", "application/json;charset=UTF-8");
                params.put("Accept", "application/json");
                params.put("token", token);
                return params;
            }
        };

        //Agrego la Petición a la cola de peticiones
        RequestQueue queue = CustomerSingleton.getInstance(this.mContext).getRequestQueue();
        queue.add(jsArrayRequest);
    }

    public void cargarVistaRegistrarInsumo(ArrayList<SectorDTO> listaObtenidaSectores, ArrayList<TipoInsumoDTO> listaObtenidaTipos)
    {
        Intent myIntent = new Intent(mContext, sergioc6.stockserverandroid.RegistrarInsumo.class);
        myIntent.putExtra("ListSectores", listaObtenidaSectores);
        myIntent.putExtra("ListTiposInsumos", listaObtenidaTipos);
        myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(myIntent);
    }


    public void consultarStockDeInsumo(String codigoInsumo) throws JSONException {
        //Armo el Json
        JSONObject json = new JSONObject();
        json.put("cod_insumo",codigoInsumo);

        //Genero la Petición
        JsonObjectRequest jsObjRequest = new JsonObjectRequest(
                Request.Method.POST, // init método
                this.URL_BASE + consultar_stock, // URL API
                json, // Parámetos a enviar en el POST
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        JsonParser mParser = new JsonParser();
                        JsonElement mJson =  mParser.parse(response.toString());
                        Gson gson = new Gson();

                        Type collectionType = new TypeToken<InsumoDTO>() {}.getType();
                        InsumoDTO insumoObtenido = gson.fromJson(mJson, collectionType);

                    }
                },
                new Response.ErrorListener() { //Tratamiento del error
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG, "Error Respuesta en JSON: " + error.getMessage());

                        CharSequence text = "No existe insumo para el código ingresado!";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(mContext, text, duration);
                        toast.show();
                    }
                }
        );

        //Agrego la Petición a la cola de peticiones
        RequestQueue queue = CustomerSingleton.getInstance(mContext).getRequestQueue();
        queue.add(jsObjRequest);
    }


}
