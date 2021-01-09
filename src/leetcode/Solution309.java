package leetcode;

/**
 * @description:  最佳买卖股票时机含冷冻期
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。:
 *
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * @author: Deepcola
 * @time: 2021/1/9 8:16
 */
public class Solution309 {

    /**
     * 动态规划
     * 对于某一天的状态有三种可能:
     *      1.目前持有一只股票
     *      2.不持有股票且处于冷冻期(明天无法购买股票) -> 当天卖出股票
     *      3.不持有股票且不处于冷冻期
     * 对于每一天考虑 前一天操作和当天操作的可能
     * 初始值为第 0 天的操作值
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int f0 = -prices[0];
        int f1 = 0;
        int f2 = 0;
        for (int price: prices) {
            int F0 = Math.max(f0, f2-price);
            int F1 = F0 + price;
            int F2 = Math.max(f1, f2);
            f0 = F0;
            f1 = F1;
            f2 = F2;
        }
        return Math.max(f1, f2);
    }
}
