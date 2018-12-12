package com.example.myapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class TransitionToPage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String price = intent.getStringExtra("price");
        String count = intent.getStringExtra("count");
        TextView nameTextView = findViewById(R.id.name_second);
        TextView surnameTextView = findViewById(R.id.price_second);
        TextView birthdayTextView = findViewById(R.id.count_second);
        nameTextView.setText(name);
        surnameTextView.setText(price);
        birthdayTextView.setText(count);
    }
}
