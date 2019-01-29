package com.example.jgallo.usuarios;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.jgallo.usuarios.entidades.Mascota;
import com.example.jgallo.usuarios.entidades.Usuario;
import com.example.jgallo.usuarios.utilidades.Utilidades;

public class DetalleMascotaActivity extends AppCompatActivity {

    TextView nombreUsuario, telefonoUsuario, nombreMascota, razaMascota, idMascota, idUsuario;
    ConexionSQLiteHelper conn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_mascota);

        idUsuario = (TextView) findViewById(R.id.tvUid);
        nombreUsuario = (TextView) findViewById(R.id.tvUnombre);
        telefonoUsuario = (TextView) findViewById(R.id.tvUtelefono);

        idMascota = (TextView) findViewById(R.id.tvMid);
        nombreMascota = (TextView) findViewById(R.id.tvMnombre);
        razaMascota = (TextView) findViewById(R.id.tvMraza);


        Bundle objetoEnviado = getIntent().getExtras();
        Mascota mascota = null;

        if(objetoEnviado != null){
            mascota = (Mascota) objetoEnviado.getSerializable("mascota");
            idMascota.setText(mascota.getIdMascota().toString());
            nombreMascota.setText(mascota.getNombbreMascota().toString());
            razaMascota.setText(mascota.getRaza().toString());
            consultarPersona(mascota.getIdDuenio());
        }

    }

    private void consultarPersona(Integer idPersona) {
        SQLiteDatabase db = conn.getReadableDatabase();
        String[] parametros = {idPersona.toString()};
        String[] campos = {Utilidades.C_NOMBRE, Utilidades.C_TELEFONO};

        try {
            Cursor cursor = db.query(Utilidades.T_USUARIOS,campos,Utilidades.C_ID+"=? ",parametros,null,null,null,null);
            cursor.moveToFirst();
            idUsuario.setText(idPersona.toString());
            nombreUsuario.setText(cursor.getString(1));
            telefonoUsuario.setText(cursor.getString(2));
            cursor.close();
        }catch (Exception e){
            nombreUsuario.setText("");
            telefonoUsuario.setText("");
        }


    }
}
