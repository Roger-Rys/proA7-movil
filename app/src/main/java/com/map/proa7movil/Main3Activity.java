package com.map.proa7movil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;

//PAGINA CONFIGURACION
public class Main3Activity extends AppCompatActivity {
    private EditText et_numTelefonico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //SHAREDPREFERENCES
        //Variable receptora del EditText
        et_numTelefonico=(EditText)findViewById(R.id.txt_numTelefonico);
        //Declaracion de SharedPreferences como preferences
        SharedPreferences preferences = getSharedPreferences("share", Context.MODE_PRIVATE);
        //Asignacion la variable "numTelefonico" en preferences
        et_numTelefonico.setText(preferences.getString("numTelefonico",""));

        //Asignar el contenido de TextView a una variable
        String texto = et_numTelefonico.getText().toString();

        //Sin numero telefonico, obtiene un valor
        String SinnumTelefonico = getIntent().getStringExtra("sinNumero");
        
        //Comparacion si tiene o no un numero telefonico 
        if(texto.length()>=10 && ("verdad".equals(SinnumTelefonico))){
            //Pasara de pagina Configuracion a pagina de mostrar mapa
            Intent intent  = new Intent(Main3Activity.this,Main2Activity.class);
            //Asignar el numero TELEFONO que almacena "numTelefonico" a la variable "telefono"  
            intent.putExtra("telefono", preferences.getString("numTelefonico",""));
            //URL
            String url = "http://proa7gps.byethost6.com/ubicarBici.php";
            //Enviamos la url por intent como variable "dato_URL"
            intent.putExtra("dato_URL", url);
            //Iniciar el paso de pagina
            startActivity(intent);
        }
    }

    //Metodo para el boton
    public void Guardar(View view){
        //SharedPreferences
        SharedPreferences preferences = getSharedPreferences("share",Context.MODE_PRIVATE);//
        //creamos una clase "Editor" con la clase SharedPreferences
        SharedPreferences.Editor obj_editor = preferences.edit();
        //Con el "Editor" se puede asignarle el numero telefonico al "numTelefonico"
        obj_editor.putString("numTelefonico", et_numTelefonico.getText().toString());
        //guardara los datos dentro del SharedPreferences
        obj_editor.commit();
        //Intent
            //TELEFONO
            //Pasara de pagina Configuracion a pagina de mostrar mapa
            Intent intent  = new Intent(Main3Activity.this,Main2Activity.class);
            //Asignar el numero TELEFONO que almacena "numTelefonico" a la variable "telefono"
            intent.putExtra("telefono", preferences.getString("numTelefonico",""));
            //URL
            String url = "http://proa7gps.byethost6.com/ubicarBici.php";
            //Iniciar el paso de pagina
            intent.putExtra("dato_URL", url);
        
        //Toast es un mensaje que se muestra por pantalla
        Toast.makeText(this,"Valor almacenado: "+preferences.getString("datos",""), Toast.LENGTH_LONG).show();
        startActivity(intent);
    }
}
