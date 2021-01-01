package leetcode;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * @description: 路径总和
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 * @author: Deepcola
 * @time: 2021/1/1 14:05
 */
public class Solution112 {
    /**
     * Definition for binary node
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
     * 递归:
     *      终止条件: 遍历至叶子结点停止
     *      单层动作: 判断当前是否为叶子结点并且遍历路径等于 sum
     *      返回值: 返回某条路径是否可以满足条件
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        // 当前节点是叶子结点
        if (root.left == null && root.right == null) {
            // 判断是否满足给定的路径和
            return root.val == sum;
        }
        // 左子树和右子树递归判断
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    /**
     * 广度优先搜索
     */
    /*public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        Queue<TreeNode> nodeQueue = new LinkedList<>();// 层序遍历存储节点
        Queue<Integer> valQueue = new LinkedList<>();// 存储到达当前节点路径的节点和
        nodeQueue.offer(root);
        valQueue.offer(root.val);
        while (!nodeQueue.isEmpty()) {
            TreeNode tempNode = nodeQueue.poll();
            int tempVal = valQueue.poll();
            // 判断是否到达叶子节点
            if (tempNode.left == null && tempNode.right == null) {
                if (tempVal == sum) {
                    return true;
                }
                continue;
            }
            if (tempNode.left != null) {
                nodeQueue.offer(tempNode.left);
                valQueue.offer(tempVal + tempNode.left.val);
            }
            if (tempNode.right != null) {
                nodeQueue.offer(tempNode.right);
                valQueue.offer(tempVal + tempNode.right.val);
            }
        }
        return false;
    }*/
}
