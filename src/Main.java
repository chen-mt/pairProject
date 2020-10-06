import util.Generator;
import util.MyFile;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入生成题目的个数：");
        int num = sc.nextInt();
        System.out.println();
        System.out.print("题目中数值（自然数、真分数和真分数分母）的范围：");
        int range = sc.nextInt();
        System.out.println();
        sc.close();

        while (num > 0){
            String question = "运算题目" + num + "：" + Generator.generate(range);
            // 将题目写入 Exercises.txt 文件
            MyFile.write("Exercises.txt", question);

            num++;
        }
    }
}
