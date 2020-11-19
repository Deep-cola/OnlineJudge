package LeetCode;

/**
 * @description: 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * @author: Deepcola
 * @time: 2020/11/19 12:58
 */
public class Solution104 {

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
     * 二叉树的最大深度是取左右子树中更深的
     */
    public int maxDepth(TreeNode root) {
        // 空树
        if (root == null) return 0;
        //递归分别求左右子树的深度
        int leftDepth = maxDepth(root.left) + 1;
        int rightDepth = maxDepth(root.right) + 1;
        // 左右子树更大的为二叉树的深度
        return Math.max(leftDepth, rightDepth);
    }

}
