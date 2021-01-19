package newcode;

import java.util.Scanner;

/**
 * @description: 数字之和
 * 对于给定的正整数 n，计算其十进制形式下所有位置数字之和，并计算其平方的各位数字之和。
 *
 * 输入描述:
 * 每行输入数据包括一个正整数n(0<n<40000)
 *
 * 输出描述:
 * 对于每个输入数据，计算其各位数字之和，以及其平方值的数字之和，输出在一行中，之间用一个空格分隔，但行末不要有空格。
 *
 * 示例1
 * 输入
 * 4
 * 12
 * 97
 * 39999
 * 输出
 * 4 7
 * 3 9
 * 16 22
 * 39 36
 * @author: Deepcola
 * @time: 2021/1/19 22:49
 */
public class SumOfDigital {
    // 求和 —— 取出每一位上的数字进行求和
    public static int getSumOfDigital(int n) {
        int result = 0;
        while(n > 0) {
            int digital = n % 10;
            result += digital;
            n /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            int n = scan.nextInt();
            int powerN = n * n;
            System.out.print(getSumOfDigital(n));
            System.out.println(" " + getSumOfDigital(powerN));
        }
    }
}
