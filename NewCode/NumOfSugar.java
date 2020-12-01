package NewCode;

import java.util.Scanner;

/**
 * @description: 计算糖果
 * A,B,C三个人是好朋友,每个人手里都有一些糖果,我们不知道他们每个人手上具体有多少个糖果,但是我们知道以下的信息：
 * A - B, B - C, A + B, B + C. 这四个数值.每个字母代表每个人所拥有的糖果数.
 * 现在需要通过这四个数值计算出每个人手里有多少个糖果,即A,B,C。这里保证最多只有一组整数A,B,C满足所有题设条件。
 *
 * 输入: 输入为一行，一共4个整数，分别为A - B，B - C，A + B，B + C，用空格隔开。 范围均在-30到30之间(闭区间)。
 *      1 -2 3 4
 * 输出: 输出为一行，如果存在满足的整数A，B，C则按顺序输出A，B，C，用空格隔开，行末无空格。 如果不存在这样的整数A，B，C，则输出No
 *      2 1 3
 * @author: Deepcola
 * @time: 2020/12/1 18:15
 */
public class NumOfSugar {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();
            int d = scan.nextInt();
            int B1 = (b + d) / 2;
            int B2 = (c - a) / 2;
            if (B1 != B2) {
                System.out.println("No");
                return;
            }
            int A = a + B1;
            int C = B1 - b;
            System.out.println(A + " " + B1 + " " + C);
        }
    }
}
