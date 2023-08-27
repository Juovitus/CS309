package com.example.michaelcoms309practice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Attempts;
    private Button Login;

    //3 login attempts
    private int AttemptNumber = 3;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);

        //Assign XML IDS
        Name = (EditText)findViewById(R.id.loginpageusername);
        Password = (EditText)findViewById(R.id.loginpagepassword);
        Attempts = (TextView)findViewById(R.id.loginpageloginattempt);
        Login = (Button)findViewById(R.id.login_button);

        //initialize the attempt counter
        Attempts.setText("No of attempts remaining: 3");

        //when button is clicked we need to validate the username and password
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //call our function to validate, while also pulling in the username and password!
                loginValidation(Name.getText().toString(), Password.getText().toString());
            }
        });

    }

    //Function to validate users information
    private void loginValidation(String username, String password){
        //When login info is correct, move to new page!
        if ((username.equals("name")) && (password.equals("password"))){

            Intent moveOn = new Intent(Login.this, thirdpage.class);
            startActivity(moveOn);
        }
        else {
            //decrement the attempt number to keep track of # of attempts
            AttemptNumber--;
            //display #of attempts left
            Attempts.setText("No of attempts remaining: " + String.valueOf(AttemptNumber));

            //check if there are any attempts left, if not then disable the button
            if(AttemptNumber == 0){
                Login.setEnabled(false); //disables the button
            }
        }
    }

}
