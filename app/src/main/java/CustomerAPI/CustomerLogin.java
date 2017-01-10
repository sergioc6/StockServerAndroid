package CustomerAPI;

import android.content.Context;
import android.media.session.MediaSession;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.security.Principal;
import java.util.List;

import DTOs.TokenDTO;

import static android.R.id.list;
import static android.content.ContentValues.TAG;


/**
 * Created by SergioC on 16/12/2016.
 */

public class CustomerLogin extends CustomerAPI {

    //ATRIBUTOS
    private static final String doLogin = "API_Login/login";
    private Context mContext;


    //MÉTODOS
    public void doLogin (String usuario, String pass) throws JSONException {
        //Armo el Json
        JSONObject json = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        json.put("usuario",usuario);
        json.put("pass", pass);
        jsonArray.put(json);

        //Genero la Petición
        JsonArrayRequest jsArrayRequest = new JsonArrayRequest(
                Request.Method.POST, // init método
                this.URL_BASE + doLogin, // URL API
                jsonArray, // Parámetos a enviar en el POST
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        String mJson =  response.toString();
                        Gson gson = new Gson();
                        Type collectionType = new TypeToken<List<TokenDTO>>() {}.getType();

                        List<TokenDTO> entries = gson.fromJson(mJson, collectionType);


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
        RequestQueue queue = CustomerSingleton.getInstance(mContext).getRequestQueue();
        queue.add(jsArrayRequest);
    }


}
