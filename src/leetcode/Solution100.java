package leetcode;

/**
 * @description: 相同的树
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * @author: Deepcola
 * @time: 2020/11/19 8:26
 */
public class Solution100 {
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
     * 判断两个树是否相同 :
     * 1.结构不同;
     * 2.结构相同，值不同;
     * 3.相同的数
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 两个都为空树
        if (p == null && q == null) return true;
        // 只有一个为 null
        if (p == null || q == null) return false;
        // 都不是空树
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
