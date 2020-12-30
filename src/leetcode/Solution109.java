package leetcode;

/**
 * @description: 有序链表转换二叉搜索树
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 * @author: Deepcola
 * @time: 2020/11/28 8:02
 */
public class Solution109 {

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
     * Definition for a binary tree node
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
     * 递归
     * 1.终止条件: 链表只有一个节点活没有节点时
     * 2.返回值: 返回链表的根据链表中间节点创建的额二叉树节点
     * 3.单次实现: 使用快慢指针查找中间节点, 根据这个节点创建二叉树节点作为当前的根节点, 上一层次的左子节点或右子节点
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        // 查找链表中间节点为根节点
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        // 将链表分开成两部分
        if (prev != null) {
            prev.next = null;
        }
        TreeNode root = new TreeNode(slow.val);
        // 递归查找左子节点和右子节点
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }
}
