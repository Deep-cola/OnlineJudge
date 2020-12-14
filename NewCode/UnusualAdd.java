package NewCode;

import java.util.Scanner;

/**
 * @description: 另类加法
 * 给定两个int A和B。编写一个函数返回A+B的值，但不得使用+或其他算数运算符。
 * 测试样例：         1,2
 * 返回：              3
 * @author: Deepcola
 * @time: 2020/12/14 23:45
 */
public class UnusualAdd {

    /**
     * 位的异或运算跟求'和'的结果一致：
     * 异或 1^1=0 1^0=1 0^0=0
     * 求和 1+1=0 1+0=1 0+0=0
     * 位的与运算跟求'进位‘的结果一致：
     * 位与 1&1=1 1&0=0 0&0=0
     * 进位 1+1=1 1+0=0 0+0=0
     */
    public static int addAB(int A, int B) {
        if (B == 0) return A;
        int sum = A ^ B;// 相加但是没有进位
        int carry = (A & B) << 1;// 进位但是没有相加
        return addAB(sum, carry);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            System.out.println(addAB(A, B));
        }
    }
}
