package leetcode;

/**
 * @description: 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * @author: Deepcola
 * @time: 2020/11/24 16:42
 */
public class Solution83 {

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
     * 1.新创建一个头结点用于连接新链表结点
     * 2.遍历链表查找不重复结点连接到新链表, 重复结点只连接一个
     */
    /*public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode newHead = new ListNode(0);
        ListNode temp = newHead;
        ListNode cur = head;
        while (cur != null) {
            // 遇到重复元素就跳过这个元素
            // 每次的重复元素选取最后一个加入新链表
            if (cur.next != null && cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
            }
            // 将结点插入新链表
            temp.next = cur;
            temp = temp.next;
            cur = cur.next;
        }
        return newHead.next;
    }*/

    /**
     * 相等就跳过
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return head;
    }

}
