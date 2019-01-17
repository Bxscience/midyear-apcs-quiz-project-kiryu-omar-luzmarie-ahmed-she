package com.example.kiryu.finalquizapp

class Question {
    var id: Int = 0
    var questionNumber: Int = 0
    var questionCategory: String? = null
    var questionPath: String? = null
    var questionAnswer: String? = null
    var questionYear: Int = 0

    constructor(id: Int, questionNumber: Int, questionCategory: String, questionPath: String, questionAnswer: String, questionYear: Int){
        this.id = id
        this.questionNumber = questionNumber
        this.questionCategory = questionCategory
        this.questionPath = questionPath
        this.questionAnswer = questionAnswer
        this.questionYear = questionYear
    }

    constructor(questionNumber: Int, questionCategory: String, questionPath: String, questionAnswer: String, questionYear: Int){
        this.questionNumber = questionNumber
        this.questionCategory = questionCategory
        this.questionPath = questionPath
        this.questionAnswer = questionAnswer
        this.questionYear = questionYear
    }
}