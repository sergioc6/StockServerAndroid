package sergioc6.stockserverandroid;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import org.json.JSONException;

import CustomerAPI.CustomerInsumos;

/**
 * Created by SergioC on 17/01/2017.
 */

public class ObtenerSector extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obtenersector);
    }


    public void buscarSectorClick (View v) throws JSONException {
        TokenApplication token = TokenApplication.getInstance();
        EditText editTextCodIns   = (EditText)findViewById(R.id.editTextCodInsumoDeposito);

        if (editTextCodIns.getText().length() != 0) {
            CustomerInsumos customerInsumos = new CustomerInsumos(token.getTokenGlobal(), getApplicationContext());
            customerInsumos.obtenerSectorInsumo(editTextCodIns.getText().toString());
        }
        else {
            AlertDialog alertDialog = new AlertDialog.Builder(ObtenerSector.this).create();
            alertDialog.setTitle("Código de insumo requerido!");
            alertDialog.setMessage("Por favor ingrese el Código del Insumo.");
            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }
    }

    public void buscarSectorQRClick (View v) {
        Intent intent = new Intent(this, ObtenerSectorQR.class);
        startActivity(intent);
    }



    public void volverClick (View v) {
        Intent intent = new Intent(this, Principal.class);
        startActivity(intent);
    }




}
