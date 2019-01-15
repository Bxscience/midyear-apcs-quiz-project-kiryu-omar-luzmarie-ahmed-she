package com.elhosseno.midyearprojcectapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultsPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_page);
        Intent intent = this.getIntent();
        int NumCorrect = intent.getIntExtra("correct", 5);
        TextView Score = (TextView) findViewById(R.id.ScoreView);
        Score.setText(NumCorrect + "/5");

    }

    public void Exit(View v) {
        int pid = android.os.Process.myPid();
        android.os.Process.killProcess(pid);
    }

    public void newQuiz(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
