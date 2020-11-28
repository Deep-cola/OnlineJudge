package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: 链表中的下一个更大节点
 * 给出一个以头节点 head 作为第一个节点的链表。链表中的节点分别编号为：node_1, node_2, node_3, ... 。
 * 每个节点都可能有下一个更大值（next larger value）：对于 node_i，如果其 next_larger(node_i) 是 node_j.val，
 * 那么就有 j > i 且  node_j.val > node_i.val，而 j 是可能的选项中最小的那个。如果不存在这样的 j，那么下一个更大值为 0 。
 * 返回整数答案数组 answer，其中 answer[i] = next_larger(node_{i+1}) 。
 *
 * 输入：[1,7,5,1,9,2,5,1]
 * 输出：[7,9,9,9,0,5,0,0]
 * @author: Deepcola
 * @time: 2020/11/28 17:27
 */
public class Solution1019 {

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
     * 1.将链表的节点值装入 list
     * 2.遍历链表找出第一个大于自身的数装入 result , 没有装入值的默认是 0
     * 时间复杂度 O(N^2)
     */
    /*public int[] nextLargerNodes(ListNode head) {
        if (head == null) return null;
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        // 取出节点值
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        // 找出第一个大于自身的数即可
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if (list.get(j) > list.get(i)) {
                    result[i] = list.get(j);
                    break;
                }
            }
        }
        return result;
    }*/

    /**
     * 单调栈
     * 1.遍历所有节点将值放入 list
     * 2.单调栈: 栈顶元素最小
     *      1.栈中存放的是后面大于当前遍历到的 list 元素的最大值
     *      2.从后向前遍历 list, 将栈中所有小于当前元素的都弹出去, 维护单调栈
     *      3.第二步之后栈顶元素(如果存在)必然是后面第一个大于当前元素的值，即下一个更大节点： 栈空说明遍历过的元素自己最大
     *      4.每次循环进行完将当前元素压栈, 进行下一次判断
     */
    public int[] nextLargerNodes(ListNode head) {
        if (head == null) return null;
        List<Integer> list = new ArrayList<>();
        // 取出节点值
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        // 使用栈存放对应位置的 list 元素以及其之后元素中最大的值
        int[] result = new int[list.size()];
        Stack<Integer> stack = new Stack<>();
        for (int i = list.size()-1; i >= 0; i--) {
            // 所有小于等于 list.get(i) 的都弹出去
            // 栈里面存放的都大于 list,get(i), 那么第一个大于 list 元素的就是栈顶元素
            while (!stack.isEmpty() && stack.peek() <= list.get(i)) {
                stack.pop();
            }
            // 栈不为空时说明栈顶元素就是当前大于 list 元素的第一个元素
            // 栈为空说明当前元素大于遍历过的所有元素, 也就是说后面没有比它更大的了, 所以此时下一个更大节点是 0
            result[i] = stack.isEmpty() ? 0 : stack.peek();
            stack.push(list.get(i));
        }
        return result;
    }


}
