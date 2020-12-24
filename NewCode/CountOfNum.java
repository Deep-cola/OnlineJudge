package newcode;

import java.util.Scanner;

/**
 * @description: n个数里出现次数大于等于n/2的数
 * 输入n个整数，输出出现次数大于等于数组长度一半的数。
 *
 * 输入: 每个测试输入包含 n个空格分割的n个整数，n不超过100，其中有一个整数出现次数大于等于n/2。
 *          3 9 3 2 5 6 7 3 2 3 3 3
 * 输出: 输出出现次数大于等于n/2的数。
 *          3
 * @author: Deepcola
 * @time: 2020/12/1 18:29
 */
public class CountOfNum {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String s = scan.nextLine();
            String[] strings = s.split(" ");
            int[] arr = new int[strings.length];
            for (int i = 0; i < strings.length; i++) {
                arr[i] = Integer.valueOf(strings[i]);
            }

            int num = arr[0];
            int count = 0;
            for (int i = 1; i < strings.length; i++) {
                if (arr[i] == num) {
                    count++;
                }else if (count > 0) {
                    count--;
                }else {
                    num = arr[i];
                }
            }
            System.out.println(num);
        }
    }

    /*public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = 0;
        HashMap<Integer, Integer> map =  new HashMap<>();
        while (scan.hasNext()) {
            int num = scan.nextInt();
            map.put(num, map.getOrDefault(num, 0) + 1);
            n++;
        }
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() >= n / 2) {
                System.out.println(entry.getKey());
                return;
            }
        }
    }*/
}
