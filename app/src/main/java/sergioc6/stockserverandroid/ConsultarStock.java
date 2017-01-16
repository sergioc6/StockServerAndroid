package sergioc6.stockserverandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import org.json.JSONException;

import CustomerAPI.CustomerInsumos;

/**
 * Created by SergioC on 12/01/2017.
 */

public class ConsultarStock extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultarstock);
    }


    public void volverClick (View v) {
        Intent intent = new Intent(this, Principal.class);
        startActivity(intent);
    }


    public void consultarStockManualClick (View v) throws JSONException {
        TokenApplication token = TokenApplication.getInstance();
        EditText editTextCodIns   = (EditText)findViewById(R.id.editTextCodIns);

        CustomerInsumos customerInsumos = new CustomerInsumos(token.getTokenGlobal(), getApplicationContext());
        customerInsumos.consultarStockDeInsumo(editTextCodIns.getText().toString());
    }

}
