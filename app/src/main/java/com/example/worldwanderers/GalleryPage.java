package com.example.worldwanderers;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;

public class GalleryPage extends AppCompatActivity {
    private EditText location_text;
    ListView listView;
    String[] name = {"Mountains", "Sea", "Friends", "Family", "Sports", "Art"};

    ArrayAdapter<String> arrayAdapter;
    @Override
    public boolean onCreateOptionMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);

        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView menuItem.getActionView();
        SearchView.setQueryHint("Type here to search");

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
        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.gallery);
          ListView = findViewById(R.id.listview);

        arrayAdapter = new ArrayAdapter<String>( context: this, android.R.layout.simple_list_item_1,name);
        listView.setAdapter(arrayAdapter);


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
    } }
}