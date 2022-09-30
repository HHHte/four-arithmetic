package com;

import java.util.Random;

/**
 * 生成题目和答案
 *
 * @author Hte
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
            //定义生成的题目
            String[] exp = new String[2];
            //分子
            int member1 = random.nextInt(range);
            //分母
            int denominator1 = random.nextInt(range);
            //下一个分子
            int member2 = random.nextInt(range);
            //下一个分母
            int denominator2 = random.nextInt(range);
            //+-*/,运算符
            int operator = random.nextInt(4);
            //分母均不为0时，生成算式并计算结果
            if (denominator1 != 0 && denominator2 != 0) {
                //分子
                int member = member1 * denominator2 + denominator1 * member2;
                //分母
                int denominator = denominator1 * denominator2;
                if (operator == 0) {
                    exp[0] = MemberAndDenominator.pseudoFraction(member1, denominator1) + "+" + MemberAndDenominator.pseudoFraction(member2, denominator2) + "=";
                }

                if (operator == 1 && member1 * denominator2 - denominator1 * member2 >= 0) {
                    member = member1 * denominator2 - denominator1 * member2;
                    exp[0] = MemberAndDenominator.pseudoFraction(member1, denominator1) + "-" + MemberAndDenominator.pseudoFraction(member2, denominator2) + "=";
                }

                if (operator == 1 && member1 / denominator1 - member2 / denominator2 < 0 || member1 == 0) {
                    member = denominator1 * member2 - member1 * denominator2;
                    exp[0] = MemberAndDenominator.pseudoFraction(member2, denominator2) + "-" + MemberAndDenominator.pseudoFraction(member1, denominator1) + "=";
                }

                if (operator == 2) {
                    member = member1 * member2;
                    exp[0] = MemberAndDenominator.pseudoFraction(member1, denominator1) + "×" + MemberAndDenominator.pseudoFraction(member2, denominator2) + "=";
                }

                if (operator == 3 && member2 != 0) {
                    member = member1 * denominator2;
                    denominator = denominator1 * member2;
                    exp[0] = MemberAndDenominator.pseudoFraction(member1, denominator1) + "÷" + MemberAndDenominator.pseudoFraction(member2, denominator2) + "=";
                }

                if (operator == 3 && member2 == 0) {
                    break;
                }
                if (exp[0] == null) {
                    exp[0] = MemberAndDenominator.pseudoFraction(member1, denominator1) + "+" + MemberAndDenominator.pseudoFraction(member2, denominator2) + "=";
                }

                System.out.println(exp[0]);
                results[i] = MemberAndDenominator.reductionOfFraction(member, denominator);

            } else {
                //分母至少一个为0时生成
                denominator1 = denominator2 = 1;
                //分子
                int member = member1 + member2;
                //分母
                int denominator = denominator1 * denominator2;

                if (operator == 0) {
                    exp[0] = member1 + "+" + member2 + "=";
                }

                if (operator == 1 && member1 - member2 >= 0) {
                    member = member1 - member2;
                    exp[0] = member1 + "-" + member2 + "=";
                }

                if (operator == 1 && member1 - member2 < 0) {
                    member = member2 - member1;
                    exp[0] = member2 + "-" + member1 + "=";
                }

                if (operator == 2) {
                    member = member1 * member2;
                    exp[0] = member1 + "×" + member2 + "=";
                }

                if (operator == 3 && member2 != 0) {
                    member = member1;
                    denominator = member2;
                    exp[0] = member1 + "÷" + member2 + "=";
                }

                if (operator == 3 && member2 == 0) {
                    break;
                }

                System.out.println(exp[0]);
                results[i] = MemberAndDenominator.reductionOfFraction(member, denominator);
            }
            try {
                //输出问题
                QuestionAndAnswerOutput.outputQuestion(exp, i);
                //输出答案
                QuestionAndAnswerOutput.outputAnswer(exp, results, i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return results;
    }


}
