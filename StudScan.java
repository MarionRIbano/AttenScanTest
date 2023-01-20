package com.example.attenscantest;

import android.content.Intent;

import com.journeyapps.barcodescanner.CaptureActivity;

public class StudScan extends CaptureActivity {
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        String classType = getIntent().getStringExtra("classType");
        if (classType.equals("Student_UI")) {
            Intent intent = new Intent(StudScan.this, Student_UI.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
}
