package com.example.jgallo.usuarios;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.jgallo.usuarios.entidades.Mascota;
import com.example.jgallo.usuarios.utilidades.Utilidades;

import java.util.ArrayList;

public class ListaMascotasActivity extends AppCompatActivity {

    ListView lvM;
    ArrayList<String> listaInformacion;
    ArrayList<Mascota> listaMascota;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_mascotas);

        lvM = (ListView) findViewById(R.id.lvMascotas);
        conn = new ConexionSQLiteHelper(getApplicationContext(),"BDusuarios",null,1);

        consultarListaMascotas();

        ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listaInformacion);
        lvM.setAdapter(adaptador);

        lvM.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Mascota mascota = listaMascota.get(position);

                Intent intent = new Intent(ListaMascotasActivity.this, DetalleMascotaActivity.class);
                Bundle bundle = new Bundle();

                bundle.putSerializable("mascota",mascota);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }

    private void consultarListaMascotas() {
        SQLiteDatabase db = conn.getReadableDatabase();

        Mascota mascota;
        listaMascota = new ArrayList<Mascota>();

        Cursor cursor = db.rawQuery("SELECT * FROM " +Utilidades.T_MASCOTA,null);

        while(cursor.moveToNext()){

            mascota = new Mascota();
            mascota.setIdMascota(cursor.getInt(0));
            mascota.setNombbreMascota(cursor.getString(1));
            mascota.setRaza(cursor.getString(2));
            mascota.setIdDuenio(cursor.getInt(3));
            listaMascota.add(mascota);
        }

        obtenerListaMascotas();

    }

    private void obtenerListaMascotas() {
        listaInformacion = new ArrayList<String>();

        for(int i = 0; i < listaMascota.size(); i++){
            listaInformacion.add(listaMascota.get(i).getIdMascota()+" - "+listaMascota.get(i).getNombbreMascota());
        }

    }
}
