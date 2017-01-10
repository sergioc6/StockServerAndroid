package sergioc6.stockserverandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

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


}
