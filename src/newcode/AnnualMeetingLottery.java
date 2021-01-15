package newcode;

import java.util.Scanner;

/**
 * @description: 年会抽奖
 * 今年公司年会的奖品特别给力，但获奖的规矩却很奇葩：
 * 1. 首先，所有人员都将一张写有自己名字的字条放入抽奖箱中；
 * 2. 待所有字条加入完毕，每人从箱中取一个字条；
 * 3. 如果抽到的字条上写的就是自己的名字，那么“恭喜你，中奖了！”
 * 现在告诉你参加晚会的人数，请你计算有多少概率会出现无人获奖？
 *
 * 输入描述:
 * 输入包含多组数据，每组数据包含一个正整数n（2≤n≤20）。
 * 输出描述:
 * 对应每一组数据，以“xx.xx%”的格式输出发生无人获奖的概率。
 *
 * 示例1
 * 输入
 * 2
 * 输出
 * 50.00%
 * @author: Deepcola
 * @time: 2021/1/15 16:26
 */
public class AnnualMeetingLottery {

    /**
     * 错排算法:
     *    1.分母: 总共的选择次数 ———— n!
     *    2.分析: 每一个人拿到的都不是自己的 ———— 错排
     *      对于一个人，拿到不是自己的有 (n-1) 种情况，假设 1 号拿到了不是自己的第 k 张
     *      (1)对于第 k 个人, 如果拿到的是 1 号 -> 剩下 (n-2) 个进行错排
     *      (2)对于第 k 个人, 如果拿到的不是 1 号 -> (n-1) 个人进行重排
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            float result = count(n) / factorial(n) * 100;
            System.out.println(String.format("%.2f", result) + "%");
        }
    }
    // 计算所有情况 -> 阶乘
    private static float factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }
    // 计算无人获奖情况 -> 错排
    private static float count(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        return (n - 1) * (count(n - 1) + count(n - 2));
    }
}
