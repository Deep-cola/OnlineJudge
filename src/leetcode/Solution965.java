package leetcode;

/**
 * @description: 单值二叉树
 * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 *
 * 示例 1：
 * 输入：[1,1,1,1,1,null,1]
 * 输出：true
 *
 * 示例 2：
 * 输入：[2,2,2,5,2]
 * 输出：false
 *
 * 提示：
 * 给定树的节点数范围是 [1, 100]。
 * 每个节点的值都是整数，范围为 [0, 99] 。
 * @author: Deepcola
 * @time: 2021/1/19 15:31
 */
public class Solution965 {
    /**
     * Definition for a binary tree node
     */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 遍历
     */
    /*public boolean isUnivalTree(TreeNode root) {
        return isUnivalTree(root, root.val);
    }

    public boolean isUnivalTree(TreeNode root, int val) {
        if (root == null) return true;
        // 值不相等
        if (root.val != val) {
            return false;
        }
        return isUnivalTree(root.left, val) && isUnivalTree(root.right, val);
    }*/

    public boolean isUnivalTree(TreeNode root) {
        boolean left = root.left == null ||
                (root.left.val == root.val && isUnivalTree(root.left));
        boolean right = root.right == null ||
                (root.right.val == root.val && isUnivalTree(root.right));
        return left && right;
    }
}
