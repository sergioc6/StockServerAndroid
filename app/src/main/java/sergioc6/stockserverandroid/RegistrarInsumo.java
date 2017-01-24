package sergioc6.stockserverandroid;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import org.json.JSONException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import CustomerAPI.CustomerInsumos;
import DTOs.ProveedorDTO;
import DTOs.SectorDTO;
import DTOs.TipoInsumoDTO;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

/**
 * Created by Nahuel on 10/1/2017.
 */

public class RegistrarInsumo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_insumo);

        ArrayList<SectorDTO> listSectores = (ArrayList<SectorDTO>) getIntent().getSerializableExtra("ListSectores");
        ArrayList<TipoInsumoDTO> listTiposInsumos = (ArrayList<TipoInsumoDTO>) getIntent().getSerializableExtra("ListTiposInsumos");

        ArrayList<String> listaSectoresStrings = new ArrayList<String>();
        for (SectorDTO sector: listSectores) {
            listaSectoresStrings.add(sector.getSector_deposito());
        }
        ArrayAdapter<String> adapterSectores = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listaSectoresStrings);
        adapterSectores.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinnerSectores = (Spinner) findViewById(R.id.spinnerSectorInsumo);
        spinnerSectores.setAdapter(adapterSectores);

        ArrayList<String> listaTiposStrings = new ArrayList<String>();
        for (TipoInsumoDTO tipo: listTiposInsumos) {
            listaTiposStrings.add(tipo.getTipo());
        }
        ArrayAdapter<String> adapterTipos = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listaTiposStrings);
        adapterSectores.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinnerTipos = (Spinner) findViewById(R.id.spinnerTipoInsumo);
        spinnerTipos.setAdapter(adapterTipos);



    }

    public void registrarInsumoClick(View v) throws JSONException {

        EditText nombreInsumo = (EditText) findViewById(R.id.editNombreInsumo);
        //String pNombreInsumo = nombreInsumo.getText().toString();

        EditText descripcionInsumo = (EditText) findViewById(R.id.editDescripcionInsumo);
        //String pDescripcionInsumo = descripcionInsumo.getText().toString();

        EditText stockMin = (EditText) findViewById(R.id.editStockMinimo);
        //int pStockMin = Integer.parseInt(stockMin.getText().toString());

        EditText stockMax = (EditText) findViewById(R.id.editStockMaximo);
        //int pStockMax = Integer.parseInt(stockMax.getText().toString());

        Spinner spinnerTipoInsumo = (Spinner) findViewById(R.id.spinnerTipoInsumo);
        //String pTipoInsumo = spinnerTipoInsumo.getSelectedItem().toString();

        Spinner spinnerSectorInsumo = (Spinner) findViewById(R.id.spinnerSectorInsumo);
        //String pSectorInsumo = spinnerSectorInsumo.getSelectedItem().toString();


        //Chequeo que los campos no sean nulos
        if (nombreInsumo.getText().length() == 0) {
            AlertDialog alertDialog = new AlertDialog.Builder(RegistrarInsumo.this).create();
            alertDialog.setTitle("Nombre de Insumo requerido!");
            alertDialog.setMessage("Por favor ingrese un nombre para el insumo.");
            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        } else if (descripcionInsumo.getText().length() == 0) {
            AlertDialog alertDialog = new AlertDialog.Builder(RegistrarInsumo.this).create();
            alertDialog.setTitle("Descripción de insumo requerida!");
            alertDialog.setMessage("Por favor ingrese una descripción para el insumo.");
            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        } else if (stockMax.getText().length() == 0) {
            AlertDialog alertDialog = new AlertDialog.Builder(RegistrarInsumo.this).create();
            alertDialog.setTitle("Stock Máximo requerido!");
            alertDialog.setMessage("Por favor ingrese un stock máximo.");
            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        } else if (stockMin.getText().length() == 0) {
            AlertDialog alertDialog = new AlertDialog.Builder(RegistrarInsumo.this).create();
            alertDialog.setTitle("Stock Mínimo requerido!");
            alertDialog.setMessage("Por favor ingrese stock mínimo.");
            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();

        } else {
            //Envío la petición
            TokenApplication tokenApplication = TokenApplication.getInstance();

            CustomerInsumos customerInsumos = new CustomerInsumos(tokenApplication.getTokenGlobal(), getApplicationContext());
            customerInsumos.insertarInsumo(nombreInsumo.getText().toString(), descripcionInsumo.getText().toString(), Integer.parseInt(stockMin.getText().toString()), Integer.parseInt(stockMax.getText().toString()), spinnerSectorInsumo.getSelectedItem().toString(), spinnerTipoInsumo.getSelectedItem().toString());
        }
    }

    public void volverClick (View v) {
        Intent intent = new Intent(this, Principal.class);
        startActivity(intent);
    }
}
