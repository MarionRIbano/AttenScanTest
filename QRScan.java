package com.example.attenscantest;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

public class QRScan extends AppCompatActivity {
    String classType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qrscan);
        classType = getIntent().getStringExtra("classType");
        scanStud();
    }

    private void scanStud() {
        String type = getIntent().getStringExtra("classType");
        ScanOptions options = new ScanOptions();
        options.setBeepEnabled(true);
        options.setOrientationLocked(true);
        options.setCaptureActivity(StudScan.class);
        options.addExtra("classType", classType);
        barLauncher.launch(options);
    }

    ActivityResultLauncher<ScanOptions> barLauncher = registerForActivityResult(new ScanContract(), result -> {
        if (result.getContents() != null) {
            String type1 = getIntent().getExtras().getString("classType");
            String resultID = result.getContents();
        }
    });


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (classType.equals("Student_UI")) {
            Intent intent = new Intent(QRScan.this, Student_UI.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
    }}

}