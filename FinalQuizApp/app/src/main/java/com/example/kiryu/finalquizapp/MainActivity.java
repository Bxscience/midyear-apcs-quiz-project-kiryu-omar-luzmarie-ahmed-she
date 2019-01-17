package com.example.kiryu.finalquizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    void createProblem(String path){
        String remaining = null;
    }

    fun createProblem(path: String){
        var remaining: String = path
        var number = 0
        var category: String? = null
        var answer: String? = null
        var year = 0
        for (letter in remaining){
            if (letter in "0123456789"){
                category = remaining.substring(0, remaining.indexOf(letter))
                remaining = remaining.substring(remaining.indexOf(letter), remaining.length)
                break
            }
        }
        for (letter in remaining){
            if (letter.toLowerCase() in "abcde"){
                number = Integer.parseInt(remaining.substring(0, remaining.indexOf(letter)))
                remaining = remaining.substring(remaining.indexOf(letter), remaining.length)
                break;
            }
        }
        answer = remaining.substring(0, 1)
        year = Integer.parseInt(remaining.substring(1, remaining.length))
        val question = Question(number, category.toString(), path, answer, year)

        val dbHandler = MyDBHandler(this, null, null, 1)
        dbHandler.addQuestion(question)
    }
}
