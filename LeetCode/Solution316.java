package LeetCode;

import java.util.HashMap;

/**
 * @description: 取出重复字母
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * 输入：s = "bcabc"
 * 输出："abc"
 *
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 * @author: Deepcola
 * @time: 2020/12/20 0:27
 */
public class Solution316 {

    public String smallestSubsequence(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 1);
        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {

            }else {
                map.put(ch, 1);
            }
        }
    }


}
