package leetcode;

import javafx.scene.Parent;

/**
 * @description: 二叉搜索树的范围和
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 *
 * 示例 1：
 * 输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
 * 输出：32
 *
 * 示例 2：
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 * 输出：23
 *  
 * 提示：
 *      树中节点数目在范围 [1, 2 * 104] 内
 *      1 <= Node.val <= 105
 *      1 <= low <= high <= 105
 *      所有 Node.val 互不相同
 * @author: Deepcola
 * @time: 2021/1/19 15:04
 */
public class Solution938 {

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
     * 深度优先搜索
     */
    /*int result = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root, low, high);
        return result;
    }

    private void dfs(TreeNode root, int low, int high) {
        if (root != null) {
            if (root.val >= low && root.val <= high) {
                result += root.val;
            }
            if (root.val > low) {
                dfs(root.left, low, high);
            }
            if (root.val < high) {
                dfs(root.right, low, high);
            }
        }
    }*/

    /**
     * 递归
     */
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }else if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }else {
            return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        }
    }
}
