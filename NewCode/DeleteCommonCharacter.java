package newcode;

import java.util.Scanner;

/**
 * @description:
 * @author: Deepcola
 * @time: 2020/12/1 17:41
 */
public class DeleteCommonCharacter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            char[] chars = scan.nextLine().toCharArray();
            String str = scan.nextLine();
            for (int i = 0; i < chars.length; i++) {
                if (!str.contains(String.valueOf(chars[i]))) {
                    System.out.print(chars[i]);
                }
            }
        }
    }
}
