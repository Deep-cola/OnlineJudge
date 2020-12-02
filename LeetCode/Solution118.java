package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @description: 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 输入:      5
 * 输出:[
 *           [1],
 *          [1,1],
 *         [1,2,1],
 *        [1,3,3,1],
 *       [1,4,6,4,1]
 *     ]
 * @author: Deepcola
 * @time: 2020/12/2 13:34
 */
public class Solution118 {

    /**
     * 进行一个调整:      1
     *                  1 1
     *                  1 2 1
     *                  1 3 3 1
     *                  1 4 6 4 1
     * 这样的话很明显可以看出规律
     */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            // 每一行第一个都是 1
            list.add(1);
            if (i >= 1) {
                // 每个数(除了第一个和最后一个)是它左上方和正上方的数的和。
                for (int j = 1; j < i; j++) {
                    list.add(result.get(i-1).get(j) + result.get(i-1).get(j-1));
                }
                // 每一行最后一个都是 1
                list.add(1);
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
