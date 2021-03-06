package com.map.proa7movil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

//PAGINA MOSTRAR MAPA
public class Main2Activity extends AppCompatActivity {
    //Variables para receptar URL
    WebView wv1;
    WebSettings web_Settings;

    //PERMISOS NUMERO TELEFONICO
    private static final int MY_PERMISSION_REQUEST_CALL_PHONE = 0;
    //Variable para almacenar el numero telefonico
    String phoneNo = ""; 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //VARIABLES PARA PAGINA WEB
        wv1=(WebView)findViewById(R.id.webView);
        //wv1.setOnTouchListener(this);


        web_Settings = wv1.getSettings();
        //Habilita el uso de JavaScript
        web_Settings.setJavaScriptEnabled(true);

        //REDIRECION A PAGINA WEB
        String URL=getIntent().getStringExtra("dato_URL");
        //wv1.setWebViewClient(new WebViewClient());
        wv1.setWebChromeClient(new WebChromeClient());
        wv1.getSettings().setJavaScriptEnabled(true);
        wv1.loadUrl(URL);

        //leer numTelefonico
        String numTelefonico = getIntent().getStringExtra("telefono");

        //Verificar numero telefonico
        if(numTelefonico != null){ //numTelefonico.length() >= 10
            //Se almacena el numero Telefonico en phoneNo
            phoneNo = numTelefonico;
            Toast.makeText(this,"Numero: "+phoneNo,Toast.LENGTH_LONG).show();
        }else{//No hay numero telefonico en numTelefonico
            //Pasara de pagina Mostrar mapa a pagina de Configuracion
            Intent intent  = new Intent(Main2Activity.this,Main3Activity.class);
            //Enviar el string "verdad" en la variable "sinNumero"
            intent.putExtra("sinNumero", "verdad");
            //Iniciar el paso de pagina
            startActivity(intent);
        }
    }

    ///////DECLARA VARIABLES DE BUTTON
    public void Llamar(View view){
        //Comprobar si existe "phoneNo"
        if (!TextUtils.isEmpty(phoneNo)) {
            //Asignacion a marcador "dial" para llamar
            String dial = "tel:" + phoneNo;
            //Comprobar permisos
            if (ActivityCompat.checkSelfPermission(Main2Activity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(Main2Activity.this, new String[]{Manifest.permission.CALL_PHONE}, MY_PERMISSION_REQUEST_CALL_PHONE);
            } else { //Se tiene los permisos
                try {
                    //Realiza la llamada
                    startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
                } catch (SecurityException e) {
                    e.printStackTrace();
                }
            }
        } else {//Envia un mensaje
            Toast.makeText(Main2Activity.this, "Ingresar un numero telefonico", Toast.LENGTH_LONG).show();
        }

    }
}
