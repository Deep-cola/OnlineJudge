package LeetCode;

/**
 * @description: 删除链表的结点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 * @author: Deepcola
 * @time: 2020/11/24 17:52
 */
public class Offer18 {

    /**
     * Definition for singly-lined list
     */
    class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 1.删除的是头结点
     * 2.定义遍历结点 cur 和其前驱结点 prev, 遍历链表查找删除结点
     */
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) return head.next;
        ListNode prev = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == val) {
                prev.next = cur.next;
            }else {
                prev = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}
