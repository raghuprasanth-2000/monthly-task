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
    TextView title;
    EditText mail, password;
    Button btn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        title = findViewById(R.id.title2);
        mail = findViewById(R.id.email2);
        password= findViewById(R.id.pass2);
        btn = findViewById(R.id.click2);

        Intent intent = getIntent();

        String email = intent.getStringExtra("email");
        String pass = intent.getStringExtra("pass");
        String Email = mail.getText().toString();
        String Password = password.getText().toString();
        mail.setText(email);
        password.setText(pass);

        Log.e("ADebugTag ", email + "," + pass + "," + Email + "," + Password + ",");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent MainActivityIntent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(MainActivityIntent);

            }
        });
    }
}