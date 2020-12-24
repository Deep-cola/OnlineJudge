package leetcode;

import java.util.*;

/**
 * @description: 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * @author: Deepcola
 * @time: 2020/11/19 14:36
 */
public class Solution102 {

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
     * 层序遍历
     * 当一个结点出队时，它的左右孩子全部入队(如果存在)，那么当这一层结点全部出队后，队列中剩余结点全是下一层的。依次类推
     * 每层使用 count 记录这一层结点个数，从而按层打印结点的值
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        // 空树
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode cur = root;
        //根节点入栈
        queue.offer(cur);
        while (!queue.isEmpty()) {
            // 记录每层的结点个数, 作为条件判断这一层是否全部出队
            int count = queue.size();
            List<Integer> list = new ArrayList<>();
            while (count-- != 0) {
                TreeNode temp = queue.poll();
                list.add(temp.val);
                // 左右孩子不为空的入队
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}
