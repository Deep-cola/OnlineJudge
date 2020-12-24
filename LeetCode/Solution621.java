package leetcode;

import java.util.Arrays;

/**
 * @description: 任务调度器
 * 给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。
 * 任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。
 * 然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 * 你需要计算完成所有任务所需要的 最短时间 。
 *
 * 输入：tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
 * 输出：16
 * 解释：一种可能的解决方案是：
 *      A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> (待命) -> (待命) -> A -> (待命) -> (待命) -> A
 * @author: Deepcola
 * @time: 2020/12/5 0:17
 */
public class Solution621 {

    /**
     * 为了最短时间, 所以出现次数最多的每次冷却前都应该执行一次
     * 对 tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
     * 每次都是 A X X A X X A X X ...
     * 使用 count 代表 A 出现次数; max 代表出现次数为 count 的任务个数
     * 如果说出现次数最多的大于等于其他任务次数之和, 时间就是 完整部分 +  剩余任务个数 : (count - 1) * (n+1) + max
     * 如果说出现次数最多的小于其他任务次数之和, 那就说明冷却时间基本没用, 直接就是数组长度。
     */
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        // 统计任务的执行次数
        for (char ch: tasks) {
            count[ch - 'A']++;
        }
        // 排序
        Arrays.sort(count);
        int max = 0;// 最大数量的任务个数
        for (int i = 25; i >= 0; i--) {
            if (count[i] != count[25]) {
                break;
            }
            max++;
        }
        // 存在 出现次数最多的大于等于 / 小于其他任务次数之和两种情况
        return Math.max((count[25] - 1) * (n+1) + max, tasks.length);
    }

    public static void main(String[] args) {
        Solution621 solution = new Solution621();
        char[] tasks = {'A','A','A','A','A','A','B','C','D','E','F','G'};
        int n = 2;
        System.out.println(solution.leastInterval(tasks, n));
    }
}
