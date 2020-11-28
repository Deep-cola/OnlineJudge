package LeetCode;

/**
 * @description: 环路检测
 * 给定一个链表，如果它是有环链表，实现一个算法返回环路的开头节点。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * @author: Deepcola
 * @time: 2020/11/28 8:35
 */
public class Interview0208 {

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
     * 1.使用快慢指针判断是否有环
     * 2.有环就使用双指针进行遍历, 查找两个指针的相遇点为环入口.
     *      很显然相遇点必定在环上
     *      现在有  M -> 头结点到换入口距离,    N -> 相遇点走过入口点的距离        C -> 环的周长
     *      那么      快指针路程: M + N + nC       慢指针的路程: M + N
     *      由于速度是二倍的关系, 所以有 2(M + N) = M + N + nC   ->      M = nC - N
     *      将快指针放到头结点, 和慢指针以相同速度前进:
     *          当快指针走了 M 第一次到达入口点时, 慢指针走了 (n-1)C + (C-N), 很明显也到达入口点, 两指针相遇
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        // 快慢指针判断是否存在环
        ListNode fast = head;
        ListNode slow = head;
        // 指针相遇必定存在环
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        // 判断是否相遇, 还是正常结束
        if (fast == null || fast.next == null) return null;
        // 双指针遍历, 查找入口处
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
