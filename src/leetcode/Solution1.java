package leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @description: 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * @author: Deepcola
 * @time: 2020/11/14 18:23
 */
public class Solution1 {
    /**
     * 假设每种输入只会对应一个答案，通过 target 减去 nums 中的元素，判断差值是否在数组中
     */
    /*public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                // 判断后面的元素中是否有 target - nums[i]
                if (target - nums[i] == nums[j]) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }*/

    /**
     * 创建哈希表，k-v 用于存放 nums[i] 和 i ,一趟遍历即可，寻找元素的时间复杂度由 O(N) 降为 O(1),但是空间复杂度由于哈希表存放元素
     */
    public int[] twoSum(int[] nums, int target) {
        // 创建哈希表
        HashMap<Integer,Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            // 判断哈希表中是否有 target - nums[i]
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{hashMap.get(target - nums[i]), i};
            }
            // 将判断过的键值对加入hashMap防止和自己匹配
            hashMap.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] result = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
}
