package LeetCode;

/**
 * @description: 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 * @author: Deepcola
 * @time: 2020/11/19 13:29
 */
public class Solution101 {

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
     * 判断一棵树是不是镜像对称
     * 判断二叉树的左子树和右子树是不是镜像对称，
     */
    public boolean isSymmetric(TreeNode root) {
        // 空树
        if (root == null) return true;
        if (isSymmetric(root.left, root.right)) return true;
        return false;
    }

    /**
     * 判断两个树是不是镜像对称的
     * 1.p、q都是空树  -> true
     * 2.p、q有一个是空树  -> false
     * 3.没有空树  p.val == q.val && p.left and q.right is symmetric && p.right and q.left is symmetric
     */
    public boolean isSymmetric(TreeNode p, TreeNode q) {
        // 都是空树
        if (p == null && q == null) return true;
        // 有一个是空树
        if (p == null || q == null) return false;
        // 没有空树
        // 镜像对称需要满足 p.val == q.val && p.left and q.right is symmetric && p.right and q.left is symmetric
        if (p.val == q.val && isSymmetric(p.left,q.right) && isSymmetric(p.right, q.left)) return true;
        return false;
    }
}
