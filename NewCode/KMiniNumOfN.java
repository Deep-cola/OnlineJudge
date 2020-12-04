package NewCode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description: n个数中最小的k个
 * 找出n个数里最小的k个
 * 输入描述:    每个测试输入包含空格分割的n+1个整数，最后一个整数为k值,n不超过100。
 * 输出描述:    输出n个整数里最小的k个数。升序输出
 * 输入       3 9 6 8 -10 7 -11 19 30 12 23 5
 * 输出       -11 -10 3 6 7
 * @author: Deepcola
 * @time: 2020/12/4 17:51
 */
public class KMiniNumOfN {


    /**
     * 快速排序寻找基准
     */
    public static int quick(int[] arr, int start, int end) {
        int temp = arr[start];
        while (start < end) {
            while (start < end && arr[end] >= temp) {
                end--;
            }
            arr[start] = arr[end];
            while (start < end && arr[start] <= temp) {
                start++;
            }
            arr[end] = arr[start];
        }
        arr[start] = temp;
        return start;
    }

    /**
     * 寻找前 k 个最小的, 使用快速排序寻找基准使得基准前面正好有k个数, 进行排序即可
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String str = scan.nextLine();
            String[] strings = str.split(" ");
            int[] arr = new int[strings.length-1];
            for (int i = 0; i < strings.length-1; i++) {
                arr[i] = Integer.parseInt(strings[i]);
            }
            int k = Integer.parseInt(strings[strings.length-1]);
            // 寻找基准
            int prior = quick(arr, 0, arr.length-1);
            // 判断基准位置
            while (prior != k) {
                if (prior > k) {
                    prior = quick(arr, 0, prior-1);
                }else {
                    prior = quick(arr, prior+1, arr.length-1);
                }
            }
            Arrays.sort(arr, 0 , k);
            for (int i = 0; i < k; i++) {
                System.out.print((i==k-1) ? arr[i] : arr[i] + " ");
            }
        }
    }
}
