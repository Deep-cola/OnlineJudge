package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 二叉树的最下深度
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 *      树中节点数的范围在 [0, 105] 内
 *      -1000 <= Node.val <= 1000
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 *
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 * @author: Deepcola
 * @time: 2020/12/31 16:54
 */
public class Solution111 {
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
     * 层序遍历:
     *      当某一节点左子树和右子树都为 null 时, 该节点为第一个叶子结点, 此时就是最小深度
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int Depth = 0;
        while (!queue.isEmpty()) {
            int count = queue.size();
            Depth++;
            while (count-- > 0) {
                TreeNode temp = queue.poll();
                if (temp.left == null && temp.right == null) {
                    break;
                }else {
                    if (temp.left != null) queue.offer(temp.left);
                    if (temp.right != null) queue.offer(temp.right);
                }
            }
            if (count != -1) {
                break;
            }
        }
        return Depth;
    }

    /**
     * 深度优先策略
     */
    /*public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_depth = Math.min(min_depth, minDepth(root.left));
        }
        if (root.right != null) {
            min_depth = Math.min(min_depth, minDepth(root.right));
        }
        return min_depth + 1;
    }*/


    /*public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }else if (root.left == null) {
            return minDepth(root.right) + 1;
        }else if (root.right == null) {
            return minDepth(root.left) + 1;
        }else {
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }*/
}
