package com.example.worldwanderers;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class GalleryPage extends AppCompatActivity {
    private EditText location_text;

    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.gallery);

        ImageView arrowBack;

        arrowBack = findViewById(R.id.arrowBack);

        //buttons sto gallery
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button button10 = findViewById(R.id.button10);


        location_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(location_text.getText())) {
                    // Εάν το location EditText είναι ήδη κενό, μην κάνετε τίποτα
                } else {
                    // Κάντε ό,τι θέλετε όταν πατηθεί το EditText της τοποθεσίας
                }
            }
        });
        {
       /*     button3.setOnClickListener(new View.OnClickListener() {
        });
            @Override
            public void onClick(View v){

            }
        }*/

            arrowBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(GalleryPage.this, MainBoard.class);
                    startActivity(intent);
                }

            });

        }
    }
}

