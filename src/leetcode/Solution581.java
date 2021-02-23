package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @description: 最短无序连续子数组
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 *
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [2,6,4,8,10,9,15]
 * 输出：5
 * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：0
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：0
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 104
 * -105 <= nums[i] <= 105
 *  
 * 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？
 * @author: Deepcola
 * @time: 2021/2/23 15:31
 */
public class Solution581 {

    /**
     * 排序后比较
     */
    /*public int findUnsortedSubarray(int[] nums) {
        int[] clone = nums.clone();
        Arrays.sort(clone);
        int start = nums.length;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != clone[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        return (end >= start) ? end - start + 1 : 0;
    }*/

    public int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE;// 无序数组中最小的元素
        int max = Integer.MIN_VALUE;// 无序数组中最大的元素
        boolean flag = false;// 是否为无序数组
        // 查找无序数组中最小的元素
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                flag = true;
            }
            if (flag) {
                min = Math.min(min, nums[i]);
            }
        }
        // 查找无序数组中最大的元素
        flag = false;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                flag = true;
            }
            if (flag) {
                max = Math.max(max, nums[i]);
            }
        }
        int start = 0;
        // 查找 min 正确位置
        for (; start < nums.length; start++) {
            if (nums[start] > min) {
                break;
            }
        }
        int end = nums.length - 1;
        // 查找 max 正确位置
        for (; end >= 0; end--) {
            if (nums[end] < max) {
                break;
            }
        }
        return (start < end) ? end - start + 1 : 0;
    }
}
