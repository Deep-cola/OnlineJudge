package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 汇总区间
 * 给定一个无重复元素的有序整数数组 nums 。
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 *      "a->b" ，如果 a != b
 *      "a" ，如果 a == b
 *
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 *
 * 输入：nums = [0,2,3,4,6,8,9]
 * 输出：["0","2->4","6","8->9"]
 * 解释：区间范围是：
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 *
 * 输入：nums = []
 * 输出：[]
 *
 * 输入：nums = [-1]
 * 输出：["-1"]
 *
 * 输入：nums = [0]
 * 输出：["0"]
 * @author: Deepcola
 * @time: 2021/1/10 0:06
 */
public class Solution228 {

    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            String str = "";
            int length = 1;
            while (i < nums.length && nums[i] + 1 < nums[i + 1]) {
                length++;
                i++;
            }
            if (length == 1) {
                str += nums[i];
            }else {
                str += nums[i - length + 1] + "->" + nums[i];
            }
            list.add(str);
        }
        return list;
    }
}
