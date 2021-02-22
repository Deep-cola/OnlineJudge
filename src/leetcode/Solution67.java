package leetcode;

/**
 * @description: 二进制求和
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 *
 * 示例 2:
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *  
 * 提示：
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 * @author: Deepcola
 * @time: 2021/2/22 21:36
 */
public class Solution67 {

    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder result = new StringBuilder();
        int carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            int num1 = (i == -1) ? 0 : a.charAt(i--) - '0';
            int num2 = (j == -1) ? 0 : b.charAt(j--) - '0';
            int num = num1 + num2 + carry;
            carry = num / 2;
            result.insert(0, num % 2);
        }
        return result.toString();
    }
}
