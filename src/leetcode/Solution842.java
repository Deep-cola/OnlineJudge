package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 将数组拆分后斐波那契数列
 * 给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。
 * 形式上，斐波那契式序列是一个非负整数列表 F，且满足：
 *          0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
 *          F.length >= 3；
 * 对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
 * 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
 * 返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。
 *
 * 输入："123456579"
 * 输出：[123,456,579]
 *
 * 输入: "11235813"
 * 输出: [1,1,2,3,5,8,13]
 * @author: Deepcola
 * @time: 2020/12/8 20:06
 */
public class Solution842 {

    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> list = new ArrayList<>();
        backtrack(list, S, S.length(), 0, 0, 0);
        return list;
    }

    /**
     *
     * @param list 结果序列
     * @param S 分割字符串
     * @param length 分割字符串的长度
     * @param index 本次判断的起始位置
     * @param sum 前两数之和
     * @param prev 前一个数
     * @return 是否可以满足要求, 将当前位置分割成前两数之和
     */

    public boolean backtrack(List<Integer> list, String S, int length, int index, int sum , int prev) {
        // 不用继续判断, 同时满足斐波那契数列的要求
        if (index == length && list.size() >= 3) return true;

        long curLong = 0;
        for (int i = index; i < length; i++) {
            // 至少有两位数字但是以 0 开头, 不合适
            if (i > index && S.charAt(index) == '0') {
                break;
            }
            // 当前的数字数值
            curLong = curLong * 10 + S.charAt(i) - '0';
            // 不符合 32 位有符号整数类型
            if (curLong > Integer.MAX_VALUE) {
                break;
            }
            int cur = (int) curLong;
            // 判断数值 cur 是否等于 前面两树之和 sum, 以确定下一步动作
            if (list.size() >= 2) {
                if (cur > sum) {
                    // 当前数值已经大于前面两数之和, 不需要再向下走, 必定大于
                    break;
                }else if (cur < sum){
                    // 数值不够, 继续分配下一个
                    continue;
                }
            }
            // 到达这里说明 cur == sum, 满足 Fibonacci 数列
            list.add(cur);
            if (backtrack(list, S, length, i+1, prev + cur, cur)) {
                return true;
            }else {
                list.remove(list.size()-1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution842 solution = new Solution842();
        String S = "11235813";
        System.out.println(solution.splitIntoFibonacci(S));
    }
}
