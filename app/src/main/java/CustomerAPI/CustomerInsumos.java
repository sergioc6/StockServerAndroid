package CustomerAPI;

/**
 * Created by Nahuel on 10/1/2017.
 */

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import DTOs.InsumoDTO;
import DTOs.SectorDTO;
import DTOs.TipoInsumoDTO;

public class CustomerInsumos extends CustomerAPI {

    //ATRIBUTOS
    private static String insertar_insumo = "API_Insumos/insertarInsumo";
    private static String obtener_sectores = "API_Insumos/obtenerSectores";
    private static String obtener_tipos_insumos = "API_Insumos/obtenerTiposInsumos";
    private String token;
    private Context mContext;

    //METODOS
    public CustomerInsumos(String token, Context context) {
        this.token = token;
        this.mContext = context;
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
}
