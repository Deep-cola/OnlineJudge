package LeetCode;

import java.util.Arrays;

/**
 * @description: 旋转图像
 * 给定一个 n × n 的二维矩阵表示一个图像。将图像顺时针旋转 90 度。
 * 说明：你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * 给定 matrix =              原地旋转输入矩阵，使其变为:
 * [                          [
 *   [1,2,3],                   [7,4,1],
 *   [4,5,6],                   [8,5,2],
 *   [7,8,9]                    [9,6,3]
 * ],                         ].
 * 给定 matrix =              原地旋转输入矩阵，使其变为:
 * [                         [
 *   [ 5, 1, 9,11],             [15,13, 2, 5],
 *   [ 2, 4, 8,10],             [14, 3, 4, 1],
 *   [13, 3, 6, 7],             [12, 6, 8, 9],
 *   [15,14,12,16]              [16, 7,10,11]
 * ],                        ].
 * @author: Deepcola
 * @time: 2020/12/19 7:42
 */
public class Solution48 {

    /**
     * 先上下翻转，再主对角线翻转
     */
    /*public void rotate(int[][] matrix) {
        // 上下交换
        for (int i = 0; i < matrix.length/2; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length-1-i][j];
                matrix[matrix.length-1-i][j] = temp;
            }
        }
        // 主对角线交换
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }*/

    /**
     * 原地交换
     * 每一次对四个数进行交换即可
     * n 为偶数: n/2
     * n 为奇数: (n+1)/2
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < (n+1)/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
        }
    }


    public static void main(String[] args) {
        Solution48 solution = new Solution48();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        solution.rotate(matrix);
        for (int[] arr: matrix) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
