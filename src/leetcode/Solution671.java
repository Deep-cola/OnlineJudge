package leetcode;

/**
 * @description: 二叉树中第二小的节点
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
 * 更正式地说，root.val = min(root.left.val, root.right.val) 总成立。
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 *
 * 示例 1：
 * 输入：root = [2,2,5,null,null,5,7]
 * 输出：5
 * 解释：最小的值是 2 ，第二小的值是 5 。
 *
 * 示例 2：
 * 输入：root = [2,2,2]
 * 输出：-1
 * 解释：最小的值是 2, 但是不存在第二小的值。
 *
 * 提示：
 *      树中节点数目在范围 [1, 25] 内
 *      1 <= Node.val <= 231 - 1
 *      对于树中每个节点 root.val == min(root.left.val, root.right.val)
 * @author: Deepcola
 * @time: 2021/1/18 18:07
 */
public class Solution671 {

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
     * 父节点一定小于子节点
     * 1.最小的一定包括根节点
     * 2.查找第一个大于根节点的值
     */
    public int findSecondMinimumValue(TreeNode root) {
         return findBigger(root, root.val);
    }
    // 寻找第一个大于根节点的值
    private int findBigger(TreeNode root, int val) {
        if (root == null) return -1;
        // 找到第一个大于的就返回
        if (root.val > val) return root.val;
        int left = findBigger(root.left, val);
        int right = findBigger(root.right, val);
        if (left == -1) return right;
        if (right == -1) return left;
        return Math.min(left, right);
    }
}
