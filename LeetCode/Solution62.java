package LeetCode;

/**
 * @description: 不同路径
 * 一个机器人位于一个 m x n 网格的左上角，机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 *
 * 输入: m = 3, n = 2
 * 输出: 3
 *
 * 输入: m = 7, n = 3
 * 输出: 28
 * @author: Deepcola
 * @time: 2020/12/9 0:04
 */
public class Solution62 {

    /**
     * 递归
     * 超出时间限制？
     */
    /*public int uniquePaths(int m, int n) {
        if (m == 1 || n ==1) return 1;
        return uniquePaths(m-1, n) + uniquePaths(m, n-1);
    }*/

    /**
     * 动态规划
     * 用 dp[i][j] 表示从左上角到 (i, j) 的路径数量;
     * 每一步只能向下或者向右移动, 所以
     *              如果向下走一步, 就到了 (i-1, j);
     *              如果向右走一步, 就到了 (i, j-1);
     *              dp 方程就是 dp[i][j] = dp[i-1][j] + dp[i][j-1];
     * 如果 i==0 || j == 0 不满足上述方程, 这个时候只能向下或者向右.
     */
    /*public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                }else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }*/

    /**
     * 组合数学
     * 从左上角到[m, n]一共需要走 m+n-2 步, 其中 m-1 次向右, n-1 次向下
     * 所以 C((m-1) (m+n-2)) = (m+n-2)! / (m-1)!(n-1)! = (m+n-2)(m+n-3)...n / (m-1)!
     */
    public int uniquePaths(int m, int n) {
        long result = 1;
        for (int i = 1,j = n; i < m; i++, j++) {
            result = result * j / i;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        Solution62 solution = new Solution62();
        System.out.println(solution.uniquePaths(100, 100));
    }
}
