package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @description: 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * @author: Deepcola
 * @time: 2020/12/14 0:19
 */
public class Solution49 {

    /**
     * 比较妙的
     * 26 个字母每一个对应一个 质数;
     * 1.遍历字符串数组, 计算每个字符串的乘积, 如果两个字符串是异位词, 那么他们的乘积相同
     * 2.使用 nap 储存对应的字符串: key 是乘积, value 是对应的字符串
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
        HashMap<Double, List<String>> map = new HashMap<>();
        for (String s: strs) {
            double key = 1;
            for (int i = 0; i < s.length(); i++) {
                key *= primes[s.charAt(i) - 'a'];
            }
            System.out.println(key);
            List<String> value = map.getOrDefault(key, new ArrayList<>());
            value.add(s);
            map.put(key, value);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 使用 HashMap
     * 对于字母异位词, 排序之后的字符串时一样的。
     * 所以可以将排序后的字符串作为 key,而将原来的字符串作为 value,由于可能存在的异位词缘故, value 的形式应该是list
     * 1.遍历字符串数组，对于每个字符串(数组)进行排序作为储存的 key;
     * 2.装入 map:
     *      (1)如果 map 中存在: 就将当前字符串装入 key 对应的 list;
     *      (2)如果 map 中不存在: 就新创建一个 list。
     * 3.返回 map 的 value 即可
     */
    /*public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s: strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            // 装入 map
            String key = new String(chars);
            List<String> value = map.getOrDefault(key, new ArrayList<>());
            value.add(s);
            map.put(key, value);
        }
        return new ArrayList<>(map.values());
    }*/

    /**
     * 计数数组
     * 相当于对每个字符串字母计数, 代替了排序
     */
    /*public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s: strs) {
            int[] count = new int[26];
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i)-'a']++;
            }
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if (count[i] != 0) {
                    sb.append((char) i + 'a');
                    sb.append(count[i]);
                }
            }
            String key = sb.toString();
            List<String> value = map.getOrDefault(key, new ArrayList<>());
            value.add(s);
            map.put(key, value);
        }
        return new ArrayList<>(map.values());
    }*/
}
