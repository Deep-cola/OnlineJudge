package leetcode;

/**
 * @description: 斐波那契数
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *      F(0) = 0，F(1) = 1
 *      F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给你 n ，请计算 F(n) 。
 *
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 *
 * 输入：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
 *
 * 输入：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
 *  
 *
 * 提示：
 *      0 <= n <= 30
 * @author: Deepcola
 * @time: 2021/1/4 0:12
 */
public class Solution509 {

    /**
     * 动态规划
     */
    public int fib(int n) {
        if (n < 2) return n;
        int f0 = 0;
        int f1 = 1;
        int f2 = 1;
        for (int i = 2; i <= n; i++) {
            f2 = f0 + f1;
            f0 = f1;
            f1 = f2;
        }
        return f2;
    }


    /**
     * 递归
     */
    /*public int fib(int n) {
        if (n < 2) return n;
        return fib(n -1) + fib(n - 2);
    }*/
}
