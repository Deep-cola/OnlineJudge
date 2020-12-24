package leetcode;

import java.util.*;

/**
 * @description: 找到 k 个最接近的数
 * 给定一个排序好的数组，两个整数 k 和 x，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
 * 如果有两个数与 x 的差值一样，优先选择数值较小的那个数。
 *
 * 示例 :
 * 输入: [1,2,3,4,5], k=4, x=3
 * 输出: [1,2,3,4]
 * @author: Deepcola
 * @time: 2020/11/20 16:58
 */
public class Solution658 {

    /**
     * 找到 k 个接近 x 的数, 维护一个大根堆，由于数组是排好序的，所以依次向后遍历
     * 当数组中的元素更接近 x 时, 就弹出堆顶元素, 加入新元素同时更新大根堆继续维护
     * 由于大根堆中记录的是差值，所以定义一个队列用以存放相对应的元素下标
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // 建立大根堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        // 存放优先级队列中差值对应的元素下标
        Queue<Integer> queue = new LinkedList<>();
        // 遍历数组
        // queue 和 priorityQueue 应该基本同步进行，(某个元素 - x)入队时，这个元素下标应该也入队 queue; 同样，出队时也因该从 queue 中移除
        for (int i = 0; i < arr.length; i++) {
            // 使用 k 个元素建立大根堆
            if (priorityQueue.size() < k) {
                priorityQueue.offer(Math.abs(arr[i] - x));
                queue.offer(i);
            }else {
                // 当数组中元素更接近 x 时, 弹出栈顶元素
                // list 中的相应元素也要删除
                if (Math.abs(arr[i] - x) < priorityQueue.peek()) {
                    priorityQueue.poll();
                    priorityQueue.offer(Math.abs(arr[i] - x));
                    queue.poll();
                    queue.offer(i);
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            list.add(arr[queue.poll()]);
        }
        return list;
    }

    public static void main(String[] args) {
        Solution658 solution = new Solution658();
        int[] arr = {0,0,1,2,3,3,4,7,7,8};
        int k = 3;
        int x = 5;
        System.out.println(solution.findClosestElements(arr, k, x));
    }
}
