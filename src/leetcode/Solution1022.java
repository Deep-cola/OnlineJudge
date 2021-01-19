package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description: 从根到叶的二进制数之和
 * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。
 * 例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
 * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
 * 返回这些数字之和。题目数据保证答案是一个 32 位 整数。
 *
 * 示例 1：
 * 输入：root = [1,0,1,0,1,0,1]
 * 输出：22
 * 解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 *
 * 示例 2：
 * 输入：root = [0]
 * 输出：0
 *
 * 示例 3：
 * 输入：root = [1]
 * 输出：1
 *
 * 示例 4：
 * 输入：root = [1,1]
 * 输出：3
 *  
 * 提示：
 *      树中的结点数介于 1 和 1000 之间。
         * Node.val 为 0 或 1 。
 * @author: Deepcola
 * @time: 2021/1/19 17:11
 */
public class Solution1022 {

    /**
     * Definition for a binary tree node
     */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 深度优先遍历
     */
    int result = 0;
    public int sumRootToLeaf(TreeNode root) {
        dfs(root, 0);
        return result;
    }

    public void dfs(TreeNode root, int val) {
        if (root != null) {
            int temp = (val << 1) + root.val;
            // 当前为叶子结点
            if (root.left == null && root.right == null) {
                result += temp;
            }
            dfs(root.left, temp);
            dfs(root.right, temp);
        }
    }

    /**
     * 广度优先搜索
     */
    /*public int sumRootToLeaf(TreeNode root) {
        int result = 0;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> valueQueue = new LinkedList<>();
        nodeQueue.offer(root);
        valueQueue.offer(root.val);
        while (!nodeQueue.isEmpty()) {
            TreeNode nodeTemp = nodeQueue.poll();
            int valueTemp = valueQueue.poll();
            // 叶子结点
            if (nodeTemp.left == null && nodeTemp.right == null) {
                result += valueTemp;
            }else {
                if (nodeTemp.left != null) {
                    nodeQueue.offer(nodeTemp.left);
                    valueQueue.offer((valueTemp << 1) + nodeTemp.left.val);
                }
                if (nodeTemp.right != null) {
                    nodeQueue.offer(nodeTemp.right);
                    valueQueue.offer((valueTemp << 1) + nodeTemp.right.val);
                }
            }
        }
        return result;
    }*/
}
