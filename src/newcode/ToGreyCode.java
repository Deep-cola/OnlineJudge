package newcode;

import java.util.Arrays;

/**
 * @description:
 * @author: Deepcola
 * @time: 2020/12/4 22:19
 */
public class ToGreyCode {

    public static String[] GrayCode(int n) {
        String[] gray = new String[(int) Math.pow(2, n)];
        if (n == 1) {
            gray[0] = "0";
            gray[1] = "1";
            return gray;
        }
        String[] temp = GrayCode(n-1);
        for (int i = 0; i < temp.length; i++) {
            gray[i] = 0 + temp[i];
            gray[gray.length - i - 1] = 1 + temp[i];
        }
        return gray;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(GrayCode(5)));
    }
}
