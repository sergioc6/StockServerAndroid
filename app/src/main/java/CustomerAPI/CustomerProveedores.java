package CustomerAPI;


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

import DTOs.ProveedorDTO;


/**
 * Created by SergioC on 14/12/2016.
 */

public class CustomerProveedores extends CustomerAPI {

    //ATRIBUTOS
    private static String obtener_proveedores = "API_Proveedores/obtenerProveedores";
    private String token;
    private Context mContext;

    //METODOS
    public CustomerProveedores(String token, Context context) {
        this.token = token;
        this.mContext = context;
    }

    public void obtenerProveedores () {
        //Genero la Petición
        JsonArrayRequest jsArrayRequest = new JsonArrayRequest(
                Request.Method.POST, // init método
                this.URL_BASE + obtener_proveedores, // URL API
                null, // Parámetos a enviar en el POST
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        JsonParser parser = new JsonParser();
                        JsonElement mJson =  parser.parse(response.toString());
                        Gson gson = new Gson();

                        Type collectionType = new TypeToken<ArrayList<ProveedorDTO>>() {}.getType();

                        ArrayList<ProveedorDTO> listaObtenidaProveedores = gson.fromJson(mJson, collectionType);
                        cargarProveedores(listaObtenidaProveedores);
                    }
                },
                new Response.ErrorListener() { //Tratamiento del error
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(mContext, "Error enviando la solicitud al Servidor!", Toast.LENGTH_LONG).show();
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


    public void cargarProveedores(ArrayList<ProveedorDTO> listaProveedores) {
        Intent myIntent = new Intent(mContext, sergioc6.stockserverandroid.Proveedores.class);
        myIntent.putExtra("ListProv", listaProveedores);
        myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(myIntent);
    }


}
