package newcode;

import java.util.Scanner;

/**
 * @description: 尼科彻斯定理
 * 验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。
 * 例如：
 * 1^3=1
 * 2^3=3+5
 * 3^3=7+9+11
 * 4^3=13+15+17+19
 * 输入一个正整数m（m≤100），将m的立方写成m个连续奇数之和的形式输出。
 * 输入描述:    输入一个int整数
 * 输出描述:    输出分解后的string
 * 输入       6
 * 输出       31+33+35+37+39+41
 * @author: Deepcola
 * @time: 2020/12/14 23:11
 */
public class Nikochus {

    /**
     * 等差数列首项是 m*(m-1) + 1
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int m = scan.nextInt();
            StringBuffer sb = new StringBuffer();
            int start = m*(m-1)+1;
            for (int i = 0; i < m; i++) {
                sb.append(start).append("+");
                start += 2;
            }
            sb.deleteCharAt(sb.length()-1);
            System.out.println(sb.toString());
        }
    }
}
