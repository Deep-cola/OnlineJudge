package leetcode;

/**
 * @description: 重排链表
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * @author: Deepcola
 * @time: 2020/11/27 22:41
 */
public class Solution143 {

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
     * 1.快慢指针寻找中间节点
     * 2.反转后半部分链表
     * 3.合并两个链表
     */
    public void reorderList(ListNode head) {
        if (head == null) return;
        // 快慢指针寻找中间节点
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 反转后半部分链表
        ListNode prev = slow;
        slow = slow.next;
        while (slow != null) {
            ListNode slowNext = slow.next;
            slow.next = prev;
            prev = slow;
            slow = slowNext;
        }
        // 合并两个链表
        fast = head;
        slow = prev;
        while (fast != slow) {
            ListNode slowNext = slow.next;
            ListNode fastNext = fast.next;
            slow.next = fast.next;
            fast.next = slow;
            slow = slowNext;
            fast = fastNext;
            // 节点个数为偶数
            if (fast.next == slow) {
                break;
            }
        }
        slow.next = null;
    }
}
