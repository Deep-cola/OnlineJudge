package NewCode;

/**
 * @description: 回文链表
 *对于一个链表，请设计一个时间复杂度为O(n),额外空间复杂度为O(1)的算法，判断其是否为回文结构。
 * 给定一个链表的头指针A，请返回一个bool值，代表其是否为回文结构。保证链表长度小于等于900。
 *
 * 测试： 1->2->2->1
 * 返回：true
 * @author: Deepcola
 * @time: 2020/11/24 10:53
 */
public class PalindromeList {

    /**
     * Definition for a singly-linked list
     */
    class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 双指针
     * 1.将链表后半部分反转
     *      (1)定义快慢指针寻找中间结点
     *      (2)反转后半部分链表
     * 2.定义指针分别从头尾出发
     * 3.判断头尾指针所指向的结点是否相等, 不相等就不是回文链表
     * 4.直至头尾指针相遇都相等, 就是回文链表(偶数情况需要判断头指针的下一个时尾指针)
     */
    public boolean chkPalindrome(ListNode A) {
        if (A == null) return false;
        ListNode fast = A;
        ListNode slow = A;
        // 查找中间结点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 反转后半部分链表
        ListNode prev = slow;// 定位当前结点的前驱结点,也就是反转之后的 next 结点
        slow = slow.next;
        while (slow != null) {
            // 注意反转以后 slow 指针指向的 next 结点会发生改变
            ListNode slowNext = slow.next;// 标记改变之前 slow 指向的 next 结点
            slow.next = prev;
            prev = slow;
            slow = slowNext;
        }
        // 比较
        fast = A;
        slow = prev;
        while (fast != slow) {
            if (fast.val != slow.val) {
                return false;
            }
            // 偶数结点, 两者指挥相邻
            if (fast.next == slow) {
                break;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
}
