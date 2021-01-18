package newcode;

/**
 * @description: 二叉树的平衡检查
 * @author: Deepcola
 * @time: 2021/1/18 23:16
 */
public class Balance {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isBalance(TreeNode root) {
        // write code here
        if(root == null) return true;
        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1
                && isBalance(root.left) && isBalance(root.right);
    }
    // 最大深度
    public static int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
