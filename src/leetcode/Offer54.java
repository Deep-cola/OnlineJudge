package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: 二叉搜索树中的第 k 大节点
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 4
 * 限制：
 *      1 ≤ k ≤ 二叉搜索树元素个数
 * @author: Deepcola
 * @time: 2021/1/11 21:41
 */
public class Offer54 {
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
     * 中序遍历添加节点值到 list
     */
    /*public int kthLargest(TreeNode root, int k) {
        List<Integer> result = inorderTraversal(root);
        return result.get(result.size() - k);
    }
    // 中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        List<Integer> left = inorderTraversal(root.left);
        result.addAll(left);
        result.add(root.val);
        List<Integer> right = inorderTraversal(root.right);
        result.addAll(right);
        return result;
    }*/

    /**
     * 中序倒序遍历
     */
    int result;
    int k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return result;
    }
    // 中序倒序遍历
    public void dfs(TreeNode root) {
        if (root == null) return;
        // 先遍历右边
        if (root.right != null) {
            dfs(root.right);
        }
        // 判断是否遍历到目标节点
        k--;
        if (k == 0) {
            result = root.val;
            return;
        }
        /*if (k == 0) return;
        if (--k >= 0) {
            result = root.val;
        }*/
        // 遍历左边
        dfs(root.left);
    }
}
