package LeetCode;

/**
 * @description: 合并两个链表
 * 给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。
 * 请你将 list1 中第 a 个节点到第 b 个节点删除，并将list2 接在被删除节点的位置。
 *
 *输入：list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
 * 输出：[0,1,2,1000000,1000001,1000002,5]
 * 解释：我们删除 list1 中第三和第四个节点，并将 list2 接在该位置。上图中蓝色的边和节点为答案链表。
 * @author: Deepcola
 * @time: 2020/12/6 16:01
 */
public class Solution1669 {

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
     * 1.通过 a,b 删除区间节点
     * 2.插入 list2
     */
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode cur1 = list1;// 遍历list1
        ListNode cur2 = list2;// 遍历list2
        // 1.删除 [a,b] 节点(从零开始计数)
        // 遍历到删除节点的前驱节点
        while (a-- > 1) {
            cur1 = cur1.next;
            b--;
        }
        ListNode prev = cur1;// 插入位置的前驱节点
        while (b-- > 0) {
            cur1 = cur1.next;
        }
        ListNode next = cur1.next;// 插入位置的后继节点
//        cur1.next = null;
        // 2.插入
        prev.next = list2;
        while (cur2.next != null) {
            cur2 = cur2.next;
        }
        cur2.next = next;
        return list1;
    }
}
