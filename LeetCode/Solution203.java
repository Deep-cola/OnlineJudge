package LeetCode;

/**
 * @description: 移除链表元素
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 * @author: Deepcola
 * @time: 2020/11/23 16:48
 */
public class Solution203 {

    /**
     * Definition for singly-linked list.
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
     * 2.用 prev 作为删除结点的前驱结点, cur 遍历链表查找需要删除的元素
     * 3.遇到删除元素时 prev.next = cur.next;
     * 4.最后判断头结点是否需要删除
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        // prev 用来标价当前结点的前驱结点
        ListNode prev = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == val) {
                // 删除结点
                prev.next = cur.next;
            }else {
                prev = cur;
            }
            cur = cur.next;
        }
        // 判断头结点是否需要删除
        if (head.val == val) {
            head = head.next;
        }
        return head;
    }
}
