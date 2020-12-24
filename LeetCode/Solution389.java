package leetcode;

/**
 * @description: 找不同
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * 请找出在 t 中被添加的字母。
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 *
 * 输入：s = "", t = "y"
 * 输出："y"
 *
 * 输入：s = "a", t = "aa"
 * 输出："a"
 *
 * 输入：s = "ae", t = "aea"
 * 输出："a"
 * @author: Deepcola
 * @time: 2020/12/18 0:02
 */
public class Solution389 {

    /**
     * 使用数组先装后出
     * 24%————75%
     */
    /*public char findTheDifference(String s, String t) {
        int[] count = new int[26];
        // 装
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        // 出
        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i) - 'a']--;
            if (count[t.charAt(i) - 'a'] == -1) {
                return t.charAt(i);
            }
        }
        return ' ';
    }*/

    /**
     * 位运算
     * 44%——44%
     */
    /*public char findTheDifference(String s, String t) {
        StringBuffer sb = new StringBuffer();
        sb.append(s).append(t);
        char ch = 0;
        for (int i = 0; i < sb.length(); i++) {
            ch ^= sb.charAt(i);
        }
        return ch;
    }*/

    /**
     * 位运算
     * 76%——56%
     */
    public char findTheDifference(String s, String t) {
        char ch = t.charAt(s.length());
        for (int i = 0; i < s.length(); i++) {
            ch ^= s.charAt(i) ^ t.charAt(i);
        }
        return ch;
    }


    /**
     * 求和做差
     * 76%——58%
     */
    /*public char findTheDifference(String s, String t) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += t.charAt(i) - s.charAt(i);
        }
        return (char) (result+t.charAt(t.length()-1));
    }
*/
}
