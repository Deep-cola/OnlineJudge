package LeetCode;

/**
 * @description: 买卖股票的最佳时机含手续费
 * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * 返回获得利润的最大值。
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 * 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出: 8
 * 解释: 能够达到的最大利润:
 *     在此处买入 prices[0] = 1
 *     在此处卖出 prices[3] = 8
 *     在此处买入 prices[4] = 4
 *     在此处卖出 prices[5] = 9
 *     总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 *
 * @author: Deepcola
 * @time: 2020/12/17 7:33
 */
public class Solution714 {

    /**
     * 贪心算法:
     * 1.由于存在手续费, 可以看作买入股票的价格是 prices[i]+fee;
     * 2.判断:
     *      (1)如果价格小于买入的股票, 那就不用管继续向后;
     *      (2)如果价格不小于买入的股票, 那就当作是卖出来更新利润; 同时，由于后面可能还有更高的价格, 所以这次也看作是没有手续费的买入。
     */
    public int maxProfit(int[] prices, int fee) {
        int buy = prices[0] + fee;
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] + fee < buy) {
                // 价格更低, 更适合买入
                buy = prices[i] + fee;
            }else if (prices[i] > buy) {
                // 假定卖出, 更新利润和买入价格
                profit += prices[i] - buy;
                buy = prices[i];
            }
        }
        return profit;
    }

    /**
     * 动态规划: 每天只有两种状态, 手上有 1 支股票或者 0 支
     * 定义 dp[i][0]表示第 i 天有 0 支股票; dp[i][1] 表示第 i 天有 1 支股票 -> 那么前一天可能是  dp[i-1][0] 或 dp[i-1][1]
     * 转移方程: dp[i][0] = max{dp[i-1][0], dp[i-1][1] + prices[i] - fee};
     *         dp[i][1] = max{dp[i-1][1], dp[i-1][0] - prices[i]};
     * 最后: dp[n-1][0] 利润一定大于 dp[n-1][1]
     */
    /*public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        int sell = 0;
        int buy = -prices[0];
        for (int i = 1; i < n; i++) {
            sell = Math.max(sell, buy + prices[i] - fee);
            buy = Math.max(buy, sell - prices[i]);
        }
        return sell;
    }*/


    public static void main(String[] args) {
        Solution714 solution = new Solution714();
//        int[] prices = {9,8,7,1,2};
//        int fee = 3;
        int[] prices = {1,3,5,8,4,9};
        int fee = 2;
        System.out.println(solution.maxProfit(prices, fee));
    }
}
