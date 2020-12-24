package leetcode;

/**
 * @description: 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 *          一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 * @author: Deepcola
 * @time: 2020/11/19 13:06
 */
public class Solution110 {

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
     * 递归计算每个子树的高度，判断是否为平衡二叉树
     */
    public boolean isBalanced(TreeNode root) {
        // 空树
        if (root == null) return true;
        // 二叉树满足平衡二叉树条件 -> 高度差的绝对值小于等于1
        // 二叉树的所有子树也是平衡二叉树
        if (Math.abs(maxDepth(root.left) - maxDepth(root.right)) <=1
                && isBalanced(root.left) && isBalanced(root.right)) {
            return true;
        }
        return false;
    }

    /**
     * 计算二叉树的最大深度
     */
    public int maxDepth(TreeNode root) {
        // 空树
        if (root == null) return 0;
        // 分别递归计算左右子树的高度，同时返回最大的深度
        int leftDepth = maxDepth(root.left) + 1;
        int rightDepth = maxDepth(root.right) + 1;
        return Math.max(leftDepth, rightDepth);
    }

}
