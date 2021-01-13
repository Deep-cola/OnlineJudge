package leetcode;

import java.sql.PreparedStatement;

/**
 * @description: 买卖股票的最佳时机Ⅱ
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 *
 * 示例 2:
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 *
 * 示例 3:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * 提示：
 *      1 <= prices.length <= 3 * 10 ^ 4
 *      0 <= prices[i] <= 10 ^ 4
 * @author: Deepcola
 * @time: 2021/1/13 8:03
 */
public class Solution122 {

    /**
     * 模拟: 收集所有可以赚钱的机会
     */
   /* public int maxProfit(int[] prices) {
       int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            int buy = prices[i];// 买入
            while (i + 1 < prices.length && prices[i] < prices[i + 1]) {
                i++;
            }
            int sell = prices[i];// 卖出
            profit += sell - buy  ;
        }
        return profit;
    }*/

    /**
     * 动态规划: 每天交易完手中持有股票和不持有股票两种状态
     * sell 表示不持有股票的最大利润; buy 表示持有股票的最大利润。考虑当前状态是前一天的状态还是今天操作的状态
     *      sell = max(sell, buy + price);
     *      buy = max(buy, sell - price);
     */
    /*public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int buy = -prices[0];
        int sell = 0;
        for (int price : prices) {
            // 判断状态的来源是前一天还是今日操作
            int newBuy = Math.max(buy, sell - price);
            int newSell = Math.max(sell, buy + price);
            buy = newBuy;
            sell = newSell;
        }
        return sell;
    }*/

    /**
     * 贪心: 只考虑今天用不用买入或者卖出
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            // 是否买入
            profit += Math.max(0, prices[i] - prices[i - 1]);
        }
        return profit;
    }
}
