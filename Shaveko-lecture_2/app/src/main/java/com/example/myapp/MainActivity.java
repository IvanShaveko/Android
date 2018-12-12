package com.example.myapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    private EditText productName;
    private EditText price;
    private EditText count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        productName = findViewById(R.id.name_main);
        price = findViewById(R.id.price_main);
        count = findViewById(R.id.count_main);
    }

    public void launchSecondActivity(View view) {
        Intent intent = new Intent(this, TransitionToPage.class);
        String name = productName.getText().toString();
        String priceOfProduct = price.getText().toString();
        String countProduct = count.getText().toString();
        intent.putExtra("name", name);
        intent.putExtra("price", priceOfProduct);
        intent.putExtra("count", countProduct);
        startActivity(intent);
    }
}
