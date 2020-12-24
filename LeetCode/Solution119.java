package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 杨辉三角Ⅱ
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 输入: 3
 * 输出: [1,3,3,1]
 * @author: Deepcola
 * @time: 2020/12/2 14:30
 */
public class Solution119 {

    /**
     * 动态规划
     */
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>(rowIndex + 1);
        for (int i = 0; i <= rowIndex; i++) {
            // 每次多加一个 1 作为修后一个数
            result.add(1);
            for (int j = i-1; j > 0; j--) {
                // 当前元素和前一个元素相加等于当前元素
                result.set(j, result.get(j) + result.get(j-1));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getRow(5));
    }
}
