package sergioc6.stockserverandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Nahuel on 10/1/2017.
 */

public class Insumos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_insumo);
    }

    public void volverClick (View v) {
        Intent intent = new Intent(this, Principal.class);
        startActivity(intent);
    }
}
