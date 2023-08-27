package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button skip,toRegister,toLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toRegister = findViewById(R.id.startButton);
        toRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nextPage = new Intent(view.getContext(),RegisterActivity.class);
                startActivity(nextPage);
            }
        });

        skip = findViewById(R.id.skip);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent skipPage = new Intent(view.getContext(),HomeActivity.class);
                startActivity(skipPage);
            }
        });

        toLogin = findViewById(R.id.toLoginStart);
        toLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toLogin = new Intent(view.getContext(),LoginActivity.class);
                startActivity(toLogin);
            }
        });


    }


}