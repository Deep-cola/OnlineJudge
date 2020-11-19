package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: 二叉树的后序遍历
 * 给定一个二叉树，返回它的 后序 遍历。
 * @author: Deepcola
 * @time: 2020/11/19 8:05
 */
public class Solution145 {
    /**
     * Definition for a binary tree
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
     * 后序遍历
     * 使用非递归 + 返回值实现
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        // 记录上次添加到 list 的结点，防止重复添加
        TreeNode pre = null;
        // 结点为空并且栈为空时遍历完
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            // 判断当前结点的右孩子是否为空或者有没有被添加过
            if (cur.right == null || cur.right == pre) {
                result.add(cur.val);
                stack.pop();
                pre = cur;
                // cur 置空访问下一个结点
                cur = null;
            }else {
                // 只有右孩子不为空同时没有添加过才遍历右结点
                cur = cur.right;
            }
        }
        return result;
    }
}
