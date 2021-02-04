package leetcode;

/**
 * @description: 子数组最大平均数Ⅰ
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 *
 * 示例：
 * 输入：[1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 *  
 * 提示：
 *      1 <= k <= n <= 30,000。
 *      所给数据范围 [-10,000，10,000]。
 * @author: Deepcola
 * @time: 2021/2/4 21:33
 */
public class Solution643 {

    /**
     * 模拟
     */
    /*public double findMaxAverage(int[] nums, int k) {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - k + 1; i++) {
            int temp = 0;
            // 连续子数组
            for (int j = i; j < i + k; j++) {
                temp += nums[j];
            }
            System.out.println(temp);
            result = Math.max(result, temp);
        }
        return result * 1.0 / k;
    }*/

    /**
     * 滑动窗口
     */
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        // 计算初始值
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int max = sum;
        for (int i = k; i < nums.length; i++) {
            // 右移一步: 左边减去一个元素, 右边增加一个元素
            sum = sum - nums[i - k] + nums[i];
            max = Math.max(max, sum);
        }
        return 1.0 * max / k;
    }
}
