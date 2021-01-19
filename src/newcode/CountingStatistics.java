package newcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @description: 计票统计
 * 请实现一个计票统计系统。你会收到很多投票，其中有合法的也有不合法的，请统计每个候选人得票的数量以及不合法的票数。
 * 本题有多组样例输入。
 *
 * 输入描述:
 * 输入候选人的人数n，第二行输入n个候选人的名字（均为大写字母的字符串），第三行输入投票人的人数，第四行输入投票。
 *
 * 输出描述:
 * 按照输入的顺序，每行输出候选人的名字和得票数量，最后一行输出不合法的票数。
 *
 * 示例1
 * 输入
 * 4
 * A B C D
 * 8
 * A D E CF A GG A B
 * 输出
 * A : 3
 * B : 1
 * C : 0
 * D : 1
 * Invalid : 3
 * @author: Deepcola
 * @time: 2021/1/19 23:25
 */
public class CountingStatistics {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            int n = scan.nextInt();
            // map —— 姓名：票数
            Map<String, Integer> map = new HashMap<>();
            String[] candidates = new String[n];
            for(int i = 0; i < n; i++) {
                candidates[i] = scan.next();
                map.put(candidates[i], 0);
            }
            int m = scan.nextInt();
            for(int i = 0; i < m; i++) {
                String name = scan.next();
                if(map.containsKey(name)) {
                    map.put(name, map.get(name) + 1);
                }else {
                    map.put("Invalid", map.getOrDefault("Invalid", 0) + 1);
                }
            }
            // 输出
            for(String s: candidates) {
                System.out.println(s + " : " + map.getOrDefault(s, 0));
            }
            System.out.println("Invalid : " + map.getOrDefault("Invalid", 0));
        }
    }
}
