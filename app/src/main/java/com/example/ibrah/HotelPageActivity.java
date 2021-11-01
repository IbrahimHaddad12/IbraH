package com.example.ibrah;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HotelPageActivity extends AppCompatActivity {


    private TextView textViewWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_page);

        textViewWelcome = findViewById(R.id.textViewWelcome);


        String name = getIntent().getStringExtra( "name");
        textViewWelcome.setText("Welcome "+name);

    }


}