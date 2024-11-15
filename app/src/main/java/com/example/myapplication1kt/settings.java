package com.example.myapplication1kt;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_settings);


        Button button1 = findViewById(R.id.button1); // Assuming button1 is the logout button

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(settings.this);
                builder.setTitle("Confirm Logout");
                builder.setMessage("Are you sure you want to log out?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int
                            i) {
                        Toast.makeText(settings.this,
                                "Logging out", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(settings.this, MainActivity.class);
                        startActivity(intent);
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int
                            i) {
                        Toast.makeText(settings.this,
                                "No", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.show();
            }
        });


        findViewById(R.id.backButton).setOnClickListener(v -> finish());

        findViewById(R.id.editProfileButton).setOnClickListener(v -> {

        });
    }
}