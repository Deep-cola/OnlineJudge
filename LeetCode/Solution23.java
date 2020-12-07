package LeetCode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @description: 合并 k 个有序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * @author: Deepcola
 * @time: 2020/12/7 15:36
 */
public class Solution23 {
    /**
     * Definition for singly-linked list
     */
    class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 使用分治 + 合并两个有序链表
     */
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length-1);
    }

    /**
     * 归并
     */
    public ListNode merge(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];
        if (start > end) return null;
        int mid = (start + end) / 2;
        return mergeTwoLists(merge(lists, start, mid), merge(lists, mid+1, end));
    }

    /**
     * 合并两个有序链表
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0);
        ListNode temp = newHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                temp = temp.next;
                l1 = l1.next;
            }else {
                temp.next = l2;
                temp = temp.next;
                l2 = l2.next;
            }
        }
        // 有一个链表遍历完
        temp.next = l1 != null ? l1 : l2;
        return newHead.next;
    }


    /**
     * 使用优先级队列
     */
    /*public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead;
        // 优先级队列——小根堆
        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2) -> o1.val-o2.val);
        // 所有链表的第一个节点放入进行排序
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                queue.offer(lists[i]);
            }
        }

        while (!queue.isEmpty()) {
            ListNode next = queue.poll();// 确定弹出的节点是哪个链表的
            temp.next = next;
            temp = temp.next;
            // 令弹出节点的链表的下一个节点进入队列
            if (next.next != null) {
                queue.offer(next.next);
            }
        }
        return dummyHead.next;
    }*/
}
