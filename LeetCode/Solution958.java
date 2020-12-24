package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 二叉树的完全性检验
 * 给定一个二叉树，确定它是否是一个完全二叉树。
 * 完全二叉树的定义如下：
 * 若设二叉树的深度为 h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。
 * @author: Deepcola
 * @time: 2020/11/19 23:00
 */
public class Solution958 {
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

    /**
     * 检验一棵树是不是完全二叉树
     */
    public boolean isCompleteTree(TreeNode root) {
        // 空树
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 队首元素出队
            TreeNode temp = queue.poll();
            // 不论出队元素的左右孩子是不是空结点都入队
            // 根据完全二叉树的特性，通过层序遍历在没有遍历完之前不会有null，遍历完成之后全为 null
            if (temp != null) {
                queue.offer(temp.left);
                queue.offer(temp.right);
            }else {
                // 遇到第一个 null 就去判断是不是完全二叉树
                break;
            }
        }
        // 判断队中还有没有不为空的元素
        // 全为空才是完全二叉树
        while (!queue.isEmpty()) {
            if (queue.poll() != null) {
                return false;
            }
        }
        return true;
    }
}
