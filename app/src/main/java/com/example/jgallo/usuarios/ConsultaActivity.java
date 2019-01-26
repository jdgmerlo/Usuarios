package com.example.jgallo.usuarios;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jgallo.usuarios.utilidades.Utilidades;

public class ConsultaActivity extends AppCompatActivity {


    EditText et1, et2, et3;

    ConexionSQLiteHelper conn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);

        conn = new ConexionSQLiteHelper(getApplicationContext(),"BDusuarios",null,1);

        et1 = (EditText) findViewById(R.id.documento);
        et2 = (EditText) findViewById(R.id.nombre);
        et3 = (EditText) findViewById(R.id.telefono);



    }

    public void onclick(View view) {

        switch (view.getId())
        {
            case R.id.btnBuscar:
                consultar();
                break;
        }

    }

    private void consultar() {
        SQLiteDatabase db = conn.getReadableDatabase();
        String[] parametros = {et1.getText().toString()};
        String[] campos = {Utilidades.C_NOMBRE,Utilidades.C_TELEFONO};


        try {
            Cursor cursor = db.query(Utilidades.T_USUARIOS,campos,Utilidades.C_ID+"=?",parametros,null,null,null);
            cursor.moveToFirst();
            et2.setText(cursor.getString(0));
            et3.setText(cursor.getString(1));
            cursor.close();
        }catch (Exception ex){
            Toast.makeText(getApplicationContext(),"No existe",Toast.LENGTH_LONG).show();
            limpiar();
        }


    }

    private void limpiar() {
        et2.setText("");
        et3.setText("");
    }
}
