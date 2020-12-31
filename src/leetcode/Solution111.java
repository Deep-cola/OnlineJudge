package leetcode;

/**
 * @description: 二叉树的最下深度
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 *      树中节点数的范围在 [0, 105] 内
 *      -1000 <= Node.val <= 1000
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 *
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 * @author: Deepcola
 * @time: 2020/12/31 16:54
 */
public class Solution111 {
    /**
     * Definition for a binary node
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
     * 前提是: 在左右子树都有叶子结点的前提下
     * 计算左子树和右子树各自的最小深度, 取最小值
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int left = minDepth(root.left) + 1;
        int right = minDepth(root.right) + 1;
        return Math.min(left, right);
    }

    public int minDepth(TreeNode root, TreeNode node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        int left = minDepth(root, node.left) + 1;
        int right = minDepth(root, node.right) + 1;
        if (root.left == null) return right;
        if (root.right == null) return left;
        return Math.min(left, right);
    }
}
