package leetcode;

import java.util.*;

/**
 * @description: 两数之和Ⅳ-输入BST
 * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 *
 * 输入:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 * Target = 9
 *
 * 输出: True
 *
 * 输入:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 * Target = 28
 *
 * 输出: False
 *
 * @author: Deepcola
 * @time: 2021/1/5 16:00
 */
public class Solution653 {
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
     * 使用 HashSet
     */
    /*public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return findTarget(root, k, set);
    }

    public boolean findTarget(TreeNode root, int target, Set<Integer> set) {
        if (root == null) return false;
        // 集合中包含 另一个数,使得两数之和为 target
        if (set.contains(target - root.val)) {
            return true;
        }
        // 将该数加入 set 用于判断后面的
        set.add(root.val);
        return findTarget(root.left, target, set) || findTarget(root.right, target, set);
    }*/

    /**
     * BFS + HashSet
     */
    /*public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            if (queue.peek() != null) {
                TreeNode temp = queue.poll();
                if (set.contains(k - temp.val)) {
                    return true;
                }
                set.add(temp.val);
                queue.add(temp.left);
                queue.add(temp.right);
            }else {
                queue.poll();
            }
        }
        return false;
    }*/

    /**
     * BST 性质: 中序遍历有序 + 双指针
     */
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int sum = list.get(left) + list.get(right);
            if (sum < k) {
                left++;
            }else if (sum > k) {
                right--;
            }else {
                return true;
            }
        }
        return false;
    }

    public void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }
}
