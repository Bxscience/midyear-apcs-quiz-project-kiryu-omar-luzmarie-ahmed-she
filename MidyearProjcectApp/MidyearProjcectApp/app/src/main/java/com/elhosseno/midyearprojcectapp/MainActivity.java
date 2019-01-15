package com.elhosseno.midyearprojcectapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        TextView[] categs = new TextView[10];
        String baseCategText = "Categ";
        for(int i = 0; i < 10; i++) {
            String TextViewIDs = baseCategText + i;
            int TextViewID = this.getResources().getIdentifier(TextViewIDs, "layout", this.getPackageName());
            categs[i] = (TextView) findViewById(TextViewID);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OpenQuiz(View v) {
        String[] classes = {"classes1c2008","classes2c2008","classes3e2008","classes4c2008","classes5c2008","classes6d2005","classes7e2005","classes8a2005","classes9b2005","classes10e2005"};

        String[] fields_methods = {"field1b1999","field2c2001","field3b2001","field4b2002","field5d2003","field6e2004","field7d2005","field8e2006","field9e2006","field10c2008"};

        String[] recursion_bigo = {"recursion1d1999","recursion2a1999","recursion3b1999","recursion4e2000","recursion5d2000","recursion6e2000","recursion7a2001","recursion8a2001","recursion9c2002","recursion9c2002"};

        String[] sorting = {"sorting1e2000","sorting2a2000","sorting3c2001","sorting4d2001","sorting5c2001","sorting6a2002","sorting7c2003","sorting8a2004","sorting9b2005","sorting10a2006"};

        String[] stacks_queues = {"stacks1e1999","stacks2c2000","stacks3c2000","stacks4c2001","stacks5c2001","stacks6c2002","stacks7b2003","stacks8a2003","stacks9b2005","stacks10a2005"};

        String[] arithmetic_boolean = {"arith_boolexp1d2008","arith_boolexp2c2007","arith_boolexp3b2006","arith_boolexp4c2005","strings5e2004","arith_boolexp6b2003","arith_boolexp7d2002","arith_boolexp2001","arith_boolexp9c2000","arith_boolexp10a1999"};

        String[] arraylist_linkedlist = {"array_linked1d2008","array_linked2b2007","array_linked3a2006","array_linked4c2005", "array_linked5e2005","array_linked6c2004","array_linked7d2004","array_linked8d2003","array_linked9e2002","array_linked10c1999"};

        String[] arrays = {"arrays1a2008","arrays2e2007","arrays3a2006","arrays4d2005","arrays5d2004","arrays6d2003","arrays7e2002","arrays8a2001","arrays9b2000","arrays10a1999"};

        String[] loops_iterators = {"loops_iter1c2008","loops_iter2d2007","loops_iter3c2006","loops_iter4a2005", "loops_iter5d2004","loops_iter6d2003","loops_iter7d2002","loops_iter8e2001","loops_iter9c2000","loops_iter10c1999"};

        String[] strings = {"strings1a2008","strings2a2007","string3a2006","strings4d2005", "strings5e2004","strings6c2003","strings7d2002","strings8b2001","strings9e2000","strings10b1999"};

        TextView CategoryText = (TextView)findViewById(v.getId());
        Intent intent = new Intent(this, QuizPage.class);
        String categ = CategoryText.getText().toString().toLowerCase();
        if (categ.equals("classes, interfaces, inheritance")) {
            intent.putExtra("Category", classes);
        } else if(categ.equals("fields, methods, parameters")) {
            intent.putExtra("Category", fields_methods);
        } else if(categ.equals("recursion and big-o")) {
            intent.putExtra("Category", recursion_bigo);
        } else if(categ.equals("sorting")) {
            intent.putExtra("Category", sorting);
        } else if(categ.equals("stacks and queues")) {
            intent.putExtra("Category", stacks_queues);
        } else if(categ.equals("arithmetic and boolean expressions")) {
            intent.putExtra("Category", arithmetic_boolean);
        } else if(categ.equals("arraylist and linkedlist")) {
            intent.putExtra("Category", arraylist_linkedlist);
        } else if(categ.equals("arrays")) {
            intent.putExtra("Category", arrays);
        } else if(categ.equals("loops and iterators")) {
            intent.putExtra("Category", loops_iterators);
        } else if(categ.equals("strings")) {
            intent.putExtra("Category", strings);
        }

        Log.d("Category", categ);
        startActivity(intent);
    }
}
