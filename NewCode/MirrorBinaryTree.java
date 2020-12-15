package NewCode;

/**
 * @description: 二叉树的镜像
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 输入描述: 二叉树的镜像定义：
 *          源二叉树
 *     	    8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 *     	镜像二叉树
 *     	    8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7  5
 * @author: Deepcola
 * @time: 2020/12/15 23:17
 */
public class MirrorBinaryTree {
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

    public void Mirror(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) return;
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        if (root.left != null) {
            Mirror(root.left);
        }
        if (root.right != null) {
            Mirror(root.right);
        }
    }
}
