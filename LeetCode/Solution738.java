package leetcode;

import java.util.Scanner;

/**
 * @description: 单调递增的数字
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 * 输入: N = 10
 * 输出: 9

 * 输入: N = 1234
 * 输出: 1234
 *
 * 输入: N = 332
 * 输出: 299
 * @author: Deepcola
 * @time: 2020/12/15 7:55
 */
public class Solution738 {

    /**
     * 从后向前遍历, 如果前面一位大于后面一位，就让前面一位减 1,后面的所有数字变为 9.
     */
    /*public int monotoneIncreasingDigits(int N) {
        char[] chars = String.valueOf(N).toCharArray();
        for (int i = chars.length - 1; i > 0; i--) {
            // 后面一位小于前面一位
            if (chars[i] < chars[i-1]) {
                chars[i-1]--;
                // 后面都变为 9
                for (int j = i; j < chars.length; j++) {
                    chars[j] = '9';
                }
            }
        }
        return Integer.parseInt(new String(chars));
    }*/
    /*public int monotoneIncreasingDigits(int N) {
        char[] chars = String.valueOf(N).toCharArray();
        int flag = chars.length;
        for (int i = chars.length-1; i > 0; i--) {
            // 后一位小于前一位
            if (chars[i] < chars[i-1]) {
                flag = i;
                chars[i-1]--;
            }
        }
        // 后面都是 9
        for (int i = flag; i < chars.length; i++) {
            chars[i] = '9';
        }
        return Integer.parseInt(new String(chars));
    }*/



    /**
     * 贪心算法: 不考虑 N 的限制最大数就是全为 9;
     * 1.从前到后遍历, 直到 i 使得 [0,i-1]递增且 chars[i+1] < chars[i];
     * 2.把当前位置改为 9, 前一个位置应该 -1, 这样就最大；但是 -1 后有可能不是递增了, 所以
     * 3.向前遍历寻找改变后仍然递增的点或者直只遍历完前面所有的。
     */
    public int monotoneIncreasingDigits(int N) {
        char[] chars = String.valueOf(N).toCharArray();
        int i = 1;
        // 查找第一个非递增的
        while (i < chars.length && chars[i-1] <= chars[i]) {
            i++;
        }
        // 没有走完
        if (i < chars.length) {
            while (i > 0 && chars[i] < chars[i-1]) {
                chars[i-1] -= 1;
                i--;
            }

            // 后面都是 9
            for (int j = i+1; j < chars.length; ++j) {
                chars[j] = '9';
            }
        }
        return Integer.parseInt(new String(chars));
    }

    public static void main(String[] args) {
        Solution738 solution = new Solution738();
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int N = scan.nextInt();
            System.out.println(solution.monotoneIncreasingDigits(N));
        }
    }
}
