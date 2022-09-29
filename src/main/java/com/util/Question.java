package com.util;

import java.util.Random;

/**
 * 生成题目和答案
 */
public class Question {
    private static final Random random = new Random();

    /**
     * 生成问题和答案
     *
     * @param range 数字范围
     * @param num   算式数目
     * @return 返回结果集
     */
    public static String[] createAndSolve(int range, int num) {
        String[] results = new String[num * 2];
        int i = 0;
        for (; i < num; i++) {
            String[] exp = new String[2];//定义生成的题目
            int a = random.nextInt(range);//分子
            int b = random.nextInt(range);//分母
            int c = random.nextInt(range);//下一个分子
            int d = random.nextInt(range);//下一个分母
            int operator = random.nextInt(4);//+-*/,运算符
            if (b != 0 && d != 0) {//分母均不为0时，生成算式并计算结果
                int member = a * d + b * c;//分子
                int denominator = b * d;//分母
                if (operator == 0) {
                    exp[0] = MemberAndDenominator.pseudoFraction(a, b) + "+" + MemberAndDenominator.pseudoFraction(c, d) + "=";
                }

                if (operator == 1 && a * d - b * c >= 0) {
                    member = a * d - b * c;
                    exp[0] = MemberAndDenominator.pseudoFraction(a, b) + "-" + MemberAndDenominator.pseudoFraction(c, d) + "=";
                }

                if (operator == 1 && a / b - c / d < 0 || a == 0) {
                    member = b * c - a * d;
                    exp[0] = MemberAndDenominator.pseudoFraction(c, d) + "-" + MemberAndDenominator.pseudoFraction(a, b) + "=";
                }

                if (operator == 2) {
                    member = a * c;
                    exp[0] = MemberAndDenominator.pseudoFraction(a, b) + "×" + MemberAndDenominator.pseudoFraction(c, d) + "=";
                }

                if (operator == 3 && c != 0) {
                    member = a * d;
                    denominator = b * c;
                    exp[0] = MemberAndDenominator.pseudoFraction(a, b) + "÷" + MemberAndDenominator.pseudoFraction(c, d) + "=";
                }

                if (operator == 3 && c == 0) {
                    break;
                }
                if (exp[0] == null) {
                    exp[0] = MemberAndDenominator.pseudoFraction(a, b) + "+" + MemberAndDenominator.pseudoFraction(c, d) + "=";
                }

                System.out.println(exp[0]);
                results[i] = MemberAndDenominator.reductionOfFraction(member, denominator);

            } else {//分母至少一个为0时生成
                b = d = 1;
                int member = a + c;//分子
                int denominator = b * d;//分母
                if (operator == 0) {
                    exp[0] = a + "+" + c + "=";
                }

                if (operator == 1 && a - c >= 0) {
                    member = a - c;
                    exp[0] = a + "-" + c + "=";
                }

                if (operator == 1 && a - c < 0) {
                    member = c - a;
                    exp[0] = c + "-" + a + "=";
                }

                if (operator == 2) {
                    member = a * c;
                    exp[0] = a + "×" + c + "=";
                }

                if (operator == 3 && c != 0) {
                    member = a;
                    denominator = c;
                    exp[0] = a + "÷" + c + "=";
                }

                if (operator == 3 && c == 0) {
                    break;
                }

                System.out.println(exp[0]);
                results[i] = MemberAndDenominator.reductionOfFraction(member, denominator);
            }
            try {
                QuestionAndAnswerOutput.outputQuestion(exp, i);//输出问题
                QuestionAndAnswerOutput.outputAnswer(exp, results, i);//输出答案
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return results;
    }


}
