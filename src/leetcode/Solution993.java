package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @description: 二叉树的堂兄弟节点
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 * 如果二叉树的两个节点深度相同，但父节点不同，则它们是一对堂兄弟节点。
 * 我们给出了具有唯一值的二叉树的根节点 root，以及树中两个不同节点的值 x 和 y。
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true。否则，返回 false。
 *
 * 示例 1：
 * 输入：root = [1,2,3,4], x = 4, y = 3
 * 输出：false
 *
 * 示例 2：
 * 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
 * 输出：true
 *
 * 示例 3：
 * 输入：root = [1,2,3,null,4], x = 2, y = 3
 * 输出：false
 *
 * 提示：
 *       二叉树的节点数介于 2 到 100 之间。
 *      每个节点的值都是唯一的、范围为 1 到 100 的整数。
 * @author: Deepcola
 * @time: 2021/1/19 15:43
 */
public class Solution993 {
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
     * 1.两个父节点位于同一层
     * 2.两个节点的父节点不同
     */
    int depthX, depthY;// x, y 的深度
    int parentX, parentY;// x, y 的父节点值
    public boolean isCousins(TreeNode root, int x, int y) {
        findParent(root.left,1, x, y, root.val);
        findParent(root.right,1, x, y, root.val);
        return (depthX == depthY) && (parentX != parentY);
    }

    private void findParent(TreeNode root, int depth, int x, int y, int parent) {
        if (root == null) return;
        if (root.val == x) {
            depthX = depth;
            parentX = parent;
        }else if (root.val == y) {
            depthY = depth;
            parentY = parent;
        }else {
            findParent(root.left, 1 + depth, x, y, root.val);
            findParent(root.right, 1 + depth, x, y, root.val);
        }
    }

    /**
     * 广度优先搜索————BFS
     */
    /*public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode nodeX = null;
        TreeNode nodeY = null;
        TreeNode parentX = null;
        TreeNode parentY = null;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    queue.offer(temp.left);
                    if (temp.left.val == x) {
                        nodeX = temp.left;
                        parentX = temp;
                    }
                    if (temp.left.val == y) {
                        nodeY = temp.left;
                        parentY = temp;
                    }
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                    if (temp.right.val == x) {
                        nodeX = temp.right;
                        parentX = temp;
                    }
                    if (temp.right.val == y) {
                        nodeY = temp.right;
                        parentY = temp;
                    }
                }
                // 判断
                // 两个节点都没有找到
                if (nodeX == null && nodeY == null) {
                    continue;
                }else if (nodeX != null && nodeY != null) {
                    // 两个节点都找到了
                    return parentX != parentY;
                }else if (size == 0) {
                    // 只找到一个节点 同时 已经遍历完了
                    return false;
                }
            }
        }
        return true;
    }*/

    /**
     * 深度优先搜索————递归
     */
    /*Map<Integer, Integer> depthMap = new HashMap<>();// 节点值——深度
    Map<Integer, TreeNode> parentMap = new HashMap<>();// 节点值——父节点
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, null);
        return (depthMap.get(x).equals(depthMap.get(y))) && (parentMap.get(x) != parentMap.get(y));
    }

    public void dfs(TreeNode root, TreeNode parent) {
        if (root != null) {
            depthMap.put(root.val, parent == null ? 0 : depthMap.get(parent.val) + 1);
            parentMap.put(root.val, parent);
            dfs(root.left, root);
            dfs(root.right, root);
        }
    }*/
}
