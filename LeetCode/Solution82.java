package LeetCode;

/**
 * @description: 删除排序链表中的重复元素Ⅱ
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * 示例 :
 *      输入: 1->2->3->3->4->4->5
 *      输出: 1->2->5
 * @author: Deepcola
 * @time: 2020/11/27 23:16
 */
public class Solution82 {

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
     * 1.定义一个新链表用于存放不重复元素
     * 2.遍历原链表寻找重复元素. 有重复元素就跳过一直向后直到两个相邻节点不再重复, 此时, 还需要再多跳过一个节点(上一个重复元素的最后一个节点)
     *                      没有重复元素就存放到新链表中
     * 3.注意: 最后需要把新链表尾结点的 next 置空
     */
    /*public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode cur = head;
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                // 跳过重复元素
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                // 再跳一个, 是重复元素的最后一个
                cur = cur.next;
            }else {
                temp.next = cur;
                temp = temp.next;
                cur = cur.next;
            }
        }
        // 尾结点需要置为 null, 不然会连接原链表后面的所有结点, 尤其是尾部全是重复节点
        temp.next = null;
        return dummyHead.next;
    }*/

    /**
     * 递归
     */
    public ListNode deleteDuplicates(ListNode head) {
        // 终止条件
        if (head == null || head.next == null) return head;
        // 判断当前结点和下一节点值是否相等
        if (head.val == head.next.val) {
            // 相等 -> 跳过所有相等节点
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            // 判断最后一个重复节点的下一节点(多跳一次)
            return deleteDuplicates(head.next);
        }else {
            // 递归判断下一节点
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }


}
