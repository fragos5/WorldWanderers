package com.example.worldwanderers;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FormActivity extends AppCompatActivity {

    private EditText locationEditText, commentsEditText, hashtagsEditText, dateEditText;
    private CheckBox autofillCheckBox, anotherCheckBox;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inport);

        autofillCheckBox = findViewById(R.id.checkBox);
        anotherCheckBox = findViewById(R.id.checkBox3);
        submitButton = findViewById(R.id.submit_button);

        setupListeners();
    }

    private void setupListeners() {
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
            }
        });

        locationEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(locationEditText.getText())) {
                    // Εάν το location EditText είναι ήδη κενό, μην κάνετε τίποτα
                } else {
                    // Κάντε ό,τι θέλετε όταν πατηθεί το EditText της τοποθεσίας
                }
            }
        });

        commentsEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   if (TextUtils.isEmpty(commentsEditText.getText())) {
                // Εάν το comments EditText είναι ήδη κενό, μην κάνετε τίποτα
            } else {
                // Κάντε ό,τι θέλετε όταν πατηθεί το EditText των σχολίων
            }
        }
    });

        hashtagsEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(commentsEditText.getText())) {
                    // Εάν το comments EditText είναι ήδη κενό, μην κάνετε τίποτα
                } else {
                    // Κάντε ό,τι θέλετε όταν πατηθεί το EditText των σχολίων
                }
            }
        });

        dateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(commentsEditText.getText())) {
                    // Εάν το comments EditText είναι ήδη κενό, μην κάνετε τίποτα
                } else {
                    // Κάντε ό,τι θέλετε όταν πατηθεί το EditText των σχολίων
                }

            }
        });

        autofillCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Κάντε ό,τι θέλετε όταν αλλάξει η κατάσταση του CheckBox "Autofill"
            }
        });

        anotherCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Κάντε ό,τι θέλετε όταν αλλάξει η κατάσταση του άλλου CheckBox
            }
        });
    }

    private void submitForm() {
        // Εδώ μπορείτε να πάρετε τις τιμές από τα TextViews
        String location = locationEditText.getText().toString();
        String comments = commentsEditText.getText().toString();
        String hashtags = hashtagsEditText.getText().toString();
        String date = dateEditText.getText().toString();

        // Εδώ μπορείτε να πάρετε την κατάσταση των CheckBoxes
        boolean isAutofillChecked = autofillCheckBox.isChecked();
        boolean isAnotherCheckBoxChecked = anotherCheckBox.isChecked();

        // Εκτελέστε τη λογική που θέλετε με τα δεδομένα
        String resultMessage = "Location: " + location +
                "\nComments: " + comments +
                "\nHashtags: " + hashtags +
                "\nDate: " + date +
                "\nAutofill Checked: " + isAutofillChecked +
                "\nAnother Checkbox Checked: " + isAnotherCheckBoxChecked;

        Toast.makeText(FormActivity.this, resultMessage, Toast.LENGTH_LONG).show();
    }
}