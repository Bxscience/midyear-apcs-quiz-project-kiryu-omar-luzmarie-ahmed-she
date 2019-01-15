package com.elhosseno.midyearprojcectapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.content.IntentCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class QuizPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_page);

        Intent intent = this.getIntent();
        final String[] questions = intent.getStringArrayExtra("Category");
        Log.d("QUESTIONS", Arrays.toString(questions));

        final ImageView img1 = (ImageView) findViewById(R.id.Q1image);
        ImageView img2 = (ImageView) findViewById(R.id.Q2image);
        ImageView img3 = (ImageView) findViewById(R.id.Q3image);
        ImageView img4 = (ImageView) findViewById(R.id.Q4image);
        ImageView img5 = (ImageView) findViewById(R.id.Q5image);
        ImageView[] images = {img1,img2,img3,img4,img5};
        final ArrayList<Integer> pathsFound = new ArrayList<>();
        for(ImageView img : images) {
            int randPath = (int)(Math.random() * ((9) + 1));
            while (pathsFound.contains(questions[randPath])) {
                randPath = (int)(Math.random() * ((9) + 1));
            }
            pathsFound.add(randPath);
            Context context = img.getContext();
            int id = context.getResources().getIdentifier(questions[randPath], "drawable", context.getPackageName());
            img.setImageResource(id);
        }


        Button BackButton = (Button) findViewById(R.id.BackButton);
        Button submitButton = (Button) findViewById(R.id.SubmitButton);
        Button button1 = (Button) findViewById(R.id.Check1);
        Button button2 = (Button) findViewById(R.id.Check2);
        Button button3 = (Button) findViewById(R.id.Check3);
        Button button4 = (Button) findViewById(R.id.Check4);
        Button button5= (Button) findViewById(R.id.Check5);

        final Spinner spinner1 = (Spinner) findViewById(R.id.Spinner1);
        final Spinner spinner2 = (Spinner) findViewById(R.id.Spinner2);
        final Spinner spinner3 = (Spinner) findViewById(R.id.Spinner3);
        final Spinner spinner4 = (Spinner) findViewById(R.id.Spinner4);
        final Spinner spinner5 = (Spinner) findViewById(R.id.Spinner5);
        final Spinner[] spinners = {spinner1, spinner2, spinner3, spinner4, spinner5};

        final List<String> categories = new ArrayList<>();
        categories.add("None");
        categories.add("A");
        categories.add("B");
        categories.add("C");
        categories.add("D");
        categories.add("E");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        for (Spinner spinner : spinners) {
            spinner.setAdapter(dataAdapter);
        }

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView CheckA1 = (TextView) findViewById(R.id.CheckA1);
                String Answer = spinner1.getSelectedItem().toString();
                Log.d("SPINNER1", Answer);
                Character CorrectAnswerChar = questions[pathsFound.get(0)].charAt(questions[pathsFound.get(0)].length()-5);
                String CorrectAnswer = CorrectAnswerChar.toString().toUpperCase();
                Log.d("Answer", CorrectAnswer);
                if(Answer.equals(CorrectAnswer)) {
                  CheckA1.setTextColor(Color.GREEN);
                  CheckA1.setText("Correct");
                }
                else {
                  CheckA1.setTextColor(Color.RED);
                  CheckA1.setText("WRONG");
                }

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView CheckA2 = (TextView) findViewById(R.id.CheckA2);
                String Answer = spinner2.getSelectedItem().toString();
                Log.d("SPINNER2", Answer);
                Character CorrectAnswerChar = questions[pathsFound.get(1)].charAt(questions[pathsFound.get(1)].length()-5);
                String CorrectAnswer = CorrectAnswerChar.toString().toUpperCase();
                Log.d("Answer", CorrectAnswer);
                if(Answer.equals(CorrectAnswer)) {
                    CheckA2.setTextColor(Color.GREEN);
                    CheckA2.setText("Correct");
                }
                else {
                    CheckA2.setTextColor(Color.RED);
                    CheckA2.setText("WRONG");
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView CheckA3 = (TextView) findViewById(R.id.CheckA3);
                String Answer = spinner3.getSelectedItem().toString();
                Log.d("SPINNER3", Answer);
                Character CorrectAnswerChar = questions[pathsFound.get(2)].charAt(questions[pathsFound.get(2)].length()-5);
                String CorrectAnswer = CorrectAnswerChar.toString().toUpperCase();
                Log.d("Answer", CorrectAnswer);
                if(Answer.equals(CorrectAnswer)) {
                    CheckA3.setTextColor(Color.GREEN);
                    CheckA3.setText("Correct");
                }
                else {
                    CheckA3.setTextColor(Color.RED);
                    CheckA3.setText("WRONG");
                }
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView CheckA4 = (TextView) findViewById(R.id.CheckA4);
                String Answer = spinner4.getSelectedItem().toString();
                Log.d("SPINNER4", Answer);
                Character CorrectAnswerChar = questions[pathsFound.get(3)].charAt(questions[pathsFound.get(3)].length()-5);
                String CorrectAnswer = CorrectAnswerChar.toString().toUpperCase();
                Log.d("Answer", CorrectAnswer);
                if(Answer.equals(CorrectAnswer)) {
                    CheckA4.setTextColor(Color.GREEN);
                    CheckA4.setText("Correct");
                }
                else {
                    CheckA4.setTextColor(Color.RED);
                    CheckA4.setText("WRONG");
                }
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView CheckA5 = (TextView) findViewById(R.id.CheckA5);
                String Answer = spinner5.getSelectedItem().toString();
                Log.d("SPINNER5", Answer);
                Character CorrectAnswerChar = questions[pathsFound.get(4)].charAt(questions[pathsFound.get(4)].length()-5);
                String CorrectAnswer = CorrectAnswerChar.toString().toUpperCase();
                Log.d("Answer", CorrectAnswer);
                if(Answer.equals(CorrectAnswer)) {
                    CheckA5.setTextColor(Color.GREEN);
                    CheckA5.setText("Correct");
                }
                else {
                    CheckA5.setTextColor(Color.RED);
                    CheckA5.setText("WRONG");
                }
            }
        });



        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int correct = 0;
                for(int i = 0; i < spinners.length; i++) {
                    String imgPath = questions[pathsFound.get(i)];
                    if(spinners[i].getSelectedItem().toString().equals(Character.toString(imgPath.charAt(imgPath.length() - 5)).toUpperCase())){
                       correct ++;

                    }Log.d("Check", Character.toString(imgPath.charAt(imgPath.length()-5)));
                }
                Intent intent = new Intent(v.getContext(), ResultsPage.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.putExtra("correct", correct);
                Log.d("Num Correct:", Integer.toString(correct));
                startActivity(intent);
            }
        });
    }

    public void goBack(View v) {
        this.finish();
    }



}
