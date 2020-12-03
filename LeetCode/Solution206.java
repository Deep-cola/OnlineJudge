package LeetCode;

/**
 * @description: 反转链表
 * 反转一个单链表。
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * @author: Deepcola
 * @time: 2020/11/23 16:59
 */
public class Solution206 {

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
     * 1.判断链表是否为空
     * 2.prev 标记 cur 的前驱结点
     * 3.curNext 指向原链表 cur 的 next 结点
     * 4.遍历反转链表直到 cur = null
     * 5.此时, prev 就是新的头结点
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode cur = head;
        // 标记 cur 结点的前驱结点, 也是反转链表后的 cur.next
        ListNode prev = null;
        while (cur != null) {
            // 指向未反转前的 cur.next,
            // 在 cur 发生反转后, next 会发生改变,所以需要一个结点来标记它原本的 next 结点
            ListNode curNext = cur.next;
            // 反转
            cur.next = prev;
            prev = cur;
            // 按照原本的连接遍历
            cur = curNext;
        }
        // 此时 cur 结点为 null, prev 就是原本链表的最后一个结点, 反转链表的头结点
        return prev;
    }
}
