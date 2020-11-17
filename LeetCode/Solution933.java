package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 最近的请求次数
 * 写一个 RecentCounter 类来计算特定时间范围内最近的请求。
 * 请你实现 RecentCounter 类：
 *      RecentCounter() 初始化计数器，请求数为 0 。
 *      int ping(int t) 在时间 t 添加一个新请求，其中 t 表示以毫秒为单位的某个时间，并返回过去 3000 毫秒内发生的所有请求数（包括新请求）。
 *      确切地说，返回在 [t-3000, t] 内发生的请求数。
 * 保证 每次对 ping 的调用都使用比之前更大的 t 值。
 *
 * 输入：
 * ["RecentCounter", "ping", "ping", "ping", "ping"]
 * [[], [1], [100], [3001], [3002]]
 * 输出：
 * [null, 1, 2, 3, 3]
 * @author: Deepcola
 * @time: 2020/11/17 22:21
 */
public class Solution933 {

    /**
     * 计算特定时间范围内最近的请求
     * 利用队列先进先出的特性, 当先请求的的不满足  是[t-3000, t] 内发生的请求数时，就弹出队列。
     */
    class RecentCounter {
        public Queue<Integer> queue;
        /**
         * 初始化计数器，请求数为 0
         */
        public RecentCounter() {
            queue = new LinkedList<>();
        }

        /**
         * 返回请求树
         */
        public int ping(int t) {
            queue.offer(t);
            while (queue.peek() < t - 3000) {
                queue.poll();
            }
            return queue.size();
        }
    }


    public static void main(String[] args) {
        Solution933 solution = new Solution933();
        RecentCounter recentCounter = solution.new RecentCounter();
        System.out.println(recentCounter.ping(1));
        System.out.println(recentCounter.ping(100));
        System.out.println(recentCounter.ping(3001));
        System.out.println(recentCounter.ping(3002));
    }
}
