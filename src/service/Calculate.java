package service;

import entity.Fraction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 算数运算类
 * @author cmt&gzq
 */
public class Calculate {

    /**
     * 四则运算
     * @param count 操作数的数目
     * @param num 操作数数组
     * @param operator 运算符数组
     * @return 运算结果
     */
    public String calculate(int count, int[] num, char[] operator){
        Map<String, Object> map = null;
        if(count == 2){
            map = intArithmetic(num[0], num[1], operator[0]);
        }else if(count == 3){
            // todo:

        }else{// 操作数=4

        }
        return toString(map);
    }

    /**
     * 中间运算时不返回 String 类型，最后的结果才返回 String 类型
     * @param map 中间结果
     * @return
     */
    public String toString(Map<String, Object> map){
        if(map.containsKey("integer")){
            return map.get("integer").toString();
        }else if(map.containsKey("fraction")){
            return map.get("fraction").toString();
        }
        return map.get("error").toString();
    }

    /**
     * 找出'×','÷'所在位置
     * @param operator 运算符数组
     * @param count 运算符的数目
     * @return
     */
    public List<Integer> location(char[] operator, int count){
        List<Integer> locations = new ArrayList();
        for(int i = 0; i < count; i++){
            if(operator[i] == '×' || operator[i] == '÷')
                locations.add(i);
        }
        return locations;
    }

//    /**
//     * 将字符串化为分数
//     * @param s 字符串，如"3/5", "2'3/8", "2"
//     * @return
//     */
//    public Fraction strToFraction(String s){
//        int numerator, denominator;
//        if (s.contains("'")){
//            // 带分数
//            denominator = Integer.parseInt(s.split("/")[1]);
//            numerator = Integer.parseInt(s.split("'")[0]) * denominator + Integer.parseInt(s.split("'")[1]);
//        }else if(s.contains("/")){
//            // 真分数
//            numerator = Integer.parseInt(s.split("/")[0]);
//            denominator = Integer.parseInt(s.split("/")[1]);
//        }else{
//            // 整数
//            numerator = Integer.parseInt(s);
//            denominator = 1;
//        }
//        return new Fraction(numerator, denominator);
//    }

    /**
     * 整数的加减乘除运算
     * @param num1 操作数1
     * @param num2 操作数2
     * @param operator 运算符
     * @return 运算结果。如果结果为-1，表明输入的题目不符合规范。
     */
    public Map<String, Object> intArithmetic(int num1, int num2, char operator){
        Map<String, Object> map = new HashMap<>();
        int result;
        switch (operator){
            case '+':
                result = num1 + num2;
                break;
            case '-':
                if(num1 >= num2){
                    result = num1 - num2;
                }else{
                    map.put("error", "计算过程中不能产生负数");
                    return map;
                }
                break;
            case '×':
                result = num1 * num2;
                break;
            case '÷':
            default:
                // todo: 分母不能为0
                if(num1 % num2 == 0){
                    result = num1 / num2;
                }else {
                    map.put("fraction", new Fraction(num1, num2));
                    return map;
                }

        }
        map.put("integer", result);
        return map;
    }


    /**
     * 分数的加减乘除运算
     * @param fraction1 分数1
     * @param fraction2 分数2
     * @param operator 操作符
     * @return 运算结果。如果结果为-1，表明输入的题目不符合规范。
     */
    public Map<String, Object> fractionArithmetic(Fraction fraction1, Fraction fraction2, char operator){
        Map<String, Object> map = new HashMap<>();
        // 获取分数的分子、分母
        int fraction1Numerator = fraction1.getNumerator();
        int fraction1Denominator = fraction1.getDenominator();
        int fraction2Numerator = fraction2.getNumerator();
        int fraction2Denominator = fraction2.getDenominator();
        // 新分数的分子、分母
        int newNumerator, newDenominator;
        switch (operator){
            case '+':
                newNumerator = fraction1Numerator * fraction2Denominator + fraction2Numerator * fraction1Denominator;
                newDenominator = fraction1Denominator * fraction2Denominator;
                break;
            case '-':
                // 计算过程不能产生负数
                if((newNumerator = fraction1Numerator * fraction2Denominator - fraction2Numerator * fraction1Denominator) < 0){
                    map.put("error", "计算过程中不能产生负数");
                    return map;
                }else{
                    newDenominator = fraction1Denominator * fraction2Denominator;
                }
                break;
            case '×':
                newNumerator = fraction1Numerator * fraction1Numerator;
                newDenominator = fraction1Denominator * fraction2Denominator;
                break;
            case '÷':
            default:
                // todo: 分母不能为0
                newNumerator = fraction1Numerator * fraction2Denominator;
                newDenominator = fraction1Denominator * fraction2Numerator;
        }

        // 运算结果为整数
        if(newNumerator % newDenominator == 0){
            map.put("integer", newNumerator / newDenominator);
            return map;
        }
        map.put("fraction", new Fraction(newNumerator, newDenominator));
        return map;
    }

}
