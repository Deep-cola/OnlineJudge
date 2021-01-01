package leetcode;

/**
 * @description: 二叉搜索树的最近公共祖先
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：
 *          “对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 *  
 *
 * 说明:
 *      所有节点的值都是唯一的。
 *      p、q 为不同节点且均存在于给定的二叉搜索树中。
 * @author: Deepcola
 * @time: 2021/1/1 16:25
 */
public class Solution235 {

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
     * 对于 p、q 的情况:
     *      1.p、q 位于根节点两侧   ->  最近公共祖先是根节点
     *      2.p、q 位于同侧        -> 最近公共祖先是靠近根节点的节点
     */
    /*public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        // 找到某一节点就返回
        if (root == p) {
            return p;
        }else if (root == q){
            return q;
        }
        // 递归查找 p、q
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 情况判断
        if (left == null) {
            return right;
        }else if (right == null) {
            return left;
        }else {
            return root;
        }
    }*/

    /**
     * 一次遍历:
     *      使用二叉搜索树的性质
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while (true) {
            if (p.val < ancestor.val && q.val < ancestor.val) {
                // 在 左子树
                ancestor = ancestor.left;
            }else if (p.val > ancestor.val && q.val > ancestor.val) {
                // 在右子树
                ancestor = ancestor.right;
            }else {
                // p、q 位于左右两侧或者说有一个就是根节点
                break;
            }
        }
        return ancestor;
    }
}
