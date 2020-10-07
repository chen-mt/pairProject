import service.Calculate;
import util.Generator;
import util.MyFile;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入生成题目的个数：");
        int num = sc.nextInt();
        System.out.print("题目中数值（自然数、真分数和真分数分母）的范围：");
        int range = sc.nextInt();
        sc.close();

        // 清空Exercises.txt,Answers.txt的内容
        MyFile.clear("Exercises.txt");
        MyFile.clear("Answers.txt");

        Calculate calculate = new Calculate();
        // 序号
        int order = 1;
        while (num > 0){
            // 生成题目
            String question = Generator.generate(range);
            MyFile.write("Exercises.txt", order + ". " + question);
            // 计算答案
            String answer = calculate.calculate(question);
            MyFile.write("Answers.txt", order + ". " + answer);
            num--; order++;
        }
    }
}
