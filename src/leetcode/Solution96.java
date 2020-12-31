package leetcode;

/**
 * @description: 不同的二叉搜索树
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * @author: Deepcola
 * @time: 2020/12/31 14:55
 */
public class Solution96 {

    /**
     * 动态规划:
     *      使用 dp[n] 记录长度为 n 的序列构成不同二叉搜索树的数量
     *      使用 F[j, i] 记录根节点为 j,长度为 i 的二叉搜索树数量
     *   dp[n] = F[1, n] + .. + F[n, n];————依次以 1-n 为根节点的所有序列之和
     *   F[j, i] = dp[i-1] * dp[j-i];————左子树[0, j-1], 右子树[j+1, i]的排列组合
     *   所以 dp[n] = Σ(i = 1, n) dp[i-1] * dp[n-i]
     */
    /*public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {// 动规: 递推
            for (int j = 1; j <= i; j++) {// 累加求和: 使用不同节点作为根节点
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }*/


    /**
     * 组合数学:卡塔兰数
     *      C(0) = 1;     C(n+1) = 2(2n+1) / (n+2) * C(n)
     */
    public int numTrees(int n) {
        long C = 1;
        for (int i = 0; i < n; i++) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }
}
