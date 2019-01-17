package com.example.kiryu.finalquizapp

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.content.Context
import android.content.ContentValues

class MyDBHandler(context: Context, name: String?, factory: SQLiteDatabase.CursorFactory?, Version: Int) :
        SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION){

    override fun onCreate(db: SQLiteDatabase){
        val CREATE_PRODUCTS_TABLE = ("CREATE TABLE " +
                TABLE_QUESTIONS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY," +
                COLUMN_NUMBER + " INTEGER," +
                COLUMN_CATEGORY + " TEXT," +
                COLUMN_PATH + " TEXT," +
                COLUMN_ANSWER + " TEXT," +
                COLUMN_YEAR + " TEXT" + ")")

        db.execSQL(CREATE_PRODUCTS_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTIONS)
        onCreate(db)
    }

    companion object {
        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "questionDB.db"
        val TABLE_QUESTIONS = "questions"

        val COLUMN_ID = "_id"
        val COLUMN_NUMBER = "questionnumber"
        val COLUMN_CATEGORY = "questioncategory"
        val COLUMN_PATH = "questionpath"
        val COLUMN_ANSWER = "questionanswer"
        val COLUMN_YEAR = "questionyear"
    }

    fun addQuestion(question: Question){
        val values = ContentValues()
        values.put(COLUMN_NUMBER, question.questionNumber)
        values.put(COLUMN_CATEGORY, question.questionCategory)
        values.put(COLUMN_PATH, question.questionPath)
        values.put(COLUMN_ANSWER, question.questionAnswer)
        values.put(COLUMN_YEAR, question.questionYear)

        val db = this.writableDatabase

        db.insert(TABLE_QUESTIONS, null, values)
        db.close()
    }

    fun findQuestion(questionPath: String): Question?{
        val query = "SELECT * FROM $TABLE_QUESTIONS WHERE $COLUMN_PATH = \"$questionPath\""

        val db = this.writableDatabase
        val cursor = db.rawQuery(query, null)
        var question: Question? = null

        if (cursor.moveToFirst()){
            cursor.moveToFirst()

            val id = Integer.parseInt(cursor.getString(0))
            val number = Integer.parseInt(cursor.getString(1))
            val category = cursor.getString(2)
            val path = cursor.getString(3)
            val answer = cursor.getString(4)
            val year = Integer.parseInt(cursor.getString(5))

            question = Question(id, number, category, path, answer, year)
            cursor.close()
        }
        db.close()
        return question
    }
}