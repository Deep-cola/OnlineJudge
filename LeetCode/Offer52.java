package LeetCode;

/**
 * @description: 两个链表的第一个公共结点
 * 输入两个链表，找出它们的第一个公共节点。
 * @author: Deepcola
 * @time: 2020/11/24 17:35
 */
public class Offer52 {

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
     * 双指针法
     * 1.定义两个指针同时 分别 先后遍历两个链表, 那么两个指针所 走的路程 是相同的
     * 2.既然这样, 如果两个链表相交, 他们最后的一段路程必定一起渡过; 如果不相交, 那么就一起到达 null
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode A = headA;
        ListNode B = headB;
        while (A != B) {
            A = (A == null) ? headB : A.next;
            B = (B == null) ? headA : B.next;
        }
        return A;
    }
}
