package newcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @description: 锤子剪刀布
 * 大家应该都会玩“锤子剪刀布”的游戏：
 *
 * 现给出两人的交锋记录，请统计双方的胜、平、负次数，并且给出双方分别出什么手势的胜算最大。
 *
 * 输入描述:
 * 输入第1行给出正整数N（<=105），即双方交锋的次数。随后N行，每行给出一次交锋的信息，即甲、乙双方同时给出的的手势。C代表“锤子”、J代表“剪刀”、B代
 * 表“布”，第1个字母代表甲方，第2个代表乙方，中间有1个空格。
 *
 *
 * 输出描述:
 * 输出第1、2行分别给出甲、乙的胜、平、负次数，数字间以1个空格分隔。第3行给出两个字母，分别代表甲、乙获胜次数最多的手势，中间有1个空格。如果解不唯
 * 一，则输出按字母序最小的解。
 *
 * 示例1
 * 输入
 * 10<br/>C J<br/>J B<br/>C B<br/>B B<br/>B C<br/>C C<br/>C B<br/>J B<br/>B C<br/>J J
 * 输出
 * 5 3 2<br/>2 3 5<br/>B B
 * @author: Deepcola
 * @time: 2021/1/19 22:24
 */
public class FingerGuessing {

    /**
     * C > J
     * J > B
     * B > C
     */
    // 统计获胜的手势以及次数
    static Map<Character, Integer> mapA = new HashMap<>();// A
    static Map<Character, Integer> mapB = new HashMap<>();// B
    // 比较两个手势
    public static void compare(String s, int[] A, int[] B) {
        if(s.equals("CJ") || s.equals("JB") || s.equals("BC")) {
            // A win
            char ch = s.charAt(0);
            mapA.put(ch, mapA.getOrDefault(ch, 0) + 1);
            A[0]++;
            B[2]++;
        }else if (s.equals("JC") || s.equals("BJ") || s.equals("CB")) {
            // B win
            char ch = s.charAt(1);
            mapB.put(ch, mapB.getOrDefault(ch, 0) + 1);
            A[2]++;
            B[0]++;
        }else {
            // 平
            A[1]++;
            B[1]++;
        }
    }
    // 从各自的 map 中获得胜利次数最多的手势(次数相同 -> 字典序输出最小的)
    public static char[] getMaxCount() {
        // 0, 1 -> A, B
        char[] chars = new char[2];
        Arrays.fill(chars, 'B');
        // A
        int max1 = -1;
        for(Map.Entry<Character, Integer> entry: mapA.entrySet()) {
            // 记录出现次数最多的
            if(entry.getValue() > max1) {
                max1 = entry.getValue();
                chars[0] = entry.getKey();
            }
            // 次数相同输出字典序最小的
            if(entry.getValue() == max1 && entry.getKey() < chars[0]) {
                chars[0] = entry.getKey();
            }
        }
        // B
        int max2 = -1;
        for(Map.Entry<Character, Integer> entry: mapB.entrySet()) {
            // 记录出现次数最多的
            if(entry.getValue() > max2) {
                max2 = entry.getValue();
                chars[1] = entry.getKey();
            }
            // 次数相同输出字典序最小的
            if(entry.getValue() == max2 && entry.getKey() < chars[1]) {
                chars[1] = entry.getKey();
            }
        }
        return chars;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            int n = scan.nextInt();
            scan.nextLine();
            // 0 1 2 —————— 胜 平 负
            int[] A = new int[3];
            int[] B = new int[3];
            // 获取输入
            for(int i = 0; i < n; i++) {
                String[] str = scan.nextLine().split(" ");
                // 比较输赢
                compare(str[0] + str[1], A, B);
            }
            // 获得胜利手势出现次数最多的结果
            char[] chars = getMaxCount();
            // 输出
            System.out.println(A[0] + " " + A[1] + " " + A[2]);
            System.out.println(B[0] + " " + B[1] + " " + B[2]);
            System.out.println(chars[0] + " " + chars[1]);
        }
    }
}
