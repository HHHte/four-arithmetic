package com;

import java.io.*;

/**
 * 比对答案
 */
public class CheckAnswer {
    /**
     * 读取答案并且比对，输出结果
     *
     * @param num     算术式个数
     * @param results 结果
     */
    public static void inputAnswerAndCheck(int num, String[] results) {
        int[] correctCount = new int[num + 2];
        int[] wrongCount = new int[num + 2];
        int right1 = 0;
        int wrong1 = 0;
        String[] array = new String[num];
        int k = 0;
        FileReader fileReader;
        try {
            fileReader = new FileReader("D:\\test\\Your_answers.txt");

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String s;
            String[] str;
            while ((s = bufferedReader.readLine()) != null) {//读取答案
                str = s.split("、");
                String str1 = str[1];
                array[k] = str1;
                if (array[k].equals(results[k])) {//验证答案，统计正确和错误的个数
                    correctCount[k] = k + 1;
                    right1++;
                } else {
                    wrongCount[k] = k + 1;
                    wrong1++;
                }
                k++;
                if (k == num)
                    break;
            }
            bufferedReader.close();
            fileReader.close();

            //反馈正确与错误题目的信息
            File f = new File("D:\\test\\Grade.txt");
            FileWriter fw = new FileWriter(f, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(" ");
            pw.print("Correct:" + right1 + "(");
            for (int j = 0; j <= num; j++) {
                if (correctCount[j] != 0) {
                    pw.print(correctCount[j] + ",");
                }
            }
            pw.println(")");
            pw.print("Wrong:" + wrong1 + "(");
            for (int j = 0; j <= num; j++) {
                if (wrongCount[j] != 0) {
                    pw.print(wrongCount[j] + ",");
                }
            }
            pw.print(")");
            pw.println();
            pw.flush();
            fw.flush();
            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println("答案文件不存在，无法比对！");
        }
    }

}
