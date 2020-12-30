package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @description: 两个数组的交集Ⅱ
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * @author: Deepcola
 * @time: 2020/11/22 16:42
 */
public class Solution350 {

    /**
     * 1.使用 map 统计一个数组出现数字以及出现次数
     * 2.遍历另一个数组, 如果 map 中包含某个数字就加入 list, 同时，需要 map 中该数字出现次数 -1;
     * 3.只有 map 中包含该数字并且在 map 中出现次数不是 0 次, 才加入 list
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // 统计数字以及出现次数
        for (int i: nums1) {
            map.put(i, map.getOrDefault(i,0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int i :nums2) {
            // 检索 map 中是否有相应的元素
            // 得到该元素在 nums1 中出现的次数, 如果没有次数为 0
            int count = map.getOrDefault(i, 0);
            if (map.containsKey(i) && count != 0) {
                list.add(i);
                map.put(i, map.get(i) - 1);
                count--;
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution350 solution = new Solution350();
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        System.out.println(Arrays.toString(solution.intersect(nums1, nums2)));
    }
}
