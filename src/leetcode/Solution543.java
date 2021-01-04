package leetcode;

/**
 * @description: 二叉树的直径
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 *
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 * @author: Deepcola
 * @time: 2021/1/4 14:48
 */
public class Solution543 {

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
     * 深度优先搜索
     */
    int max = 1;// 记录最大直径
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        // -1 代表最大直径是边的数目，即最多节点数-1
        return max - 1;
    }

    /**
     * 计算二叉树的最大深度
     */
    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        // 计算以当前节点开始的左右子树经过的节点数之和 : left + right + 1
        // 更新对于整个二叉树来说的最大节点数
        max = Math.max(max, left + right + 1);
        // 返回以当前节点为根节点的最大深度
        return Math.max(left + 1, right + 1);
    }

    
}
