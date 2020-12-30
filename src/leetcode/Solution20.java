package leetcode;

import java.util.Stack;

/**
 * @description: 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 *      左括号必须用相同类型的右括号闭合。
 *      左括号必须以正确的顺序闭合。
 *      注意空字符串可被认为是有效字符串。
 * 输入: "()"     "()[]{}"      "(]"      "([)]"     "{[]}"
 * 输出: true       true       false       false     true
 * @author: Deepcola
 * @time: 2020/11/16 16:27
 */
public class Solution20 {

    /**
     * 左括号入栈，右括号出栈，检查是否匹配，最后检查右括号是否有剩余或者栈是否不为空
     */
    public boolean isValid(String s) {
        if (s == null) return true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            // 左括号入栈
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            }else {
                if (stack.isEmpty()) {
                    // 栈为空但是还有右括号
                    return false;
                }else {
                    // 右括号出栈
                    char ch = stack.pop();
                    // 检查是否匹配
                    if(s.charAt(i) == ')' && ch == '(' ||
                            s.charAt(i) == ']'  && ch == '[' ||
                            s.charAt(i) == '}' && ch == '{' ) {
                        continue;
                    }else return false;
                }
            }
        }
        // 右括号已完，检查栈是否为空(还有没有左括号未匹配)
        if (!stack.isEmpty()) return false;
        return true;
    }

    public static void main(String[] args) {
        String s = "{[]}";
        Solution20 solution = new Solution20();
        System.out.println(solution.isValid(s));
    }
}
