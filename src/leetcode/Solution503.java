package leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: 下一个更大元素 Ⅱ
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 *
 * 示例 1:
 *
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 注意: 输入数组的长度不会超过 10000。
 * @author: Deepcola
 * @time: 2021/3/6 17:10
 */
public class Solution503 {

    /**
     * 模拟
     */
    /*public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int index = (i + 1) & nums.length;
            while (index != i) {
                if (nums[index] > num) {
                    result[i] = nums[index];
                    break;
                }
                index = (index + 1) % nums.length;
            }
            if (index == i) {
                result[i] = - 1;
            }
        }
        return result;
    }*/

    /**
     * 单调栈
     */
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < n * 2 - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                result[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return result;
    }
}
