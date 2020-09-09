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
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    WebView wv1;
    WebSettings web_Settings;

    //PERMISOS NUMERO TELEFONICO
    private static final int MY_PERMISSION_REQUEST_CALL_PHONE = 0;
    String phoneNo = ""; // Almacena el numero telefonico

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //VARIABLES PARA PAGINA WEB
        wv1=(WebView)findViewById(R.id.webView);
        web_Settings = wv1.getSettings();
        web_Settings.setJavaScriptEnabled(true);

        //REDIRECION A PAGINA WEB
        String URL=getIntent().getStringExtra("dato_URL");
        wv1.setWebViewClient(new WebViewClient());
        wv1.loadUrl(URL);

        //leer numTelefonico
        String numTelefonico = getIntent().getStringExtra("telefono");

        //Verifico numero
        if(numTelefonico != null){ //numTelefonico.length() >= 10
            phoneNo = numTelefonico;
            Toast.makeText(this,"Numero: "+phoneNo,Toast.LENGTH_LONG).show();
        }else{
            Intent intent  = new Intent(Main2Activity.this,Main3Activity.class);
            intent.putExtra("sinNumero", "verdad");
            startActivity(intent);
        }
    }


    ///////DECLARA VARIABLES DE BUTTON
    public void Llamar(View view){

        if (!TextUtils.isEmpty(phoneNo)) {
            String dial = "tel:" + phoneNo;
            if (ActivityCompat.checkSelfPermission(Main2Activity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(Main2Activity.this, new String[]{Manifest.permission.CALL_PHONE}, MY_PERMISSION_REQUEST_CALL_PHONE);
            } else { //Se tiene los permisos
                try {
                    startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
                } catch (SecurityException e) {
                    e.printStackTrace();
                }
            }

        } else {
            Toast.makeText(Main2Activity.this, "Ingresar un numero telefonico", Toast.LENGTH_LONG).show();
        }

    }
}
