package leetcode;

/**
 * @description: 链表相交
 * 给定两个（单向）链表，判定它们是否相交并返回交点。请注意相交的定义基于节点的引用，而不是基于节点的值。
 * 换句话说，如果一个链表的第k个节点与另一个链表的第j个节点是同一节点（引用完全相同），则这两个链表相交。
 * @author: Deepcola
 * @time: 2020/11/24 14:33
 */
public class Interview0207 {
    /**
     * definition for singly-linked list
     */
    class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 双指针
     * 使用两个指针同时 分别遍历两个链表, 两个指针相遇时如果不为 null, 就是相交的结点(两个指针都遍历两个链表, 那么所走的路程相同)
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
