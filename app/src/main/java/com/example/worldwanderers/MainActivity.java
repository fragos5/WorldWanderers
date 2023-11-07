package com.example.worldwanderers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database;
    TextView textView;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void writeButton(View view) {
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("Image 1");

        databaseReference.child("id").setValue("1");
        databaseReference.child("coordinates").setValue("kati kati");
        databaseReference.child("image").setValue("edw tha mpei eikona");
        databaseReference.child("hastags").setValue("#nofilter");
    }

}