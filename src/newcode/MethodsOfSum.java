package newcode;

import java.util.Scanner;

/**
 * @description:  sum 的方法数
 * 给定一个有n个正整数的数组A和一个整数sum,求选择数组A中部分数字sum的方案数。
 * 当两种选取方案有一个数字的下标不一样,我们就认为是不同的组成方案。
 * 输入描述:
 *      输入为两行:
 *          第一行为两个正整数n(1 ≤ n ≤ 1000)，sum(1 ≤ sum ≤ 1000)
 *          第二行为n个正整数A[i](32位整数)，以空格隔开。
 * 输出描述:
 *      输出所求的方案数
 *
 * 输入
 * 5 15
 * 5 5 10 2 3
 * 输出
 * 4
 * @author: Deepcola
 * @time: 2021/1/15 17:20
 */
public class MethodsOfSum {
    /**
     * 动态规划:
     *    1.使用 dp[i][j] 表示前 i 个数和为 j 的情况
     *    2.对于 dp[]i[j]
     *          (1)前 i-1 个数和已经为 j
     *          (2)前 i-1 个数和为 j-A[i] (需要 j > A[i])
     *     dp[i][j] = dp[i-1][j] + dp[i-1][j-A[i]]
     * 初始值
     */
    /**
     *      0   1   2   3   4   5   6   7   8   9   10  11  12  13  14  15
     * 0    1   0   0   0   0   0   0   0   0   0   0   0   0   0   0   0
     * 5    1   0   0   0   0   1   0   0   0   0   0   0   0   0   0   0
     * 5    1   0   0   0   0   2   0   0   0   0   1   0   0   0   0   0
     * 10   1   0   0   0   0   2   0   0   0   0   2   0   0   0   0   2
     * 2    1   0   1   0   0   2   0   2   0   0   2   0   2   0   0   2
     * 3    1   0   1   1   0   3   0   2   2   0   4   0   2   2   0   4
     */
    /*public static long count(int[] A, int n, int sum) {
        long[][] dp = new long[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j >= A[i]) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - A[i]];
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            int sum = scan.nextInt();
            int[] A = new int[n + 1];
            for (int i = 1; i < n; i++) {
                A[i] = scan.nextInt();
            }
            System.out.println(count(A, n, sum));
        }
    }*/


    /**
     * dp[j] 表示和为 j 的方法数
     */
    public static long count(int[] A, int n, int sum) {
        long[] dp = new long[sum + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = sum; j >= A[i]; j--) {
                // 当和已经为 j 时 -> 无操作
                // 当和位 j-A[i] 时 -> 操作
                // 为两者之和
                dp[j] = dp[j - A[i]] + dp[j];
                System.out.print(dp[j] + " ");
            }
            System.out.println();
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            int sum = scan.nextInt();
            int[] A = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = scan.nextInt();
            }
            System.out.println(count(A, n, sum));
        }
    }
}
