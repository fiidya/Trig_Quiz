package com.example.trigonometryquiz;

public class Question {
    private String text;
    private String answer;
    private String[] options;

    public Question(String text, String answer, String[] options) {
        this.text = text;
        this.answer = answer;
        this.options = options;
    }

    public String getText() {
        return text;
    }

    public String getAnswer() {
        return answer;
    }

    public String[] getOptions() {
        return options;
    }
}
