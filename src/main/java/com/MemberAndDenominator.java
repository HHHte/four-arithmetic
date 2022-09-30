package com;

/**
 * 处理分数
 *
 * @author Hte
 */
public class MemberAndDenominator {
    /**
     * 处理分数结果
     *
     * @param member      分子
     * @param denominator 分母
     * @return 返回判断假分数
     */
    public static String reductionOfFraction(int member, int denominator) {
        int m = 1;
        int i = member;
        for (; i >= 1; i--) {
            if (member % i == 0 && denominator % i == 0) {
                m = i;
                break;
            }
        }
        int n = member / m;
        int k = denominator / m;
        if (n == 0) {
            return "0";
        }

        if (k == 1) {
            return n + "";
        } else {
            return pseudoFraction(n, k);
        }
    }

    /**
     * 判断假分数，并转化为带分数
     *
     * @param member      分子
     * @param denominator 分母
     * @return 返回带分数
     */
    public static String pseudoFraction(int member, int denominator) {
        if (member > denominator || member == denominator) {
            int c = member / denominator;
            int d = member % denominator;
            if (d == 0) {
                return c + "";
            }
            return c + "'" + d + "/" + denominator;
        }
        return member + "/" + denominator;
    }

}
