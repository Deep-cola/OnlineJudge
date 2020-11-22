package LeetCode;

import java.util.HashMap;

/**
 * @description: 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * @author: Deepcola
 * @time: 2020/11/22 17:11
 */
public class Solution387 {

    /**
     * 1.使用 hashmap 统计出现字符以及相应的次数
     * 2.遍历原字符串数组(s 相随应的), 如果当前字符出现次数是 1 次，返回下标
     */
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        // 统计出现字符以及出现次数
        for (Character ch: chars) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        // 遍历原数组检索第一次出现 1 次的
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;
    }
}
