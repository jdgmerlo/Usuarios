package com.example.jgallo.usuarios;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.jgallo.usuarios.entidades.Usuario;
import com.example.jgallo.usuarios.utilidades.Utilidades;

import java.util.ArrayList;

public class RegistroMascotaActivity extends AppCompatActivity {

    EditText NomMascota, RazaMascota;
    Spinner spDueniomascota;
    Button btnGM;

    ArrayList<String> listaPersonas;
    ArrayList<Usuario> personasList;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_mascota);

        NomMascota = (EditText) findViewById(R.id.etNombreMascota);
        RazaMascota = (EditText) findViewById(R.id.etRaza);
        spDueniomascota = (Spinner) findViewById(R.id.spDuenio_Mascota);
        btnGM = (Button) findViewById(R.id.btnGuardarMascota);

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

    public void onclick(View view) {
        guardarMascota();
    }

    private void guardarMascota() {
        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Utilidades.C_NOMBRE_MASCOTA, NomMascota.getText().toString());
        values.put(Utilidades.C_RAZA_MASCOTA, RazaMascota.getText().toString());

        int idCombo = (int) spDueniomascota.getSelectedItemId();

        if(idCombo != 0){
            int idDuenio = personasList.get(idCombo-1).getId();
            values.put(Utilidades.C_ID_DUENIO, idDuenio);

            Long idResultante = db.insert(Utilidades.T_MASCOTA, Utilidades.C_ID_MASCOTA, values);
            Toast.makeText(getApplicationContext(),"Mascota Guardada...", Toast.LENGTH_LONG).show();
            db.close();
        }else{
            Toast.makeText(getApplicationContext(),"Ingrese un dueño...", Toast.LENGTH_LONG).show();
        }


    }
}
