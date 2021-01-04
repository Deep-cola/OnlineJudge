package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description: 二叉树的层平均值
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 *
 * 输入：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出：[3, 14.5, 11]
 * 解释：
 * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
 * @author: Deepcola
 * @time: 2021/1/4 22:42
 */
public class Solution637 {

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
     * 深度优先搜索
     */
    /*public List<Double> averageOfLevels(TreeNode root) {
        List<Integer> count = new ArrayList<>();// 计算每层节点个数
        List<Double> sum = new ArrayList<>();// 计算每一层节点值之和
        dfs(root, 0, count, sum);
        List<Double> result = new ArrayList<>();// 计算每一层平均值
        for (int i = 0; i < sum.size(); i++) {
            result.add(sum.get(i) / count.get(i));
        }
        return result;
    }

    private void dfs(TreeNode root, int level, List<Integer> count, List<Double> sum) {
        if (root == null) return;
        if (level < sum.size()) {// 当前层已经创建, 直接添加
            count.set(level, count.get(level) + 1);
            sum.set(level, sum.get(level) + root.val);
        }else {// 新的一层
            count.add(1);
            sum.add(1.0 * root.val);
        }
        // 递归深度搜索
        dfs(root.left, level + 1, count, sum);
        dfs(root.right, level + 1, count, sum);
    }*/


    /**
     * 广度优先搜索: 层序遍历 + 求平均值
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            double sum = 0;
            int num = count;
            while (count-- > 0) {
                TreeNode temp = queue.poll();
                sum += temp.val;
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            result.add(sum / num);
        }
        return result;
    }
}
