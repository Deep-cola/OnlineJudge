package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 左叶子之和
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 * @author: Deepcola
 * @time: 2021/1/1 20:40
 */
public class Solution404 {
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
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root);
    }
    // 深度优先搜索
    public int dfs(TreeNode node) {
        int result = 0;
        // 左子节点
        if (node.left != null) {
            // 为叶子节点
            if (node.left.left == null && node.left.right == null) {
                result += node.left.val;
            }else {
                // 不是叶子节点 -> 继续向下遍历
                result += dfs(node.left);
            }
        }
        // 右子节点
        if (node.right != null) {
            // 不为叶子结点 -> 继续向下遍历
            if (!(node.right.left == null && node.right.right == null)) {
                result += dfs(node.right);
            }
        }
        return result;
    }

    /**
     * 广度优先搜索
     */
    /*public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int result = 0;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            // 左节点
            if (temp.left != null) {
                // 叶子节点
                if (temp.left.left == null && temp.left.right == null) {
                    result += temp.left.val;
                }else {
                    queue.offer(temp.left);
                }
            }
            // 右子节点
            if (temp.right != null) {
                // 非叶子节点
                if (!(temp.right.left == null && temp.right.right == null)) {
                    queue.offer(temp.right);
                }
            }
        }
        return result;
    }*/
}
