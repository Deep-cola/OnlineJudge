package leetcode;

import java.util.PriorityQueue;

/**
 * @description: 华滑动窗口的最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 *
 * 示例 1：
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 * 示例 2：
 * 输入：nums = [1], k = 1
 * 输出：[1]
 *
 * 示例 3：
 * 输入：nums = [1,-1], k = 1
 * 输出：[1,-1]
 *
 * 示例 4：
 * 输入：nums = [9,11], k = 2
 * 输出：[11]
 *
 * 示例 5：
 * 输入：nums = [4,-2], k = 2
 * 输出：[4]
 *
 * 提示：
 *      1 <= nums.length <= 105
 *      -104 <= nums[i] <= 104
 *      1 <= k <= nums.length
 * @author: Deepcola
 * @time: 2021/1/2 7:23
 */
public class Solution239 {

    /**
     * 分块 + 预处理:
     *      1.数组分块: k 个一组, 最后一组元素个数可能不到 k 个
     *        对于 nums[i] ~ nums[i+k-1] 窗体中的最大值:
     *          (1)当 i 是 k 的倍数, 窗体对应一组，最大值就是该分组中的最大值;
     *          (2)当 i 不是 k 的倍数, 窗体就会跨越两个分组 -> 假设 j 是 k 的倍数 (i <= k <= i+k-1)
     *                          -> 那么窗体跨越了第一个分组后缀 nums[i] ~ nums[j-1]; 第二个分组前缀 nums[j] ~ nums[i+k-1]
     *      2.预处理:使用 suffixMax[i] 表示下标 i 对应的分组中, 以 i 开始的后缀最大值; 使用 prefixMax[i] 表示下标 i 对应的分组中, 以 i 结束的前缀最大值;
     *        suffixMax[i] = nums[i]    i+1 是 k 的倍数
     *                     = max{suffixMax[i+1], nums[i]}   i+1 不是 k 的倍数
     *        prefixMax[i] = nums[i]    i 是 k 的倍数
     *                     = max{prefixMax[i-1], nums[i]}   i 不是 k 的倍数
     *      3.对于 nums[i] ~ nums[i+k-1] 窗体中的最大值
     *          -> 当 i 是 k 的倍数, 窗体恰好对应一部分分组, 最大值为 suffixMax[i] 或者 prefixMax[i+k-1] 均可
     *          -> 当 i 不是 k 的倍数, 跨越两个分组, 最大值为 max{suffixMax[i], prefixMax[i+k-1]}
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];
        // 计算prefixMax
        for (int i = 0; i < n; i++) {
            // i 是 k 的倍数
            if (i % k == 0) {
                prefixMax[i] = nums[i];
            }else {
                // i 不是 k 的倍数
                prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
            }
        }
        // 计算 suffixMax
        for (int i = n - 1; i >= 0; i--) {
            // i+1 是 i 的倍数 或者说是最后一个数
            if ((i + 1) % k == 0 || i == n - 1) {
                suffixMax[i] = nums[i];
            }else {
                suffixMax[i] = Math.max(suffixMax[i + 1], nums[i]);
            }
        }
        // 计算结果
        int[] result = new int[n - k + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = Math.max(suffixMax[i], prefixMax[i + k - 1]);
        }
        return result;
    }



    /**
     * 优先级队列维护窗体最大值,
     *      当然，堆顶元素不一定在窗体内, 此时该最大值在上一窗体的最左侧，不会出现在下一窗体, 所以需要永久移除
     *      使用优先级队列存储二元组(nums[i], i)， 用于判断当前栈顶元素是否在窗体内
     */
    /*public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        // 使用优先级队列存储二元组(nums[i], i) -> 大根堆
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            return o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1];
        });
        // 添加元素
        for (int i = 0; i < k; i++) {
            queue.offer(new int[]{nums[i], i});
        }
        int[] result = new int[n - k + 1];
        result[0] = queue.peek()[0];// 第一个最大值
        for (int i = k; i < n; i++) {
            queue.offer(new int[]{nums[i], i});
            // 判断最大值是否在窗体内
            while (queue.peek()[1] <= i - k) {
                // 最大值不在窗体内
                queue.poll();
            }
            // 此时最大值在窗体内
            result[i - k + 1] = queue.peek()[0];
        }
        return result;
    }*/



    /**
     * 模拟优化: 超出时间限制
     */
   /* public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        // 查找第一个窗口的最大值以及下标
        int index = findMax(nums, k, 0);
        result[0] = nums[index];
        // 比较 窗口新增的数和最大值 进行添加
        for (int i = k; i < nums.length; i++) {
            // 上次的最大值还在窗体内
            if (index > i - k) {
                result[i - k + 1] = Math.max(nums[i], result[i - k]);
            }else {
                // 不在窗体内就需要查找当前窗体的最大值
                index = findMax(nums, k, i - k + 1);
                result[i - k + 1] = nums[index];
            }
        }
        return result;
    }
    // 寻找当前窗口的最大值的下标
    public int findMax(int[] nums, int k, int index) {
        int max = nums[index];
        int maxIndex = index;
        for (int i = index; i < k + index; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }*/
}
