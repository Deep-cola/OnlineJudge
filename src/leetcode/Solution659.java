package leetcode;

import java.util.HashMap;

/**
 * @description: 分割数组为连续子序列
 * 给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个子序列，其中每个子序列都由连续整数组成且长度至少为 3 。
 * 如果可以完成上述分割，则返回 true ；否则，返回 false 。
 *
 * 输入: [1,2,3,3,4,4,5,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 *      1, 2, 3, 4, 5
 *      3, 4, 5
 * @author: Deepcola
 * @time: 2020/12/4 0:31
 */
public class Solution659 {

    /**
     * 贪心算法
     * 1. 定义两个 map: countMap 用于保存剩余的元素以及对应数量, endMap 用于保存以某个元素结尾的子序列数量
     * 2.遍历 nums 统计元素和数量
     * 3.再次遍历 nums 判断是否能进行分割称为连续子序列
     *      1.如果当前元素 num 有剩余(countMap.getOrDefault(num, 0) > 0), 就判断是否可以加入某个子序列
     *      2.判断是否右以 前一个元素 num-1 结尾的子序列:
     *          (1)存在: 加入这个子序列。需要 num 数量 -1; 以 num-1 结尾序列数量 -1; 以 num 结尾子序列数量 +1
     *          (2)不存在: 判断后面两位连续元素是否还有剩余:
     *                  如果没有: 就说明不能分割成连续子序列, 返回 false 即可;
     *                  如果有: 可以分割，相应的 num num+1 num-1 剩余数量 -1; 以 num+2 结尾子序列数量 +1
     * 4.遍历完数组都可以分割成子序列, 那就说明为 true
     */
    public boolean isPossible(int[] nums) {
        // 统计保存数组中的元素以及对应数量
        HashMap<Integer, Integer> countMap = new HashMap<>();
        // 统计以某个元素结尾的子序列数量
        HashMap<Integer, Integer> endMap = new HashMap<>();

        // 统计数组中的元素以及对应个数
        for (int num: nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        // 遍历数组分割子序列
        for (int num: nums) {
            // 当前元素 num 还有剩余, 也就是说可以考虑分给哪个子序列
            if (countMap.get(num) > 0) {
                // 判断有没有以 num-1 结尾的子序列
                // 有的话就可以将 num 加入这个子序列
                if (endMap.getOrDefault(num-1, 0) > 0) {
                    // 可以加入 num 到子序列,所以剩余数量需要-1
                    countMap.put(num, countMap.getOrDefault(num, 0) - 1);
                    // 由于新加入 num 后就以 num 结尾了, 所以以 num-1 结尾的数量需要-1
                    endMap.put(num-1, endMap.getOrDefault(num-1, 0) - 1);
                    // 以 num 结尾的数量+1
                    endMap.put(num, endMap.getOrDefault(num, 0) + 1);
                }else {
                    // 没有以 num-1 结尾的子序列, 也就是说这个元素要新开一个序列
                    // 查看一下后面两位连续的数字(一个子序列最少三位数字)有没有剩余数量了, 有的话就可以可以组成新的子序列
                    int count1 = countMap.getOrDefault(num+1, 0);
                    int count2 = countMap.getOrDefault(num+2, 0);
                    // 有剩余数量
                    if (count1 > 0 && count2 > 0) {
                        // 可以组成新的子序列, 就将 num+2 作为结尾元素加入 endMap
                        countMap.put(num, countMap.getOrDefault(num, 0) - 1);
                        countMap.put(num+1,count1 - 1);
                        countMap.put(num+2,count2 - 1);
                        endMap.put(num+2, endMap.getOrDefault(num+2, 0) + 1);
                    }else {
                        // 没有剩余了, num 就不能组成一个新的子序列
                        return false;
                    }
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Solution659 solution = new Solution659();
        int[] nums = {1,2,3,3,4,4,5,5};
        System.out.println(solution.isPossible(nums));
    }
}
