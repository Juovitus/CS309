package com.example.projectapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private EditText username, password;
    private Button loginButton;
    private static String URL_LOGIN = "http://coms-309-016.cs.iastate.edu:8080/users";

    //private static String URL_LOGIN = "https://9ea7b3bb-98f5-48a6-9b2d-043db4d2a640.mock.pstmn.io/post_test/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.loginUser);
        password = findViewById(R.id.loginPassword);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _username = username.getText().toString().trim();
                String _password = password.getText().toString().trim();

                if (!_username.isEmpty() || !_password.isEmpty()) {
                    Login(_username, _password);
                }else {
                    username.setError("Please insert username");
                    password.setError("Please insert password");
                }
            }
        });


    }
    private void Login(String username, String password){

        loginButton.setVisibility(View.GONE);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_LOGIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            JSONArray jsonArray =jsonObject.getJSONArray("login");

                            if(success.equals("success")){

                                for(int i = 0; i <jsonArray.length(); i++){
                                    JSONObject object = jsonArray.getJSONObject(i);
                                    String username = object.getString("userName").trim();
                                    String email = object.getString("userEmail").trim();
                                   // String password = object.getString("password").trim();
                                    Toast.makeText(LoginActivity.this,
                                            "Success Login: \nUsername: "+username+"\nEmail: "
                                                    +email, Toast.LENGTH_SHORT).show();
                                }
                            }
                        }catch (JSONException error){
                            loginButton.setVisibility(View.VISIBLE);
                            error.printStackTrace();
                            Toast.makeText(LoginActivity.this, "Error "+error.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        loginButton.setVisibility(View.VISIBLE);

                        Toast.makeText(LoginActivity.this, "Error "+error.toString(), Toast.LENGTH_SHORT).show();

                    }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError{
                Map<String, String> params = new HashMap<>();
                params.put("username", username);
                params.put("password", password);
                return params;
        }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
