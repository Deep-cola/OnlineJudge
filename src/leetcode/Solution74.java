package leetcode;

/**
 * @description: 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 * @author: Deepcola
 * @time: 2021/3/30 18:13
 */
public class Solution74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        // 查找行
        int index = 0;
        for (; index < matrix.length; index++) {
            if (matrix[index][0] > target) {
                break;
            }else if (matrix[index][0] == target) {
                return true;
            }
        }
        if (index == 0) return false;
        // 查找具体目标
        for (int i = 0; i < matrix[index - 1].length; i++) {
            if (matrix[index - 1][i] == target) {
                return true;
            }
        }
        return false;
    }
}
