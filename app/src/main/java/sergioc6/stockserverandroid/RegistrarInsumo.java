package sergioc6.stockserverandroid;

import android.content.Intent;
import android.os.Bundle;
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
        ArrayAdapter<String> adapterSectores = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, listaSectoresStrings);
        adapterSectores.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinnerSectores = (Spinner) findViewById(R.id.spinnerSectorInsumo);
        spinnerSectores.setAdapter(adapterSectores);

        ArrayList<String> listaTiposStrings = new ArrayList<String>();
        for (TipoInsumoDTO tipo: listTiposInsumos) {
            listaTiposStrings.add(tipo.getTipo());
        }
        ArrayAdapter<String> adapterTipos = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, listaTiposStrings);
        adapterSectores.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinnerTipos = (Spinner) findViewById(R.id.spinnerTipoInsumo);
        spinnerTipos.setAdapter(adapterTipos);



    }

    public void registrarInsumoClick(View v) throws JSONException {
        EditText nombreInsumo = (EditText) findViewById(R.id.editNombreInsumo);
        String pNombreInsumo = nombreInsumo.getText().toString();

        EditText descripcionInsumo = (EditText) findViewById(R.id.editDescripcionInsumo);
        String pDescripcionInsumo = descripcionInsumo.getText().toString();

        EditText stockMin = (EditText) findViewById(R.id.editStockMinimo);
        int pStockMin = Integer.parseInt(stockMin.getText().toString());

        EditText stockMax = (EditText) findViewById(R.id.editStockMaximo);
        int pStockMax = Integer.parseInt(stockMax.getText().toString());

        Spinner spinnerTipoInsumo = (Spinner) findViewById(R.id.spinnerTipoInsumo);
        String pTipoInsumo = spinnerTipoInsumo.getSelectedItem().toString();

        Spinner spinnerSectorInsumo = (Spinner) findViewById(R.id.spinnerSectorInsumo);
        String pSectorInsumo = spinnerSectorInsumo.getSelectedItem().toString();

        TokenApplication tokenApplication = TokenApplication.getInstance();

        CustomerInsumos customerInsumos = new CustomerInsumos(tokenApplication.getTokenGlobal(), getApplicationContext());
        customerInsumos.insertarInsumo(pNombreInsumo, pDescripcionInsumo, pStockMin, pStockMax, pSectorInsumo, pTipoInsumo);

    }

    public void volverClick (View v) {
        Intent intent = new Intent(this, Principal.class);
        startActivity(intent);
    }
}
