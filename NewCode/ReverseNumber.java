package NewCode;

import sun.security.krb5.SCDynamicStoreConfig;

import java.util.Scanner;

/**
 * @description: 数字颠倒
 * 输入一个整数，将这个整数以字符串的形式逆序输出
 * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 * 输入描述     输入一个int整数
 * 输出描述     将这个整数以字符串的形式逆序输出
 * 输入       1516000
 * 输出       0006151
 * @author: Deepcola
 * @time: 2020/12/4 19:21
 */
public class ReverseNumber {


    /**
     * 1.取各位数字, 加入打印行列
     * 2.去掉个位数字, 继续第一步直到数字为0
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int num = scan.nextInt();
            String result = "";
            for (int i = 0; num != 0; i++) {
                // 取各位数字
                int temp = num % 10;
                // 去掉个位数字, 进入下一次循环
                num = num / 10;
                result += temp + "";
            }
            System.out.println(result);
        }
    }
}
