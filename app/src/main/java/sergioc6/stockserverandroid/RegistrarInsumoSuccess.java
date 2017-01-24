package sergioc6.stockserverandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import CustomerAPI.CustomerInsumos;
import DTOs.InsumoDTO;


/**
 * Created by SergioC on 20/01/2017.
 */

public class RegistrarInsumoSuccess extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_insumo_success);

        InsumoDTO insumo = (InsumoDTO) getIntent().getSerializableExtra("Insumo");

        //Cargo el Text View
        TextView textViewNuevoInsumo = (TextView)findViewById(R.id.textViewNuevoInsumo);
        textViewNuevoInsumo.setText(insumo.toString());
    }


    public void registrarOtroInsumoClick (View v) {
        TokenApplication tokenApp = TokenApplication.getInstance();

        CustomerInsumos customerInsumos = new CustomerInsumos(tokenApp.getTokenGlobal(), getApplicationContext());
        customerInsumos.obtenerSectoresInsumosYTiposInsumos();
    }

    public void volverClick (View v) {
        Intent intent = new Intent(this, Principal.class);
        startActivity(intent);
    }



}