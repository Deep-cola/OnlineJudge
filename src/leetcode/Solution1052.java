package leetcode;

/**
 * @description: 爱生气的书店老板
 * 今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分钟结束后离开。
 *
 * 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。
 *
 * 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。
 *
 * 请你返回这一天营业下来，最多有多少客户能够感到满意的数量。
 *  
 *
 * 示例：
 *
 * 输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
 * 输出：16
 * 解释：
 * 书店老板在最后 3 分钟保持冷静。
 * 感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
 *  
 *
 * 提示：
 *
 * 1 <= X <= customers.length == grumpy.length <= 20000
 * 0 <= customers[i] <= 1000
 * 0 <= grumpy[i] <= 1
 * @author: Deepcola
 * @time: 2021/2/23 15:17
 */
public class Solution1052 {

    /**
     * 滑动窗口
     */
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int origin = 0;// 原本的满意度
        int n = customers.length;
        // 1.计算原本的满意度
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                origin += customers[i];
            }
        }
        // 2.计算抑制自己情绪的最大增加满意度: 抑制时会把 grumpy[i] 中 1 变为 0
        // 初始
        int increase = 0;
        for (int i = 0; i < X; i++) {
            if (grumpy[i] == 1) {
                increase += customers[i];
            }
        }
        // 滑动窗口
        int maxIncrease = increase;
        for (int i = X; i < n; i++) {
            increase = increase - customers[i - X] * grumpy[i - X] + customers[i] * grumpy[i];
            maxIncrease = Math.max(increase, maxIncrease);
        }
        return origin + maxIncrease;
    }
}
