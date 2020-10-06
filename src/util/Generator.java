package util;

import java.util.Random;

/**
 * 题目生成类
 * @author cmt&gzq
 */
public class Generator {

    /**
     * 生成题目
     * @param range 题目中数值的范围
     * @return 运算题目
     */
    public static String generate(int range){
        String[] operators = {"+", "-", "×", "÷"};
        Random random = new Random();
        // 操作数的数目
        int count = random.nextInt(3) + 2;
        // 操作数
        int num[] = new int[4];
        num[0] = random.nextInt(range);
        num[1] = random.nextInt(range);
        num[2] = random.nextInt(range);
        num[3] = random.nextInt(range);
        // 运算符
        String[] operator = new String[3];
        operator[0] = operators[random.nextInt(4)];
        operator[1] = operators[random.nextInt(4)];
        operator[2] = operators[random.nextInt(4)];

        switch (count){
            case 2:
                return num[0] + " " + operator[0] + " " + num[1];
            case 3:
                return num[0] + " " + operator[0] + " " + num[1] + " " + operator[1] + " " + num[2];
            default:
                return num[0] + " " + operator[0] + " " + num[1] + " " + operator[1] + " " + num[2] + " " + operator[2] + " " + num[3];
        }
    }
}
