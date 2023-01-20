package com.example.attenscantest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Teacher_UI extends AppCompatActivity {

    Button GENERATE;
    Button SCHEDULE;
    Button CALENDAR;
    Button LOGOUT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_ui);
        GENERATE = findViewById(R.id.GENERATE);
        GENERATE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Teacher_UI.this, com.example.attenscantest.TeacherGenerator.class);
                startActivity(intent);

            }
        });
        SCHEDULE = findViewById(R.id.SCHEDULE);
        SCHEDULE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        CALENDAR = findViewById(R.id.CALENDAR);
        CALENDAR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Teacher_UI.this, com.example.attenscantest.teacher_calendar.class);
                startActivity(intent);

            }
        });
        LOGOUT = findViewById(R.id.LOGOUT);
        LOGOUT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(R.id.LOGOUT);
            }
        });


    }
}