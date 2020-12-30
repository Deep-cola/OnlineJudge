package leetcode;

/**
 * @description: 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * @author: Deepcola
 * @time: 2020/11/24 17:06
 */
public class Offer06 {

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
     * 1.将所有结点的值依次压栈
     * 2.弹出所有元素装入数组
     */
    /*public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        int[] result = new int[stack.size()];
        int k = 0;
        while (!stack.isEmpty()) {
            result[k++] = stack.pop();
        }
        return result;
    }*/

    /**
     * 遍历两趟链表, 第一次统计个数, 第二次装入数组
     */
    public int[] reversePrint(ListNode head) {
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        int[] result = new int[count];
        cur = head;
        for (int i = count - 1; i >= 0; i--) {
            result[i] = cur.val;
            cur = cur.next;
        }
        return result;
    }
}
