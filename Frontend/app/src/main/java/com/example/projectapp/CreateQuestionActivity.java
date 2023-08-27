package com.example.projectapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class CreateQuestionActivity extends AppCompatActivity {

    private Button validateQuestionButton;
    private EditText question,correct_ans,incorrectans1,incorrectans2,incorrectans3;
    private static String URL_QUESTION_TABLE = "http://coms-309-016.cs.iastate.edu:8080/TriviaQuestions";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_create);


        validateQuestionButton = findViewById(R.id.sendQuestionsQC);
        question = findViewById(R.id.questionPageQuestion);
        correct_ans = findViewById(R.id.questionPageAns1);
        incorrectans1 = findViewById(R.id.questionPageIncorrectAns1);
        incorrectans2 = findViewById(R.id.questionPageIncorrectAns2);
        incorrectans3 = findViewById(R.id.questionPageIncorrectAns3);

        validateQuestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                QuestionValidate();

                Intent intent =  new Intent(view.getContext(),QuestionResultActivity.class);
                startActivity(intent);
            }
        });
    }

    /* */

    private void QuestionValidate(){
        final String question = this.question.getText().toString().trim();
        final String correct_ans = this.correct_ans.getText().toString().trim();
        final String incorrect_ans1 = this.incorrectans1.getText().toString().trim();
        final String incorrect_ans2 = this.incorrectans2.getText().toString().trim();
        final String incorrect_ans3 = this.incorrectans3.getText().toString().trim();

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_QUESTION_TABLE,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                String success = jsonObject.getString("success");
                                if(success.equals("success")) {
                                    Toast.makeText(CreateQuestionActivity.this, "Submission Success!", Toast.LENGTH_SHORT).show();
                                }}catch(JSONException error){
                                    error.printStackTrace();
                                    Toast.makeText(CreateQuestionActivity.this, "Register Error!"+ error.toString(), Toast.LENGTH_SHORT).show();

                                }
                    }
                    }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){
                Toast.makeText(CreateQuestionActivity.this, "Submission Error!"+ error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            protected Map<String, String> getParams(){
                Map<String, String> param = new HashMap<>();
                param.put("question", question);
                param.put("correct_answer",correct_ans);
                param.put("incorrect_answer_1", incorrect_ans1);
                param.put("incorrect_answer_2", incorrect_ans2);
                param.put("incorrect_answer_3", incorrect_ans3);
                return param;
            }
        };

        requestQueue.add(stringRequest);


    }
}
