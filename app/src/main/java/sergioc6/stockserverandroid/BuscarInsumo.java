package sergioc6.stockserverandroid;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import org.json.JSONException;

import CustomerAPI.CustomerInsumos;
import Token.TokenApplication;

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

        if (editTextCodInsABuscar.getText().length() > 0) {
            ProgressDialog progressDialog;
            progressDialog = ProgressDialog.show(this, "Buscando insumo",
                    "Espere por favor...", true);

            CustomerInsumos customerInsumos = new CustomerInsumos(token.getTokenGlobal(), getApplicationContext());
            customerInsumos.buscarInsumo(editTextCodInsABuscar.getText().toString(), progressDialog);
        } else {
            AlertDialog alertDialog = new AlertDialog.Builder(BuscarInsumo.this).create();
            alertDialog.setTitle("Código de Insumo requerido!");
            alertDialog.setMessage("Por favor ingrese el código del insumo que desea obtener.");
            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }
    }

    public void buscarDatosInsumoQRClick (View v) {
        Intent intent = new Intent(this, BuscarInsumoQR.class);
        startActivity(intent);
    }



}
