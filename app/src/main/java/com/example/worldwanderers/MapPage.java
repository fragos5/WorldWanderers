package com.example.worldwanderers;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MapPage extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.map);

        ImageView arrowBack;

        arrowBack=findViewById(R.id.arrowBack);

        arrowBack.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapPage.this, MainBoard.class);
                startActivity(intent);
            }

        });
    }
}
