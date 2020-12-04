package NewCode;

import java.util.Scanner;

/**
 * @description:
 * @author: Deepcola
 * @time: 2020/12/4 15:49
 */
public class Cakes {

    /**
     * 四行四列是一个周期
     *          * *    * *    * *    * *
     *          * *    * *    * *    * *
     *             * *    * *    * *    * *
     *             * *    * *    * *    * *
     *          * *    * *    * *    * *
     *          * *    * *    * *    * *
     * 对于 M 行 H 列
     * i / i+1 行: H/4 * 2 + (H % 4 < 2) ? H % 4 : 2
     * i+1 / i+2 行: (H-2)/4 * 2 + ((H-2) % 4 < 2) ? (H-2)/4 : 2
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int M = scan.nextInt();
            int H = scan.nextInt();
            int evenCount = H / 4 * 2 + (Math.min(H % 4, 2));
            int oddCount = (H-2) / 4 * 2 + (((H-2) % 4 < 2) ? (H-2)/4 : 2);
            int result = M/4 * (evenCount + oddCount) * 2;
            if (M % 4 > 0) result += evenCount;
            if (M % 4 > 1) result += evenCount;
            if (M % 4 > 0) result += oddCount;
            System.out.println(result);
        }
    }
}
