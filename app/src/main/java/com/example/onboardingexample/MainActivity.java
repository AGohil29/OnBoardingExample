package com.example.onboardingexample;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences onBoardingScreen = getSharedPreferences("onBoardingScreen", MODE_PRIVATE);
        boolean isFirstTime = onBoardingScreen.getBoolean("firstTime", true);

        if (isFirstTime) {
            SharedPreferences.Editor editor = onBoardingScreen.edit();
            editor.putBoolean("firstTime", true);
            editor.apply();

            startActivity(new Intent(MainActivity.this, OnBoardingActivity.class));
        }
    }
}
