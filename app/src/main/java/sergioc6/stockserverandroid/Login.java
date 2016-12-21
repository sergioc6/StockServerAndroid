package sergioc6.stockserverandroid;

import android.app.Activity;
import android.os.Bundle;

import java.util.List;

import CustomerAPI.CustomerProveedores;
import DTOs.ProveedorDTO;

public class Login extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        String token = "V3p60v6geu8Qc9OQB+R/jnseNd0SHqcxYZZfBbTsr3zHls0aiKEXxjUcIaoZW+RvdS0V8UoEdWHgd52sPuKQnQ==";
        CustomerProveedores customProv = new CustomerProveedores(token, getApplicationContext());

        List<ProveedorDTO> ListaProv = customProv.obtenerProveedores();

    }
}
