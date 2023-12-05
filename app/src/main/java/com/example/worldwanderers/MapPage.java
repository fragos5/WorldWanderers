package com.example.worldwanderers;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

public class MapPage extends AppCompatActivity {
    private GoogleMap mMap;
    private PopupWindow popupWindow;

    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.map);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {

                mMap = googleMap;
            }

        });



        ImageView arrowBack;
        arrowBack = findViewById(R.id.arrowBack);

        arrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapPage.this, MainBoard.class);
                startActivity(intent);
            }
        });

        Button b1, b2, openPopupButton;
        b1 = findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zoomIn();
            }
        });

        b2 = findViewById(R.id.button4);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zoomOut();
            }
        });

        openPopupButton = findViewById(R.id.openPopupButton);
        openPopupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupWindow();
            }
        });
    }

    // Method to handle zoom in
    private void zoomIn() {
        if (mMap != null) {
            mMap.animateCamera(CameraUpdateFactory.zoomIn());
        }
    }

    // Method to handle zoom out
    private void zoomOut() {
        if (mMap != null) {
            mMap.animateCamera(CameraUpdateFactory.zoomOut());
        }
    }

    // Method to show the popup window
    private void showPopupWindow() {
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_layout, null);

        // Find the close button in the popup layout
        Button closePopupButton = popupView.findViewById(R.id.closePopupButton);

        // Set a click listener for the close button
        closePopupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Dismiss the popup window when the close button is pressed
                if (popupWindow != null && popupWindow.isShowing()) {
                    popupWindow.dismiss();

                    // Make the "Open Popup" button visible again
                    findViewById(R.id.openPopupButton).setVisibility(View.VISIBLE);
                }
            }
        });


        // Create the popup window
        popupWindow = new PopupWindow(
                popupView,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                true
        );

        // Set content view
        popupWindow.setContentView(popupView);

        // Set the dismiss action when the popup is closed
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                // Handle any cleanup or actions after the popup is dismissed
            }
        });

        // Get the position of the "Open Popup" button
        int[] location = new int[2];
        findViewById(R.id.openPopupButton).getLocationOnScreen(location);
        int openButtonX = location[0];
        int openButtonY = location[1];

        // Hide the "Open Popup" button when the popup is shown
        findViewById(R.id.openPopupButton).setVisibility(View.INVISIBLE);

        // Show the popup window at the specified absolute position
        popupWindow.showAtLocation(popupView, Gravity.NO_GRAVITY, openButtonX, openButtonY);

        // Add a touch listener to make the popup movable
        popupView.setOnTouchListener(new View.OnTouchListener() {
            private float offsetX, offsetY;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // Increase the initial touch position offset
                        offsetX = event.getRawX() - popupWindow.getContentView().getX() * 2;
                        offsetY = event.getRawY() - popupWindow.getContentView().getY() * 2;
                        break;
                    case MotionEvent.ACTION_MOVE:
                        // Update the position of the popup window based on touch movement
                        popupWindow.update(
                                (int) (event.getRawX() - offsetX),
                                (int) (event.getRawY() - offsetY),
                                -1, -1, true);
                        break;
                }
                return true;
            }
        });

    }
}
