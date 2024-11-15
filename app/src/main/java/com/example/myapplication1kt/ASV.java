package com.example.myapplication1kt;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ASV extends AppCompatActivity {

    private Spinner voiceTypeSpinner, voiceLanguageSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asv);


        // Initialize views
        voiceTypeSpinner = findViewById(R.id.voiceTypeSpinner);
        voiceLanguageSpinner = findViewById(R.id.voiceLanguageSpinner);

        // Set up spinners with data (replace with your data)
        ArrayAdapter<String> voiceTypeAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,
                new String[]{"Voice 1", "Voice 2", "Voice 3"});
        voiceTypeSpinner.setAdapter(voiceTypeAdapter);

        ArrayAdapter<String> voiceLanguageAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,
                new String[]{"English", "Spanish", "French"});
        voiceLanguageSpinner.setAdapter(voiceLanguageAdapter);


        findViewById(R.id.backButton).setOnClickListener(v -> finish());


        findViewById(R.id.saveSettingsButton).setOnClickListener(v -> {

            String selectedVoiceType = voiceTypeSpinner.getSelectedItem().toString();
            String selectedVoiceLanguage = voiceLanguageSpinner.getSelectedItem().toString();

            // Implement your logic to save preferences (e.g., using SharedPreferences)

            // Show a success message or navigate back to previous screen
            Toast.makeText(this, "Settings saved successfully", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}