package leetcode;

/**
 * @description: 矩阵中的最长递增路径
 * 给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。
 *
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。
 *
 * 示例 1：
 * 输入：matrix = [[9,9,4],[6,6,8],[2,1,1]]
 * 输出：4
 * 解释：最长递增路径为 [1, 2, 6, 9]。
 *
 * 示例 2：
 * 输入：matrix = [[3,4,5],[3,2,6],[2,2,1]]
 * 输出：4
 * 解释：最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
 *
 * 示例 3：
 * 输入：matrix = [[1]]
 * 输出：1
 *  
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 200
 * 0 <= matrix[i][j] <= 231 - 1
 * @author: Deepcola
 * @time: 2021/2/23 18:30
 */
public class Solution329 {

    /**
     * 深度优先搜索
     */
    private final int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int rows;
    private int cols;

    public int longestIncreasingPath(int[][] matrix) {
        rows = matrix.length;
        cols = matrix[0].length;
        int[][] cal = new int[rows][cols];// 计算的单元格结果
        int result = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result = Math.max(result, dfs(matrix, i, j, cal));
            }
        }
        return result;
    }

    private int dfs(int[][] matrix, int row, int col, int[][] cal) {
        if (cal[row][col] != 0) {// 已计算
            return cal[row][col];
        }
        cal[row][col]++;// 自身
        for (int[] direction : directions) {
            int nextRow = direction[0] + row;
            int nextCol = direction[1] + col;
            if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols
                && matrix[nextRow][nextCol] > matrix[row][col]) {
                cal[row][col] = Math.max(cal[row][col], dfs(matrix, nextRow, nextCol, cal) + 1);
            }
        }
        return cal[row][col];
    }
}
