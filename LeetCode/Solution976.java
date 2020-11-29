package LeetCode;

import java.util.Arrays;

/**
 * @description: 三角形的最大周长
 * 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
 * 如果不能形成任何面积不为零的三角形，返回 0。
 *
 * @author: Deepcola
 * @time: 2020/11/29 0:02
 */
public class Solution976 {

    /**
     * 1.数组排序
     * 2.逆序遍历数组, 取出连续三个值进行判断是否满足构成三角形条件
     *          假设排序后 a >= b >= c >= d...
     *          若组合 abd 满足, 那么 b+d > a, 但是很显然 b+c > b+d > a, 求出最大轴承, 所以连续判断就好
     */
    public int largestPerimeter(int[] A) {
        if (A == null || A.length < 3) return 0;
        Arrays.sort(A);
        for (int i = A.length-1; i >= 2; i--) {
            // 构成三角形条件
            if (A[i-2] + A[i-1] > A[i]) {
                return A[i] + A[i-1] + A[i-2];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution976 solution = new Solution976();
        int[] A = {3,6,2,3};
        System.out.println(solution.largestPerimeter(A));
    }
}
