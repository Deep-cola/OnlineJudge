package LeetCode;

/**
 * @description: 回文链表
 * 编写一个函数，检查输入的链表是否是回文的。
 * @author: Deepcola
 * @time: 2020/11/24 14:43
 */
public class Interview0206 {
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
     * 1.反转后半部分链表
     *      1.快慢指针寻找中间结点
     *      2.反转后半部分链表
     * 2.判断后半部分链表和前半部分是否相同
     *      1.双指针分别从头部和尾部进行遍历比较
     *      2.判断两个指针相遇之前指向的结点是否都相同(偶数时，一个指针的下一个结点是另一指针)
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        // 寻找中间结点
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 反转后半部分链表
        ListNode prev = slow;
        slow = slow.next;
        while (slow != null) {
            // slow 反转后 next 发生变化, 需要将原本的 next 结点保存下来
            ListNode slowNext = slow.next;
            slow.next = prev;
            prev = slow;
            slow = slowNext;
        }
        // 比较
        fast = head;
        slow = prev;
        while (fast != slow) {
            if (fast.val != slow.val) {
                return false;
            }
            // 偶数情况下, fast.next == slow
            if (fast.next == slow) {
                break;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
}
