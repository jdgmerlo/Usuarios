package com.example.jgallo.usuarios;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jgallo.usuarios.utilidades.Utilidades;

public class RegistroActivity extends AppCompatActivity {

    EditText et1, et2, et3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        et1 = (EditText) findViewById(R.id.id_usuario);
        et2 = (EditText) findViewById(R.id.nombre);
        et3 = (EditText) findViewById(R.id.telefono);



    }

    public void onclick(View view) {

        registrarUsuario();

    }

    private void registrarUsuario() {

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this,"BDusuarios",null,1);

        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Utilidades.C_ID,et1.getText().toString());
        values.put(Utilidades.C_NOMBRE,et2.getText().toString());
        values.put(Utilidades.C_TELEFONO,et3.getText().toString());

        Long idResultante = db.insert(Utilidades.T_USUARIOS,Utilidades.C_ID,values);

        Toast.makeText(getApplicationContext(),"Id_Registro"+idResultante,Toast.LENGTH_LONG).show();
        db.close();
    }
}
