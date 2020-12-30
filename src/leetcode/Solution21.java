package leetcode;

/**
 * @description: 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * @author: Deepcola
 * @time: 2020/11/23 18:09
 */
public class Solution21 {

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
     * 1.特殊情况:
     *          l1 l2 都为空 -> null
     *          l1 为空 -> l2
     *          l2 为空 -> l1
     * 2.定义一个新的 newHead, 用来表示新链表
     * 3.遍历比较 两个链表, 将较小的值依次插入新链表, 直到有一个链表遍历完
     * 4.将另一个链表全部插入到新链表后面
     * 5.新链表头结点是自己定义的, 所以下一个才是合并的头结点
     */
    /*public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode newHead = new ListNode(0);
        // 用于标记新链表的末尾位置
        ListNode temp = newHead;
        // 遍历比较两个链表的值, 从小到大加入新链表, 知道一个链表被添加完
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                temp.next = l1;
                temp = temp.next;
                l1 = l1.next;
            }else {
                temp.next = l2;
                temp = temp.next;
                l2 = l2.next;
            }
        }
        // 此时, 有一个链表被遍历完, 将另一个链表加在新链表后面即可
        temp.next = (l1 == null) ? l2 : l1;
        return newHead.next;
    }*/

    /**
     * 递归
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }else if (l2 == null) {
            return l1;
        }else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

}
