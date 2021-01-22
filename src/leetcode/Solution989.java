package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @description: 数组形式的整数加法
 * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 *
 * 示例 1：
 * 输入：A = [1,2,0,0], K = 34
 * 输出：[1,2,3,4]
 * 解释：1200 + 34 = 1234
 *
 * 示例 2：
 * 输入：A = [2,7,4], K = 181
 * 输出：[4,5,5]
 * 解释：274 + 181 = 455
 *
 * 示例 3：
 * 输入：A = [2,1,5], K = 806
 * 输出：[1,0,2,1]
 * 解释：215 + 806 = 1021
 *
 * 示例 4：
 * 输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
 * 输出：[1,0,0,0,0,0,0,0,0,0,0]
 * 解释：9999999999 + 1 = 10000000000
 *  
 * 提示：
 *      1 <= A.length <= 10000
 *      0 <= A[i] <= 9
 *      0 <= K <= 10000
 *      如果 A.length > 1，那么 A[0] != 0
 * @author: Deepcola
 * @time: 2021/1/22 21:33
 */
public class Solution989 {
    /**
     * 使用栈逐位相加
     */
    /*public List<Integer> addToArrayForm(int[] A, int K) {
        Stack<Integer> stack1 = new Stack<>();
        for (int num : A) {
            stack1.push(num);
        }
        List<Integer> result = new ArrayList<>();
        int num = K % 10;
        int carry = 0;
        while (!stack1.isEmpty() || K != 0 || carry != 0) {
            // 求和
            int temp = carry;
            temp += num + (stack1.isEmpty() ? 0 : stack1.pop());
            // 添加
            result.add(0, temp % 10);
            // 更新值
            K = K == 0 ? 0 : K / 10;
            num = K % 10;
            carry = temp / 10;
        }
        return result;
    }*/

    /*public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> result = new ArrayList<>();
        int n = A.length;
        for (int i = n - 1; i >= 0 || K > 0; --i) {
            int sum = K % 10;
            if (i >= 0) {
                sum += A[i];
            }
            K /= 10;
            if (sum >= 10) {
                // 当和大于等于 10，将进位的 1 加入到下一位的计算中
                K++;
                sum -= 10;
            }
            result.add(0, sum);
        }
        return result;
    }*/


    /**
     * 对于 123 + 912
     * 第一次计算为[1, 2, 3 + 912]
     * 第二次计算为[1, 2 + 91, 5]
     * 第三次计算为[1 + 9, 3, 5]
     * 结果为[1, 0, 3, 5]
     */
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> result = new LinkedList<>();
        int i = A.length - 1;
        while (i >= 0 || K != 0) {
            // 数组中有值
            if (i >= 0) {
                K += A[i];
            }
            result.add(0, K % 10);
            K /= 10;
            i--;
        }
        return result;
    }
}
