package NewCode;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @description:
 * @author: Deepcola
 * @time: 2020/12/7 0:35
 */
public class AddLongNum {
    /**
     * 使用 BigDecimal 类
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String addend = scan.nextLine();
            String augend = scan.nextLine();
            BigDecimal add = new BigDecimal(addend);
            BigDecimal aug = new BigDecimal(augend);
            System.out.println(add.add(aug));
        }
    }


    /**
     * 使用字符串对每一位拆分求和
     * 1.从后向前遍历字符串, 使用 StringBuffer 连接每一位上的结果;
     * 2.每一位上的数字: ( 两个字符串相对应位置之和(字符串位数不够的时候对应位置就是 0) + 进位 ) % 10;
     * 3.直到两个字符串遍历完并且进位为 0 时说明相加完。
     */
    /*public static String addLongNum(String addend, String augend) {
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
    }*/
}
