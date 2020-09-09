package com.map.proa7movil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Mapa(View view){
        Intent i=new Intent( this, Main2Activity.class);
        String url = "http://proa7gps.byethost6.com/ubicarBici.php";
        i.putExtra("dato_URL", url);
        startActivity(i);
    }
    public void Informacion(View view){
        Intent i=new Intent( this, Main4Activity.class);
        String url = "http://proa7gps.byethost6.com/comoUsar.php";
        i.putExtra("dato_URL", url); //http://proa7gps.byethost6.com/funcionamiento.php
        startActivity(i);
    }
    public void numTelefonico(View view){
        Intent i=new Intent( this, Main3Activity.class);
        startActivity(i);
    }
}
