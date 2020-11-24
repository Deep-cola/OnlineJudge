package LeetCode;

/**
 * @description: 反转链表 Ⅱ
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * @author: Deepcola
 * @time: 2020/11/24 18:04
 */
public class Solution92 {

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
     * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
     * 输出: 1->4->3->2->5->NULL
     * 1.首先定义 cur 和 prev 双指针
     * 2.cur 指向反转链表的头结点; prev 指向反转链表的前驱结点. 给定开始位置为 m, 那就移动 m-1 个结点
     * 3.需要先将这两个指针存起来在反转链表以后进行修改相应结点的指向, 所以 dummy = prev; last = cur;
     * 4.反转相应区间的链表, 需要注意的是需要修改 n-m+1 个结点
     * 5.在反转完链表后, 此时 prev 指向最后一个修改结点, cur 指向下一个
     * 类似于  1<-2<-3<-4->5->NULL, 修改 1->4 ; 2->5
     * 6.需要将 prev 放在 dummy 后面, 而 cur 放在 last 后面
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode cur = head;
        ListNode prev = null;
        // 标记反转链表的结点个数
        int step = n - m + 1;
        // 使 prev 指向反转链表头结点的前驱结点
        // cur指向反转链表的头结点
        while (m-- > 1) {
            prev = cur;
            cur = cur.next;
        }
        // 将指针另存起来方便最后修改结点指向
        ListNode dummy = prev;
        ListNode last = cur;
        // 反转链表
        while (step-- > 0){
            // 保存没有反转之前结点的 next
            ListNode curNext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        // m==1 时，dummy 为空
        if (dummy != null) {
            dummy.next = prev;
        }else {
            head = prev;
        }
        last.next = cur;
        return head;
    }
}
