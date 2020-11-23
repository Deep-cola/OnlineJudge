package NewCode;

/**
 * @description: 分割链表
 * 现有一链表的头指针 ListNode* pHead，给一定值x，编写一段代码将所有小于x的结点排在其余结点之前，且不能改变原来的数据顺序，返回重新排列后的链表的头指针。
 * @author: Deepcola
 * @time: 2020/11/23 18:24
 */
public class Partition {

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
     * 创建两个链表分别插入大于等于 x 和小于 x 的结点
     * 1.全部大于
     * 2.全部小于
     */
    public ListNode partition(ListNode pHead, int x) {
        if (pHead == null) return null;
        // 创建两个新链表新头结点以及遍历结点
        ListNode beforeHead = new ListNode(0);
        ListNode afterHead = new ListNode(0);
        ListNode before = beforeHead;
        ListNode after = afterHead;
        ListNode cur = pHead;
        // 遍历原链表进行比较插入
        while (cur != null) {
            if (cur.val < x) {
                before.next = cur;
                before = before.next;
            }else {
                after.next = cur;
                after = after.next;
            }
            cur = cur.next;
        }
        // 判断两个链表的情况
        if (before.next == null) {
            return afterHead.next;
        }else {
            before.next = afterHead.next;
            after.next = null;
            return beforeHead.next;
        }
    }

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.substring()
    }
}
