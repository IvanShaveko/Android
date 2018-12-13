package com.example.akr19.service;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{

    private Button start,stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startService(View view){
        Intent intent = new Intent(this,ServiceTask.class);
        startService(intent);
    }

    public void stopService(View view){
        Intent intent = new Intent(this,ServiceTask.class);
        stopService(intent);
    }
}
