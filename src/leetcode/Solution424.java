package leetcode;

/**
 * @description: 替换后的最长重复字符
 * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。
 * 在执行上述操作后，找到包含重复字母的最长子串的长度。
 * 注意：字符串长度 和 k 不会超过 104。
 *
 * 示例 1：
 * 输入：s = "ABAB", k = 2
 * 输出：4
 * 解释：用两个'A'替换为两个'B',反之亦然。
 *
 * 示例 2：
 * 输入：s = "AABABBA", k = 1
 * 输出：4
 * 解释：
 * 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
 * 子串 "BBBB" 有最长重复字母, 答案为 4。
 * @author: Deepcola
 * @time: 2021/2/2 20:41
 */
public class Solution424 {

    /**
     * 双指针 + 滑动窗口
     */
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int left = 0;
        int right = 0;
        int max = 0;
        // 统计窗口中出现的字符种类数量
        int[] count = new int[26];
        while (right < n) {
            count[s.charAt(right) - 'A']++;
            // 出现次数最多的字符
            max = Math.max(max, count[s.charAt(right) - 'A']);
            // 窗口中出现应该替换字符数量大于可替换次数
            if (right - left + 1 - max > k) {
                // 窗口右移
                count[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }
        return right - left;
    }
}
