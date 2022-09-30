import com.CheckAnswer;
import com.Question;

import java.util.Scanner;

/**
 * @author Hte
 */
public class Main {
    /**
     * 范围数字,即随机数最大值
     */
    public static int range;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入产生几以内的数字：");
        range = sc.nextInt();
        System.out.println("请输入产生多少个运算表达式：");
        int num = sc.nextInt();
        String[] results = Question.createAndSolve(range, num);
        System.out.println("输入commit,提交答案！");
        String com = "commit";
        int x = 0;
        Scanner sc1 = new Scanner(System.in);
        String submit = sc1.nextLine();
        while (com.equals(submit) && x == 0) {
            CheckAnswer.inputAnswerAndCheck(num, results);
            x++;
        }
    }
}
