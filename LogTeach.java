package com.example.attenscantest;

import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogTeach extends AppCompatActivity {
    Button TeacherLogin;
    FirebaseAuth mAuth;
    EditText TeacherEmail;
    EditText TeacherPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logteach);

        mAuth = FirebaseAuth.getInstance();
        TeacherEmail = findViewById(R.id.TeacherEmail);
        TeacherPassword = findViewById(R.id.TeacherPassword);
        TeacherLogin = findViewById(R.id.TeacherLogin);
        TeacherLogin.setOnClickListener(view -> {
            loginuser();
        });
    }
    private void loginuser() {
        String Email = TeacherEmail.getText().toString().trim();
        String Password = TeacherPassword.getText().toString().trim();

        if (TextUtils.isEmpty(Email)) {
            TeacherEmail.setError("ENTER TEACHER EMAIL ADDRESS IS REQUIRED");
            TeacherEmail.requestFocus();
        }
        else if (TextUtils.isEmpty(Password)) {
            TeacherPassword.setError("PASSWORD REQUIRED TRY AGAIN");
            TeacherPassword.requestFocus();
        }
        else {
            mAuth.signInWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(LogTeach.this, "TEACHER LOGGED IN SUCCESSFULLY", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LogTeach.this, Teacher_UI.class));

                    }
                    else {
                        Toast.makeText(LogTeach.this, "LOGGED IN UNSUCCESSFULLY TRY AGAIN" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}