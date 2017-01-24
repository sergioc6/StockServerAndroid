package sergioc6.stockserverandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.zxing.Result;

import org.json.JSONException;

import CustomerAPI.CustomerInsumos;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

/**
 * Created by SergioC on 18/01/2017.
 */

public class BuscarInsumoQR extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView mScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_insumo);

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
            customerInsumos.buscarInsumo(rawResult.getText());
        }
        catch (JSONException jsExc)
        {

        }
    }

}
