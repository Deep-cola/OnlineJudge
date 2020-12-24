package newcode;

import java.util.Scanner;

/**
 * @description: 统计同成绩人数
 * 读入N名学生的成绩，将获得某一给定分数的学生人数输出。
 * 输入描述:          测试输入包含若干测试用例，每个测试用例的格式为
 *                  第1行：N
 *                  第2行：N名学生的成绩，相邻两数字用一个空格间隔。
 *                  第3行：给定分数
 *                  当读到N=0时输入结束。其中N不超过1000，成绩分数为（包含）0到100之间的一个整数。
 * 输出描述:          对每个测试用例，将获得给定分数的学生人数输出。
 * 输入
 * 3
 * 80 60 90
 * 60
 * 2
 * 85 66
 * 0
 * 5
 * 60 75 90 55 75
 * 75
 * 0
 * 输出
 * 1
 * 0
 * 2
 * @author: Deepcola
 * @time: 2020/12/15 22:45
 */
public class NumOfSameScore {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int N = scan.nextInt();
            if (N == 0) return;
            int[] scores = new int[N];
            // 读入成绩
            for (int i = 0; i < N; i++) {
                scores[i] = scan.nextInt();
            }
            // 给定成绩
            int target = scan.nextInt();
            int count = 0;// 人数
            for (int i = 0; i < N; i++) {
                if (scores[i] == target) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
