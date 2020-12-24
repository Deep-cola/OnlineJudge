package leetcode;

/**
 * @description: 删除链表中的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * @author: Deepcola
 * @time: 2020/12/2 22:32
 */
public class Solution19 {

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
     * 双指针法————快慢指针
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        // 定义快慢指针
        ListNode fast = head;
        ListNode slow = head;
        // fast 指针先走 k 步
        while (n-- > 0 && fast != null) {
            fast = fast.next;
        }
        // 由于给定 n 有效, 所以 fast 指针为空时证明要删除的是头结点
        if (fast == null) {
            head = head.next;
            return head;
        }
        // 快慢指针一起走, fast 到达尾结点时, slow 指向要删除节点的前一个节点
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // 删除
        slow.next = slow.next.next;
        return head;
    }
}
