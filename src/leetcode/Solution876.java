package leetcode;

/**
 * @description: 链表的中间结点
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 *
 * @author: Deepcola
 * @time: 2020/11/23 17:20
 */
public class Solution876 {

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
     * 查找中间结点, 使用双指针(快慢指针)
     * 一个速度是另一个的两倍
     */
    public ListNode middleNode(ListNode head) {
        if (head == null) return null;
        // 快慢指针
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            // 快指针每次走两个结点, 慢指针每次一个结点
            // 快指针到末尾时, 慢指针正好走了一半
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
