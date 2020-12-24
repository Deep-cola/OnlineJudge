package leetcode;

/**
 * @description: 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * @author: Deepcola
 * @time: 2020/11/24 17:27
 */
public class Offer24 {

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
     * 需要定义一个 prev 用来标记即将反转结点的前驱结点
     * 同时要把反转之前反转结点的 next 结点保存, 因为反转以后 next 发生改变
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            // 用来保存反转之前的 next 结点
            ListNode curNext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return prev;
    }
}
