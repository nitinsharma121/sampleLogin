package com.example.nitinsharma.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        int secondsDelayed = 4;
        new Handler().postDelayed(new Runnable() {
            public void run() {
              /*  String tutorialKey = "SOME_KEY";
                Boolean firstTime = getPreferences(MODE_PRIVATE).getBoolean(tutorialKey, true);
                if (firstTime) {
                  // here you do what you want to do - an activity tutorial in my case
                    getPreferences(MODE_PRIVATE).edit().putBoolean(tutorialKey, false).apply();
                }else{
                startActivity(new Intent(SplashScreen.this,MainActivity.class));*/
                Intent i=new Intent(SplashScreen.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        }, secondsDelayed * 1000);
    }
}
