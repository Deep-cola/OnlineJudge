package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 * @author: Deepcola
 * @time: 2021/2/23 16:02
 */
public class Solution78 {

    /**
     * 递归
     */
    /*List<List<Integer>> result = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return result;
    }
    // 深度优先搜索
    private void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[cur]);
        dfs(cur + 1, nums);
        list.remove(list.size() - 1);
        dfs(cur + 1, nums);
    }*/


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int num : nums) {
            int size = result.size();
            // 去除每个子集集合中的子集和新的元素进行并添加
            for (int j = 0; j < size; j++) {
                List<Integer> list = new ArrayList<>(result.get(j));
                list.add(num);
                result.add(list);
            }
        }
        return result;
    }
}
