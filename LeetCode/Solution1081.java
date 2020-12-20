package LeetCode;

/**
 * @description: 不同字符的最小子序列
 * 返回字符串 text 中按字典序排列最小的子序列，该子序列包含 text 中所有不同字符一次。
 * 输入："cdadabcc"
 * 输出："adbc"
 *
 * 输入："abcd"
 * 输出："abcd"
 *
 * 输入："ecbacba"
 * 输出："eacb"
 *
 * 输入："leetcode"
 * 输出："letcod"
 * @author: Deepcola
 * @time: 2020/12/20 14:27
 */
public class Solution1081 {

    public String smallestSubsequence(String s) {
        int[] count = new int[26];// 计数数组
        boolean[] flag = new boolean[26];// 栈中是否已存在
        // 计数
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        // 维护
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // "栈"中不存在
            if (!flag[ch - 'a']) {
                // 不满足最小字典序并且后面还有该元素
                while (sb.length() > 0 && sb.charAt(sb.length()-1) > ch && count[sb.charAt(sb.length()-1) - 'a'] > 0) {
                    // 不存在了
                    flag[sb.charAt(sb.length()-1) - 'a'] = false;
                    // 删除
                    sb.deleteCharAt(sb.length()-1);
                }
                // 进去
                sb.append(ch);
                flag[ch - 'a'] = true;
            }
            // 存在不存在都这个元素都已经遍历过
            count[ch - 'a']--;
        }
        return sb.toString();
    }
}
