package test;

import entity.Fraction;
import service.Calculate;
import util.Generator;
import util.MyFile;

import java.util.List;
import java.util.Map;

public class Test {

    Calculate calculate = new Calculate();

    /**
     * 测试生成题目
     */
    @org.junit.Test
    public void testGenerator(){
        System.out.println(Generator.generate(10));
    }

    /**
     * 测试写入文件
     */
    @org.junit.Test
    public void testWriteFile(){
        MyFile.write("Exercises.txt", Generator.generate(10));
    }

    /**
     * 测试整数四则运算
     */
    @org.junit.Test
    public void testIntArithmetic(){
        int num1, num2;
        num1 = 1; num2 = 3;
        char operator = '÷';
        Map map = calculate.intArithmetic(num1, num2, operator);
        System.out.println(num1 + " " + operator + " " + num2 + " = " + calculate.toString(map));
    }

    /**
     * 测试分数四则运算
     */
    @org.junit.Test
    public void testFractionArithmetic(){
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(1, 2);
        char operator = '÷';
        Map map = calculate.fractionArithmetic(fraction1, fraction2, operator);
        System.out.println(fraction1.toString() + " " + operator + " " + fraction2.toString() + " = "
                + calculate.toString(map));
    }

    @org.junit.Test
    public void testLocation(){
        char[] operator = {'+', '×', '×'};
        int count = 3;
        List<Integer> locations = calculate.location(operator, count);
        for(int i: locations){
            System.out.println(i + " ");
        }
    }

    @org.junit.Test
    public void testCalculate(){
        int[] num = {2, 4};
        char[] operator = {'-'};
        int count = 2;
        String s = this.calculate.calculate(count, num, operator);
        System.out.println("运算结果：" + s);
    }
}
