package com.example.myapplication1kt;

import android.content.Intent;
import android.graphics.Camera;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.speech.RecognizerIntent;
import android.widget.Toast;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Locale;

public class Dashboard extends AppCompatActivity {

    private static final int SPEECH_REQUEST_CODE = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Button btnActivate = findViewById(R.id.btnActivate);


        btnActivate.setOnClickListener(view -> startVoiceRecognition());

    }

    private void startVoiceRecognition() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

        try {
            startActivityForResult(intent, SPEECH_REQUEST_CODE);
        } catch (Exception e) {
            Toast.makeText(this, "Speech recognition is not supported on your device.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SPEECH_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            ArrayList<String> results = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            if (results != null && !results.isEmpty()) {
                String command = results.get(0).toLowerCase();

                if (command.contains("home")) {
                    navigateToHomePage();
                }  if (command.contains("settings")) {
                navigateToSettings();
                } if (command.contains("rid")) {
                    realtime();
                } if (command.contains("ocr")) {
                    OCR();
                }  if (command.contains("asv")) {
                    ASV();

                }
                else {
                    Toast.makeText(this, "Command not recognized: " + command, Toast.LENGTH_SHORT).show();
                }
            }
        }

    }

    private void navigateToHomePage() {

        Toast.makeText(this, "Navigating to Home...", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, Dashboard.class);
        startActivity(intent);
    }
    private void navigateToSettings() {
        Toast.makeText(this, "Navigating to Settings...", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, settings.class);
        startActivity(intent);


    }
    private void realtime() {
        Toast.makeText(this, "Navigating to RID...", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Camera.class);
        startActivity(intent);

    }

    private void OCR() {
        Toast.makeText(this, "Navigating to OCR...", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, OCR.class); // Assuming you have a SettingsActivity
        startActivity(intent);
    }
    private void ASV() {
        Toast.makeText(this, "Navigating to ASV...", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, ASV.class); // Assuming you have a SettingsActivity
        startActivity(intent);
    }
}
