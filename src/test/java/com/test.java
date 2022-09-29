package com;

import org.junit.Test;

public class test {

    @Test
    public void test1() {
        int num = 100;
        int range = 100;
        String[] results = Question.createAndSolve(range, num);
        CheckAnswer.inputAnswerAndCheck(num, results);
    }

}
