package LeetCode;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * @author: Deepcola
 * @time: 2020/11/19 7:58
 */
public class Solution94 {
    /**
     * Definition for a binary tree Node
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
     * 中序遍历
     * 使用非覅贵 + 返回值实现
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        // 结点为空并且栈为空时遍历完
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur =cur.left;
            }
            cur = stack.pop();
            result.add(cur.val);
            cur = cur.right;
        }
        return result;
    }
}
