package CustomerAPI;


import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.lang.reflect.Type;
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

    private List<ProveedorDTO> listadoProveedores;

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
                        Type collectionType = new TypeToken<List<ProveedorDTO>>() {}.getType();
                        List<ProveedorDTO> listaObtenidaProveedores = gson.fromJson(mJson, collectionType);

                        cargarProveedoresAlListado(listaObtenidaProveedores);
                    }
                },
                new Response.ErrorListener() { //Tratamiento del error
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(mContext, "Error Sending the request", Toast.LENGTH_LONG).show();
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
        CustomerSingleton.getInstance(this.mContext).addToRequestQueue(jsArrayRequest);
    }

    private void cargarProveedoresAlListado (List<ProveedorDTO> listaObtenidaProveedores){
        //Si esta cargada, la limpio y dejo vacia
        if (!this.listadoProveedores.isEmpty()) {
            this.listadoProveedores.clear();
        }
        //Cargo los proveedores a la variable de instancia
        for (ProveedorDTO prov : listaObtenidaProveedores) {
            this.listadoProveedores.add(prov);
        }
    }



}
