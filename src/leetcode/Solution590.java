package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description:
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 *
 * 例如，给定一个 3叉树 :
 *               1
 *            /  |  \
 *           3   2   4
 *         /  \
 *        5   6
 * 返回其后序遍历: [5,6,3,2,4,1].
 *
 * @author: Deepcola
 * @time: 2021/1/6 22:36
 */
public class Solution590 {
    /**
     * Definition for a node
     */
    class Node {
        public int val;
        public List<Node> children;
        public Node(int val) {
            this.val = val;
        }
    }

    /**
     * 递归
     */
    List<Integer> result = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if (root == null) return result;
        for (Node node : root.children) {
            postorder(node);
        }
        result.add(root.val);
        return result;
    }

    /**
     * 迭代
     */
    /*public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Node prev = null;
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            // 反向插入即可
            result.add(0, node.val);
            for (Node temp: node.children) {
                stack.push(temp);
            }
        }
        return result;
    }*/
}
