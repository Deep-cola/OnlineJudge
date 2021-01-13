package newcode;

/**
 * @description: 链式 A + B
 * 将两个反向存储在链表中的整数求和（即整数的个位存放在了链表首部，一位数对应一个节点），返回的结果仍用链表形式。
 * 给定两个链表ListNode* A，ListNode* B，请返回A+B的结果(ListNode*)。
 *
 * 测试样例：
 * {1,2,3},{3,2,1}
 * 返回：{4,4,4}
 * @author: Deepcola
 * @time: 2021/1/13 8:51
 */
public class Plus {

    static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode plusAB(ListNode a, ListNode b) {
        // write code here
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead;
        int carry = 0;
        while(a != null || b != null || carry != 0) {
            int sum = carry;
            int num1 = (a == null) ? 0 : a.val;
            int num2 = (b == null) ? 0 : b.val;
            sum += num1 + num2;

            temp.next = new ListNode(sum / 10);
            temp = temp.next;

            a = (a == null) ? null : a.next;
            b = (b == null) ? null : b.next;
            carry = sum % 10;
        }
        return dummyHead.next;
    }
}
