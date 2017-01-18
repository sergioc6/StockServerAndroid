package sergioc6.stockserverandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;


import com.google.zxing.Result;

import org.json.JSONException;

import CustomerAPI.CustomerInsumos;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

/**
 * Created by SergioC on 12/01/2017.
 */

public class ConsultarStock extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView mScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultarstock);
    }

    public void consultarStockManualClick (View v) throws JSONException {
        TokenApplication token = TokenApplication.getInstance();
        EditText editTextCodIns   = (EditText)findViewById(R.id.editTextCodIns);

        CustomerInsumos customerInsumos = new CustomerInsumos(token.getTokenGlobal(), getApplicationContext());
        customerInsumos.consultarStockDeInsumo(editTextCodIns.getText().toString());
    }

    public void consultarScanQR (View v) {
       mScannerView = new ZXingScannerView(this);   // Programmatically initialize the scanner view
       setContentView(mScannerView);
       mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
       mScannerView.startCamera(0);
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();   // Stop camera on pause
    }

    @Override
    public void handleResult(Result rawResult) {
        TokenApplication token = TokenApplication.getInstance();
        try {
            CustomerInsumos customerInsumos = new CustomerInsumos(token.getTokenGlobal(), getApplicationContext());
            customerInsumos.consultarStockDeInsumo(rawResult.getText());
        }
        catch (JSONException jsExc)
            {

        }
    }


    public void volverClick (View v) {
        Intent intent = new Intent(this, Principal.class);
        startActivity(intent);
    }



}
