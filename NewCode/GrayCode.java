package NewCode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description: 生成格雷码
 * 在一组数的编码中，若任意两个相邻的代码只有一位二进制数不同， 则称这种编码为格雷码(Gray Code)，请编写一个函数，使用递归的方法生成N位的格雷码。
 * 给定一个整数n，请返回n位的格雷码，顺序为从0开始。
 *
 * 测试样例：    1
 * 返回：      ["0","1"]
 * @author: Deepcola
 * @time: 2020/12/7 14:47
 */
public class GrayCode {

    public static String[] getGray(int n) {
        String[] result = null;
        if (n == 1) {
            result = new String[]{"0","1"};
        }else {
            String[] temp = getGray(n-1);
            result = new String[2*temp.length];
            for (int i = 0; i < temp.length; i++) {
                result[i] = "0" + temp[i];
                result[result.length-1-i] = "1" + temp[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scan  = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            System.out.println(Arrays.toString(getGray(n)));
        }
    }
}
