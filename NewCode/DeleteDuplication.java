package NewCode;

/**
 * @description: 删除排序链表中的重复结点
 *在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * @author: Deepcola
 * @time: 2020/11/24 9:47
 */
public class DeleteDuplication {

    /**
     * definition for singly-linked list;
     */
    class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 创建一个新链表用来保存不重复的结点, 最后返回新链表即可
     */
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) return null;
        ListNode newHead = new ListNode(0);
        // 用来遍历新链表和原有链表
        ListNode temp = newHead;
        ListNode cur = pHead;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
            }else {
                temp.next = cur;
                temp = temp.next;
            }
            cur = cur.next;
        }
        temp.next = null;
        return newHead.next;
    }

}
