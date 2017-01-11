package CustomerAPI;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
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
import java.util.HashMap;
import java.util.List;

import DTOs.CompraDTO;
import DTOs.InsumoDTO;
import sergioc6.stockserverandroid.ConfirmarCompraSuccess;
import sergioc6.stockserverandroid.Login;

/**
 * Created by SergioC on 11/01/2017.
 */

public class CustomerCompras extends CustomerAPI{
    //ATRIBUTOS
    private static String confirmar_recepcion = "API_Compras/confirmarRecepcionCompra";
    private String token;
    private Context mContext;

    //METODOS
    public CustomerCompras(String token, Context context) {
        this.token = token;
        this.mContext = context;
    }

    public void confirmarRecepcionCompra (String numeroOrdenCompra) throws JSONException {
        //Armo el JSON
        JSONObject json = new JSONObject();
        json.put("numordencompra",numeroOrdenCompra);

        //Genero la Petición
        JsonObjectRequest jsObjRequest = new JsonObjectRequest(
                Request.Method.POST, // init método
                this.URL_BASE + confirmar_recepcion, // URL API
                json, // Parámetos a enviar en el POST
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        JsonParser parser = new JsonParser();
                        JsonElement mJson =  parser.parse(response.toString());
                        Gson gson = new Gson();

                        Type collectionType = new TypeToken<CompraDTO>() {}.getType();
                        CompraDTO compraModificada = gson.fromJson(mJson, collectionType);

                        mostrarCompraModificada(compraModificada);
                    }
                },
                new Response.ErrorListener() { //Tratamiento del error
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(mContext, "¡No se encontro la Orden de Compra! Verifique el número por favor.", Toast.LENGTH_LONG).show();
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
        queue.add(jsObjRequest);
    }

    public void mostrarCompraModificada (CompraDTO compra) {
        Intent intent = new Intent(mContext, ConfirmarCompraSuccess.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("id_compra", compra.getId_compra());
        intent.putExtra("numero_oc", compra.getNumero_oc());
        intent.putExtra("nombre_proveedor", compra.getNombre_proveedor());
        intent.putExtra("monto", compra.getMonto());
        intent.putExtra("fecha", compra.getFecha());
        intent.putExtra("estado", compra.getEstado());
        mContext.startActivity(intent);
    }


}
