package com.example.worldwanderers;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButtonToggleGroup;

public class InportPage extends AppCompatActivity
{


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.inport);



        Button camera_logo=findViewById(R.id.camera_logo);
        ImageView image_from_gallery=findViewById(R.id.image_from_gallery);



// arrow go back to main board
        ImageView arrowBack;

        arrowBack=findViewById(R.id.arrowBack);

        arrowBack.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InportPage.this, MainBoard.class);
                startActivity(intent);
            }

        });




        // gallery import

        Button blue_gallery_logo=findViewById(R.id.blue_gallery_logo);
        blue_gallery_logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent,1);

            }
        });


        //camera import
        camera_logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent image_from_gallery=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(image_from_gallery,2);

            }
        });

    }
   /* @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK && data!= null)
        {
            Uri selectedImage=data.getData();
            ImageView image_from_gallery=findViewById(R.id.image_from_gallery);
            image_from_gallery.setImageURI(selectedImage);
        }
    }*/





    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ImageView image_from_gallery=findViewById(R.id.image_from_gallery);
        if (resultCode == RESULT_OK) {
            if (requestCode == 2) {
                Bitmap img = (Bitmap) (data.getExtras().get("data"));

                // Check if img is not null before setting it
                if (img != null) {
                    image_from_gallery.setImageBitmap(img);
                } else {
                    // Handle the case where the Bitmap is null
                }
            } else if (requestCode == 1 && data != null) {
                Uri selectedImage = data.getData();
                image_from_gallery.setImageURI(selectedImage);
            }
        }
    }



}