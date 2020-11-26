package LeetCode;

import java.util.Arrays;

/**
 * @description: 最大间距
 * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
 * 如果数组元素个数小于 2，则返回 0。
 *
 * 输入: [3,6,9,1]
 * 输出: 3
 * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
 * @author: Deepcola
 * @time: 2020/11/26 13:42
 */
public class Solution164 {

    /**
     * 1.数组排序
     * 2.计算差值并返回最大的
     */
    /*public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        // 排序
        Arrays.sort(nums);
        int result = 0;
        // 计算差值
        for (int i = 0; i < nums.length-1; i++) {
            int j = i + 1;
            int temp = nums[j] - nums[i];
            result = Math.max(result, temp);
        }
        return result;
    }*/

    /**
     * 1.基数排序进行数组排序
     *      1.找出数组的最大值
     *      2.取出每个元素的个位数( (num/1)%10 ), 放入对应桶中(0-9)
     *      3.按照桶中的元素进行数组排序
     *      4.取出每个元素的十位数( (num/10)%10 )重复前面操作
     *      5.重复取出每个元素的所有位数, 直到数组的最大值位数取完
     * 2.计算差值返回最大差值
     */
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }
        // 基数排序
        // 数组的最大值
        int maxVal = Arrays.stream(nums).max().getAsInt();
        int gap = 1;
        while (maxVal >= gap) {
            // 装入位数所对应的元素个数
            int[] bucket = new int[10];
            // 计算每个元素的对应位数的数字, 放入相应的桶(0-9)中, 记录每个桶中元素个数
            for (int i: nums) {
                int digit = (i / gap) % 10;
                bucket[digit]++;
            }
            // 此时每个桶记录的是当前桶和前面所有桶中元素个数之和
            // 所以每一个桶的数字-1 可以当作当前桶最后一个元素的索引
            for (int i = 1; i < 10 ; i++) {
                bucket[i] += bucket[i - 1];
            }
            // 按照桶中元素位数对应数字的顺序进行排序
            // 注意: 取出元素的顺序应该和放入的相反(从后向前计算)
            // 因为 digit 计算出的是每个桶最后一个元素的索引
            int[] temp = new int[n];
            for (int i = n-1; i >= 0; i--) {
                int digit = (nums[i] / gap) % 10;
                temp[--bucket[digit]] = nums[i];
//                bucket[digit]--;
            }
            System.out.println(Arrays.toString(temp));
            nums = temp;
            // 取出下一个位数
            gap *= 10;
        }
        // 计算差值
        int result = 0;
        for (int i = 0; i < nums.length-1; i++) {
            result = Math.max(result, nums[i+1] - nums[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution164 solution = new Solution164();
        int[] nums = {15252,16764,27963,7817,26155,20757,3478,22602,20404,6739,16790,
                10588,16521,6644,20880,15632,27078,25463,20124,15728,30042,16604,17223,
                4388,23646,32683,23688,12439,30630,3895,7926,22101,32406,21540,31799,3768,
                26679,21799,23740};
        System.out.println(solution.maximumGap(nums));
    }
}
