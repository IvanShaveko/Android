package com.example.myapp;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    private EditText productName;
    private EditText priceOfProduct;
    private EditText countProduct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        productName = findViewById(R.id.name_main);
        priceOfProduct = findViewById(R.id.price_main);
        countProduct = findViewById(R.id.count_main);
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        this.recreate();
    }

    public void launchSecondActivity(View view) {
        Intent intent = new Intent(this, TransitionToSecond.class);
        String name = productName.getText().toString();
        String price = priceOfProduct.getText().toString();
        String count = countProduct.getText().toString();
        intent.putExtra("name", name);
        intent.putExtra("price", price);
        intent.putExtra("count", count);
        startActivity(intent);
    }
}
