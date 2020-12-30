package newcode;

import java.util.Scanner;

/**
 * @description:
 * 输入描述:     输入在一行中给出正方形边长N（3<=N<=20）和组成正方形边的某种字符C，间隔一个空格。
 * 输出描述:     输出由给定字符C画出的正方形。但是注意到行间距比列间距大，所以为了让结果看上去更像正方形，我们输出的行数实际上是列数的50%（四舍五入取整）。
 * 输入   10 a
 * 输出 aaaaaaaaaa
 *     a        a
 *     a        a
 *     a        a
 *     aaaaaaaaaa
 * @author: Deepcola
 * @time: 2020/12/7 7:09
 */
public class DrawSquare {

    public static void drawSquare(int n, char ch) {
        for (int i = 0; i < Math.round(n*1.0 / 2); i++) {
            for (int j = 0; j < n; j++) {
                // 第一行和最后一行
                if (i == 0 || i == Math.round(n*1.0 / 2) - 1) {
                    System.out.print(ch);
                }else {
                    // 其他行的第一列和最后一列
                    if (j == 0 || j == n-1) {
                        System.out.print(ch);
                    }else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            char ch = scan.next().charAt(0);
            drawSquare(n ,ch);
        }
    }
}
