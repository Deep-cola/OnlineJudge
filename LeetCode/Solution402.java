package leetcode;

import java.util.Stack;

/**
 * @description: 移掉 k 位数字
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 * 注意: (1)num 的长度小于 10002 且 ≥ k。(2)num 不会包含任何前导零。
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 *
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 *
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 * @author: Deepcola
 * @time: 2020/12/24 22:46
 */
public class Solution402 {

    /**
     * 1.从左向右遍历, 删除第一个相邻元素中后一个小于前一个的元素
     * 2.删除前导零
     * 3.遍历 k 次即可
     */
    public String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";
        StringBuilder sb = new StringBuilder(num);
        while (k-- > 0){
            int index = 0;
            int i = 1;
            // 查找
            while (i < sb.length() && sb.charAt(i) >= sb.charAt(i - 1)) {
                index = i;
                i++;
            }
            // 删除第一个相邻元素中后一个小于前一个的元素
            sb.deleteCharAt(index);
            // 删除前导零
            while (sb.length() > 1 && sb.charAt(0) == '0') {
                sb.deleteCharAt(0);
            }
        }
        return sb.toString();
    }

    /**
     * 维护一个单调栈:
     *      在相邻的两个元素中, 如果后边的元素小于前面的元素, 那么在一定的基础上(删除掉的元素个数不足)就可以删掉前面的元素
     */
    /*public String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";
        StringBuilder sb = new StringBuilder();
        int end = num.length() - k;
        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            // 在删除个数还不够的情况下维持单调
            while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch && k-- > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            // 删除前导零
            if (ch == '0' && sb.length() == 0) {
                end--;
                continue;
            }
            // 连接
            sb.append(ch);
        }
        // 截取 减去 k 和前导零个数 的字符串
        // 由于维持的是单调的, 所以从左向右截取即可
        String result = sb.substring(0, end);
        // 长度为 0 代表剩余的都是 0
        return result.length() == 0 ? "0" : result;
    }*/

    public static void main(String[] args) {
        Solution402 solution = new Solution402();
        String num = "1432219";
        int k = 3;
        System.out.println(solution.removeKdigits(num, k));
    }
}
