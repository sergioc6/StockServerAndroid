package sergioc6.stockserverandroid;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;

import org.json.JSONException;

import CustomerAPI.CustomerInsumos;
import CustomerAPI.CustomerProveedores;
import DTOs.TokenDTO;

/**
 * Created by SergioC on 09/01/2017.
 */

public class Principal extends AppCompatActivity {


    //METODOS
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        TokenApplication tokenApp = TokenApplication.getInstance();

        //Cargo la imagen
        ImageView imageViewUsuario = (ImageView) findViewById(R.id.imageViewUsuario);
        byte[] decodedString = Base64.decode(tokenApp.getFotouser_base64(), Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        imageViewUsuario.setImageBitmap(decodedByte);
    }


    public void obtenerListadoProvClick (View v) throws JSONException {
        TokenApplication tokenApp = TokenApplication.getInstance();

        CustomerProveedores customerProveedores = new CustomerProveedores(tokenApp.getTokenGlobal(), getApplicationContext());
        customerProveedores.obtenerProveedores();
    }

    public void confirmarCompraClick (View v) {
        Intent intent = new Intent(this, Compras.class);
        startActivity(intent);
    }


    public void registrarInsumoNuevoClick (View v) {
        TokenApplication tokenApp = TokenApplication.getInstance();

        CustomerInsumos customerInsumos = new CustomerInsumos(tokenApp.getTokenGlobal(), getApplicationContext());
        customerInsumos.obtenerSectoresInsumosYTiposInsumos();
    }

    public void consultarStockClick (View v) {
        Intent intent = new Intent(this, ConsultarStock.class);
        startActivity(intent);
    }

    public void buscarInsumoClick(View v)
    {
        Intent intent = new Intent(this, BuscarInsumo.class);
        startActivity(intent);
    }

    public void obtenerSectorClick(View v)
    {
        Intent intent = new Intent(this, ObtenerSector.class);
        startActivity(intent);
    }


    public void cerrarSesionClick (View v) {
        TokenApplication tokenApp = TokenApplication.getInstance();
        tokenApp.deleteTokenGlobal();

        Intent i = getBaseContext().getPackageManager()
                .getLaunchIntentForPackage( getBaseContext().getPackageName() );
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }



    }
