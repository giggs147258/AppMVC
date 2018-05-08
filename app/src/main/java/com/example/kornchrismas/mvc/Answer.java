package com.example.kornchrismas.mvc;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Answer extends AppCompatActivity {

    TextView score;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        score = (TextView) findViewById(R.id.textScore);
        score.setText(String.valueOf(getIntent().getExtras().getInt("Score")));
    }

    public void ClickPlayAgain(View view) {
        Intent again = new Intent(Answer.this, MainActivity.class);
        startActivity(again);
        finish();
    }

    public void Exit (View view){
        finish();
    }
}
