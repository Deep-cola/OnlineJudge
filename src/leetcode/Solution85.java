package leetcode;

/**
 * @description: 最大矩形
 * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * 提示：
 *      rows == matrix.length
 *      cols == matrix[0].length
 *      0 <= row, cols <= 200
 *      matrix[i][j] 为 '0' 或 '1'
 *              1   0   1   0   0
 *              1   0   1   1   1
 *              1   1   1   1   1
 *              1   0   0   1   0
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：6
 *
 * 输入：matrix = []
 * 输出：0
 *
 * 输入：matrix = [["0"]]
 * 输出：0
 *
 * 输入：matrix = [["1"]]
 * 输出：1
 *
 * 输入：matrix = [["0","0"]]
 * 输出：0
 * @author: Deepcola
 * @time: 2020/12/26 7:35
 */
public class Solution85 {

    /**
     * 优化的暴力: 转换为柱形图求面积
     *      1.计算矩阵中每个元素的左边连续的 1 的个数记录于 left[i][j]
     *      2.对于矩阵中的任意一个点, 枚举以该点为右下角的所有的全 1 矩形
     *           对于 matrix[i][j] 而言, 枚举满足 0 ≤ k ≤ i 的所有的可能的 k,
     *           此时矩阵的最大宽度为 left[i][j]、left[i-1][j]、...、left[k][j]
     *      3.对每个点重读上面额过程, 寻找最大面积的矩形
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        // 计算 left 数组
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] left = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 左边为 1 -> 需要判断是不是第一列
                if (matrix[i][j] == '1') {
                    left[i][j] = (j == 0) ? 1 : left[i][j-1] + 1;
                }
            }
        }
        // 对于任意一个点, 枚举以该点为右下角的所有的全 1 矩形
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 可以枚举
                if (matrix[i][j] == '1') {
                    int width = left[i][j];// 初始宽度
                    int area = left[i][j];// 初始面积
                    // 枚举
                    // k 代表上面行的坐标
                    for (int k = i - 1; k >= 0; k--) {
                        // 优化: 当上面某一行为 0, 就可以不用继续了
                        if (left[k][j] == 0) {
                            break;
                        }
                        width = Math.min(width, left[k][j]);// 宽度取最小值满足全 1 矩形
                        area = Math.max(area, width * (i - k + 1));// 面积取最大值满足题意
                    }
                    result = Math.max(result, area);
                }
            }
        }
        return result;
    }


}
