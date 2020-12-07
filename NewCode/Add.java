package NewCode;

import java.util.Scanner;

/**
 * @description:
 * @author: Deepcola
 * @time: 2020/12/7 0:35
 */
public class Add {

    public static String addLongNum(String addend, String augend) {
        int i = addend.length() - 1;
        int j = augend.length() - 1;
        int carry = 0;
        StringBuffer sb = new StringBuffer();
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            int add = i >= 0 ? addend.charAt(i) - '0' : 0;
            int aug = j >= 0 ? augend.charAt(j) - '0' : 0;
            sum += add + aug;
            sb.insert(0, sum%10);
            carry = sum / 10;
            i--;
            j--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String add = scanner.nextLine();
            String aug = scanner.nextLine();
            System.out.println(addLongNum(add, aug));
        }
    }
}
