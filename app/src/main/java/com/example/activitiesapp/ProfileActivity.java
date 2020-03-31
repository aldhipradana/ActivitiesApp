package com.example.activitiesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    TextView lblProfileName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        sharedPreferences = getSharedPreferences("MyPref", MODE_PRIVATE);
        final String profileName = sharedPreferences.getString("usname","");

        lblProfileName = findViewById(R.id.lblProfileName);
        lblProfileName.setText(profileName);
    }
}
