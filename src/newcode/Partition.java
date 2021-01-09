package newcode;

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

    public ListNode partition(ListNode pHead, int x) {
        if (pHead == null) return null;
        // 小于 x 结点构成的链表
        ListNode beforeHead = new ListNode(0);
        ListNode afterHead = new ListNode(0);
        ListNode before = beforeHead;
        ListNode after = afterHead;
        while(pHead != null) {
            if (pHead.val < x) {
                before.next = pHead;
                before = before.next;
            }else {
                after.next = pHead;
                after = after.next;
            }
            pHead = pHead.next;
        }
        after.next = null;
        before.next = afterHead.next;

        return beforeHead.next;
    }


    /**
     * 创建两个链表分别插入大于等于 x 和小于 x 的结点
     * 1.全部大于
     * 2.全部小于
     * 3.正常情况
     */
    /*public ListNode partition(ListNode pHead, int x) {
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
        if (beforeHead.next == null) {
            return afterHead.next;
        }else {
            before.next = afterHead.next;
            after.next = null;
            return beforeHead.next;
        }
    }*/

    /**
     * 定义分别存放小于 x 结点的 before 链表和其他的结点的 after 链表
     * 1.定义 beginStart、beginEnd 用于指向 before 的头尾结点、定义 afterStart、afterEnd 指向 after 的头尾结点
     * 2.遍历原链表, 如果 cur 结点的值小于 x, 就存放到 before, 否则存放到 after
     * 3.遍历完链表, 需要判断两个链表的特殊情况:
     *          (1)全部大于 x -> before 为空, 此时返回 after 头结点即可
     *          (2)全部小于 x -> after 为空, 此时返回 before 头结点即可
     *          (3)正常分布 -> 连接两个链表, 需要注意的是需要将 afterEnd.next 置空作为尾结点
     * 4.将两个链表连接起来返回新链表的头结点即可。 连接; beforeEnd.next = afterStart;
     * 综合考虑: 不论 after 链表是不是为 null, 在将两个链表连接以后, 都不影响结果.
     *          after 链表为 null, 只需要将 afterEnd.Next 置为 null 即可
     */
    /*public ListNode partition(ListNode pHead, int x) {
        if (pHead == null) return null;
        // 小于 x 结点构成的链表
        ListNode bs = null;
        ListNode be = null;
        // 剩余的结点
        ListNode as = null;
        ListNode ae = null;
        ListNode cur = pHead;
        // 遍历链表
        while (cur != null) {
            if (cur.val < x) {
                // 第一次插入
                if (bs == null) {
                    bs = cur;
                    be = cur;
                }else {
                    be.next = cur;
                    be = cur;
                }
            }else {
                // 第一次插入
                if (as == null) {
                    as = cur;
                    ae = cur;
                }else {
                    ae.next = cur;
                    ae = cur;
                }
            }
            cur = cur.next;
        }
        // 判断两个链表的情况
        if (bs == null) {
            return as;
        }
        be.next = as;
        if (as != null){
            ae.next = null;
        }
        return bs;
    }*/
}
