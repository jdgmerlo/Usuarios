package com.example.jgallo.usuarios;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.jgallo.usuarios.entidades.Usuario;
import com.example.jgallo.usuarios.utilidades.Utilidades;

import java.util.ArrayList;

public class SpinnerActivity extends AppCompatActivity {

    Spinner spinner;
    TextView id_user, nom, tel;
    ArrayList<String> personasLista;
    ArrayList<Usuario> usuariosLista;

    ConexionSQLiteHelper conn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        conn = new ConexionSQLiteHelper(getApplicationContext(),"BDusuarios",null,1);

        spinner = (Spinner) findViewById(R.id.spUsuarios);
        id_user = (TextView) findViewById(R.id.twId);
        nom = (TextView) findViewById(R.id.twNombre);
        tel = (TextView) findViewById(R.id.twTelefono);
        
        consultaListaUsuarios();

        ArrayAdapter<CharSequence> adaptador = new ArrayAdapter(this,android.R.layout.simple_spinner_item,personasLista);
        spinner.setAdapter(adaptador);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(position != 0){
                    id_user.setText(usuariosLista.get(position-1).getId().toString());
                    nom.setText(usuariosLista.get(position-1).getNombre());
                    tel.setText(usuariosLista.get(position-1).getTelefono());
                }else{
                    id_user.setText("");
                    nom.setText("");
                    tel.setText("");
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        
    }

    private void consultaListaUsuarios() {
        SQLiteDatabase db = conn.getReadableDatabase();

        Usuario persona = null;
        usuariosLista = new ArrayList<Usuario>();

        Cursor cursor = db.rawQuery("SELECT * FROM "+ Utilidades.T_USUARIOS,null);

        while(cursor.moveToNext()){
            persona = new Usuario();
            persona.setId(cursor.getInt(0));
            persona.setNombre(cursor.getString(1));
            persona.setTelefono(cursor.getString(2));

            usuariosLista.add(persona);
        }


     obtenerLista();


    }

    private void obtenerLista() {
        personasLista = new ArrayList<String>();

        personasLista.add("Seleccione");

        for(int i = 0; i < usuariosLista.size() ;i++){
            personasLista.add(usuariosLista.get(i).getId()+" - "+usuariosLista.get(i).getNombre());
        }

    }
}
