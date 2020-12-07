package NewCode;

import java.util.Scanner;

/**
 * @description:
 * @author: Deepcola
 * @time: 2020/12/7 7:09
 */
public class Bodd {

    public static void draw(int n, char ch) {
        for (int i = 0; i < Math.round(n*1.0 / 2); i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == Math.round(n*1.0 / 2) - 1) {
                    System.out.print(ch);
                }else {
                    if (j == 0 || j == n-1) {
                        System.out.print(ch);
                    }else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            char ch = scan.next().charAt(0);
            draw(n ,ch);
        }
    }
}
