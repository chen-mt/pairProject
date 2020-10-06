package util;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 后缀表达式类
 * @author cmt&gzq
 */
public class RPN {

    public static final Map<String, Integer> OP_WEIGHT = new HashMap<>();

    /**
     * 设置权重，只考虑加减乘除
     */
    static {
        OP_WEIGHT.put("+", 0);
        OP_WEIGHT.put("-", 0);
        OP_WEIGHT.put("×", 1);
        OP_WEIGHT.put("÷", 1);
    }

    /**
     * 将中缀表达式转换为后缀表达式
     * @param exp 中缀表达式
     * @return 返回后缀表达式
     */
    public static String toRPN(String exp){
        StringBuffer result = new StringBuffer();
        Stack<String> operators = new Stack();
        for(String s: exp.split(" ")){
            if(OP_WEIGHT.containsKey(s)){
                /*
                遍历栈中的运算符，判断栈顶的运算符的权重是否大于等于当前运算符的权重。
                如果是，则将栈中的运算符弹出。否则，将遇到的操作符压入到栈中。
                 */
                while (!operators.isEmpty() && (OP_WEIGHT.get(operators.peek()) >= OP_WEIGHT.get(s))){
                    result.append(operators.pop() + " ");
                }
                operators.push(s);
            }else{
                result.append(s + " ");
            }
        }
        // 弹出栈中的运算符
        while(operators.size() > 0){
            result.append(operators.pop() + " ");
        }
        return result.toString();
    }
}
