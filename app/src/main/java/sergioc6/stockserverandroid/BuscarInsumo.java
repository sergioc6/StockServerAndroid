package sergioc6.stockserverandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import org.json.JSONException;

import CustomerAPI.CustomerInsumos;

/**
 * Created by Nahuel on 16/1/2017.
 */

public class BuscarInsumo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_insumo);
    }


    public void volverClick (View v) {
        Intent intent = new Intent(this, Principal.class);
        startActivity(intent);
    }

    public void buscarDatosInsumoClick (View v) throws JSONException {
        TokenApplication token = TokenApplication.getInstance();
        EditText editTextCodInsABuscar   = (EditText) findViewById(R.id.editTextCodInsABuscar);

        CustomerInsumos customerInsumos = new CustomerInsumos(token.getTokenGlobal(), getApplicationContext());
        customerInsumos.buscarInsumo(editTextCodInsABuscar.getText().toString());
    }



}
