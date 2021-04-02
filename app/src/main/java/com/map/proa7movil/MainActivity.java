package com.map.proa7movil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//PAGINA INICIO
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //Metodo Mapa para ir a la pagina de mostrarMapa
    public void Mapa(View view){
        //Pasara de pagina Inicio a pagina mostrarMapa
        Intent i=new Intent( this, Main2Activity.class);
        //Asignar la URL de la pagina web
        String url = "http://proa7gps.byethost6.com/ubicarBici.php";
        //Enviamos la url por intent como variable "dato_URL"
        i.putExtra("dato_URL", url);
        //Iniciar el paso de pagina
        startActivity(i);
    }
    //Metodo Informacion para ir a la pagina de Informacion
    public void Informacion(View view){
        //Pasara de pagina Inicio a pagina de Informacion
        Intent i=new Intent( this, Main4Activity.class);
        //Asignar la URL de la pagina web
        String url = "http://proa7gps.byethost6.com/comoUsar.php";
        //Enviamos la url por intent como variable "dato_URL"
        i.putExtra("dato_URL", url); 
        //Iniciar el paso de pagina
        startActivity(i);
    }
    //Metodo numTelefonico para ir a la pagina de Configuracion
    public void numTelefonico(View view){
        //Pasara de pagina Inicio a pagina de Configuracion
        Intent i=new Intent( this, Main3Activity.class);
        //Iniciar el paso de pagina
        startActivity(i);
    }
}
