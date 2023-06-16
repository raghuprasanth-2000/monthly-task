package com.example.studentdata;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    TextView txt;
    EditText mail1, pass1;
    Button btn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txt = findViewById(R.id.title2);
        mail1 = findViewById(R.id.email2);
        pass1 = findViewById(R.id.pass2);
        btn = findViewById(R.id.click2);

        Intent intent = getIntent();

        String email = intent.getStringExtra("email");
        String pass = intent.getStringExtra("pass");
        String Email = mail1.getText().toString();
        String password = pass1.getText().toString();
        mail1.setText(email);
        pass1.setText(pass);

        Log.e("ADebugTag ", email + "," + pass + "," + Email + "," + password + ",");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent MainActivityIntent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(MainActivityIntent);

            }
        });


    }
}