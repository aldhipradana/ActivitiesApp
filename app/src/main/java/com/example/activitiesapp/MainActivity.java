package com.example.activitiesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import java.security.PrivateKey;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText usname;
    private TextInputEditText uspwd;
    Button login;
    ImageButton close;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.btnLogin);
        close = findViewById(R.id.closeBtn);
        usname =  findViewById(R.id.txtUsername);
        uspwd = findViewById(R.id.txtPassword);

        sharedPreferences = getSharedPreferences("MyPref", MODE_PRIVATE);
        session = sharedPreferences.edit();

        sesssionChecker();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (loginChecker()){
                    Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                    Toast.makeText( getApplicationContext(),"Halo "+sharedPreferences.getString("usname", ""), Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }else{
                    Snackbar failedLogin = Snackbar.make(v, "Enter Correct Username and Password!", Snackbar.LENGTH_SHORT);
                    failedLogin.show();
                }
            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeApplication(v);
            }
        });
    }

    public boolean loginChecker() {

        final String username = usname.getText().toString();
        final String password = uspwd.getText().toString();

        if ( ( username != null && username.length() >= 1 ) && ( password != null && password.length() >= 3 ) ){
            session.putString("usname", username);
            session.putBoolean("session", true);
            session.commit();
            return true;
        }else{
            return false;
        }

    }

    public void sesssionChecker(){

        boolean mysession = sharedPreferences.getBoolean("session", false);

        if (mysession){
            Toast.makeText( getApplicationContext(),"Halo "+sharedPreferences.getString("usname", ""), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
            startActivity(intent);
        }else {
            Toast.makeText( getApplicationContext(),"Silahkan Login", Toast.LENGTH_SHORT).show();
        }

    }

    public void closeApplication(View view) {
        finish();
        moveTaskToBack(true);
    }


}
