package com.example.testandroidstudio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText text_to_send = (EditText) findViewById(R.id.TestInput);
        //Link the button to do stuff
        Button btn = (Button) findViewById(R.id.ChangePageButton);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String str = text_to_send.getText().toString();
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                i.putExtra("sent_text", str);
                startActivity(i);
            }
        });
    }
}