package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @description: 查找和最小的 K 对数字
 * 给定两个以升序排列的整形数组 nums1 和 nums2, 以及一个整数 k。
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2。
 * 找到和最小的 k 对数字 (u1,v1), (u2,v2) ... (uk,vk)。
 *
 * @author: Deepcola
 * @time: 2020/11/20 15:11
 */
public class Solution373 {

    /**
     * 典型 TOPK 问题
     * 1.查找和最小的 k 对数字, 所以建立规模为 k 的大根堆(使用优先级队列然后更改排序条件即可)
     * 2.大根堆建好, 比较剩下的组合与队中最大元素堆顶元素即可
     * 3.小于堆顶元素就弹出堆顶元素然后插入新组合, 反之比较下一对
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // 建立大根堆的优先级队列
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] + o2[1] - o1[0] - o1[1];
            }
        });
        // 遍历两个数组找出所有组合进行比较
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int[] temp = new int[]{nums1[i], nums2[j]};
                if (priorityQueue.size() < k) {
                    priorityQueue.offer(temp);
                }else {
                    if (compare(temp, priorityQueue.peek()) > 0) {
                        priorityQueue.poll();
                        priorityQueue.offer(temp);
                    }
                }
            }
        }
        // 返回家过
        List<List<Integer>> result = new ArrayList<>();
        for (int[] temp: priorityQueue) {
            List<Integer> list = new ArrayList<>();
            list.add(temp[0]);
            list.add(temp[1]);
            result.add(list);
        }
        return result;
    }

    /**
     * 比较两个数组元素和的大小
     * @return >0 : 后者大
     *         <0 : 前者大
     *         =0 : 一样大
     */
    public int compare(int[] o1, int[] o2) {
        return o2[0] + o2[1] - o1[0] - o1[1];
    }



    public static void main(String[] args) {
        Solution373 solution = new Solution373();
        int[] nums1 = {1,2};
        int[] nums2 = {2};
        int k = 3;
        System.out.println(solution.kSmallestPairs(nums1, nums2, k));
    }
}
