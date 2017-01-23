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
import android.net.Uri;
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


import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import DTOs.SectorDTO;

/**
 * Created by SergioC on 17/01/2017.
 */

public class ObtenerSectorSuccess extends AppCompatActivity implements LocationListener {

    private SectorDTO sector;

    double latitude = 0;
    double longitude = 0;
    LocationManager locationmanager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obtenersectorsuccess);

        sector = (SectorDTO) getIntent().getSerializableExtra("Sector");

        //Cargo el nombre del sector
        TextView textViewSectorNombre = (TextView) findViewById(R.id.textViewSectorNombre);
        textViewSectorNombre.setText(sector.getSector_deposito());

        //Cargo la latitud
        TextView textViewLatitud = (TextView) findViewById(R.id.textViewLatitud);
        textViewLatitud.setText("Latitud: " + sector.getLatitud());

        //Cargo la longitud
        TextView textViewLongitud = (TextView) findViewById(R.id.textViewLongitud);
        textViewLongitud.setText("Longitud: " + sector.getLongitud());

        //Cargo la imagen
        ImageView imageViewSector = (ImageView) findViewById(R.id.imageViewSector);
        byte[] decodedString = Base64.decode(sector.getFoto_base64(), Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(), decodedByte);
        roundedBitmapDrawable.setCornerRadius(50.0f);
        roundedBitmapDrawable.setAntiAlias(true);
        imageViewSector.setImageDrawable(roundedBitmapDrawable);

        locationmanager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Criteria cri = new Criteria();
        String provider = locationmanager.getBestProvider(cri, false);
        if (provider != null & !provider.equals("")) {
            // puede aparecer subrayado en rojo porque le faltaria un control, pero funciona igual
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            Location location = locationmanager.getLastKnownLocation(provider);
            locationmanager.requestLocationUpdates(provider,2000,1,new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    latitude = location.getLatitude();
                    longitude = location.getLongitude();
                }
                @Override
                public void onProviderDisabled(String provider) {
                    // TODO Auto-generated method stub
                }
                @Override
                public void onProviderEnabled(String provider) {
                    // TODO Auto-generated method stub
                }
                @Override
                public void onStatusChanged(String provider, int status,
                                            Bundle extras) {
                    // TODO Auto-generated method stub
                }
            });
                if(location!=null)
            {
                onLocationChanged(location);
            }
        }
    }


    public void actualizarUbicacionClick(View v) {
        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        //Checkeo si esta activado el GPS en el dispositivo
        if (!lm.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            mostrarAlertActivarGPS();
        } else {
            Location location = new Location("actual");
            location.setLongitude(getLongitude());
            location.setLatitude(getLatitude());
            cargarUbicacionActual(location);
        }
    }


    private void mostrarAlertActivarGPS() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Tu GPS está desactivado, ¿Querés activarlo?")
                .setTitle("GPS/Ubicación desactivado!")
                .setCancelable(false)
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(@SuppressWarnings("unused") final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                        startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                        dialog.cancel();
                    }
                });
        final AlertDialog alert = builder.create();
        alert.show();
    }

    private void cargarUbicacionActual(Location location) {
        //Cargo la latitud
        TextView textViewLatitudActual = (TextView) findViewById(R.id.textViewLatitudActual);
        textViewLatitudActual.setText("Latitud actual: " + location.getLatitude());

        //Cargo la longitud
        TextView textViewLongitudActual = (TextView) findViewById(R.id.textViewLongitudActual);
        textViewLongitudActual.setText("Longitud: " + location.getLongitude());

        //Cargo la distancia
        Location locationsector = new Location("SectorDeposito");
        locationsector.setLatitude(Double.parseDouble(sector.getLatitud()));
        locationsector.setLongitude(Double.parseDouble(sector.getLongitud()));
        float distancia = location.distanceTo(locationsector);

        TextView textViewDistancia = (TextView) findViewById(R.id.textViewDistancia);
        textViewDistancia.setText("Distancia: " + distancia + " metros");
    }


    public void consultarOtroInsumoClick(View v) {
        Intent intent = new Intent(this, ObtenerSector.class);
        startActivity(intent);
    }


    public void volverClick(View v) {
        Intent intent = new Intent(this, Principal.class);
        startActivity(intent);
    }



    //Fuera del onCreate van estos metodos
    @Override
    public void onLocationChanged(Location location) {
        latitude = location.getLatitude();
        longitude = location.getLongitude();
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {
    }

    @Override
    public void onProviderEnabled(String s) {
    }

    @Override
    public void onProviderDisabled(String s) {
    }

    // Usar en cualquier lado del código, es lo que obtiene la lat actualizada
    public double getLatitude() {
        return latitude;
    }

    // Usar en cualquier lado del código, es lo que obtiene la lng actualizada
    public double getLongitude() {
        return longitude;
    }

}
