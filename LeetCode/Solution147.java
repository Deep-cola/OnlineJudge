package LeetCode;

/**
 * @description: 对链表进行插入排序
 * 对链表进行插入排序。
 * 插入排序算法：
 * 1. 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 2. 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 3. 重复直到所有输入数据插入完为止。
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 * @author: Deepcola
 * @time: 2020/12/12 13:51
 */
public class Solution147 {

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
     * 1.判空
     * 2.定义一个 dummyHead 作为傀儡头结点, 因为有可能插入在 head 之前, 插入节点是需要前驱节点的, 同时, 用来指向新的头节点；
     * 3.定义一个 prevCur 指向待排序节点的前驱节点, 也就是有序序列的最后一个节点；
     * 4.遍历链表进行插入，由于第一个 head 可以看作有序, 所以从 head.next 出发；
     * 5.首先如果 cur 大于 prevCur, 说明 cur 大于前面所有的，直接两个指针后移就好；
     * 6.反之说明需要进行比较然后插入了:
     *      (1)由于插入需要前驱节点，所以在比较时, 从 temp=dummyHead 出发，比较 temp.next.val 和 cur.val 的大小;
     *      (2)查找到第一个不小于 cur 的节点停止;
     *      (3)插入在 temp 后面, 再插入之前需要注意将 cur.next 保存起来，需要进行下轮排序(直接 prevCur.Next=cur.next);
     * 7.让 cur 指向下一个待排序节点继续遍历链表直至完结。
     */
    public ListNode insertionSortList(ListNode head) {
        // 排空
        if (head == null) return null;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = head.next;// 待排序结点
        ListNode prevCur = head;// 指向待排序节点的前一个结点
        while (cur != null) {
            // cur 大于前面所有的结点
            if (prevCur.val < cur.val) {
                prevCur = cur;
                cur = cur.next;
            }else {
                ListNode temp = dummyHead;
                // 查找第一个不小于 cur 的前驱节点
                while (temp.next.val < cur.val) {
                    temp = temp.next;
                }
                // 插入
                prevCur.next = cur.next;
                cur.next = temp.next;
                temp.next = cur;
                // 指向下一个待排序结点
                cur = prevCur.next;
            }
        }
        return dummyHead.next;
    }
}
