package leetcode;

/**
 * @description: 相交链表
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 * @author: Deepcola
 * @time: 2020/11/24 12:10
 */
public class Solution160 {

    /**
     * Definition for a singly-linked list
     */
    class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 1.定义两个指针遍历两个链表
     * 2.遍历时每个指针都需要先后遍历两个链表, 也就是说两个指针 走过的路程 相同, 那么两者必定相遇
     * 3.两个针织相遇时不是在 null 位置，就说明两个链表相交, 相遇位置就是相交位置
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode A = headA;
        ListNode B = headB;
        // 两个结点相遇时要么是相遇位置, 要么都遍历完为 null
        while (A != B) {
            // 两个指针分别先后遍历两个链表
            A = (A == null) ? headB : A.next;
            B = (B == null) ? headA : B.next;
        }
        return A;
    }
}
