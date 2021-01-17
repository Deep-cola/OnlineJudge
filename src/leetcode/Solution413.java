package leetcode;

/**
 * @description: 等差数列划分
 * 如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 * 例如，以下数列为等差数列:
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * 以下数列不是等差数列。
 * 1, 1, 2, 5, 7
 * 数组 A 包含 N 个数，且索引从0开始。数组 A 的一个子数组划分为数组 (P, Q)，P 与 Q 是整数且满足 0<=P<Q<N 。
 * 如果满足以下条件，则称子数组(P, Q)为等差数组：
 * 元素 A[P], A[p + 1], ..., A[Q - 1], A[Q] 是等差的。并且 P + 1 < Q 。
 * 函数要返回数组 A 中所有为等差数组的子数组个数。
 *
 * 示例:
 * A = [1, 2, 3, 4]
 * 返回: 3, A 中有三个子等差数组: [1, 2, 3], [2, 3, 4] 以及自身 [1, 2, 3, 4]。
 * @author: Deepcola
 * @time: 2021/1/17 15:59
 */
public class Solution413 {

    /**
     * 动态规划:
     *      dp[i] 表示以 A[i] 结尾的等差数列个数
     *      由于一个等差数组可以在任意位置结束, 所以需要进行求和
     */
   /*public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) return 0;
        int[] dp = new int[A.length];
        int result = 0;
        for (int i = 2; i < A.length; i++) {
            // 满足等差数列
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                result += dp[i];
            }
        }
        return result;
    }*/

    /**
     * 空间优化
     */
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) return 0;
        int dp = 0;
        int result = 0;
        for (int i = 2; i < A.length; i++) {
            // 满足等差数列
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                // 以 A[i-1] 结尾的所有子数列后面续一个 A[i]  +   A[i-2]、A[i-1]、A[i] 这一个梳理
                dp = dp + 1;
                result += dp;
            }else {
                // 当两个子数组不连续, 就重新计算
                dp = 0;
            }
        }
        return result;
    }
}
