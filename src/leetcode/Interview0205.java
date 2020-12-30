package leetcode;

/**
 * @description: 链表求和
 * 给定两个用链表表示的整数，每个节点包含一个数位。
 * 这些数位是反向存放的，也就是个位排在链表首部。
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 * @author: Deepcola
 * @time: 2020/11/28 18:52
 */
public class Interview0205 {

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
     * 两数相加
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        int carry = 0;
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead;
        while (l1 != null ||l2 != null || carry > 0) {
            int sum = carry;
            sum += l1 == null ? 0 : l1.val;
            sum += l2 == null ? 0 : l2.val;
            ListNode node = new ListNode(sum % 10);
            temp.next = node;
            temp = temp.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            carry = sum / 10;
        }
        return dummyHead.next;
    }
}
