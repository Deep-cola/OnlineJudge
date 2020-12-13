package LeetCode;

/**
 * @description: 二叉树中的链表
 * 给你一棵以 root 为根的二叉树和一个 head 为第一个节点的链表。
 * 如果在二叉树中，存在一条一直向下的路径，且每个点的数值恰好一一对应以 head 为首的链表中每个节点的值，那么请你返回 True ，否则返回 False 。
 * 一直向下的路径的意思是：从树中某个节点开始，一直连续向下的路径。
 * @author: Deepcola
 * @time: 2020/11/28 15:55
 */
public class Solution1367 {

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
     * Deginition for a binary tree node
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }


    /**
     * 需要用到两个递归函数:
     *          1.第一个递归用于遍历每一个节点
     *          2.第二个递归用于判断从当前节点开始向下是否可以构成二叉树的列表
     * 一个递归函数不行:
     *          如果使用一个递归函数, 当判断完当前 root 和 head 不相等时
     *          1.去判断 head 和 root.left 或者 root.right 是否相等 ? -> 这样的话就会跳过这一层的 root, 相当于中间产生了断层, 不连续
     *          2.直接返回 false?  ->  那下面有列表的话...
     *          需要做的当然是使用 当前 root 和原来的链表头结点 head 进行判等, 这个时候一个递归就无法获取原来的 head
     */

    /**
     * 1.遍历每一个节点
     */
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) return false;
        return isSubPathChild(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    /**
     * 2.判断从当前节点开始向下是否可以构成二叉树的列表
     */
    public boolean isSubPathChild(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return false;
        if (head.val == root.val) {
            return isSubPathChild(head.next, root.left) || isSubPathChild(head.next, root.right);
        }
        return false;
    }
}
