package newcode;

import java.util.Scanner;

/**
 * @description: 每个月兔子的数量
 * 有一只兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子，假如兔子都不死，问每个月的兔子总数为多少？
 * 本题有多组数据。
 *
 * 输入描述:
 * 输入int型表示month
 *
 * 输出描述:
 * 输出兔子总数int型
 *
 * 输入
 * 9
 * 输出
 * 34
 * @author: Deepcola
 * @time: 2021/1/13 0:06
 */
public class Rabbit {

    /*public static int rabbit(int n) {
        if(n <= 2) {
            // 前两个月只有一个兔子
            return 1;
        }else {
            return rabbit(n - 1) + rabbit(n - 2);
        }
    }*/

    public static int rabbit(int n) {
        int one = 1;// 一个月兔子数
        int two = 0;// 两个月兔子数
        int three = 0;// 三个月以后兔子数
        while (--n > 0) {
            three += two;
            two = one;
            one = three;
        }
        return one + two + three;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            int n = scan.nextInt();
            System.out.println(rabbit(n));
        }
    }
}
