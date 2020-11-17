package LeetCode;

import javax.swing.plaf.synth.SynthTabbedPaneUI;
import java.util.Stack;

/**
 * @description: 股票价格跨度
 * 编写一个 StockSpanner 类，它收集某些股票的每日报价，并返回该股票当日价格的跨度。
 * 今天股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
 * 例如，如果未来7天股票的价格是 [100, 80, 60, 70, 60, 75, 85]，那么股票跨度将是 [1, 1, 1, 2, 1, 4, 6]。
 * @author: Deepcola
 * @time: 2020/11/16 18:52
 */
public class Solution901 {

    /**
     * 单调栈
     * 求出小于等于今天价格的最大连续日数，相当于求一个最近的大于今日价格的日子。
     * 对于 i < j 且 priceI < PriceJ,那么 j 之后每一天与 i 都将无关/所以维护单调栈, i、j 之间的跨度加起来给 j 就好
     */
    class StockSpanner {
        private Stack<Integer> weightStack;// 存放跨度
        private Stack<Integer> priceStack;// 存放价格
        public StockSpanner() {
            weightStack = new Stack<>();
            priceStack = new Stack<>();
        }
        public int next(int price) {
            // 跨度包括本身
            int tempWeight = 1;
            // 栈不为空并且当前价格大于栈顶元素就弹出所有价格小于等于我的，并把跨度给我
            while (!priceStack.isEmpty() && priceStack.peek() <= price) {
                priceStack.pop();
                tempWeight += weightStack.pop();
            }
            priceStack.push(price);
            weightStack.push(tempWeight);
            return weightStack.peek();
        }
    }


    public static void main(String[] args) {
        Solution901 solution = new Solution901();
        StockSpanner stockSpanner = solution.new StockSpanner();
        System.out.println(stockSpanner.next(100));
        System.out.println(stockSpanner.next(80));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(70));
        System.out.println(stockSpanner.next(30));
        System.out.println(stockSpanner.next(75));
        System.out.println(stockSpanner.next(85));
    }
}
