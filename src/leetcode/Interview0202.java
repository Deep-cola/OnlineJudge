package leetcode;

/**
 * @description: 返回倒数第 k 个结点
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 * @author: Deepcola
 * @time: 2020/11/24 13:45
 */
public class Interview0202 {

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
     * 栈
     * 使用栈压入所有元素, 弹出前 k-1 个, 返回第 k 个即可
     * 但是效率不高, 尤其是 k 比较大时
     */
    /*public int kthToLast(ListNode head, int k) {
        if (k < 0 || head == null) return -1;
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        while (k-- > 1) {
            if (stack.peek() != null) {
                stack.pop();
            }else {
                return -1;
            }

        }
        return stack.isEmpty() ? -1 : stack.pop();
    }*/

    /**
     * 双指针
     * 用快慢指针, 使每次同步移动, 快慢指针相距总是 k-1 个结点
     * 效率还不错
     */
    public int kthToLast(ListNode head, int k) {
        if (k < 0 || head == null) return -1;
        ListNode fast = head;
        ListNode slow = head;
        // fast 比 slow 块 k-1 个结点
        while (k-- > 1) {
            // 判断 k 是否大于链表长度
            if (fast.next != null) {
                fast = fast.next;
            }else {
                return -1;
            }
        }
        // 同步后移, fast 移到末尾时, slow 正好在倒数第 k 个结点上
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.val;
    }

}
