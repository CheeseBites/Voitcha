package com.ac.csun.team3;

import java.util.Random;

/**
 * Created by Victoria on 2/4/2017.
 * Generates pseudo random integers, then formulates a question and corresponding answers
 * Constructor generates a single question, to be referenced by .question and .answer fields
 * New questions are called by constructing new instances
 */
class QuestionGenerator {
    private Random random = new Random();
    private int n = random.nextInt(10) + 1;
    private int m = random.nextInt(10) + 1;
    int answer;

    //"What is (number) plus (number)?"
    String question;
    private String q_part_1 = "What is ";
    private String q_part_2 = "plus ";
    private String q_part_3 = "?";

    QuestionGenerator() { //TODO: Add additional types of questions
        this.question = q_part_1 + n + q_part_2 + m + q_part_3;
        this.answer = n + m;
    }

}
