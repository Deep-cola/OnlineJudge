package leetcode;

import java.util.*;

/**
 * @description: 二叉搜索树中的最小绝对差
 *  给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 *
 * 输入：
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * 输出：
 * 1
 *
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 *
 * 注意：　树中至少有两个节点
 * @author: Deepcola
 * @time: 2021/1/3 7:58
 */
public class Solution530 {
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
     * 二叉搜索树中序遍历有序
     */
    int result = Integer.MAX_VALUE;
    TreeNode prev = null;
    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return result;
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        // 计算最小值
        if (prev != null) {
            result = Math.min(result, Math.abs(prev.val - root.val));
        }
        prev = root;
        inOrder(root.right);
    }


    /**
     * 中序遍历取出所有节点值, 排序求差值
     */
    /*public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        List<Integer> list = inOrderTraversal(root);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            int temp = list.get(i) - list.get(i - 1);
            if (temp < min) {
                min = temp;
            }
        }
        return min;
    }

    // 遍历
    public List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        List<Integer> left = inOrderTraversal(root.left);
        list.addAll(left);
        list.add(root.val);
        List<Integer> right = inOrderTraversal(root.right);
        list.addAll(right);
        return list;
    }*/
}
