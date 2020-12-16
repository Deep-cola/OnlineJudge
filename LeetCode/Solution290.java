package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 单词规律
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 *
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 *
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 *
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * @author: Deepcola
 * @time: 2020/12/16 7:18
 */
public class Solution290 {

    /**
     * 将 s 分割为数组
     * 使用 map 存放相对应位置的 pattern 和 string[i];
     * 1.如果 map 中没有当前位置的 pattern,那 map 也不应该存在相同的 value;
     * 2.如果 map 中已有当前位置的 pattern,那两个位置的 value 也应该相等.
     * 时间复杂度 O(M*N): N为 pattern 长度, M 为不重复长度
     */
    /*public boolean wordPattern(String pattern, String s) {
        String[] strings = s.split(" ");
        if (pattern.length() != strings.length) return false;
        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            String str = map.getOrDefault(pattern.charAt(i), "0");
            // 前面没有相同的
            if (str.equals("0")) {
                // map 中不应该存在相同的 value.
                if (map.containsValue(strings[i])) {
                    return false;
                }
                map.put(pattern.charAt(i), strings[i]);
            }else {
                // 前面有相同的,但是 value 不同
                if (!strings[i].equals(str)) {
                    return false;
                }
            }
        }
        return true;
    }*/

    /**
     * 使用两个 map 减少时间复杂度, 但是不使用 split 函数
     * 双向检查
     */
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> ch2str = new HashMap<>();
        HashMap<String, Character> str2ch = new HashMap<>();
        int length = s.length();
        int index = 0;
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if (index >= length) {
                return false;
            }
            // 分割字符串
            int temp = index;
            while (index < length && s.charAt(index) != ' ') {
                index++;
            }
            String str = s.substring(temp, index);
            // 双向判断
            if (ch2str.containsKey(ch) && !ch2str.get(ch).equals(str)) {
                return false;
            }
            if (str2ch.containsKey(str) && str2ch.get(str) != ch) {
                return false;
            }
            // 装入
            ch2str.put(ch, str);
            str2ch.put(str, ch);
            index += 1;
        }
        return index >= length;
    }

    public static void main(String[] args) {
        Solution290 solution = new Solution290();
        String pattern = "aba";
        String s = "dog cat dog dog";
        System.out.println(solution.wordPattern(pattern, s));
    }
}
