package newcode;

import java.util.Scanner;

/**
 * @description: 饥饿的小易
 * 小易总是感觉饥饿，所以作为章鱼的小易经常出去寻找贝壳吃。最开始小易在一个初始位置x_0。
 * 对于小易所处的当前位置x，他只能通过神秘的力量移动到 4 * x + 3或者8 * x + 7。因为使用神秘力量要耗费太多体力，所以它只能使用神秘力量最多100,000次。
 * 贝壳总生长在能被1,000,000,007整除的位置(比如：位置0，位置1,000,000,007，位置2,000,000,014等)。小易需要你帮忙计算最少需要使用多少次神秘力量就能吃到贝壳。
 * 输入描述:    输入一个初始位置x_0,范围在1到1,000,000,006
 * 输出描述:    输出小易最少需要使用神秘力量的次数，如果使用次数使用完还没找到贝壳，则输出-1
 * 输入       125000000
 * 输出       1
 * @author: Deepcola
 * @time: 2020/12/14 23:56
 */
public class Hungry {

    /**
     * 对于 4x + 3 和 8x + 7: 有
     *          4(8x+7)+3 = 8(4x+3)+7  ->  对于一个可行方案。顺序并不影响
     *          4(4(4x+3)+3)+3 = 8(8x+7)+7  ->  需要求出最小次数, 所以 3 个 4x + 3 可以转换为 2 个 8x + 7
     * 要求次数最少, 所以尽量转换成 8x+7
     * 那么一个最优策略: 4x+3 就 执行 0/1/2 次, 然后计算 8x+7 次数即可.
     *
     */
    /*public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            long x = scan.nextLong();
            long target = 1000000007;// 贝壳
            long num = 100000;// 最多次数
            // 4x+7 三次的值
            long[] f = new long[3];
            f[0] = x;// 0
            f[1] = (4 * f[0] + 3) % target;// 1
            f[2] = (4 * f[1] + 3) % target;// 2
            long minStep = num;
            for (int i = 0; i < 3; i++) {
                long step = i;
                long pos = f[i];
                while (pos != 0 && step < minStep) {
                    pos = (8 * pos + 7) % target;
                    step++;
                }
                minStep = Math.min(minStep, step);
            }
            if (minStep < num) {
                System.out.println(minStep);
            }else {
                System.out.println(-1);
            }
        }
    }*/

    /**
     * 对于 f(x)=2x+1:
     *          4x+3 是  f(f(x))     -> 2次
     *          8x+7 是  f(f(f(x)))  -> 3次
     * 需要求出最小次数, 所以先考虑 8x + 7
     * 对于 num = x / 3;
     *          余数为 0 -> num
     *          余数为 1 -> num-1+2
     *          余数为 2 -> num+1
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            long pos = scan.nextLong();
            int count = 0;
            long target = 1000000007;
            while (pos != 0 && count < 300000) {
                pos = (2 * pos + 1) % target;
                count++;
            }
            int result = (count % 3 == 0) ? count / 3 : count / 3 + 1;
            // 求出最小次数
            System.out.println(result < 100000 ? result : -1);
        }
    }
}
