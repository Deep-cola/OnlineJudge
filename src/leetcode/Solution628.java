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
    /*public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[nums.length - 1],
                nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
    }*/

    /**
     * 只需要找出排序之后的前两个数字和最后三个数字即可
     */
    public int maximumProduct(int[] nums) {
        // 最小的 和 第二小的
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        // 最大的 第二大的 第三大的
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        for (int x: nums) {
            if (x < min1) {
                // 最小的
                min2 = min1;
                min1 = x;
            }else if (x < min2) {
                // 大于最小的, 小于第二小的
                min2 = x;
            }

            if (x > max1) {
                // 最大的
                max3 = max2;
                max2 = max1;
                max1 = x;
            }else if (x > max2) {
                // 第二大的
                max3 = max2;
                max2 = x;
            }else if (x > max3) {
                // 第三大的
                max3 = x;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
}
