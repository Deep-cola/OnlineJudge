package leetcode;

/**
 * @description: K 个一组反转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 示例：     给你这个链表：1->2->3->4->5
 *          当 k = 2 时，应当返回: 2->1->4->3->5
 *          当 k = 3 时，应当返回: 3->2->1->4->5
 * 说明：
 *      你的算法只能使用常数的额外空间。
 *      你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * @author: Deepcola
 * @time: 2020/12/7 16:48
 */
public class Solution25 {
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
     * 1.定义 dummyHead 用于连接, 不然第一组无法连接
     * 2.使用 prev 指向反转部分的前一个结点,tail 每次从待反转部分的前一个开始 k 个一组进行遍历分割, 如果剩余的长度不足以组就直接返回;
     * 3.保存 tailNext=tail.next 用于反转以后的连接;
     * 4.调用方法反转链表并得到反转以后的头尾结点;
     * 5.将反转以后的链表连接在原链表之中:
     *              prev.next = head;
     *              tail.next = tailNext;
     * 6.初始化下次的值:
     *              prev = tail;
     *              head = tail.next;
     */
    /*public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while (head != null) {
            ListNode tail = prev;
            // 分组
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                // 剩余节点个数不够一组
                if (tail == null) {
                    return dummyHead.next;
                }
            }
            // 保存下一组的起始位置
            ListNode tailNext = tail.next;
            // 反转链表——保存反转后链表的头尾结点
            ListNode[] result = reverseList(head, tail);
            head = result[0];
            tail = result[1];
            // 连接
            // 反转以后原来的尾成为了头连接在 prev 后面, 原来的头成为了尾连接在 tailNext 前面
            prev.next = head;
            tail.next = tailNext;
            // 下次开始初始值
            prev = tail;
            head = tail.next;
        }
        return dummyHead.next;
    }*/

    /**
     * 反转给定的一段链表, 将反转以后的头尾返回.
     */
    /*public ListNode[] reverseList(ListNode head, ListNode tail) {
        ListNode tailNext = tail.next;
        ListNode cur = head;
        ListNode prev = null;
        while (cur != tailNext) {
            ListNode curNext  = cur.next;
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return new ListNode[]{tail, head};
    }*/

    /**
     * 1.计算链表长度
     * 2.将链表分成 k 组，每组反转
     * 3.反转完成继续分组重复上一步
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = head;
        int length = 0;// 链表的长度
        while (cur != null) {
            cur = cur.next;
            length++;
        }
        cur = head;
        ListNode prev = dummyHead;
        ListNode curNext = null;
        // 分成 k 组
        // 每组进行反转: 遍历组内的每个节点, 将其插入到 prev 和 head 之间实现反转
        for (int i = 0; i < length / k; i++) {
            for (int j = 0; j < k-1; j++) {
                // 反转
                curNext = cur.next;
                cur.next = curNext.next;
                curNext.next = prev.next;
                prev.next = curNext;
            }
            // 下一次反转初始值
            prev = cur;
            cur = prev.next;
        }
        return dummyHead.next;
    }
}
