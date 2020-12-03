package LeetCode;

import java.util.Arrays;

/**
 * @description: 计算质数
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * @author: Deepcola
 * @time: 2020/12/3 0:04
 */
public class Solution204 {

    public int countPrimes(int n) {
        boolean[] flags = new boolean[n];
        Arrays.fill(flags, true);
        for (int i = 2; i*i < n; i++) {
            if (flags[i]){
                for (int j = i*i; j < n; j=j+i) {
                    flags[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (flags[i]) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution204 solution = new Solution204();
        System.out.println(solution.countPrimes(10));
    }
}
