package com.example.studentdata;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {
    TextView text;
    EditText name, email, pass;
    Button button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        text = findViewById(R.id.title);
        name = findViewById(R.id.textname);
        email = findViewById(R.id.Email);
        pass = findViewById(R.id.password);
        button = findViewById(R.id.click);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = name.getText().toString();
                String mail = email.getText().toString();
                String password = pass.getText().toString();
                Intent loginActivityIntent = new Intent(Register.this, LoginActivity.class);
                loginActivityIntent.putExtra("email", mail);
                loginActivityIntent.putExtra("pass", password);
                startActivity(loginActivityIntent);
            }
        });
    }
}