package leetcode;

/**
 * @description:　二叉搜索树节点最小距离
 * 给定一个二叉搜索树的根节点 root，返回树中任意两节点的差的最小值。
 *
 * 输入: root = [4,2,6,1,3,null,null]
 * 输出: 1
 * 解释:
 * 注意，root是树节点对象(TreeNode object)，而不是数组。
 * 给定的树 [4,2,6,1,3,null,null] 可表示为下图:
 *
 *           4
 *         /   \
 *       2      6
 *      / \
 *     1   3
 * 最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
 *  
 *
 * 注意：
 *
 * 二叉树的大小范围在 2 到 100。
 * 二叉树总是有效的，每个节点的值都是整数，且不重复。
 * @author: Deepcola
 * @time: 2021/1/3 7:59
 */
public class Solution783 {
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
     * 中序遍历 + 求最小值
     */
    int result = Integer.MAX_VALUE;
    TreeNode prev = null;
    public int minDiffInBST(TreeNode root) {
        return inOrder(root);
    }

    public int inOrder(TreeNode root) {
        if (root == null) {
            return 0;
        }
        inOrder(root.left);
        // 计算最小值
        if (prev != null) {
            result = Math.min(result, Math.abs(prev.val - root.val));
        }
        prev = root;
        inOrder(root.right);
        return result;
    }
}
