package com.example.jgallo.usuarios;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this,"BDusuarios",null,1);


    }

    public void onclick(View view) {

        Intent intent = null;

        switch (view.getId()){

            case R.id.btnG:
                intent = new Intent(MainActivity.this, RegistroActivity.class);
                break;
            case R.id.btnB:
                intent = new Intent(MainActivity.this,ConsultaActivity.class);
                break;
            case R.id.btnSpinner:
                intent = new Intent(MainActivity.this,SpinnerActivity.class);
                break;
            case R.id.btnList:
                intent = new Intent(MainActivity.this,ListViewActivity.class);
                break;
            case R.id.btnGMascota:
                intent = new Intent(MainActivity.this,RegistroMascotaActivity.class);
                break;
            case R.id.lvMascotas:
                intent = new Intent(MainActivity.this, ListaMascotasActivity.class);
                break;

        }

        startActivity(intent);

    }
}
