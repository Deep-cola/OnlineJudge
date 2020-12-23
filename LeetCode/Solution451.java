package LeetCode;

import java.util.*;

/**
 * @description: 根据字符出现频率排序
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 * 输入:"tree"
 * 输出:"eert"
 * 解释:'e'出现两次，'r'和't'都只出现一次。因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 *
 * 输入:"cccaaa"
 * 输出:"cccaaa"
 * 解释:'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 *
 * 输入:"Aabb"
 * 输出:"bbAa"
 * 解释:此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。注意'A'和'a'被认为是两种不同的字符。
 * @author: Deepcola
 * @time: 2020/12/23 7:37
 */
public class Solution451 {

    /**
     * 1.使用哈希表统计出现字符以及相应的次数
     * 2.使用堆进行排序
     * 3.根据排序结果进行连接
     */
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        // 统计
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        // 排序 -> 小根堆
        PriorityQueue<Character> queue = new PriorityQueue<>((o1, o2) -> map.get(o1) - map.get(o2));
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            queue.offer(entry.getKey());
        }
        // 根据排序结果连接
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char ch = queue.poll();
            while (map.getOrDefault(ch, 0) != 0) {
                sb.insert(0, ch);
                map.put(ch, map.getOrDefault(ch, 0) - 1);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution451 solution = new Solution451();
        String s = "raaeaedere";
        System.out.println(solution.frequencySort(s));
    }

}
