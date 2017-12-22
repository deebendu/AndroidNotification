package com.github.rajeev02.androidnotification;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.rajeev02.androidnotificationlibrary.AppConstant;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppConstant.setmContext(MainActivity.this);
        AppConstant.setIntent(new Intent(MainActivity.this, MainActivity.class));

    }
}
