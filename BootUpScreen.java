package com.example.hungrytime;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.content.Intent;


public class BootUpScreen extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boot_up_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent signInIntent = new Intent(BootUpScreen.this, SignIn.class);
                startActivity(signInIntent);
                finish();
            }

        }, SPLASH_TIME_OUT);
    }
}


