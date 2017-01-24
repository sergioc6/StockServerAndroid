package sergioc6.stockserverandroid;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import DTOs.SectorDTO;

/**
 * Created by SergioC on 17/01/2017.
 */

public class ObtenerSectorFailed extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obtenersectorfailed);
    }



    public void consultarOtroInsumoClick(View v) {
        Intent intent = new Intent(this, ObtenerSector.class);
        startActivity(intent);
    }


    public void volverClick(View v) {
        Intent intent = new Intent(this, Principal.class);
        startActivity(intent);
    }



}
