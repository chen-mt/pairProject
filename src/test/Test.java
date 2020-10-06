package test;

import entity.Fraction;
import service.Calculate;
import util.Generator;
import util.MyFile;
import util.RPN;

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
        String operator = "÷";
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
        String operator = "÷";
        Map map = calculate.fractionArithmetic(fraction1, fraction2, operator);
        System.out.println(fraction1.toString() + " " + operator + " " + fraction2.toString() + " = "
                + calculate.toString(map));
    }

    /**
     * 测试将中缀表达式转换为后缀表达式
     */
    @org.junit.Test
    public void testToRPN(){
        String exp = "4 + 12 × 3";
        System.out.println("后缀表达式：" + RPN.toRPN(exp));
    }

    @org.junit.Test
    public void testCalculate(){
        String exp = "4 + 12 × 3";
        calculate.calculate(exp);
    }
}
