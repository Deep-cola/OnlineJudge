package newcode;

import java.util.Scanner;

/**
 * @description:  数字分类
 * 给定一系列正整数，请按要求对数字进行分类，并输出以下5个数字：
 *
 * A1 = 能被5整除的数字中所有偶数的和；
 *
 * A2 = 将被5除后余1的数字按给出顺序进行交错求和，即计算n1-n2+n3-n4...；
 *
 * A3 = 被5除后余2的数字的个数；
 *
 * A4 = 被5除后余3的数字的平均数，精确到小数点后1位；
 *
 * A5 = 被5除后余4的数字中最大数字。
 *
 * 输入描述:
 * 每个输入包含1个测试用例。
 * 每个测试用例先输入一个不超过1000的正整数N。
 * 然后给出N个不超过1000的待分类的正整数。数字间以空格分隔。
 *
 *
 * 输出描述:
 * 对给定的N个正整数，按题目要求计算A1~A5并在一行中顺序输出。数字间以空格分隔，但行末不得有多余空格。
 * 若其中某一类数字不存在，则在相应位置输出“N”。
 *
 * 示例1
 * 输入
 * 13 1 2 3 4 5 6 7 8 9 10 20 16 18
 * 输出
 * 30 11 2 9.7 9
 * 说明
 * 总共13个数字
 * @author: Deepcola
 * @time: 2021/1/18 23:28
 */
public class ClassesOfDigital {

    /**
     * A1 = 能被5整除的数字中所有偶数的和；
     * A2 = 将被5除后余1的数字按给出顺序进行交错求和，即计算n1-n2+n3-n4...；
     * A3 = 被5除后余2的数字的个数；
     * A4 = 被5除后余3的数字的平均数，精确到小数点后1位；
     * A5 = 被5除后余4的数字中最大数字。
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            int A1 = 0, A2 = 0, A3 = 0, A5 = -1;
            double A4 = 0;
            // 辅助变量
            int flag = 1;
            int sum = 0;
            int count = 0;
            for (int i = 0; i < N; i++) {
                int num = scanner.nextInt();
                switch (num % 5) {
                    case 0:
                        // 偶数
                        if (num % 2 == 0) {
                            A1 += num;
                        }
                        break;
                    case 1:
                        A2 += num * flag;
                        flag = -flag;
                        break;
                    case 2:
                        A3++;
                        break;
                    case 3:
                        sum += num;
                        count++;
                        break;
                    case 4:
                        if (num > A5) {
                            A5 = num;
                        }
                        break;
                }
            }
            if (A1 == 0) {
                System.out.println("N" + " ");
            }else {
                System.out.println(A1 + " ");
            }

            if (A2 == 0) {
                System.out.println("N" + " ");
            }else {
                System.out.println(A2 + " ");
            }

            if (A3 == 0) {
                System.out.println("N" + " ");
            }else {
                System.out.println(A3 + " ");
            }

            if (sum == 0) {
                System.out.println("N" + " ");
            }else {
                A4 = sum * 1.0 / count;
                System.out.println(String.format("%.1f", A4) + " ");
            }

            if (A5 == -1) {
                System.out.println("N");
            }else {
                System.out.println(A5);
            }
        }
    }
}
