package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description: 二叉树最大宽度
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度
 * @author: Deepcola
 * @time: 2020/11/20 7:57
 */
public class Solution662 {
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
     * 二叉树的最大宽度
     * 1.空树是宽度为 0；
     * 2.非空树时宽度 maxWidth 最小为 1
     * 3.记录每一个非空结点的下标，用每一层的 最优结点-最左结点+1 就是该层的宽度
     */
    public int widthOfBinaryTree(TreeNode root) {
        // 空树
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        // 存放每个不为空结点下标
        List<Integer> list = new ArrayList<>();
        // 根节点入队，记根结点下标为 0
        queue.offer(root);
        list.add(0);
        // 最小宽度为 1
        int maxWidth = 1;
        while (!queue.isEmpty()) {
            // 记录每层装入的结点个数
            int count = queue.size();
            while (count-- > 0) {
                TreeNode temp = queue.poll();
                // 记录当前移除结点的下标用以计算左右孩子的下标
                int index = list.remove(0);
                // 非空孩子结点入队
                // 计算该非空孩子结点的下标, 添加到 list
                if (temp.left != null) {
                    queue.offer(temp.left);
                    list.add( 2 * index + 1);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                    list.add(2 * index + 2);
                }
            }
            // 对比该层的宽度和前面的最大宽度
            if (list.size() > 1) {
                int width = list.get(list.size() - 1) - list.get(0) + 1;
                maxWidth = Math.max(width, maxWidth);
            }
        }
        return maxWidth;
    }
}
