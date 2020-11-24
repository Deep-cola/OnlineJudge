package LeetCode;

/**
 * @description: 分割链表
 * 编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。
 * 如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。
 * @author: Deepcola
 * @time: 2020/11/24 22:20
 */
public class Interview0204 {

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
     * 分割链表
     * 1.定义两个傀儡头结点, 分别用于存放 小于x结点 和 其他结点.
     * 2.遍历链表将结点放入相对应的新链表
     * 3.连接后返回新链表的头结点
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode beforeDummy = new ListNode(0);// 小于x 结点的傀儡头结点
        ListNode afterDummy = new ListNode(0);// 其他结点的傀儡头结点
        ListNode before = beforeDummy;
        ListNode after = afterDummy;
        ListNode cur = head;
        // 遍历链表和 x 进行值的比较, 同时存放到相应的链表里
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
        // 连接两个链表
        before.next = afterDummy.next;
        after.next = null;
        return beforeDummy.next;
    }
}
