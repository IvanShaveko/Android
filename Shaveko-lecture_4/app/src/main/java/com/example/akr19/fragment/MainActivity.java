package com.example.akr19.fragment;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Change(View view){
        Fragment fragment=null;

        switch (view.getId()){
            case R.id.button:
                fragment = new FirstPage();
                break;
            case R.id.button2:
                fragment = new SecondPage();
                break;
        }

        FragmentManager fa = getSupportFragmentManager();
        FragmentTransaction fr = fa.beginTransaction();
        fr.replace(R.id.fr_place,fragment);
        fr.commit();
    }
}
