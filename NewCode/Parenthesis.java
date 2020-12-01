package NewCode;

import java.util.Stack;

/**
 * @description:
 * @author: Deepcola
 * @time: 2020/12/1 17:08
 */
public class Parenthesis {

    public static boolean chkParenthesis(String A, int n){
        if (A == null || A.length() == 0) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == '(') {
                stack.push(A.charAt(i));
            }else if (A.charAt(i) ==')') {
                if (stack.isEmpty()) {
                    return false;
                }else {
                    stack.pop();
                }
            }else {
                return false;
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String A = "()()(())()(()()";
        System.out.println(chkParenthesis(A, 7));
    }
}
