package com.example.attenscantest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;


public class RegStud extends AppCompatActivity {
    EditText firstName, lastName, StudentNumber, Section, phoneNumber, email, password_toggle;
    Button register;
    FirebaseAuth mAuth;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference().child("Students");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regstud);

        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        StudentNumber = findViewById(R.id.StudentNumber);
        Section = findViewById(R.id.Section);
        phoneNumber = findViewById(R.id.phoneNumber);
        email = findViewById(R.id.email);
        password_toggle = findViewById(R.id.password_toggle);
        mAuth = FirebaseAuth.getInstance();
        register = findViewById(R.id.register);
        register.setOnClickListener(view -> {
            createUser();
        });
    }
    private void createUser() {
        String FirstName = firstName.getText().toString();
        String LastName = lastName.getText().toString();
        String StudNum = StudentNumber.getText().toString();
        String section = Section.getText().toString();
        String phonenum = phoneNumber.getText().toString();
        String EMAIL = email.getText().toString();
        String password = password_toggle.getText().toString();

        HashMap<String , String> usermap = new HashMap<>();


        usermap.put("FirstName", FirstName);
        usermap.put("LastName", LastName);
        usermap.put("StudentNumber", StudNum);
        usermap.put("PhoneNumber", phonenum);
        usermap.put("Section", section);
        usermap.put("Email", EMAIL);

        myRef.setValue(usermap);


        if (TextUtils.isEmpty(FirstName)) {
            firstName.setError("PLEASE SET YOUR FIRST NAME");
            firstName.requestFocus();
        }
        else if (TextUtils.isEmpty(LastName)) {
            lastName.setError("PLEASE SET YOUR LAST NAME");
            lastName.requestFocus();
        }
        else if (TextUtils.isEmpty(StudNum)) {
            StudentNumber.setError("ENTER YOUR SCHOOL STUDENT NUMBER");
            StudentNumber.requestFocus();
        }
        else if (TextUtils.isEmpty(section)) {
            Section.setError("ENTER YOUR SECTION");
            Section.requestFocus();
        }
        else if (TextUtils.isEmpty(phonenum)) {
            phoneNumber.setError("ENTER YOUR PHONE NUMBER");
            phoneNumber.requestFocus();
        }
        else if (TextUtils.isEmpty(EMAIL)) {
            email.setError("EMAIL CANNOT BE EMPTIED!");
            email.requestFocus();
        }
        else if (TextUtils.isEmpty(password)) {
            password_toggle.setError("ENTER YOUR PASSWORD");
            password_toggle.requestFocus();
        }
        else {
            mAuth.createUserWithEmailAndPassword(EMAIL,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(RegStud.this, "STUDENT REGISTER SUCCESSFULLY", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegStud.this, LogStud.class));

                    }
                    else{
                        Toast.makeText(RegStud.this, "REGISTRATION UNSUCESSFUL TRY AGAIN" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }
    }
}