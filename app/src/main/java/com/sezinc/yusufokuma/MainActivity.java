package com.sezinc.yusufokuma;

import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
String yazim="";

    TextToSpeech textToSpeech;
    Button konus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        konus = (Button) findViewById(R.id.btnKonus);
        textToSpeech =new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    //-- Türkçe okuması için
                    textToSpeech.setLanguage(new Locale("tr","TR"));
                } else {
                    Log.e("HATA","Okuma Hatası Oluştu");
                }
            }
        });
        konus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //-- TextView deki yazı alınır.
                TextView textYaziOku=(TextView) findViewById(R.id.textView);

                CharSequence charSequence = textYaziOku.getText();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                    //-- konuşma işlemini başlatmak için speak() metodunu kullanıyoruz
                    textToSpeech.speak(charSequence,TextToSpeech.QUEUE_FLUSH,null,null);
                }
            }
        });
    }

    public void basE(View v){
        yazim+="e";
        display(yazim);
    }
    public void basL(View v){
        yazim+="l";
        display(yazim);
    }
    public void basA(View v){
        yazim+="a";
        display(yazim);
    }
    public void basK(View v){
        yazim+="k";
        display(yazim);
    }
    public void display(String yazi){
        TextView textYazi=(TextView) findViewById(R.id.textView);
        textYazi.setText(yazi);
    }

    public void basReset(View v) {
        yazim ="";
        display(yazim);
    }
}
