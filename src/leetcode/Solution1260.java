package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 二维网格的迁移
 * 给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
 * 每次「迁移」操作将会引发下述活动：
 *      位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
 *      位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
 *      位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
 * 请你返回 k 次迁移操作后最终得到的 二维网格。
 * @author: Deepcola
 * @time: 2020/11/22 18:54
 */
public class Solution1260 {

    /**
     * 1.迁移前 n-1 列 -> grid[i][j] 的元素将会移动到 grid[i][j + 1]。
     * 2.迁移第 n-1列（除了最后一个元素） -> 位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
     * 3.迁移最后一个元素 -> 位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
     * 4.循环执行 k 次
     */
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (grid.length == 0 || k < 0) return result;
        int m = grid.length;
        int n = grid[0].length;
        while (k-- > 0) {
            int[][] tempGrid = new int[m][n];
            // 移动前 n-1 列
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n-1; j++) {
                    tempGrid[i][j+1] = grid[i][j];
                }
            }
            // 移动最后一列(除了最后一个元素)
            for (int i = 0; i < grid.length - 1; i++) {
                tempGrid[i+1][0] = grid[i][n-1];
            }
            // 移动最后一个元素
            tempGrid[0][0] = grid[m-1][n-1];
            // 替换
            grid = tempGrid;
        }
        // 转换
        for (int i = 0; i < grid.length; i++) {
            List<Integer> rowList = new ArrayList<>();
            for (int j = 0; j < grid[i].length; j++) {
                rowList.add(grid[i][j]);
            }
            result.add(rowList);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution1260 solution = new Solution1260();
        int[][] grid = {{1,2,3},{4,5,6},{7,8,9}};
        int k = 9;
        System.out.println(solution.shiftGrid(grid, k));
    }

}
