package com.example.jgallo.usuarios;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetalleUsuarioActivity extends AppCompatActivity {

    TextView tId, tNom, tTel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_usuario);

        tId = (TextView) findViewById(R.id.txtId);
        tNom = (TextView) findViewById(R.id.txtNom);
        tTel = (TextView) findViewById(R.id.txtTel);


    }
}
