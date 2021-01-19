package newcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description: 最高分是多少
 * 老师想知道从某某同学当中，分数最高的是多少，现在请你编程模拟老师的询问。当然，老师有时候需要更新某位同学的成绩.
 *
 * 输入描述:
 * 输入包括多组测试数据。
 * 每组输入第一行是两个正整数N和M（0 < N <= 30000,0 < M < 5000）,分别代表学生的数目和操作的数目。
 * 学生ID编号从1编到N。
 * 第二行包含N个整数，代表这N个学生的初始成绩，其中第i个数代表ID为i的学生的成绩
 * 接下来又M行，每一行有一个字符C（只取‘Q’或‘U’），和两个正整数A,B,当C为'Q'的时候, 表示这是一条询问操作，他询问ID从A到B（包括A,B）的学生当中，成绩最高的是多少
 * 当C为‘U’的时候，表示这是一条更新操作，要求把ID为A的学生的成绩更改为B。
 *
 * 输出描述:
 * 对于每一次询问操作，在一行里面输出最高成绩.
 * 示例1
 * 输入
 * 5 7
 * 1 2 3 4 5
 * Q 1 5
 * U 3 6
 * Q 3 4
 * Q 4 5
 * U 4 5
 * U 2 9
 * Q 1 5
 * 输出
 * 5
 * 6
 * 5
 * 9
 * @author: Deepcola
 * @time: 2021/1/18 23:55
 */
public class MaxScore {


    public static int getMax(int[] A, int start, int end) {
        int result = A[start];
        for (int i = Math.min(start, end); i <= Math.max(start, end); i++) {
            if (A[i] > result) {
                result = A[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int[] scores = new int[m + 1];
            for (int i = 1; i <= m; i++) {
                scores[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                char ch = scanner.next().charAt(0);
                int A = scanner.nextInt();
                int B = scanner.nextInt();
                if (ch == 'Q') {
                    // ID从A到B（包括A,B）的学生当中，成绩最高的是多少
                    System.out.println(getMax(scores, A, B));
                }else {
                    // 把ID为A的学生的成绩更改为B。
                    scores[A] = B;
                }
            }
        }
    }
}
