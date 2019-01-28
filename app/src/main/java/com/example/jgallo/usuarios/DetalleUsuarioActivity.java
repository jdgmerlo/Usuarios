package com.example.jgallo.usuarios;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.jgallo.usuarios.entidades.Usuario;

import java.io.Serializable;

public class DetalleUsuarioActivity extends AppCompatActivity {

    TextView tId, tNom, tTel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_usuario);

        tId = (TextView) findViewById(R.id.txtId);
        tNom = (TextView) findViewById(R.id.txtNom);
        tTel = (TextView) findViewById(R.id.txtTel);


        Bundle objetoEnviado = getIntent().getExtras();
        Usuario user = null;

        if(objetoEnviado != null){
            user = (Usuario) objetoEnviado.getSerializable("usuario");

            tId.setText(user.getId().toString());
            tNom.setText(user.getNombre().toString());
            tTel.setText(user.getTelefono().toString());

        }


    }
}
