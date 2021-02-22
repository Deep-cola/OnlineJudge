package leetcode;

import java.util.Arrays;

/**
 * @description: 第三大的数
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 *
 * 示例 1：
 * 输入：[3, 2, 1]
 * 输出：1
 * 解释：第三大的数是 1 。
 *
 * 示例 2：
 * 输入：[1, 2]
 * 输出：2
 * 解释：第三大的数不存在, 所以返回最大的数 2 。
 *
 * 示例 3：
 * 输入：[2, 2, 3, 1]
 * 输出：1
 * 解释：注意，要求返回第三大的数，是指第三大且唯一出现的数。
 * 存在两个值为2的数，它们都排第二。
 *
 * 提示：
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 *
 * 进阶：你能设计一个时间复杂度 O(n) 的解决方案吗？
 * @author: Deepcola
 * @time: 2021/2/22 21:21
 */
public class Solution414 {

    public int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;
        for (int num : nums) {
            // 过滤重复的数
            if (second == num || first == num) continue;
            if (num > first) {
                third = second;
                second = first;
                first = num;
            }else if (num > second) {
                third = second;
                second = num;
            }else if (num > third) {
                third = num;
            }
        }
        return (int) ((third == Long.MIN_VALUE) ? first : third);
    }
}
