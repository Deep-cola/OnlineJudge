package newcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description: 无缓存交换
 * 给定一个int数组AB，要求编写一个函数，不使用任何临时变量直接交换第零个元素和第一个元素的值。并返回交换后的数组。
 * 测试样例：    [1,2]
 * 返回：      [2,1]
 * @author: Deepcola
 * @time: 2020/12/7 14:39
 */
public class SwapNoTemp {

    public static int[] exchangeArray(int[] array) {
        array[0] ^= array[1];
        array[1] ^= array[0];
        array[0] ^= array[1];
        return array;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int[] array = new int[2];
            array[0] = scan.nextInt();
            array[1] = scan.nextInt();
            System.out.println(Arrays.toString(exchangeArray(array)));
        }
    }
}
