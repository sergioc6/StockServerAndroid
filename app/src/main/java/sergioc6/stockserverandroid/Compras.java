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

import CustomerAPI.CustomerCompras;
import Token.TokenApplication;

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

        if (mEditTextNumOC.getText().length() > 0) {
            ProgressDialog progressDialog;
            progressDialog = ProgressDialog.show(this, "Buscando la Compra",
                    "Espere por favor...", true);

            //obtengo el Token Global
            TokenApplication tokenApp = TokenApplication.getInstance();

            CustomerCompras customerCompras = new CustomerCompras(tokenApp.getTokenGlobal(), getApplicationContext());
            customerCompras.confirmarRecepcionCompra(mEditTextNumOC.getText().toString(), progressDialog);
        } else {
            AlertDialog alertDialog = new AlertDialog.Builder(Compras.this).create();
            alertDialog.setTitle("Nª de Orden de Compra requerido!");
            alertDialog.setMessage("Por favor ingrese el Nº de la OC.");
            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }
    }


}
