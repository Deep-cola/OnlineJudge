package LeetCode;

/**
 * @description: 环形链表 Ⅱ
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 * @author: Deepcola
 * @time: 2020/11/24 13:07
 */
public class Solution142 {

    /**
     * Definition far singly-linked list
     */
    class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 1.首先使用快慢指针判断链表有没有环, 存在环就进一步判断环的入口结点
     * 2.判断入口：
     *      1.假设:  X-头结点到入口距离; L-入口到两指针相遇距离; C-环的圈长
     *      2.快指针走过的路程: X+L+nC  是 慢指针走过路程 X+L+mC  的两倍
     *      3.那么就有 X+L = kC -> X = kC-L
     *      4.此时两个指针一个从相遇点, 一个从头结点 出发都继续同步向前走, 相遇的位置就是入口点
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        // 判断是否存在环
        // 快慢指针遍历链表 -> 是否相遇
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        // 遍历到末尾结束循环就说明不存在环
        if (fast == null || fast.next == null) return null;
        // 寻找入口
        slow = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

}
