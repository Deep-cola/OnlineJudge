package newcode;

import java.util.Scanner;

/**
 * @description: 爬楼梯
 * 你在爬楼梯，需要n步才能爬到楼梯顶部
 * 每次你只能向上爬1步或者2步。有多少种方法可以爬到楼梯顶部？
 *
 * 示例1
 * 输入
 * 1
 * 输出
 * 1
 * 示例2
 * 输入
 * 3
 * 输出
 * 3
 * @author: Deepcola
 * @time: 2021/1/19 22:44
 */
public class ClimbStairs {

    /**
     * 滚动数组
     *      当前台阶 = (前一个台阶 + 1) + (前两个台阶 + 2)
     */
    public static int climbStairs (int n) {
        // write code here
        if (n <= 2) return n;
        int one = 1;
        int two = 2;
        int three = 3;
        for(int i = 3; i <= n; i++) {
            three = one + two;
            one = two;
            two = three;
        }
        return three;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.println(climbStairs(n));
        }
    }
}
