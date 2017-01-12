package sergioc6.stockserverandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import DTOs.ProveedorDTO;

/**
 * Created by SergioC on 10/01/2017.
 */

public class Proveedores extends AppCompatActivity {


    //METODOS
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listaproveedores);

        ArrayList<ProveedorDTO> listProv = (ArrayList<ProveedorDTO>) getIntent().getSerializableExtra("ListProv");

        ListView listViewProveedores = (ListView) findViewById(R.id.listViewProveedores);

        ArrayAdapter<ProveedorDTO> adapter = new ArrayAdapter<ProveedorDTO>(this, android.R.layout.simple_list_item_1, listProv);
        listViewProveedores.setAdapter(adapter);
    }


    public void volverClick (View v) {
        Intent intent = new Intent(this, Principal.class);
        startActivity(intent);
    }




}
