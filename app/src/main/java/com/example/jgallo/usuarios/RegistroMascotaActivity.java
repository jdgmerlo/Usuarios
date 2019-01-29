package com.example.jgallo.usuarios;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.jgallo.usuarios.entidades.Usuario;
import com.example.jgallo.usuarios.utilidades.Utilidades;

import java.util.ArrayList;

public class RegistroMascotaActivity extends AppCompatActivity {

    EditText NomMascota, RazaMascota;
    Spinner spDueniomascota;

    ArrayList<String> listaPersonas;
    ArrayList<Usuario> personasList;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_mascota);

        NomMascota = (EditText) findViewById(R.id.etNombreMascota);
        RazaMascota = (EditText) findViewById(R.id.etRaza);

        conn = new ConexionSQLiteHelper(getApplicationContext(),"BDusuarios",null,1);

        consultarListaPersonas();

        ArrayAdapter<CharSequence> adaptador = new ArrayAdapter(this,android.R.layout.simple_spinner_item,listaPersonas);
        spDueniomascota.setAdapter(adaptador);

    }

    private void consultarListaPersonas() {
        SQLiteDatabase db = conn.getReadableDatabase();

        Usuario persona = null;
        personasList = new ArrayList<Usuario>();

        Cursor cursor = db.rawQuery("SELECT * FROM "+Utilidades.T_USUARIOS,null);

        while (cursor.moveToNext()){
            persona = new Usuario();
            persona.setId(cursor.getInt(0));
            persona.setNombre(cursor.getString(1));
            persona.setTelefono(cursor.getString(2));

            personasList.add(persona);
        }
    obtenerLista();
    }

    private void obtenerLista() {

        listaPersonas = new ArrayList<String>();
        listaPersonas.add("Seleccione");

        for (int i = 0; i < personasList.size(); i++){
            listaPersonas.add(personasList.get(i).getId()+" - "+personasList.get(i).getNombre());
        }

    }
}
