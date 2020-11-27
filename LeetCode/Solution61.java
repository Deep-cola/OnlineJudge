package LeetCode;

/**
 * @description: 旋转链表
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * @author: Deepcola
 * @time: 2020/11/27 15:32
 */
public class Solution61 {

    /**
     * Definition for a singly-linked node
     */
    class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 将旧链表截成两部分, 前半部分长度(size-k); 后半部分长度 k , 很显然只需要将前半部分连接到后半部分后面即可
     * 1.计算链表长度 size, 由于向右移动 size 个位置正好回到原始位置, 所以不做考虑, k %= size 即可
     * 2.上一步完成后 k=0 说明链表不需要移动, return head
     * 3.新链表头结点的位置就是倒数第 k 个结点的位置, 定义 cur 遍历原链表, 找出头结点, 并将头结点的前驱置为 null(新链表的尾结点就是它了)
     * 4.原链表经过上一步分为两部分, 遍历后半部分到尾结点, 将前半部分连接到尾结点之后就行
     */
    /*public ListNode rotateRight(ListNode head, int k) {
        if (head == null ) return null;
        int size = 0;
        // 计算结点个数
        for (ListNode cur = head; cur != null; cur = cur.next) {
            size++;
        }
        // 当每次旋转的 k=size 时, 正好回到原始位置, 不做考虑
        k %= size;
        if (k == 0) return head;
        // 头结点后移 step 就是旋转后新链表的头结点 newHead
        int step = size - k;
        ListNode cur = head;
        // 移至 newHead 前驱结点处, 这个前驱结点很明显是新链表尾结点, 需要置为null
        while (cur.next != null && step-- > 1) {
            cur = cur.next;
        }
        // 链表分割成两部分
        ListNode newHead = cur.next;
        cur.next = null;
        // 遍历新链表至尾结点, 将原来的头结点连接在新链表末尾
        cur = newHead;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = head;
        return newHead;
    }*/

    /**
     * 将原链表变成环, 在合适位置(新头结点之前)断开
     * 1.计算链表长度 size, 由于向右移动 size 个位置正好回到原始位置, 所以不做考虑, k %= size 即可
     * 2.上一步完成后 k=0 说明链表不需要移动, return head
     * 3.将尾结点的 next 置为 head, 结环
     * 4.新链表头结点的位置就是第 (size-k) 个结点的位置, 定义 cur 遍历原链表, 找出头结点, 并将头结点的前驱置为 null(断开)
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null ) return null;
        int size = 1;
        // 计算结点个数
        ListNode cur = head;
        for (; cur.next != null; cur = cur.next) {
            size++;
        }
        // 当每次旋转的 k=size 时, 正好回到原始位置, 不做考虑
        k %= size;
        if (k == 0) return head;
        // 结环
        cur.next = head;
        // 寻找新链表头结点并断开
        int step = size - k;
        // 移至 newHead 前驱结点处, 这个前驱结点很明显是新链表尾结点, 需要置为null
        while (head.next != null && step-- > 1) {
            head = head.next;
        }
        ListNode newHead = head.next;
        head.next = null;
        return newHead;
    }

}
