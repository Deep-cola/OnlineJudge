package LeetCode;

/**
 * @description: 上升下降字符串
 * 给你一个字符串 s ，请你根据下面的算法重新构造字符串：
 *      1.从 s 中选出 最小 的字符，将它 接在 结果字符串的后面。
 *      2.从 s 剩余字符中选出 最小 的字符，且该字符比上一个添加的字符大，将它 接在 结果字符串后面。
 *      3.重复步骤 2 ，直到你没法从 s 中选择字符。
 *      4.从 s 中选出 最大 的字符，将它 接在 结果字符串的后面。
 *      5.从 s 剩余字符中选出 最大 的字符，且该字符比上一个添加的字符小，将它 接在 结果字符串后面。
 *      6.重复步骤 5 ，直到你没法从 s 中选择字符。
 *      7.重复步骤 1 到 6 ，直到 s 中所有字符都已经被选过。
 *      在任何一步中，如果最小或者最大字符不止一个 ，你可以选择其中任意一个，并将其添加到结果字符串。
 * 请你返回将 s 中字符重新排序后的 结果字符串 。
 *
 * 输入：s = "aaaabbbbcccc"
 * 输出："abccbaabccba"
 * 解释：第一轮的步骤 1，2，3 后，结果字符串为 result = "abc"
 * 第一轮的步骤 4，5，6 后，结果字符串为 result = "abccba"
 * 第一轮结束，现在 s = "aabbcc" ，我们再次回到步骤 1
 * 第二轮的步骤 1，2，3 后，结果字符串为 result = "abccbaabc"
 * 第二轮的步骤 4，5，6 后，结果字符串为 result = "abccbaabccba"
 * @author: Deepcola
 * @time: 2020/11/25 7:23
 */
public class Solution1370 {

    /**
     * 1.定义一个 "字典", 用来存储每个字母在字符串中的数量, 方便后面直接添加相应的字母就还
     * 2.遍历数组将对应下标的值修改为对应字母的数量
     * 3.从前向后遍历数组, 对应下标数值不为 0 就将对应字母连接到字符串中(从小到大)
     * 4.从后向前遍历数组, 同上
     * 5.重复执行3、4 直至新字符串长度和原来的相等
     */
    public String sortString(String s) {
        StringBuffer sb = new StringBuffer();
        int[] nums = new int[26];
        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i) - 'a']++;
        }
        while (sb.length() < s.length()) {
            // 从小到大
            for (int i = 0; i < 26; i++) {
                if (nums[i] > 0) {
                    sb.append((char)('a' + i));
                    nums[i]--;
                }
            }
            // 从大到小
            for (int i = 25; i >= 0; i--) {
                if (nums[i] > 0) {
                    sb.append((char)('a' + i));
                    nums[i]--;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution1370 solution = new Solution1370();
        String s = "aaaabbbbcccc";
        System.out.println(solution.sortString(s));
    }
}
