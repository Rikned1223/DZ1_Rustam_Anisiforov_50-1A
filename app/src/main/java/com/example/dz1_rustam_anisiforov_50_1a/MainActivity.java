package com.example.dz1_rustam_anisiforov_50_1a;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    private Button send;
    private EditText gmail,message,zagolovok;



    @Override
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        send = findViewById(R.id.Send);
        gmail = findViewById(R.id.gmail);
        zagolovok = findViewById(R.id.Zagolovok);
        message = findViewById(R.id.Text);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL,new String[]{gmail.getText().toString()});
                intent.putExtra(Intent.EXTRA_SUBJECT, zagolovok.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT, message.getText().toString());
                intent.setType("message/rfc822");
                startActivity(Intent.createChooser(intent,"RusBek gmail client"));

            }
        });





    }
}