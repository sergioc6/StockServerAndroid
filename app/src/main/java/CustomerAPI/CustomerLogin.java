package CustomerAPI;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static android.R.id.list;


/**
 * Created by SergioC on 16/12/2016.
 */

public class CustomerLogin extends CustomerAPI {

    //ATRIBUTOS
    private static final String doLogin = "API_Login/login";

    //MÉTODOS

/*
    public String doLogin (String usuario, String pass) throws JSONException {
        //Armo el Json
        JSONObject json = new JSONObject();
        json.put("usuario",usuario);
        json.put("pass", pass);

        //Genero la Petición
        JsonObjectRequest jsArrayRequest = new JsonArrayRequest(
                Request.Method.POST, // init método
                this.URL_BASE + doLogin, // URL API
                json, // Parámetos a enviar en el POST
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        String mJson =  response.toString();
                        Gson gson = new Gson();

                        List<ToDoEntry> entries = gson.fromJson(mJson, collectionType);

                        for (ToDoEntry todo : entries) {
                            list.add(todo);
                        }
                        adapter.notifyDataSetChanged();

                    }
                },
                new Response.ErrorListener() { //Tratamiento del error
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG, "Error Respuesta en JSON: " + error.getMessage());
                    }
                }
        );

        //Agrego la Petición a la cola de peticiones
        RequestQueue queue = CustomerSingleton.getInstance(this.getApplicationContext()).getRequestQueue();
        queue.add(jsArrayRequest);

        //Retorno

    }
*/

}
