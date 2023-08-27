package com.example.projectapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;



public class HomeActivity extends AppCompatActivity {

    private Button createPage;
    private Button lobbyPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        createPage = findViewById(R.id.createQuestionPage);
        //lobbyPage = findViewById(R.id.lobbyPageHere);

        createPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(view.getContext(),CreateQuestionActivity.class);
                startActivity(intent);
            }}
            );
        lobbyPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                //Intent intent = new Intent(view.getContext(),tempHere.class); //lobby page add
                //startActivity(intent);
            }}
        );
    }
}
