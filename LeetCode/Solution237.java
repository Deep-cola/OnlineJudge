package leetcode;

/**
 * @description: 删除链表中的结点
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。
 * @author: Deepcola
 * @time: 2020/11/24 15:51
 */
public class Solution237 {

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
     * 给定结点不是尾结点
     * 1.修改删除节点的值为下一个结点的值
     * 2.删除下一个结点
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
