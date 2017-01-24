package sergioc6.stockserverandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by SergioC on 16/01/2017.
 */

public class BuscarInsumoFailed extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_insumo_failed);
    }


    public void buscarOtroInsumoClick (View v) {
        Intent intent = new Intent(this, BuscarInsumo.class);
        startActivity(intent);
    }

    public void volverPrincipalClick (View v) {
        Intent intent = new Intent(this, Principal.class);
        startActivity(intent);
    }


}
