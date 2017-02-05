package com.ac.csun.team3;

import java.util.Random;

/**
 * Created by Victoria on 2/4/2017.
 */

public class QuestionGenerator {
    Random random = new Random();
    private int n = random.nextInt(10) + 1;
    private int m = random.nextInt(10) + 1;
    private int answer;

    String question;
    String q_part_1 = "What is ";
    String q_part_2 = "plus ";
    String q_part_3 = "?";

    QuestionGenerator() {
        this.question = q_part_1 + n + q_part_2 + m + q_part_3;
        this.answer = n + m;
    }

}
