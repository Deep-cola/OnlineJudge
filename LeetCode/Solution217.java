package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @description: 存在重复元素
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 * @author: Deepcola
 * @time: 2020/11/21 23:42
 */
public class Solution217 {

    /**
     * 统计 nums 中出现的数字和相应的次数, 通过检索查看是否有超过两次的元素
     */
//    public boolean containsDuplicate(int[] nums) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        // 统计出现数字以及对应的次数
//        for (int i: nums) {
//            map.put(i, map.getOrDefault(i, 0) +1);
//        }
//        // 检索是否有出现至少 2 次的
//        for (Map.Entry<Integer,Integer> entry: map.entrySet()) {
//            if (entry.getValue() > 1) {
//                return true;
//            }
//        }
//        return false;
//    }

    /**
     * set 自带去重, 装入 set 看长度是否减少
     */
//    public boolean containsDuplicate(int[] nums) {
//        HashSet<Integer> set = new HashSet<>();
//        for (int i : nums) {
//            set.add(i);
//        }
//        return nums.length > set.size();
//    }


    /**
     * 添加失败就说明重复
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i: nums) {
            if (!set.add(i)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution217 solution = new Solution217();
        int[] nums = {1,2,3,1};
        System.out.println(solution.containsDuplicate(nums));
    }
}
