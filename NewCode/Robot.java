package NewCode;

import java.util.Scanner;

/**
 * @description: 机器人走方格
 * 给定两个正整数int x,int y，代表一个x乘y的网格，
 * 现有一个机器人要从网格左上角顶点走到右下角，每次只能走一步且只能向右或向下走，返回机器人有多少种走法。保证x＋y小于等于12。
 * 测试样例：     2,2
 * 返回：          2
 * @author: Deepcola
 * @time: 2020/12/6 21:09
 */
public class Robot {
    public static int countWays(int x, int y) {
        if (x == 1 || y == 1) return 1;
        return countWays(x-1, y) + countWays(x, y-1);
    }

    public static void main(String[] args) {
        System.out.println(countWays(2, 2));
    }
}
