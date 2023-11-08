package com.example.worldwanderers;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {



    //animation
    Animation wellcome_animation,backround_animation;
    ImageView image;

    FirebaseDatabase database;
    TextView textView;
    DatabaseReference databaseReference;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //remove bar on top of the screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //Animations
        wellcome_animation= AnimationUtils.loadAnimation(this,R.anim.wellcome_animations);
        backround_animation= AnimationUtils.loadAnimation(this,R.anim.backround_animation);


        //Hooks
        image=findViewById(R.id.logo);
        image.setAnimation(wellcome_animation);

        image=findViewById(R.id.first_backround);
        image.setAnimation(backround_animation);

        // write to database on create
        //Todo:move this part of the code to a button
        database=FirebaseDatabase.getInstance();
        databaseReference=database.getReference("Image 1");

        databaseReference.child("id").setValue("1");
        databaseReference.child("coordinates").setValue("kati kati");
        databaseReference.child("image").setValue("edw tha mpei eikona");
        databaseReference.child("hastags").setValue("#nofilter");


        //animation sthn arxh me ton logo
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,MainBoard.class);
                startActivity(intent);
                finish();
            }
        },2500);










    }
}