package LeetCode;

/**
 * @description: 链表中的倒数第 k 个结点
 * @author: Deepcola
 * @time: 2020/11/24 17:41
 */
public class Offer22 {

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
     * 双指针法
     * 1.定义两个指针, 其中一个先走 k-1 个结点
     * 2.两个同时出发向前走, 前面的到达 null 时, 后面的正好时倒数第 k 个结点
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        // fast 先走 k-1 个结点
        for (int i = 0; i < k; i++) {
            if (fast != null) {
                fast = fast.next;
            }else {
                return null;
            }
        }
        // 同步后走
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
