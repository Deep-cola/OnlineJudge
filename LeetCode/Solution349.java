package LeetCode;

import java.util.*;

/**
 * @description: 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * @author: Deepcola
 * @time: 2020/11/22 16:19
 */
public class Solution349 {

    /**
     * 将一个数组的元素装入 set, 然后遍历另一个数组与 set 进行比较,
     * 如果相同在 set 中删除这个元素(打印一次就行), 然后装入 list,
     * 最后转为数组就行
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return null;
        Set<Integer> set = new TreeSet<>();
        // nums1 装入 set
        for (int i: nums1) {
            set.add(i);
        }
        // 遍历 nums2 , 和 set 中相同的元素装入 list, 然后删除 set 中的相应元素
        List<Integer> list = new ArrayList<>();
        for (int i: nums2) {
            if (set.contains(i)) {
                list.add(i);
                set.remove(i);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }


    public static void main(String[] args) {
        Solution349 solution = new Solution349();
        int[] nums1 = {9,4,9,8,5};
        int[] nums2 = {4,9,5};
        System.out.println(Arrays.toString(solution.intersection(nums1, nums2)));
    }
}
