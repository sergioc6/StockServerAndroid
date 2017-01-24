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
 * Created by SergioC on 12/01/2017.
 */

public class ConsultarStock extends AppCompatActivity  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultarstock);
    }

    public void consultarStockManualClick (View v) throws JSONException {
        TokenApplication token = TokenApplication.getInstance();
        EditText editTextCodIns   = (EditText)findViewById(R.id.editTextCodIns);

        if (editTextCodIns.getText().length() > 0) {
            ProgressDialog progressDialog;
            progressDialog = ProgressDialog.show(this, "Buscando insumo",
                    "Espere por favor...", true);

            CustomerInsumos customerInsumos = new CustomerInsumos(token.getTokenGlobal(), getApplicationContext());
            customerInsumos.consultarStockDeInsumo(editTextCodIns.getText().toString(), progressDialog);
        } else {
            AlertDialog alertDialog = new AlertDialog.Builder(ConsultarStock.this).create();
            alertDialog.setTitle("Código de Insumo requerido!");
            alertDialog.setMessage("Por favor ingrese el código del insumo del cual que desea obtener su ubicación.");
            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }

    }

    public void consultarScanQR (View v) {
        Intent intent = new Intent(this, ConsultarStockQR.class);
        startActivity(intent);
    }




    public void volverClick (View v) {
        Intent intent = new Intent(this, Principal.class);
        startActivity(intent);
    }



}
