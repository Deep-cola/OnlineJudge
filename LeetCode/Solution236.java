package LeetCode;

/**
 * @description: 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * @author: Deepcola
 * @time: 2020/11/19 14:50
 */
public class Solution236 {

    /**
     * Definition  for a binary tree node
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
     * 二叉树的最近公共祖先
     * 1. p、q 有一个是根节点  -> root
     * 2. p、q 在左右子树  -> 根节点
     * 3. p、q 在同一侧子树  -> 深度小的
     * 递归在左子树右子树中查找 p、q，找到就返回
     *      有一个为 null 时  -> 两个在同一侧 -> 另一个就是最近公共祖先
     *      都不为 null 时  -> 两个在异侧  -> 最近公共祖先时 root
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 空树
        if (root == null) return null;
        // p、q 中有一个是根节点
        if (p == root || q == root) return root;
        // 分别遍历左子树和右子树查找p、q
        // left、right 分别是左右子树找到的第一个结点(p或者q)
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 有一个为 null, 说明两个在同侧; 都不为 null 时，在异侧
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}
