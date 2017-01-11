package sergioc6.stockserverandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import org.json.JSONException;

import CustomerAPI.CustomerCompras;
import CustomerAPI.CustomerProveedores;

/**
 * Created by SergioC on 10/01/2017.
 */

public class Compras extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmarcompra);
    }


    public void volverClick (View v) {
        Intent intent = new Intent(this, Principal.class);
        startActivity(intent);
    }


    public void confirmarCompraClick (View v) throws JSONException {
        EditText mEditTextNumOC  = (EditText)findViewById(R.id.editTextNumeroOC);

        //obtengo el Token Global
        TokenApplication tokenApp = TokenApplication.getInstance();

        CustomerCompras customerCompras = new CustomerCompras(tokenApp.getTokenGlobal(), getApplicationContext());
        customerCompras.confirmarRecepcionCompra(mEditTextNumOC.getText().toString());
    }


}
