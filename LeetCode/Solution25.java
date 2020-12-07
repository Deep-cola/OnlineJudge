package LeetCode;

/**
 * @description: K 个一组反转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 示例：     给你这个链表：1->2->3->4->5
 *          当 k = 2 时，应当返回: 2->1->4->3->5
 *          当 k = 3 时，应当返回: 3->2->1->4->5
 * 说明：
 *      你的算法只能使用常数的额外空间。
 *      你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * @author: Deepcola
 * @time: 2020/12/7 16:48
 */
public class Solution25 {
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
     *
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while (head != null) {
            ListNode tail = prev;
            // 分组
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                // 剩余节点个数不够一组
                if (tail == null) {
                    return dummyHead.next;
                }
            }
            // 保存下一组的起始位置
            ListNode tailNext = tail.next;
            // 反转链表——保存反转后链表的头尾结点
            ListNode[] result = reverseList(head, tail);
            head = result[0];
            tail = result[1];
            // 连接
            prev.next = head;
            tail.next = tailNext;
            // 下次开始初始值
            prev = tail;
            head = tail.next;
        }
        return dummyHead.next;
    }

    /**
     * 反转给定的一段链表
     */
    public ListNode[] reverseList(ListNode head, ListNode tail) {
        ListNode cur = head;
        ListNode prev = null;
        while (cur != tail) {
            ListNode curNext  = cur.next;
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return new ListNode[]{tail, head};
    }
}
