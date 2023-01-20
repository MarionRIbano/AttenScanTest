package com.example.attenscantest;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class TeacherGenerator extends AppCompatActivity {

    EditText edit_input;
    Button bt_generate;
    ImageView iv_qr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_generator);

     edit_input = findViewById(R.id.edit_input);
     bt_generate = findViewById(R.id.bt_generate);
     iv_qr = findViewById(R.id.iv_qr);

     bt_generate.setOnClickListener(v ->{
         generateQR();
     });
    }

    private void generateQR() {
        String text = edit_input.getText().toString().trim();
        MultiFormatWriter writer = new MultiFormatWriter();
        try {
            BitMatrix matrix = writer.encode(text, BarcodeFormat.QR_CODE, 400, 400);

            BarcodeEncoder encoder = new BarcodeEncoder();
            Bitmap bitmap = encoder.createBitmap(matrix);
            iv_qr.setImageBitmap(bitmap);


        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
}