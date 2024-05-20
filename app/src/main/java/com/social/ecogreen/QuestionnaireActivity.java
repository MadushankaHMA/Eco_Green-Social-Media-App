package com.social.ecogreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class QuestionnaireActivity extends AppCompatActivity {

    private Spinner spiTypeSpinner;
    private Spinner citySpinner;
    private Button questionnaireButton;
    private String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire);

        spiTypeSpinner = findViewById(R.id.spi_type_spinner);
        citySpinner = findViewById(R.id.city_spinner);
        questionnaireButton = findViewById(R.id.questionnaireBtn); // Update button ID

        // Retrieve UID passed from registration
        uid = getIntent().getStringExtra("uid");

        // Sample Data Arrays
        String[] spiTypes = {"1", "2", "3", "4", "5", "6"};
        String[] cities = {"Colombo", "Gampaha", "Malambe", "Kandy", "Galle", "Homagama","Kiribathgoda", "Yakkala", "Maharagama", "Kadawatha", "Ragama", "Jafna", "Nugegoda"};

        // Adapters for Spinners
        ArrayAdapter<String> spiTypeAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, spiTypes);
        spiTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spiTypeSpinner.setAdapter(spiTypeAdapter);

        ArrayAdapter<String> cityAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, cities);
        cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        citySpinner.setAdapter(cityAdapter);

        questionnaireButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveQuestionnaireDataToFirestore();
            }
        });
    }
    private void saveQuestionnaireDataToFirestore() {
        String selectedSpiType = spiTypeSpinner.getSelectedItem().toString();
        String selectedCity = citySpinner.getSelectedItem().toString();

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("Users").document(uid)
                .update("spi_type", selectedSpiType, "location", selectedCity)
                .addOnSuccessListener(aVoid -> {
                    Toast.makeText(QuestionnaireActivity.this, "Data Saved!", Toast.LENGTH_SHORT).show();

                    // Start MainActivity
                    Intent intent = new Intent(QuestionnaireActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish(); // Close the QuestionnaireActivity
                })
                .addOnFailureListener(e -> Toast.makeText(QuestionnaireActivity.this, "Error saving data!", Toast.LENGTH_SHORT).show());
    }
}
