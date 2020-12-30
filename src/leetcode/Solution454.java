package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 四数相加Ⅱ
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 *
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 * @author: Deepcola
 * @time: 2020/11/27 0:21
 */
public class Solution454 {

    /**
     * A B 分为一组求所有可能之和装入 map, C D一组求所有可能之和;
     * 如果 map 中包含 C D之和的相反数, 说明和为 0
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        // 计算A B 所有可能之和放入 map
        for (int i : A) {
            for (int j: B) {
                map.put(i+j, map.getOrDefault(i+j, 0) + 1);
            }
        }
        int result = 0;
        // 求出C D所有可能之和, 如果 map 中包含这个和的相反数, 说明四数相加等于 0
        for (int i : C) {
            for (int j: D) {
                if (map.containsKey(-(i+j))) {
                    result += map.get(-(i+j));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution454 solution = new Solution454();
        int[] A = {1,2};
        int[] B = {-1,-2};
        int[] C = {-1,2};
        int[] D = {0,2};
        System.out.println(solution.fourSumCount(A, B, C, D));
    }
}
