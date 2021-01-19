package leetcode;

import java.util.Arrays;

/**
 * @description: 三个数的最大乘积
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 *
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: 6
 *
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: 24
 *
 * 注意:
 *      给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
 *      输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
 * @author: Deepcola
 * @time: 2021/1/20 0:00
 */
public class Solution628 {

    /**
     * 数组排序
     * 1.全是正数 : 最大三个数乘积
     * 2.全是负数 : 最大三个数乘积
     * 3.有正有负 : num[0] * num[1] * nums[n - 1];
     */
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[nums.length - 1],
                nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
    }
}
