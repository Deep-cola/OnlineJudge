package leetcode;

import java.util.Stack;

/**
 * @description: 仅仅翻转字母
 * 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
 *
 * 示例 1：
 * 输入："ab-cd"
 * 输出："dc-ba"
 *
 * 示例 2：
 * 输入："a-bC-dEf-ghIj"
 * 输出："j-Ih-gfE-dCba"
 *
 * 示例 3：
 * 输入："Test1ng-Leet=code-Q!"
 * 输出："Qedo1ct-eeLg=ntse-T!"
 *  
 * 提示：
 * S.length <= 100
 * 33 <= S[i].ASCIIcode <= 122 
 * S 中不包含 \ or "
 * @author: Deepcola
 * @time: 2021/2/22 20:33
 */
public class Solution917 {

    /**
     * 双指针
     */
    /*public String reverseOnlyLetters(String S) {
        int i = 0;
        int j = S.length() - 1;
        StringBuilder result = new StringBuilder();
        while (i < S.length()) {
            if (Character.isLetter(S.charAt(i))) {
                // 当前位置为字母
                while (!Character.isLetter(S.charAt(j))) {
                    j--;
                }
                result.append(S.charAt(j--));
            }else {
                result.append(S.charAt(i++));
            }
            i++;
        }
        return result.toString();
    }*/

    /**
     * 栈
     */
    public String reverseOnlyLetters(String S) {
        Stack<Character> stack = new Stack<>();
        // 入栈
        for (int i = 0; i < S.length(); i++) {
            if (Character.isLetter(S.charAt(i))) {
                stack.push(S.charAt(i));
            }
        }
        // 出栈
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (Character.isLetter(S.charAt(i))) {
                result.append(stack.pop());
            }else {
                result.append(S.charAt(i));
            }
        }
        return result.toString();
    }
}
