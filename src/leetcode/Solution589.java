package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: N叉树的前序遍历
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 *
 * 例如，给定一个 3叉树 :
 *               1
 *            /  |  \
 *           3   2   4
 *         /  \
 *        5   6
 * 返回其前序遍历: [1,3,5,6,2,4]。
 *
 * @author: Deepcola
 * @time: 2021/1/6 21:46
 */
public class Solution589 {

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
    /*public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        result.add(root.val);
        List<Integer> list = preorder(root.children);
        result.addAll(list);
        return result;
    }
    // 对于孩子节点的递归添加
    public List<Integer> preorder(List<Node> children) {
        List<Integer> result = new ArrayList<>();
        if (children == null) return result;
        for (Node child : children) {
            result.add(child.val);
            List<Integer> list = preorder(child.children);
            result.addAll(list);
        }
        return result;
    }*/
    /**
     * 简化递归
     */
    /*List<Integer> result = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if (root == null) return result;
        result.add(root.val);
        for (Node node: root.children) {
            preorder(node);
        }
        return result;
    }*/

    /**
     * 迭代
     */
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        if (root == null) return result;
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            result.add(node.val);
            // 从右到左依次加入
            for (int i = node.children.size() - 1; i >= 0; i--) {
                stack.push(node.children.get(i));
            }
        }
        return result;
    }
}
