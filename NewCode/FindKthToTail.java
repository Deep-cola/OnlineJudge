package NewCode;

/**
 * @description: 链表的倒数第 k 个结点
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 * 输入 1,{1,2,3,4,5}
 * 输出 {5}
 * @author: Deepcola
 * @time: 2020/11/23 17:27
 */
public class FindKthToTail {

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
     * 查找倒数第 k 个结点, 双指针(快慢指针)
     * 1.fast 比 slow 快了 k-1 个结点, 所以 fast 到末尾时, 与 slow 相隔 k-1 个结点
     * 2.此时, slow 结点就是倒数第 k 个结点
     */
    public ListNode findKthToTail(ListNode head,int k) {
        if (k <= 0 || head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        // fast 需要比 slow 快 k-1 个结点
        while (k-- > 1) {
            if (fast.next != null) {
                fast = fast.next;
            }else {
                return null;
            }
        }
        // 同步后移
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

}
