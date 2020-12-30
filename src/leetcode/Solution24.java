package leetcode;

/**
 * @description: 两两交换链表中的结点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * @author: Deepcola
 * @time: 2020/11/27 18:31
 */
public class Solution24 {

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
     * 递归
     *      终止条件: 只剩下一个或者零个节点时；
     *      返回值: 将每一次交换后的头结点返回, 需要连接在上一层次的后面
     *      单次过程: 相当于交换两个节点, 然后将交换后的头结点返回, 另一个节点连接递归后的返回值(后面链表头结点)
     */
    /*public ListNode swapPairs(ListNode head) {
        // 0/1 个节点不用交换
        if (head == null || head.next == null) return head;
        // 交换两个节点->相当于反转
        ListNode prev = head;
        head = head.next;
        // 递归交换下一对相邻的节点, 并将头结点连接当前的尾结点在后面
        prev.next = swapPairs(head.next);
        head.next = prev;
        return head;
    }*/

    /**
     * 迭代
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        ListNode cur = head;
        while (prev.next != null && prev.next.next != null) {
            prev.next = cur.next;
            cur.next = prev.next.next;
            prev.next.next = cur;
            prev = cur;
            cur = cur.next;
        }
        return dummyHead.next;
    }

}
