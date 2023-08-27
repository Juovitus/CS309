package com.example.testandroidstudio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView receivedText = (TextView) findViewById(R.id.sentText);

        Intent i = getIntent();
        String str = i.getStringExtra("sent_text");
        receivedText.setText(str);
    }
}