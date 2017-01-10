package sergioc6.stockserverandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.json.JSONException;

import CustomerAPI.CustomerProveedores;

/**
 * Created by SergioC on 09/01/2017.
 */

public class Principal extends AppCompatActivity {

    //ATRIBUTOS
    private static String token;

    //METODOS
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }


    public void obtenerListadoProvClick (View v) throws JSONException {
        CustomerProveedores customerProveedores = new CustomerProveedores(token, getApplicationContext());
        customerProveedores.obtenerProveedores();
    }







    }
