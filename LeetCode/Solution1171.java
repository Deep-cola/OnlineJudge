package leetcode;

import java.util.HashMap;

/**
 * @description: 从链表中删去总和值为 0 的节点
 * 给你一个链表的头节点 head，请你编写代码，反复删去链表中由 总和 值为 0 的连续节点组成的序列，直到不存在这样的序列为止。
 * 删除完毕后，请你返回最终结果链表的头节点。
 * 你可以返回任何满足题目要求的答案。
 * @author: Deepcola
 * @time: 2020/11/28 20:49
 */
public class Solution1171 {

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
     * HashMap 两次遍历
     * 1.定义一个傀儡头结点
     * 2.一次遍历: 使用 map 装入 节点和 sum ——节点 node;  当有两个 sum 相等时, 说明这里个之间的所有结点和为 0, 记住最后一个位置即可, 二次遍历进行删除
     * 3.二次遍历: 重新计算节点和 sum , 进行一次计算需要将下个节点置为 map 中等于 sum 的 next 节点 -> node.next = map.get(sum).next;
     *      1.如果 sum 一次遍历没重复, 此时 map.get(sum).next 就是正常进行;
     *      2.如果 sum 一次遍历重复了, 由于只记住了最后一次节点的位置, 所以中间这一段会被删掉, 完成要求
     */
    public ListNode removeZeroSumSublists(ListNode head) {
        if (head == null) return null;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        HashMap<Integer, ListNode> map = new HashMap<>();
        int sum = 0;
        // map -> 节点和-节点
        // 当有两个 sum 相等时, 那么这一端链表之和为 0 , 只需要记住最后一个, 中间的一段会被删除
        for (ListNode temp = dummyHead; temp != null; temp = temp.next) {
            sum += temp.val;
            map.put(sum, temp);
        }
        // 二次遍历, 如果存在 sum 相等的数据, 由于存放了最后一个的位置, 所以中间的都会被删除
        sum = 0;
        for (ListNode temp = dummyHead; temp != null; temp = temp.next) {
            sum += temp.val;
            temp.next = map.get(sum).next;
        }
        return dummyHead.next;
    }
}
