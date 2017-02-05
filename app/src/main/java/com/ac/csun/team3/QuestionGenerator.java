package com.ac.csun.team3;

import java.util.Random;

/**
 * Created by Victoria on 2/4/2017.
 */
// generates pseudo random integers, then formulates a question and corresponding answers
public class QuestionGenerator {
    private Random random = new Random();
    private int n = random.nextInt(10) + 1;
    private int m = random.nextInt(10) + 1;
    private String q_part_1 = "What is ";
    private String q_part_2 = "plus ";
    private String q_part_3 = "?";
    int answer;
    String question;

    // constructor to initialize question and answer pair
    QuestionGenerator() {
        this.question = q_part_1 + n + q_part_2 + m + q_part_3;
        this.answer = n + m;
    }

}
