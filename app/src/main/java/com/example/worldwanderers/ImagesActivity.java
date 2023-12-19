package com.example.worldwanderers;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

public class ImagesActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ImageAdapter mAdapter;
    private DatabaseReference mDatabaseRef;
    private List<Upload> mUploads;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mUploads = new ArrayList<>();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference().child("uploads");
        mDatabaseRef.addValueEventListener(new ValueEventListener() {
          ArrayList<String> list = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                 for(DataSnapshot postSnapshot : snapshot.getChildren() ) {
                     String name = postSnapshot.child("name").getValue().toString();
                     String imageUrl = postSnapshot.child("imageUri").getValue().toString();
                     String location = postSnapshot.child("location").getValue().toString();
                     String date = postSnapshot.child("date").getValue().toString();
                     String tag = postSnapshot.child("tag").getValue().toString();

                     Upload upload = new Upload(name, imageUrl, location, date, tag);
                     mUploads.add(upload);
                 }
                mAdapter = new ImageAdapter(ImagesActivity.this,mUploads);
                mRecyclerView.setAdapter(mAdapter);// edw
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ImagesActivity.this,error.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

    }
}