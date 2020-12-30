package leetcode;

/**
 * @description: 合并二叉树
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 * @author: Deepcola
 * @time: 2020/11/19 23:49
 */
public class Solution617 {
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
     * 合并二叉树
     * 1.都为 null
     * 2.有一个是 null
     * 3.都不是 null
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // 空树
        if (t1 == null && t2 == null) return null;
        // 有一个为 null
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        // 都不为空
        TreeNode root = new TreeNode(t1.val + t2.val);
        root.left = mergeTrees(t1.left, t2.left);
        root.right = mergeTrees(t1.right, t2.right);
        return root;
    }
}
