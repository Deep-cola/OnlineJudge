package leetcode;

/**
 * @description: 最小高度数
 * 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
 * 示例:
 * 给定有序数组: [-10,-3,0,5,9],
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *           0
 *          / \
 *        -3   9
 *        /   /
 *      -10  5
 * @author: Deepcola
 * @time: 2021/1/12 22:36
 */
public class Interview0402 {
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
     * 最小高度就是平衡二叉树
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return findRoot(nums, 0, nums.length - 1);
    }
    // 每次以中点为根节点构建二叉树
    public TreeNode findRoot(int[] nums, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = findRoot(nums, start, mid - 1);
        root.right = findRoot(nums, mid + 1, end);
        return root;
    }
}
