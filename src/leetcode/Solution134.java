package leetcode;

/**
 * @description: 加油站
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 * 说明: 
 *      如果题目有解，该答案即为唯一答案。
 *      输入数组均为非空数组，且长度相同。
 *      输入数组中的元素均为非负数。
 *
 * 输入:
 * gas  = [1,2,3,4,5]
 * cost = [3,4,5,1,2]
 * 输出: 3
 * 解释:
 * 从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
 * 开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
 * 开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
 * 开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
 * 开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
 * 因此，3 可为起始索引。
 *
 * 输入:
 * gas  = [2,3,4]
 * cost = [3,4,3]
 * 输出: -1
 * 解释:
 * 你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
 * 我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
 * 开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
 * 你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
 * 因此，无论怎样，你都不可能绕环路行驶一周。
 * @author: Deepcola
 * @time: 2020/12/25 16:07
 */
public class Solution134 {

    /**
     * 使用图
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int spare = 0;// 剩余油量
        int minSpare = Integer.MAX_VALUE;
        int minIndex = 0;// 最低点下标
        // 计算最低点下标
        for (int i = 0; i < gas.length; i++) {
            spare += gas[i] - cost[i];
            if (spare < minSpare) {
                minSpare = spare;
                minIndex = i;;
            }
        }
        // 最终的油量是否大于 0
        return spare < 0 ? -1 : (minIndex + 1) % gas.length;
    }


    /**
     * 模拟过程
     */
    /*public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            // 查找起点
            if (gas[i] < cost[i]) {
                // 不能作为起点
                continue;
            }
            int sum = gas[i] - cost[i];// 剩余油量
            int j = (i + 1) % n;
            // 判断是否可以行驶一周
            while (j != i) {
                sum += gas[j] - cost[j];
                // 无法到达下一站
                if (sum < 0) {
                    break;
                }
                j = (j + 1) % n;
            }
            // 可以行驶一周
            if (j == i) {
                return i;
            }
        }
        return -1;
    }*/

    public static void main(String[] args) {
        Solution134 solution = new Solution134();
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
//        int[] gas = {5,1,2,3,4};
//        int[] cost = {4,4,1,5,1};
        System.out.println(solution.canCompleteCircuit(gas, cost));
    }
}