package com.example.worldwanderers;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.WindowManager;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class InportPage extends AppCompatActivity {
    private static final int PickImageRequest = 1;
    private Uri mImageUri;
    private StorageReference mStorageRef;
    private DatabaseReference mDatabaseRef;
    private Button submit_button;
    private ImageView mImageView;
    private EditText location_text,date_text,tags_text,comments_text;


    @SuppressLint("MissingInflatedId")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.inport);

        location_text = findViewById(R.id.location_text);
        date_text = findViewById(R.id.date_text);
        date_text = findViewById(R.id.date_text);
        tags_text = findViewById(R.id.tags_text);
        comments_text = findViewById(R.id.comments_text);

        Button camera_logo = findViewById(R.id.camera_logo);
        //sffd


// arrow go back to main board
        ImageView arrowBack;

        arrowBack = findViewById(R.id.arrowBack);

        arrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InportPage.this, MainBoard.class);
                startActivity(intent);
            }

        });


        // gallery import

        Button blue_gallery_logo = findViewById(R.id.blue_gallery_logo);
        blue_gallery_logo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                openFileChooser();
            }


        });

        mStorageRef = FirebaseStorage.getInstance().getReference("uploads");
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("uploads");
        mImageView = findViewById(R.id.mImageView);

        submit_button = findViewById(R.id.submit_button);
        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadImg();
            }
        });


        //camera import
        camera_logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent image_from_gallery = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(image_from_gallery, 2);
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == 2) {
                Bitmap img = (Bitmap) (data.getExtras().get("data"));

                // Check if img is not null before setting it
                if (img != null) {
                    mImageView.setImageBitmap(img);
                } else {
                    // Handle the case where the Bitmap is null
                }
            } else if (requestCode == 1 && data != null) {
                mImageUri = data.getData();
                Picasso.get().load(mImageUri).into(mImageView);
            }
        }



    }

    private void openFileChooser(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PickImageRequest);
    }

    private void uploadImg() {
        if (mImageUri != null) {
            StorageReference fileReference = mStorageRef.child(System.currentTimeMillis() + "." + getFileExtension(mImageUri));

            fileReference.putFile(mImageUri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Toast.makeText(InportPage.this,"upload successful",Toast.LENGTH_LONG).show();

                            Upload upload = new Upload(comments_text.getText().toString(),taskSnapshot.getMetadata().getReference().getDownloadUrl().toString(),
                                    location_text.getText().toString(),
                                    date_text.getText().toString(),
                                    tags_text.getText().toString());

                            String uploadId = mDatabaseRef.push().getKey();
                            mDatabaseRef.child(uploadId).setValue(upload);
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(InportPage.this,"upload failed",Toast.LENGTH_SHORT).show();
                        }
                    })
            ;

        } else {
            Toast.makeText(this,"None selected",Toast.LENGTH_SHORT).show();
        }
    }
    private String getFileExtension(Uri uri){
        ContentResolver cR = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));
    }




}