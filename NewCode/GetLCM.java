package NewCode;

import java.util.Scanner;

/**
 * @description: 最小公倍数
 * 正整数A和正整数B 的最小公倍数是指 能被A和B整除的最小的正整数值，设计一个算法，求输入A和B的最小公倍数。
 *
 * 输入描述:    输入两个正整数A和B。
 * 输出描述:    输出A和B的最小公倍数。
 * 输入       5 7
 * 输出       35
 * @author: Deepcola
 * @time: 2020/12/4 15:28
 */
public class GetLCM {

    /**
     * lcm(A, B) = A*B / gcl(A, B)
     * 最小公倍数是两数之积除以最大公因数, 最大公因数使用辗转相除法
     */
    public static int lcm(int A, int B) {
        return A*B / gcl(A, B);
    }

    /**
     * 辗转相除法
     */
    public static int gcl(int A, int B) {
        if (B == 0) return A;
        return gcl(B, A % B);
    }

    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);
        while (scan.hasNext()) {
            int A = scan.nextInt();
            int B = scan.nextInt();
            System.out.println(lcm(A, B));
        }
    }
}
