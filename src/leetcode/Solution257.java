package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description: 二叉树的所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 * @author: Deepcola
 * @time: 2021/1/1 17:25
 */
public class Solution257 {

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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        binaryTreePaths(root, "", result);
        return result;
    }
    // 递归求所有路径
    public void binaryTreePaths(TreeNode root, String path, List<String> result) {
        if (root == null) return;
        StringBuilder sb = new StringBuilder(path);// 前面的节点
        sb.append(root.val);// 当前的节点
        if (root.left == null && root.right == null) {
            // 当前节点为叶子结点
            result.add(sb.toString());
        }else {
            // 当前节点不是叶子结点 -> 递归向下遍历
            sb.append("->");// 用于连接下一个节点
            binaryTreePaths(root.left, sb.toString(), result);
            binaryTreePaths(root.right, sb.toString(), result);
        }
    }
}
