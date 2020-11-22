package LeetCode;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description: 同构字符串
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 * @author: Deepcola
 * @time: 2020/11/22 15:40
 */
public class Solution205 {

    /**
     * 判断某一个字母第一次出现的位置的下标是否相同
     */
    /*public boolean isIsomorphic(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))) {
                return false;
            }
        }
        return true;
    }*/

    /**
     * 1.长度不同的不重构
     * 2.判断 s 和 t 的情况
     *      s 不同但是 t 相同 -> false;
     *      s 相同但是 t 不同 -> false;
     *      都相同但是下标不一致 -> false;
     *      都相同下标一致 -> true
     */
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            // s 不同
            if (!map.containsKey(s.charAt(i))) {
                // t 相同
                if (map.containsValue(t.charAt(i))) {
                    return false;
                }
                // t 也不同
                map.put(s.charAt(i), t.charAt(i));

            }else {
                // s 相同, t 相同
                if (map.get(s.charAt(i)) == t.charAt(i)) {
                    map.put(s.charAt(i), t.charAt(i));
                }else {
                    // 下标不一致
                    return false;
                }
            }
        }
        return true;
    }

}
