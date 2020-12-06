package NewCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @description: 个位数统计
 * 给定一个k位整数N = dk-1*10k-1 + ... + d1*101 + d0 (0<=di<=9, i=0,...,k-1, dk-1>0)，
 * 请编写程序统计每种不同的个位数字出现的次数。例如：给定N = 100311，则有2个0，3个1，和1个3。
 *
 * 输入描述:        每个输入包含1个测试用例，即一个不超过1000位的正整数N。
 * 输出描述:        对N中每一种不同的个位数字，以D:M的格式在一行中输出该位数字D及其在N中出现的次数M。要求按D的升序输出。
 * 输入       100311
 * 输出       0:2  <br/>  1:3  <br/>  3:1
 * @author: Deepcola
 * @time: 2020/12/6 21:43
 */
public class CountOfNUmber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        char[] chars = str.toCharArray();
        List<Integer> list = new ArrayList<>();
        // list 有 item, 装入 0-9
        for (int i = 0; i < 10; i++) {
            list.add(0);
        }
        for (int i = 0; i < chars.length; i++) {
            list.set(chars[i] - '0', list.get(chars[i] - '0') + 1);
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != 0) {
                System.out.println(i + ":" + list.get(i));
            }
        }
    }
}
