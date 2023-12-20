package com.example.worldwanderers;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;

public class GalleryPage extends AppCompatActivity {

    ListView listView;
    String[] name = {"Mountains", "Sea", "Friends & Family", "Sports", "Arts", "Music"};

    ArrayAdapter<String> arrayAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery);


        listView = findViewById(R.id.listView);

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,name);
        listView.setAdapter(arrayAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                if (position == 0) {
                    startActivity(new Intent(GalleryPage.this, Mountains.class));
                } else if (position == 1) {
                    startActivity(new Intent(GalleryPage.this,Sea.class));
                } else if (position == 2) {
                    startActivity(new Intent(GalleryPage.this, FriendsFamily.class));
                } else if (position == 3) {
                    startActivity(new Intent(GalleryPage.this, Sports.class));
                } else if (position == 4) {
                    startActivity(new Intent(GalleryPage.this, Arts.class));
                } else {
                    startActivity(new Intent(GalleryPage.this, Music.class));

                }
            }
        });


        ImageView arrowBack;

        arrowBack = findViewById(R.id.arrowBack);


        arrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GalleryPage.this, MainBoard.class);
                startActivity(intent);
            }

        });

    }

    public boolean onCreateOptionMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);

        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Type here to search");


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {

                  arrayAdapter.getFilter().filter(newText);

                return false;

            }
        });

        return super.onCreateOptionsMenu(menu);



     }
}