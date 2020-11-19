package LeetCode;

/**
 * @description: 从周中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * @author: Deepcola
 * @time: 2020/11/19 17:05
 */
public class Solution106 {

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
     * 根据中序序列和后序序列构造二叉树
     */
    // 记录遍历后序序列的下标
    public int postIndex = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 序列不能为 null 或者长度为 0
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) return null;
        // 后序序列最后一个元素为根节点位置
        postIndex = postorder.length - 1;
        // 构造二叉树
        return buildTreeChild(inorder, postorder, 0, inorder.length - 1);
    }

    /**
     *
     * @param inorder 中序序列
     * @param postorder 后序序列
     * @param begin 中序序列构建二叉树的起始位置
     * @param end 中序序列构建二叉树的终止位置
     * @return 二叉树的根节点
     */

    public TreeNode buildTreeChild(int[] inorder, int[] postorder, int begin, int end) {
        // 终止条件
        if (begin > end) return null;
        TreeNode root = new TreeNode(postorder[postIndex]);
        // 查找根节点在中序序列中的位置下标
        int indexOfInorder = searchIndexOfRoot(inorder, begin, end, postorder[postIndex]);
        // 遍历后序序列的下标前移
        postIndex--;
        // 递归构造左右子树
        // 需要先构造右子树，因为后序序列从后向前遍历
        root.right = buildTreeChild(inorder, postorder, indexOfInorder + 1, end);
        root.left = buildTreeChild(inorder, postorder, begin, indexOfInorder - 1);
        return root;
    }

    /**
     * 查找根节点在中序序列中的位置下标
     */
    public int searchIndexOfRoot(int[] inorder, int begin, int end, int val) {
        for (int i = begin; i <= end; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return - 1;
    }

}
