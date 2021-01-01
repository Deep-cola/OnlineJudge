package leetcode;

/**
 * @description: 翻转二叉树
 * 翻转一棵二叉树。
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * @author: Deepcola
 * @time: 2021/1/1 15:59
 */
public class Solution226 {
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
     * 从上向下递归:
     *      终止条件: 所有二叉树翻转完毕
     *      单层动作: 交换当前根节点下的左右子树, 继续向下遍历翻转
     *      返回值: 每次返回反转后的根节点
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        // 根据当前根节点翻转两侧
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        // 向下遍历翻转二叉树
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    /**
     * 从下向上递归:
     *      终止条件: 向下递归至叶子结点
     *      单层动作: 翻转叶子结点
     *      返回值: 每次返回反转后的根节点
     */
    /*public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        // 递归至根节点
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        // 从叶子节点开始翻转
        root.left = right;
        root.right = left;
        return root;
    }*/
}
