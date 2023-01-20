package com.example.attenscantest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class RegTeach extends AppCompatActivity {

    EditText FirstName;
    EditText LastName;
    EditText Branch;
    EditText Email;
    EditText Subject;
    EditText Password;
    Button Register;
    FirebaseAuth mAuth;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference().child("Teachers");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regteach);

        FirstName = findViewById(R.id.FirstName);
        LastName = findViewById(R.id.LastName);
        Branch = findViewById(R.id.Branch);
        Email = findViewById(R.id.Email);
        Subject = findViewById(R.id.Subject);
        Password = findViewById(R.id.Password);
        mAuth = FirebaseAuth.getInstance();
        Register = (Button) findViewById(R.id.Register);
        Register.setOnClickListener(view -> {
            createUser();
        });
    }
    private void createUser() {
        String Fname = FirstName.getText().toString();
        String Lname = LastName.getText().toString();
        String branch = Branch.getText().toString();
        String email = Email.getText().toString();
        String subject = Subject.getText().toString();
        String password = Password.getText().toString();

        HashMap<String , String> userMap = new HashMap<>();

        userMap.put("FirstName", Fname);
        userMap.put("LastName", Lname);
        userMap.put("Branch", branch);
        userMap.put("Email", email);
        userMap.put("Subject", subject);

        myRef.setValue(userMap);

        if (TextUtils.isEmpty(Fname)) {
            FirstName.setError("SET YOUR FIRST NAME");
            FirstName.requestFocus();
        }
        else if (TextUtils.isEmpty(Lname)) {
            LastName.setError("SET YOUR LAST NAME");
            LastName.requestFocus();
        }
        else if (TextUtils.isEmpty(branch)) {
            Branch.setError("PLEASE INSERT YOUR BRANCH");
            Branch.requestFocus();
        }
        else if (TextUtils.isEmpty(email)) {
            Email.setError("INSERT PROVIDED EMAIL HERE");
            Email.requestFocus();
        }
        else if (TextUtils.isEmpty(subject)) {
            Subject.setError("INSERT REQUIRED SUBJECT");
            Subject.requestFocus();
        }
        else if (TextUtils.isEmpty(password)) {
            Password.setError("PLEASE SET YOUR PASSWORD");
            Password.requestFocus();
        }
        else {
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(RegTeach.this, "TEACHER SUCCESSFULLY REGISTERED", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegTeach.this, LogTeach.class));
                        }
                    else
                    {
                        Toast.makeText(RegTeach.this, "REGISTRATION UNSUCCESSFUL PLEASE REGISTER AGAIN" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}

