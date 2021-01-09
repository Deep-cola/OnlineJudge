package leetcode;

/**
 * @description: 买卖股票的最佳时机Ⅲ
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 输入：prices = [3,3,5,0,0,3,1,4]
 * 输出：6
 * 解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 *      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 *
 * 输入：prices = [1,2,3,4,5]
 * 输出：4
 * 解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。  
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。  
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 *
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这个情况下, 没有交易完成, 所以最大利润为 0。
 *
 * 输入：prices = [1]
 * 输出：0
 *
 * 提示：
 *      1 <= prices.length <= 105
 *      0 <= prices[i] <= 105
 * @author: Deepcola
 * @time: 2021/1/9 7:28
 */
public class Solution123 {

    /**
     * 动态规划
     * 对于任意一天有以下几种状态:
     *      1.在当天之前未进行任何操作
     *      2.在当天之前有过一次买入操作
     *      3.进行过一次买卖
     *      4.进行了第二次买入
     *      5.进行过两次买卖
     * 只需要考虑后四种, 因为第一种 profit = 0. 后面每天考虑的是 前一天做出的动作和今天做出的动作 所得到的最大利润
     * 对于初始值，就是第一天进行相关操作的结果
     */
    public int maxProfit(int[] prices) {
        int firstBuy = -prices[0], firstSell = 0, secondBuy = -prices[0], secondSell = 0;
        for (int price : prices) {
            firstBuy = Math.max(firstBuy, -price);
            firstSell = Math.max(firstSell, firstBuy + price);
            secondBuy = Math.max(secondBuy, firstSell - price);
            secondSell = Math.max(secondSell, secondBuy + price);
        }
        return secondSell;
    }
}
