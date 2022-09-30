package com;

import java.io.*;

/**
 * 输出题目和答案文件
 *
 * @author Hte
 */
public class QuestionAndAnswerOutput {
    /**
     * 题目输出
     *
     * @param exp 算术式
     * @param i   顺序
     */
    public static void outputQuestion(String[] exp, int i) {
        //题目写入
        File f = new File("D:\\test\\Exercises.txt");
        FileWriter fw;
        try {
            fw = new FileWriter(f, true);
            if (exp != null) {
                FileReader fileReader = new FileReader("D:\\test\\Exercises.txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String s;
                while ((s = bufferedReader.readLine()) != null) {
                    String[] str = s.split("、");
                    String str1 = str[1];
                    if (str1.equals(exp[0])) {
                        System.out.println("重复");
                        break;
                    }
                }
                bufferedReader.close();
                fileReader.close();
                PrintWriter pw = new PrintWriter(fw);
                pw.println(i + 1 + "、" + exp[0]);
                pw.flush();
                try {
                    fw.flush();
                    pw.close();
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            System.out.println("输出题目的文件不存在！输出失败");
        }

    }

    /**
     * 答案输出
     *
     * @param exp     算术式
     * @param results 结果
     * @param i       顺序
     */
    public static void outputAnswer(String[] exp, String[] results, int i) {
        //答案写入
        File f = new File("D:\\test\\Answer1.txt");
        FileWriter fw;
        try {
            fw = new FileWriter(f, true);
            if (exp[0] != null) {
                PrintWriter pn = new PrintWriter(fw);
                pn.println(i + 1 + "、" + results[i]);
                pn.flush();
                fw.flush();
                pn.close();
                fw.close();
            }
        } catch (IOException e) {
            System.out.println("输出答案的文件不存在！输出失败");
        }
    }


}
