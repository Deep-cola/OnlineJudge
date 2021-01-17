package leetcode;

/**
 * @description: 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 *
 * 示例 2：
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * @author: Deepcola
 * @time: 2021/1/17 8:30
 */
public class Solution70 {
    /**
     * 动态规划：
     *      使用 dp[i] 表示到达第 i 阶的方法数
     *      dp[i] = dp[i - 1] + dp[i - 2]
     * 初始值: dp[0] = 1;      dp[1] = 2;
     */
    /*public int climbStairs(int n) {
        if (n <= 2) return n;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }*/

    /**
     * 优化——滚动数组
     *      由于第 i 阶只与前一阶和前两阶有关, 可以试用关东数组进行替换
     */
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int pre2 = 1;// 前两个台阶
        int pre1 = 2;// 前一个台阶
        int cur = 0;
        for (int i = 2; i < n; i++) {
            cur = pre1 + pre2;
            pre2 = pre1;
            pre1 = cur;
        }
        return cur;
    }
}
