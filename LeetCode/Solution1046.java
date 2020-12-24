package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @description: 最后一块石头的重量
 * 有一堆石头，每块石头的重量都是正整数。
 * 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 *      如果 x == y，那么两块石头都会被完全粉碎；
 *      如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 * @author: Deepcola
 * @time: 2020/11/20 16:00
 */
public class Solution1046 {

    /**
     * 从中取出两块最重的石头, 只需要维护一个大根堆, 两次弹出堆顶元素，
     * 然后将两块石头碰撞之后的新石头继续放入，维护大根堆，直至剩下一块石头或者堆为空
     */
    public int lastStoneWeight(int[] stones) {
        // 建立大根堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        // 石头进堆 -> 维护大根堆
        for (int stone: stones) {
            priorityQueue.offer(stone);
        }
        // 石头碰撞
        while (priorityQueue.size() > 1) {
            priorityQueue.offer(priorityQueue.poll() - priorityQueue.poll());
        }
        // 还有一块石头
        if (!priorityQueue.isEmpty()) {
            return priorityQueue.poll();
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution1046 solution = new Solution1046();
        int[] stones = {2,7,4,1,8,1};
        System.out.println(solution.lastStoneWeight(stones));
    }
}
