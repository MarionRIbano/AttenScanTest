package com.example.attenscantest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Student_UI extends AppCompatActivity {
    Button SCAN;
    Button ATTENDANCE;
    Button SUBJECTS;
    Button LOGOUT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_ui);
        SCAN = findViewById(R.id.SCAN);
        SCAN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Student_UI.this, QRScan.class);
                intent.putExtra("classType", "Student_UI");
                startActivity(intent);

            }
        });
        ATTENDANCE = findViewById(R.id.ATTENDANCE);
        ATTENDANCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        SUBJECTS = findViewById(R.id.SUBJECTS);
        SUBJECTS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
        LOGOUT = findViewById(R.id.LOGOUT);
        LOGOUT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                System.exit(R.id.LOGOUT);

            }
        });

    }
}