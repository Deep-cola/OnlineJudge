package leetcode;

/**
 * @description: 买卖股票的最佳时机Ⅳ
 * 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *      0 <= k <= 109
 *      0 <= prices.length <= 1000
 *      0 <= prices[i] <= 1000
 * 输入：k = 2, prices = [2,4,1]
 * 输出：2
 * 解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 *
 * 输入：k = 2, prices = [3,2,6,5,0,3]
 * 输出：7
 * 解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
 *      随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 * @author: Deepcola
 * @time: 2020/12/28 16:59
 */
public class Solution188 {

    /**
     * 动态规划:
     *      1.buy[i][j] 表示第 i 天进行 j 笔交易, 手上恰好有一只股票时的最大利润
     *      2.sell[i][j] 表示第 i 天第 i 天进行 j 笔交易, 手上没有股票时的最大利润
     *      3.对于 buy[i][j], 可以是前一天手上已经有一支股票, 或者今天买进的股票:
     *              buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j] - prices[i])
     *      4.对于 sell[i][j], 可以是前一天手上没有股票, 或者前一天有一支在今天卖出的股票:
     *              sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j - 1] + prices[i])
     * 由于均从前一天某种状态下转移而来, 可以考虑一维数组
     *              buy[j] = Math.max(buy[j], sell[j] - prices[i])
     *              sell[j] = Math.max(sell[j], buy[j - 1] + prices[i])
     */
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        // 买入股票和卖出股票
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];
        // 当 k 大于一半 -> 没必要
        k = Math.min(k, prices.length / 2);
        // 第一天买入股票 / 第一天卖出股票
        buy[0] = - prices[0];
        sell[0] = 0;
        // 默认值 - 由于之后的没有进行过任何交易, 设置为非法值
        for (int i = 1; i <= k; i++) {
            buy[i] = sell[i] = Integer.MIN_VALUE / 2;
        }
        // 交易
        for (int i = 1; i < prices.length; i++) {
            // 当前进行第一次买入股票
            buy[0] = Math.max(buy[0], sell[0] - prices[i]);
            // 最多 k 次交易
            for (int j = 1; j <= k; j++) {
                buy[j] = Math.max(buy[j], sell[j] - prices[i]);
                sell[j] = Math.max(sell[j], buy[j - 1] + prices[i]);
            }
        }
        // 最大利润
        int profit = 0;
        for (int i = 0; i <= k; i++) {
            profit = Math.max(profit, sell[i]);
        }
        return profit;
    }
}
