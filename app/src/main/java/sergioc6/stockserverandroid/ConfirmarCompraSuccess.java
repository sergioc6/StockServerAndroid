package sergioc6.stockserverandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import DTOs.CompraDTO;

/**
 * Created by SergioC on 11/01/2017.
 */

public class ConfirmarCompraSuccess extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmarcomprasuccess);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            int id_compra = extras.getInt("id_compra");
            int numero_oc = extras.getInt("numero_oc");
            String nombre_proveedor = extras.getString("nombre_proveedor");
            String monto = extras.getString("monto");
            String fecha = extras.getString("fecha");
            String estado = extras.getString("estado");

            TextView textViewNumOC = (TextView)findViewById(R.id.textViewNumOC);
            textViewNumOC.append(" "+Integer.toString(numero_oc));

            TextView textViewFecha = (TextView)findViewById(R.id.textViewFecha);
            textViewFecha.append(" "+fecha);

            TextView textViewMonto = (TextView)findViewById(R.id.textViewMonto);
            textViewMonto.append(" $"+monto);

            TextView textViewProveedor = (TextView)findViewById(R.id.textViewProveedor);
            textViewProveedor.append(" "+nombre_proveedor);

            TextView textViewEstado = (TextView)findViewById(R.id.textViewEstado);
            textViewEstado.append(" "+estado);
        }

    }

    public void volverClick (View v) {
        Intent intent = new Intent(this, Principal.class);
        startActivity(intent);
    }

    public void confirmarOtraRecepcionClick (View v) {
        Intent intent = new Intent(this, Compras.class);
        startActivity(intent);
    }


}
