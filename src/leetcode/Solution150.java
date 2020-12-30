package leetcode;

import java.util.Stack;

/**
 * @description: 逆波兰表达式求值
 * 根据 逆波兰表示法，求表达式的值。
 *
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * 说明：
 *      整数除法只保留整数部分。
 *      给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * @author: Deepcola
 * @time: 2020/11/16 19:47
 */
public class Solution150 {

    /**
     * 遇到数字压栈，遇到运算符弹出运算数进行运算，之后把结果压入栈中直到遍历完就可以了
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Integer op1,op2;
        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            switch (s) {
                case "+":
                    op1 = Integer.valueOf(stack.pop());
                    op2 = Integer.valueOf(stack.pop());
                    stack.push(op1 + op2);
                    break;
                case "-":
                    op1 = Integer.valueOf(stack.pop());
                    op2 = Integer.valueOf(stack.pop());
                    stack.push(op2 - op1);
                    break;
                case "*" :
                    op1 = Integer.valueOf(stack.pop());
                    op2 = Integer.valueOf(stack.pop());
                    stack.push(op1 * op2);
                    break;
                case "/":
                    op1 = Integer.valueOf(stack.pop());
                    op2 = Integer.valueOf(stack.pop());
                    stack.push(op2 / op1);
                    break;
                default:
                    stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        Solution150 solution = new Solution150();
        System.out.println(solution.evalRPN(tokens));
    }
}
