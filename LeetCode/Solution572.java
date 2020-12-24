package leetcode;

/**
 * @description: 另一个树的子树
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
 * s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 * @author: Deepcola
 * @time: 2020/11/19 8:36
 */
public class Solution572 {
    /**
     * Definition for a binary tree node
     */
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 判断一个树是不是另一棵树的子树
     * 判断 s 或者 s 的子树是不是和 t 相同
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        // 两棵树中为空树
        if (s == null || t == null) return false;
        // 判断两棵树是不是相同 或者 t 是不是 s 的左右子树的子树
        if (isSameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t)) return true;
        return false;
    }

    /**
     * 判断两个数是不是相同的数
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 两棵树都是空树
        if (p == null && q == null) return true;
        // 有一颗是空树
        if (p == null || q == null) return false;
        // 都不是空树
        if (p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right)) return true;
        return false;
    }

}
