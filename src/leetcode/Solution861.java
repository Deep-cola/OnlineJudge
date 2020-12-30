package leetcode;

/**
 * @description: 反转矩阵后的得分
 * 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
 * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
 * 返回尽可能高的分数。
 *
 * 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
 * 输出：39
 * 解释：转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
 *      0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
 * @author: Deepcola
 * @time: 2020/12/7 7:38
 */
public class Solution861 {

    /**
     * 贪心算法: 实际不反转, 通过"贡献"来计算总和就好
     * 对于 m 行 n 列
     * 1.使第一列全部为 1; 贡献: m*2^(n-1)
     * 2.后面每列的 1 的个数应该大于等于 0 的个数; 符合之后如果列的 1 的个数是 k,  贡献:  * 2^(n-1-i)
     */
    public int matrixScore(int[][] A) {
        int m = A.length;// 行
        int n = A[0].length;// 列
        int result = 0;
        // 第 0 列全部为 1
        result += m * (1 << (n-1));
        // 剩余列
        for (int i = 1; i < n; i++) {// 列
            int k = 0;// 每一列反转后 1 的个数
            for (int j = 0; j < m; j++) {// 行
                if (A[j][0] == 0)  {
                    // 本行第一列是 0 需要反转
                    if (A[j][i] == 0) {
                        k++;
                    }
                }else {
                    // 本行第一列是 1 不需要反转
                    if (A[j][i] == 1) {
                        k++;
                    }
                }
            }
            // 如果 1 的个数小于 0 的个数——反转——两者的数量交换
            k = (k >= Math.round(m*1.0/2)) ? k : (m-k);
            // 这一列的贡献就是 k * 2^(n-1-i)
            result += k * (1 << (n-1-i));
        }
        return result;
    }

    public static void main(String[] args) {
        Solution861 solution = new Solution861();
        int[][] A = {{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        System.out.println(solution.matrixScore(A));
    }
}
