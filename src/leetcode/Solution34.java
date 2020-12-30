package leetcode;

import java.util.Arrays;

/**
 * @description: 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * @author: Deepcola
 * @time: 2020/12/1 0:19
 */
public class Solution34 {

    /**
     * 遍历一遍数组, 将等于 target 的下标全取出来, 获得第一个和最后一个就行
     * 时间夫再度O(N)
     */
    /*public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                list.add(i);
            }
        }
        if (list.size() == 0) return result;
        result[0] = list.get(0);
        result[1] = list.get(list.size() - 1);
        return result;
    }*/

    /**
     * 1.利用二分查找第一个 大于等于 target 的下标就是 first; 第一个大于 target 的下标减去 1 就是 last
     * 2.判断所有情况都符合证明存在，否则不存在
     * 时间复杂度O(logN)
     */
    public int[] searchRange(int[] nums, int target) {
        // 二分查找
        // true 代表查找第一个大于等于 target 的下标
        // false 代表查找第一个大于 target 的下标
        int first = binarySearch(nums, target, true);
        int last = binarySearch(nums, target, false) - 1;
        // 判断合理性
        if (first <= last && last < nums.length && nums[first] == target && nums[last] == target) {
            return new int[]{first, last};
        }
        return new int[]{-1, -1};
    }

    /**
     * 二分查找
     * flag = true 代表查找第一个大于等于 target 的下标
     * flag = false 代表查找第一个大于 target 的下标
     * 进行查找时, 如果出现 mid 正好时 target
     *      1.查找 first 需要在左边查找
     *      2.查找 last 需要在右边查找
     */
    public int binarySearch(int[] nums, int target, boolean flag) {
        int left = 0;
        int right = nums.length - 1;
        int result = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            // target 应该在左区间查找
            if (nums[mid] > target || (flag && nums[mid] >= target)) {
                right = mid - 1;
                result = mid;
            }else {
                // 在右区间查找
                left = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution34 solution = new Solution34();
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(solution.searchRange(nums, target)));
    }
}
