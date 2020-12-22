package LeetCode;

import java.util.*;

/**
 * @description: 二叉树的锯齿形层序遍历
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层序遍历如下：
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 * @author: Deepcola
 * @time: 2020/12/22 0:03
 */
public class Solution103 {

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
     * 1.层序遍历
     * 2.使用 flag 记录当前行应该遍历的顺序, 如果反向就反转当前行的 list
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        boolean flag = true;// 从左往右
        queue.offer(root);
        // 层序遍历
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<Integer> list = new ArrayList<>();
            while (count-- > 0) {
                TreeNode temp = queue.poll();
                // 判断添加顺序
                if (flag) {
                    list.add(temp.val);
                }else {
                    list.add(0, temp.val);
                }
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            // 每一行需要修改遍历顺序
            flag = !flag;
            result.add(list);
        }
        return result;
    }

    /**
     * 使用双端队列
     */
    /*public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        boolean flag = true;// 从左往右
        queue.offer(root);
        // 层序遍历
        while (!queue.isEmpty()) {
            int count = queue.size();
            Deque<Integer> deque = new LinkedList<>();
            while (count-- > 0) {
                TreeNode temp = queue.poll();
                // 判断添加顺序
                if (flag) {
                    deque.offerLast(temp.val);
                }else {
                    deque.offerFirst(temp.val);
                }
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            // 每一行需要修改遍历顺序
            flag = !flag;
            result.add(new ArrayList<>(deque));
        }
        return result;
    }*/
}
