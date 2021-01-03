package leetcode;

import java.util.*;

/**
 * @description: 大餐计数
 * 大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。
 * 你可以搭配 任意 两道餐品做一顿大餐。
 * 给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第 i​​​​​​​​​​​​​​ 道餐品的美味程度，返回你可以用数组中的餐品做出的不同 大餐 的数量。结果需要对 109 + 7 取余。
 * 注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。
 *
 * 输入：deliciousness = [1,3,5,7,9]
 * 输出：4
 * 解释：大餐的美味程度组合为 (1,3) 、(1,7) 、(3,5) 和 (7,9) 。
 * 它们各自的美味程度之和分别为 4 、8 、8 和 16 ，都是 2 的幂。
 *
 * 输入：deliciousness = [1,1,1,3,3,3,7]
 * 输出：15
 * 解释：大餐的美味程度组合为 3 种 (1,1) ，9 种 (1,3) ，和 3 种 (1,7) 。
 *
 * 提示：
 *
 *      1 <= deliciousness.length <= 10^5
 *      0 <= deliciousness[i] <= 2^20
 * @author: Deepcola
 * @time: 2021/1/3 18:58
 */
public class Solution5642 {

    /**
     * 哈希表 + 预计算
     */
    public int countPairs(int[] deliciousness) {
        // 幂数组 -> 由于最大数为 2^20 -> 所以最多只能为 2^21
        int[] targets = new int[22];
        // 存放幂
        targets[0] = 1;
        // 模
        int mod = 1_000_000_007;
        for (int i = 1; i < 22; i++) {
            targets[i] = targets[i-1] << 1;
        }
        // 存储遍历过的数
        HashMap<Integer, Integer> map = new HashMap<>();
        // 结果
        long result = 0;
        for (int i = 0; i < deliciousness.length; i++) {
            int num = deliciousness[i];
            for (int j = 0; j < 22; j++) {
                // 大餐的另一个数
                int target = targets[j] - num;
                // 不合法
                if (target < 0) {
                    continue;
                }
                // 存在 -> 对于相同的数值, 每一道都是大餐
                if (map.containsKey(target)) {
                    result = (result + map.get(target)) % mod;
                }
            }
            // 遍历多的装进去
            map.put(num, (map.getOrDefault(num, 0) + 1) % mod);
        }
        return (int) (result % mod);
    }


    /**
     * 暴力: 超时
     */
    /*public int countPairs(int[] deliciousness) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int i = 0; i < deliciousness.length; i++) {
            for (int j = i + 1; j < deliciousness.length; j++) {
                int sum = deliciousness[i] + deliciousness[j];
                // 是 2 的幂
                if ((sum & (sum - 1)) == 0 && sum != 0 || sum == 1) {
                    result++;
                }
            }
        }
        return result;
    }*/
}
