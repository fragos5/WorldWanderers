package com.example.worldwanderers;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import androidx.appcompat.app.AppCompatActivity;

public class MainBoard extends AppCompatActivity {




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_board);

        TextView mapTextView = findViewById(R.id.maptext);

    /*    mapTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Replace the mapContainer with the SupportMapFragment
                SupportMapFragment mapFragment = new SupportMapFragment();

                // Add the OnMapReadyCallback implementation
                mapFragment.getMapAsync(new OnMapReadyCallback() {
                    @Override
                    public void onMapReady(GoogleMap googleMap) {
                        // Do operations on the map here if needed
                    }
                });

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.mapContainer, mapFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
*/

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main_board);

// when you press the options logo from main board you go to setting board
        ImageView optionsLogo;

        optionsLogo=findViewById(R.id.optionsLogo);

        optionsLogo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainBoard.this, OptionsPage.class);
                startActivity(intent);
            }
        });
//////////////////////////////////////////////////////////////////////////////////////
//

// when you press the inport logo or text inport or arrow logo inport from main board you go to setting board

        ImageView inportLogo;

        optionsLogo=findViewById(R.id.inportLogo);

        optionsLogo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainBoard.this, InportPage.class);
                startActivity(intent);
            }
        });

        TextView inporttext;

        inporttext=findViewById(R.id.inporttext);

        inporttext.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainBoard.this, InportPage.class);
                startActivity(intent);
            }
        });

        ImageView arrowlogoinport;

        arrowlogoinport=findViewById(R.id.arrowlogoinport);

        arrowlogoinport.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainBoard.this, InportPage.class);
                startActivity(intent);
            }
        });
/////////////////////////////////////////////////////////////////////////////////////////////

        // when you press the gallery logo or text gallery or arrow logo gallery from main board you go to setting board

        ImageView gallerylogo;

        gallerylogo=findViewById(R.id.gallerylogo);

        gallerylogo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainBoard.this, GalleryPage.class);
                startActivity(intent);
            }
        });

        TextView gallerytext;

        gallerytext=findViewById(R.id.gallerytext);

        gallerytext.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainBoard.this, GalleryPage.class);
                startActivity(intent);
            }
        });

        ImageView arrowlogogallery;

        arrowlogogallery=findViewById(R.id.arrowlogogallery);

        arrowlogogallery.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainBoard.this, GalleryPage.class);
                startActivity(intent);
            }
        });
/////////////////////////////////////////////////////////////////////////////////////////////

        // when you press the map logo or text map or arrow logo map from main board you go to setting board

        ImageView maplogo;

        maplogo=findViewById(R.id.maplogo);

        maplogo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainBoard.this, MapPage.class);
                startActivity(intent);
            }
        });

        TextView maptext;

        maptext=findViewById(R.id.maptext);

        maptext.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainBoard.this, MapPage.class);
                startActivity(intent);
            }
        });

        ImageView arrowlogomap;

        arrowlogomap=findViewById(R.id.arrowlogomap);

        arrowlogomap.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainBoard.this, MapPage.class);
                startActivity(intent);
            }
        });
/////////////////////////////////////////////////////////////////////////////////////////////


















    }
}