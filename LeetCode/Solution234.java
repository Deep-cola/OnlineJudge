package LeetCode;

/**
 * @description: 回文链表
 * 请判断一个链表是否为回文链表。
 * @author: Deepcola
 * @time: 2020/12/3 14:10
 */
public class Solution234 {

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
     * 1.定义双指针寻找中间节点
     * 2.反转后半部分链表
     * 3.比较前后两部分链表
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        // 定义双指针
        ListNode fast = head;
        ListNode slow = head;
        // 寻找中间节点
        // fast 到达尾部时, slow 刚好到达中间节点(奇数)或右边一个中间节点(偶数)
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 反转后半部分
        ListNode prev = slow;
        slow = slow.next;
        while (slow != null) {
            ListNode slowNext = slow.next;
            slow.next = prev;
            prev = slow;
            slow = slowNext;
        }

        // 比较前后两部分
        fast = head;
        slow = prev;
        while (fast != slow) {
            if (fast.val != slow.val) {
                return false;
            }
            // 偶数情况
            if (fast.next == slow) {
                return true;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

}
