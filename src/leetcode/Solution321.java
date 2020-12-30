package leetcode;

import java.util.Arrays;

/**
 * @description: 拼接最大数
 * 给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。
 * 现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
 * 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。
 *
 * 输入:      nums1 = [3, 4, 6, 5]      nums2 = [9, 1, 2, 5, 8, 3]    k = 5
 * 输出:      [9, 8, 6, 5, 3]
 *
 * 输入:      nums1 = [6, 7]            nums2 = [6, 0, 4]             k = 5
 * 输出:      [6, 7, 6, 0, 4]
 *
 * 输入:      nums1 = [3, 9]            nums2 = [8, 9]                k = 3
 * 输出:      [9, 8, 9]
 * @author: Deepcola
 * @time: 2020/12/2 20:25
 */
public class Solution321 {

    /**
     * 输入:  nums1 = [3, 4, 6, 5]  nums2 = [9, 1, 2, 5, 8, 3]   k = 5
     * 输出:  [9, 8, 6, 5, 3]
     * 维护一个单调栈: 基本上相当于  从每一个数组中选出最大的子序列 这个类型
     * 不同的是: 从两个数组中分别选出最大子序列, 拼接成最大子序列, 与其他情况进行比较
     *
     * 对于上面的例子来说选择的情况有 5 种 : 0 + 5; 1 + 4; 2 + 3; 3 + 2; 4 + 1.取出 5 种情况最大的数即可
     * Math.max(0,k-nums2.length): 如果 num2.length > k, nums1 就可以从 0 开始;
     *                             如果 nums.length < k, 说明 nums2 子序列长度最大只能是 k-nums2.length；
     *                             剩下不够的只能从 num1 中补, 此时 nums1 的子序列长度是最小的
     *
     */
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] result = new int[k];
        // start end 都是子序列元素数量
        // 如果 num2.length 大于 k, nums1 就可以从 0 开始
        // 如果 nums2 都没有 k 个元素, 说明它的子序列长度最大只能为(nums.length),那么 nums1 必须要补齐元素数量, 从缺少的元素数量开始选最大子序列
        int start = Math.max(0,k-nums2.length);
        // 不论 nums1 从哪开始，最多只能由 k 个元素, 或者说 nums1 剩下的长度不足 k 个
        int end = Math.min(nums1.length, k);
        for (int i = start; i <= end; i++) {
            // nums1 和 nums2 对于相应长度的最大子序列(两个子序列长度之和必定是 k)
            int[] subsequence1 = maxSubSequence(nums1, i);
            int[] subsequence2 = maxSubSequence(nums2, k - i);
            // 归并排序后 nums1 和 nums2 组成的 k 个元素最大子序列
            int[] maxSubSequence = merge(subsequence1, subsequence2, k);
            if (compare(maxSubSequence, 0, result, 0) > 0) {
                System.arraycopy(maxSubSequence, 0, result, 0, k);
            }
        }
        return result;
    }

    /**
     *
     * @param nums 待找出最大子序列的数组
     * @param k 最大子序列长度
     * @return 最大子序列数组
     */
    public int[] maxSubSequence(int[] nums, int k) {
        int n = nums.length;
        // 使用数组作为一个单调栈
        int[] stack = new int[k];
        // 栈顶元素
        int top = -1;
        // 剩下没入栈的元素数量
        int remain = n - k;
        for (int i = 0; i < n; i++) {
            // 维护单调栈
            while (top >= 0 && nums[i] > stack[top] && remain > 0) {
                top--;
                remain--;
            }
            // 元素入栈
            if (top < k - 1) {
                stack[++top] = nums[i];
            }else {
                remain--;
            }
        }
        return stack;
    }

    /**
     *
     * @param nums1 序列 1
     * @param nums2 序列 2
     * @param k 序列 1 和 2 的总长度
     * @return 序列 1 和序列 2 归并排序后组成的数组
     */
    public int[] merge(int[] nums1, int[] nums2, int k) {
        if (nums1.length == 0) return nums2;
        if (nums2.length == 0) return nums1;
        int[] temp = new int[k];
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < k; i++) {
            if (compare(nums1, index1, nums2, index2) > 0) {
                temp[i] = nums1[index1++];
            }else {
                temp[i] = nums2[index2++];
            }
        }
        return temp;
    }

    /**
     *
     * @param nums1 序列 1
     * @param index1 序列 1 的开始下标
     * @param nums2 序列 2
     * @param index2 序列 2 的开始下标
     * @return >0   ->   nums1 > nums2
     *         <0   ->   nums1 < nums2
     *         =0   ->   nums1 = nums2
     */
    public int compare(int[] nums1, int index1, int[] nums2, int index2) {
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] - nums2[index2] != 0) {
                return nums1[index1] - nums2[index2];
            }else {
                index1++;
                index2++;
            }
        }
        return (nums1.length - index1) - (nums2.length - index2);
    }

    public static void main(String[] args) {
        Solution321 solution = new Solution321();
        int[] nums1 = {3,4,6,5};
        int[] nums2 = {9,1,2,5,8,3};
        int k = 5;
        System.out.println(Arrays.toString(solution.maxNumber(nums1, nums2, k)));
    }
}
