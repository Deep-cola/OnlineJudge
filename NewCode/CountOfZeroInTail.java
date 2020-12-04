package NewCode;

import java.util.Scanner;

/**
 * @description: 末尾0的个数
 * 输入一个正整数n,求n!(即阶乘)末尾有多少个0？ 比如: n = 10; n! = 3628800,所以答案为2
 * 输入描述     输入为一行，n(1 ≤ n ≤ 1000)
 * 输出描述     输出一个整数,即题目所求
 * 输入           10
 * 输出           2
 * @author: Deepcola
 * @time: 2020/12/4 19:27
 */
public class CountOfZeroInTail {

    /**
     * 计算 n 的阶乘有多少个零, 可以将小于等于 0 的正整数分解成质因数, 然后再乘到一起
     * 末尾时 0 的个数就是 2*5 的个数, 因为质数只有 2*5 末尾有零, 由于 2 个数太多, 所以计算 5 的个数就好
     * 只有 5 的倍数才有 5 这个因数。除了 25 125 652 等等这些每个数都提供 2 3 4 个 5
     */

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            int result = 0;
            // 计算 n 的阶乘有多少个零, 可以将小于等于 n 的每个数分解成质因数
            for (int i = n; i >= 5; i--) {
                int temp = i;
                while (temp % 5 ==0) {
                    result++;
                    temp /= 5;
                }
            }
            System.out.println(result);
        }
    }
}
