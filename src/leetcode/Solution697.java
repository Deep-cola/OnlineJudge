package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 数组的度
 * 给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 *
 * 示例 1：
 * 输入：[1, 2, 2, 3, 1]
 * 输出：2
 * 解释：
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 *
 * 示例 2：
 * 输入：[1,2,2,3,1,4,2]
 * 输出：6
 *  
 * 提示：
 *      nums.length 在1到 50,000 区间范围内。
 *      nums[i] 是一个在 0 到 49,999 范围内的整数。
 * @author: Deepcola
 * @time: 2021/2/20 17:44
 */
public class Solution697 {

    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        // 哈希表计数
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 查找最大度
        Map<Integer, Integer> maxMap = new HashMap<>();
        int count = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > count) {
                count = entry.getValue();
                maxMap.clear();
                maxMap.put(entry.getKey(), 0);
            }else if (entry.getValue() == count) {
                maxMap.put(entry.getKey(), 0);
            }
        }
        // 判断
        int result = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : maxMap.entrySet()) {
            int num = entry.getKey();
            int left = 0;
            int right = nums.length - 1;
            while (nums[left] != num) {
                left++;
            }
            while (nums[right] != num) {
                right--;
            }
            result = Math.min(result, right - left + 1);
        }
        return result;
    }
}
