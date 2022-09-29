package com.util;

/**
 * 处理分数
 */
public class MemberAndDenominator {
    /**
     * 处理分数结果
     *
     * @param a 分子
     * @param b 分母
     * @return 返回判断假分数
     */
    public static String reductionOfFraction(int a, int b) {
        int m = 1;
        int i = a;
        for (; i >= 1; i--) {
            if (a % i == 0 && b % i == 0) {
                m = i;
                break;
            }
        }
        int n = a / m;
        int k = b / m;
        if (n == 0)
            return "0";
        if (k == 1)
            return n + "";
        else return pseudoFraction(n, k);
    }

    /**
     * 判断假分数，并转化为带分数
     *
     * @param a 分子
     * @param b 分母
     * @return 返回带分数
     */
    public static String pseudoFraction(int a, int b) {
        if (a > b || a == b) {
            int c = a / b;
            int d = a % b;
            if (d == 0) {
                return c + "";
            }
            return c + "'" + d + "/" + b;
        }
        return a + "/" + b;
    }

}
