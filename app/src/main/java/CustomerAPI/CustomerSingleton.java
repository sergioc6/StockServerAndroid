package CustomerAPI;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by SergioC on 15/12/2016.
 *
 * EJEMPLO DE USO
 * // Obtener una cola de peticiones RequestQueue.
         RequestQueue queue = CustomerSingleton.getInstance(this.getApplicationContext()).getRequestQueue();

 // Agregar una peticion ,Request , (en este ejemplo, llamada stringRequest) a tu cola de peticiones RequestQueue.
         CustomerSingleton.getInstance(this).addToRequestQueue(stringRequest);
 *
 */

public final class CustomerSingleton {

    //Atributos
    private static CustomerSingleton instance;
    private RequestQueue mRequestQueue;
    private static Context mCtx;

    //METODOS

    /**
     * Constructor
     * @param context
     */
    private CustomerSingleton(Context context) {
        mCtx = context;
        mRequestQueue = getRequestQueue();

    }

    public static synchronized CustomerSingleton getInstance(Context context) {
        if (instance == null) {
            instance = new CustomerSingleton(context);
        }
        return instance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return mRequestQueue;
    }


    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }


}
