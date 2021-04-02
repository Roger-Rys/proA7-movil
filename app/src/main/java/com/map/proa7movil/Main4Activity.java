package com.map.proa7movil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

//PAGINA INFORMACION
public class Main4Activity extends AppCompatActivity {
    //Variables para receptar URL
    WebView wv1;
    WebSettings web_Settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        //VARIABLES PARA PAGINA WEB
        wv1=(WebView)findViewById(R.id.webView);
        web_Settings = wv1.getSettings();
        //Habilita el uso de JavaScript
        web_Settings.setJavaScriptEnabled(true);
        //REDIRECION A PAGINA WEB
        String URL=getIntent().getStringExtra("dato_URL");
        wv1.setWebViewClient(new WebViewClient());
        wv1.loadUrl(URL);
    }
}
