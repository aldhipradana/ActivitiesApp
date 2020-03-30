package com.example.activitiesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import java.security.PrivateKey;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText usname;
    private TextInputEditText uspwd;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.btnLogin);
        usname =  findViewById(R.id.txtUsername);
        uspwd = findViewById(R.id.txtPassword);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (loginChecker()){
                    Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                    startActivity(intent);
                }else{
                    Snackbar failedLogin = Snackbar.make(v, "Enter Correct Username and Password!", Snackbar.LENGTH_SHORT);
                    failedLogin.show();
                }
            }
        });
    }

    public boolean loginChecker() {

        final String username = usname.getText().toString();
        final String password = uspwd.getText().toString();

        if ( ( username != null && username.length() >= 1 ) && ( password != null && password.length() >= 3 ) ){
            return true;
        }else{
            return false;
        }

    }

}
