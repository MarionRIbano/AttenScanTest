package com.example.attenscantest;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class LogStud extends AppCompatActivity {

    private FirebaseAuth auth;
    private DatabaseReference reference;

    private String userID;
    Button login;
    FirebaseAuth mAuth;
    EditText EMAIL;
    EditText password;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logstud);

        EMAIL = findViewById(R.id.EMAIL);
        password = findViewById(R.id.password);
        mAuth = FirebaseAuth.getInstance();
        login = findViewById(R.id.login);
        login.setOnClickListener(view -> {
            loginuser();
        });
    }
    private void loginuser() {
        String Email = EMAIL.getText().toString().trim();
        String PassWord = password.getText().toString().trim();

        if (TextUtils.isEmpty(Email)) {
            EMAIL.setError("ENTER STUDENT EMAIL ADDRESS IS REQUIRED");
            EMAIL.requestFocus();
        }
        else if (TextUtils.isEmpty(PassWord)) {
            password.setError("PASSWORD REQUIRED TRY AGAIN");
            password.requestFocus();
        }
        else {
            mAuth.signInWithEmailAndPassword(Email,PassWord).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(LogStud.this, "STUDENT LOGGED IN SUCCESSFULLY", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LogStud.this, Student_UI.class));
                    }
                    else {
                        Toast.makeText(LogStud.this, "LOGGED IN UNSUCCESSFULLY" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });


        }
    }
}