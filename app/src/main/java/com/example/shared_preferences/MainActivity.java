package com.example.shared_preferences;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {

    private int counter;
    private TextView textViewCounter;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewCounter = findViewById(R.id.textViewCounter);
        Button buttonIncrement = findViewById(R.id.buttonIncrement);
        Button buttonDecrement = findViewById(R.id.buttonDecrement);

        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        counter = sharedPreferences.getInt("counter", 0);
        textViewCounter.setText("Counter: " + counter);

        buttonIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                textViewCounter.setText("Counter: " + counter);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("counter", counter);
                editor.apply();
            }
        });

        buttonDecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter--;
                textViewCounter.setText("Counter: " + counter);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("counter", counter);
                editor.apply();
            }
        });
    }
}