package sergioc6.stockserverandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import DTOs.InsumoDTO;

/**
 * Created by SergioC on 16/01/2017.
 */

public class ConsultarStockFailed extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultarstockfailed);
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
