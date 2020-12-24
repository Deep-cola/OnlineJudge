package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 链表组件
 * 给定链表头结点 head，该链表上的每个结点都有一个 唯一的整型值 。
 * 同时给定列表 G，该列表是上述链表中整型值的一个子集。
 * 返回列表 G 中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表 G 中）构成的集合。
 *
 * 输入: head: 0->1->2->3     G = [0, 1, 3]
 * 输出: 2
 * 解释:链表中,0 和 1 是相连接的，且 G 中不包含 2，所以 [0, 1] 是 G 的一个组件，同理 [3] 也是一个组件，故返回 2。
 * @author: Deepcola
 * @time: 2020/11/28 13:19
 */
public class Solution817 {

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
     * 1.由于链表中的元素不重复, 所以将数组中的元素装入 set,计算出最长子序列即可
     * 2.遍历链表, 判断 set 中的元素是否和节点值相等
     *          若相等, 那么接下来所有连续的和节点值相等的都属于一个子序列, 直到 set 中不包含一个节点值结束
     *          不相等, 就继续遍历直到链表遍历完
     */
    public int numComponents(ListNode head, int[] G) {
        if (head == null) return 0;
        Set<Integer> set = new HashSet<>();
        // 将集合元素装入 set
        for (int i: G) {
            set.add(i);
        }
        int num = 0;
        ListNode cur = head;
        // 遍历链表判断子序列数量
        while (cur != null) {
            if (set.contains(cur.val)) {
                num++;
                while (cur != null && set.contains(cur.val)) {
                    cur = cur.next;
                }
            }else {
                cur = cur.next;
            }
        }
        return num;
    }
}
