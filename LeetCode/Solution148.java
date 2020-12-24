package leetcode;

/**
 * @description: 链表排序
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 *
 * 输入：head = []
 * 输出：[]
 * @author: Deepcola
 * @time: 2020/12/12 14:53
 */
public class Solution148 {

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
     * 自底向上的归并排序
     * 1. 计算链表长度，归并排序需要将链表拆分成子链表进行排序；
     * 2. subLen 作为每次子链表的长度，初始为1（有序链表长度），每次是前一次的二倍；
     * 3. 将原链表分割成若干个长度为 subLen 的子链表（最后一组可能不够），两个一组进行合并（合并两个有序链表）；
     *    合并之后有序链表的长度变成了 subLen*2（最后一组可能不够）；
     * 4. subLen变成前一次的二倍，继续分割合并直至整个链表排序完毕。
     */
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        ListNode cur = head;
        int length = 0;
        // 链表长度
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        // 归并
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        for (int subLen = 1; subLen < length; subLen *= 2) {
            ListNode prev = dummyHead;// 已排序的尾结点
            cur = dummyHead.next;
            while (cur != null) {
                // 链表1
                ListNode head1 = cur;
                for (int i = 0; i < subLen-1 && cur.next != null; i++) {
                    cur = cur.next;
                }
                // 链表2
                ListNode head2 = cur.next;
                cur.next = null;// 断开链表 1
                cur = head2;
                for (int i = 0; i < subLen-1 && cur != null && cur.next != null; i++) {
                    cur = cur.next;
                }
                // 判断是否有链表2
                ListNode curNext = null;
                if (cur != null) {
                    curNext = cur.next;
                    cur.next = null;// 断开链表2
                }
                ListNode temp = merge(head1, head2);
                prev.next = temp;
                // prev 再次指向已排序的尾结点
                while (prev.next != null) {
                    prev = prev.next;
                }
                cur = curNext;
            }
        }
        return dummyHead.next;
    }

    /**
     * 合并两个有序链表
     */
    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead;
        // 比较并插入到新链表
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                temp.next = head1;
                temp = temp.next;
                head1 = head1.next;
            }else {
                temp.next = head2;
                temp = temp.next;
                head2 = head2.next;
            }
        }
        // 此时一个链表为 null
        temp.next = (head1 == null) ?  head2 : head1;
        return dummyHead.next;
    }
}
