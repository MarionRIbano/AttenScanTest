package com.example.attenscantest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Student_teacher_picker_Main extends AppCompatActivity {
    Button LogTeach, RegTeach, LogStud, RegStud, LogAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_teacher_picker_main);


        LogTeach = findViewById(R.id.LogTeach);
        RegTeach = findViewById(R.id.RegTeach);
        LogStud = findViewById(R.id.LogStud);
        RegStud = findViewById(R.id.RegStud);

        LogTeach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Student_teacher_picker_Main.this, com.example.attenscantest.LogTeach.class);
                startActivity(intent);
            }
        });

        RegTeach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Student_teacher_picker_Main.this, com.example.attenscantest.RegTeach.class);
                startActivity(intent);
            }
        });

        LogStud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Student_teacher_picker_Main.this, com.example.attenscantest.LogStud.class);
                startActivity(intent);
            }
        });

        RegStud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Student_teacher_picker_Main.this, com.example.attenscantest.RegStud.class);
                startActivity(intent);
            }
        });


    }
}