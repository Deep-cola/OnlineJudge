package NewCode;

import java.util.Scanner;

/**
 * @description: 买苹果
 * 小易去附近的商店买苹果，奸诈的商贩使用了捆绑交易，只提供6个每袋和8个每袋的包装(包装不可拆分)。
 * 可是小易现在只想购买恰好n个苹果，小易想购买尽量少的袋数方便携带。如果不能购买恰好n个苹果，小易将不会购买。
 *
 * 输入    20
 * 输出    3
 * @author: Deepcola
 * @time: 2020/12/1 17:19
 */
public class BuyApple {

    /**
     * 只提供 6 个每袋和 8 个每袋的包装(包装不可拆分)
     * 如果不能购买恰好 n 个苹果，小易将不会购买
     * 1. 小于 6 个苹果 -> 不买
     * 2. 奇数个苹果 -> 不买
     *      由于袋数要尽量少, 先满足 8 个每袋的  ->  偶数 % 8 : 余数为0 2 4 6
     * 3. n % 8 == 0 -> n/8
     * 4. n % 8 != 0
     *                      8 个每袋               6 个每袋           总袋数
     *      余数为 2  :      n / 8 - 2        (16 + 2) / 6 = 3     n/8 - 2 + 3 = n / 8 + 1
     *      余数为 4  :      n / 8 - 1        (8 + 4) / 6 = 2      n/8 - 1 + 2 = n / 8 + 1
     *      余数未 6  :      n / 8 - 1           1                               n / 8 + 1
     */
    public static int Num(int apple) {
        if (apple < 6 || apple % 2 != 0 || apple == 10) return -1;
        if (apple % 8 == 0) {
            return apple / 8;
        }
        return apple / 8 + 1;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int apple = scan.nextInt();
            System.out.println(Num(apple));
        }
    }
}
