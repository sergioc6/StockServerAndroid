package CustomerAPI;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.session.MediaSession;
import android.support.v7.app.AlertDialog;
import android.support.v7.view.ContextThemeWrapper;
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
import java.security.Principal;
import java.util.List;

import DTOs.TokenDTO;
import sergioc6.stockserverandroid.Login;
import sergioc6.stockserverandroid.R;
import sergioc6.stockserverandroid.TokenApplication;

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
    public CustomerLogin(Context mContext) {
        this.mContext = mContext;
    }

    public void doLogin (String usuario, String pass) throws JSONException {
        //Armo el Json
        JSONObject json = new JSONObject();
        json.put("usuario",usuario);
        json.put("pass", pass);

        //Genero la Petición
        JsonObjectRequest jsObjRequest = new JsonObjectRequest(
                Request.Method.POST, // init método
                this.URL_BASE + doLogin, // URL API
                json, // Parámetos a enviar en el POST
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        JsonParser mParser = new JsonParser();
                        JsonElement mJson =  mParser.parse(response.toString());
                        Gson gson = new Gson();
                        Type collectionType = new TypeToken<TokenDTO>() {}.getType();

                        TokenDTO token = gson.fromJson(mJson, collectionType);

                        TokenApplication tokenApp = TokenApplication.getInstance();
                        tokenApp.setTokenGlobal(token.getToken());
                        tokenApp.setFotouser_base64(token.getFoto_base64());
                        cargarPrincipal(token);
                    }
                },
                new Response.ErrorListener() { //Tratamiento del error
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG, "Error Respuesta en JSON: " + error.getMessage());

                        CharSequence text = "Fallo en el ingreso! Verifique los datos";
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

    public void cargarPrincipal(TokenDTO token) {
        Intent myIntent = new Intent(mContext, sergioc6.stockserverandroid.Principal.class);
        myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        myIntent.putExtra("token", token);
        mContext.startActivity(myIntent);
    }
}
