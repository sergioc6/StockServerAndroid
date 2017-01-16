package sergioc6.stockserverandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import DTOs.InsumoDTO;

/**
 * Created by Nahuel on 16/1/2017.
 */

public class BuscarInsumoSuccess extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_insumo_success);

        InsumoDTO insumo = (InsumoDTO) getIntent().getSerializableExtra("Insumo");

        // Instancio los textViews
        TextView textViewCodInsEncontrado = (TextView)findViewById(R.id.textViewCodInsEncontrado);
        TextView textViewNombreInsEncontrado = (TextView)findViewById(R.id.textViewNombreInsEncontrado);
        TextView textViewDescInsEncontrado = (TextView)findViewById(R.id.textViewDescInsEncontrado);

        //seteo los textos
        textViewCodInsEncontrado.setText("Código del Insumo: "+insumo.getId_insumo());
        textViewNombreInsEncontrado.setText("Nombre del Insumo: "+insumo.getNombre_insumo());
        textViewDescInsEncontrado.setText("Descripción: "+insumo.getDescripcion());
    }

    public void volverClick (View v) {
        Intent intent = new Intent(this, BuscarInsumo.class);
        startActivity(intent);
    }
}
