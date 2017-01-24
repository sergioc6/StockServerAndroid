package sergioc6.stockserverandroid;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import org.json.JSONException;

import java.security.*;
import java.util.List;

import CustomerAPI.CustomerLogin;
import CustomerAPI.CustomerProveedores;
import DTOs.ProveedorDTO;

import static java.sql.Types.NULL;

public class Login extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void doLoginButtonClick (View v) throws JSONException {
        EditText mEditTextEmail   = (EditText)findViewById(R.id.editTextEmail);
        EditText mEditTextCont   = (EditText)findViewById(R.id.editTextCont);

        if (this.isValidEmail(mEditTextEmail.getText())) {
            if(mEditTextCont.getText().length() > 0) {
                ProgressDialog progressDialog;
                progressDialog = ProgressDialog.show(this, "Iniciando Sesión",
                        "Espere por favor...", true);

                CustomerLogin customerLogin = new CustomerLogin(getApplicationContext());
                customerLogin.doLogin(mEditTextEmail.getText().toString(), mEditTextCont.getText().toString(), progressDialog);

            }else {
                AlertDialog alertDialog = new AlertDialog.Builder(Login.this).create();
                alertDialog.setTitle("Contraseña requerida!");
                alertDialog.setMessage("Por favor ingrese una contraseña.");
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
            }
        } else {
            AlertDialog alertDialog = new AlertDialog.Builder(Login.this).create();
            alertDialog.setTitle("Email Inválido!");
            alertDialog.setMessage("Por favor ingrese una dirección de Email correcta.");
            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }

    }

    public final static boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }


    public void salirButtonClick (View v) {
        finish();
        System.exit(0);
    }


    }




