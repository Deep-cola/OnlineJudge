package leetcode;

/**
 * @description: 二叉搜索树中的搜索
 * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 * 例如，
 * 给定二叉搜索树:
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 * 和值: 2
 * 你应该返回如下子树:
 *       2
 *      / \
 *     1   3
 * 在上述示例中，如果要找的值是 5，但因为没有节点值为 5，我们应该返回 NULL。
 * @author: Deepcola
 * @time: 2021/1/18 18:33
 */
public class Solution700 {

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
     * 递归
     */
    /*public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val > val) {
            return searchBST(root.left, val);
        }else if (root.val < val) {
            return searchBST(root.right, val);
        }else {
            return root;
        }
    }*/
    /*public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        return root.val > val ? searchBST(root.left, val) : searchBST(root.right, val);
    }*/

    /**
     * 迭代
     */
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null && root.val != val) {
            root = (root.val > val) ? root.left : root.right;
        }
        return root;
    }

}
