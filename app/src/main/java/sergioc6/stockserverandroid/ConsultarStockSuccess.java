package sergioc6.stockserverandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import DTOs.InsumoDTO;
import DTOs.ProveedorDTO;

/**
 * Created by SergioC on 16/01/2017.
 */

public class ConsultarStockSuccess extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultarstocksuccess);

        InsumoDTO insumo = (InsumoDTO) getIntent().getSerializableExtra("Insumo");

        // Instancio los textViews
        TextView textViewCodIns = (TextView)findViewById(R.id.textViewCodIns);
        TextView textViewNombreIns = (TextView)findViewById(R.id.textViewNombreIns);
        TextView textViewCantidad = (TextView)findViewById(R.id.textViewCantidad);

        //seteo los textos
        textViewCodIns.setText("Código del Insumo: "+insumo.getId_insumo());
        textViewNombreIns.setText("Nombre del Insumo: "+insumo.getNombre_insumo());
        textViewCantidad.setText("Cantidad: "+insumo.getCantidad());
    }


    public void consultarOtroInsumoClick (View v) {
        Intent intent = new Intent(this, ConsultarStock.class);
        startActivity(intent);
    }

    public void volverPrincipalClick (View v) {
        Intent intent = new Intent(this, Principal.class);
        startActivity(intent);
    }


}
