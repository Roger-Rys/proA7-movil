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

public class Main3Activity extends AppCompatActivity {
    private EditText et_numTelefonico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //SHAREDPREFERENCES
        et_numTelefonico=(EditText)findViewById(R.id.txt_numTelefonico);
        SharedPreferences preferences = getSharedPreferences("share", Context.MODE_PRIVATE);
        et_numTelefonico.setText(preferences.getString("numTelefonico",""));

        //Asignacion del TextView a variable
        String texto = et_numTelefonico.getText().toString();


        //Sin numero telefonico
        String SinnumTelefonico = getIntent().getStringExtra("sinNumero");
        
        if(texto.length()>=10 && ("verdad".equals(SinnumTelefonico))){
            Intent intent  = new Intent(Main3Activity.this,Main2Activity.class);
            //TELEFONO
            intent.putExtra("telefono", preferences.getString("numTelefonico",""));
            //URL
            String url = "http://proa7gps.byethost6.com/ubicarBici.php";
            intent.putExtra("dato_URL", url);
            startActivity(intent);
        }
    }

    //Metodo para el boton
    public void Guardar(View view){
        //SharedPreferences
        SharedPreferences preferences = getSharedPreferences("share",Context.MODE_PRIVATE);//
        SharedPreferences.Editor obj_editor = preferences.edit();//creamos una clase "Edito" con la clase SharedPref
        obj_editor.putString("numTelefonico", et_numTelefonico.getText().toString());
        obj_editor.commit();//guardara los datos dentro del SharedPreferences


        //Intent
            //TELEFONO
            Intent intent  = new Intent(Main3Activity.this,Main2Activity.class);
            intent.putExtra("telefono", preferences.getString("numTelefonico",""));
            //URL
            String url = "http://proa7gps.byethost6.com/ubicarBici.php";
            intent.putExtra("dato_URL", url);
        
        //Toast
        Toast.makeText(this,"Valor almacenado: "+preferences.getString("datos",""), Toast.LENGTH_LONG).show();
        startActivity(intent);
    }

}
