package leetcode;

import java.util.Stack;

/**
 * @description: 两数相加Ⅱ
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * @author: Deepcola
 * @time: 2020/11/27 16:56
 */
public class Solution445 {

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
     * 1.将两个链表的结点全都压栈, 这样弹出顺序就是计算顺序
     * 2.定义一个进位 carry ,两个栈都为空并且进位为 0 时结束计算
     * 3.当栈为空但是运算没结束时, 就让它等于0， 求三者之和创建新结点
     * 4.注意: 定义的 head 是头结点, 所以让它时刻等于新创建的结点, 这样最后就不用反转链表
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        // 将结点压栈, 弹出顺序就是计算顺序
        while (l1 != null) {
            stack1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2);
            l2 = l2.next;
        }
        ListNode head = null;// 新链表的头结点
        int carry = 0;// 进位
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry > 0) {
            int sum = carry;
            sum += (stack1.isEmpty() ? 0 : stack1.pop().val) + (stack2.isEmpty() ? 0 : stack2.pop().val);
            ListNode node = new ListNode(sum % 10);
            // 头结点是紧跟着新创建结点的, 这样可以保证最后结束时， head 就是新链表的头结点, 不用进行反转
            node.next = head;
            head = node;
            carry = sum / 10;
        }
        return head;
    }


    /**
     * 需要一个反转链表函数进行辅助
     * 1.反转两个链表
     * 2.定义一个进位 carry, 只有 l1 l2 为空且 carry = 0 时, 才能说明运算结束, 否则还要继续运算
     * 3.l1、l2 的 val 在它们不为空时 就是本身 val, 为空时等于 0
     * 4.新结点的 val = (carry + l1.val + l2.val) % 10, %10 是因为 val 大于时应该有进位, 只需要取个位即可
     * 5.使用 val 创建结点, 连接在新链表后面, 然后判断了 l1、l2 为空时等于 null 就行, 不为空继续遍历, carry 需要使用 val/10 取十位上的数
     * 6.直到第二步说的条件结束才结束, 反转新链表就结束了
     */
    /*public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode temp = dummyHead;
        l1 = reverse(l1);
        l2 = reverse(l2);
        int carry = 0;
        while (l1 != null || l2 != null || carry > 0) {
            int sum = carry;
            sum += ((l1 == null) ? 0 : l1.val) + ((l2 == null) ? 0 : l2.val);
            ListNode node = new ListNode(sum % 10);
            temp.next = node;
            temp = temp.next;
            l1 = (l1 == null) ? null : l1.next;
            l2 = (l2 == null) ? null : l2.next;
            carry = sum / 10;
        }
        return reverse(dummyHead.next);
    }*/

    /**
     * 反转链表
     */
    /*public static ListNode reverse(ListNode head) {
        if (head == null) return null;
        ListNode prev = null;
        while (head != null) {
            ListNode headNext = head.next;
            head.next = prev;
            prev = head;
            head = headNext;
        }
        return prev;
    }*/

}
