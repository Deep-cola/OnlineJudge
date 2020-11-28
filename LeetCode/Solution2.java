package LeetCode;

/**
 * @description: 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * @author: Deepcola
 * @time: 2020/11/28 14:38
 */
public class Solution2 {

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
     * 每一次创建新节点的值 时 l1.val/0 + l2.val/0 + carry;
     * 1.定义一个傀儡头结点用作连接新链表
     * 2.只有 l1、l2 为 null 并且进位 carry = 0 时才说明计算结束
     * 3.计算三者之和创建新节点连接在新链表后面
     * 4.每次的进位等于这次三者之和 sum/10
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;// 进位
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead;
        while (l1 != null || l2 != null || carry > 0) {
            int sum = carry;
            sum += l1 == null ? 0 : l1.val;
            sum += l2 == null ? 0 : l2.val;
            ListNode  node = new ListNode(sum % 10);
            temp.next = node;
            temp = temp.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            carry = sum / 10;
        }
        return dummyHead.next;
    }
}
