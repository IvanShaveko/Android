package com.example.akr19.bindingdata;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.akr19.bindingdata.databinding.ActivityMainBinding;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding dataBinding;
    int count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

     dataBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

     dataBinding.setTitle1("lol");

     dataBinding.btnChange.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             switch (count){
                 case 0:
                     dataBinding.tTitle1.setText("lol");
                     count++;
                     break;
                 case 1:
                     dataBinding.tTitle1.setText("kek");
                     count++;
                     break;
                 case 2:
                     dataBinding.tTitle1.setText("cheburek");
                     count = 0;
                     break;
             }
         }
     });

    }
}
