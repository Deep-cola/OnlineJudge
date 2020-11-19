package LeetCode;

/**
 * @description: 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * @author: Deepcola
 * @time: 2020/11/19 16:18
 */
public class Solution105 {

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
     * 根据前序序列和中序序列构造二叉树
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 前序、中序序列不能为 null 或者没有元素
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) return null;
        // 构造二叉树
        return buildTreeChild(preorder, inorder,0, inorder.length - 1);
    }

    /**
     * 构造二叉树
     * 前序序列第一个元素为二叉树的根节点，在中序序列中找到这个结点从而确定根节点位置，将中序序列分成两部分片段也就是左右子树
     * 然后递归构造左子树和右子树:
     *      遍历前序序列，在指定的中序序列片段中查找每一次 preIndex 对应的 "根节点" ，根据根结点位置将部分中序序列片段继续分为两部分也就是左右子树
     * @param preorder 前序序列
     * @param inorder 中序序列
     * @param begin 中序序列中构建二叉树的开始位置
     * @param end 中序序列中构建二叉树的结束位置
     * @return 二叉树的根节点
     */
    // 遍历前序序列的下标
    // 在递归过程中需要一直向后遍历，所以不能作为局部变量每次进行重置
    public int preIndex = 0;
    public TreeNode buildTreeChild(int[] preorder, int[] inorder, int begin, int end) {
        // 当 begin > end 时，序列片段已经遍历完
        if (begin > end) return null;
        TreeNode root = new TreeNode(preorder[preIndex]);
        // 查找根节点在中序序列中的位置下标
        int indexOfInorder = searchIndexOfRoot(inorder, begin, end, preorder[preIndex]);
        // preIndex 向后继续遍历
        preIndex++;
        // 构造左右子树
        root.left = buildTreeChild(preorder, inorder, begin, indexOfInorder - 1);
        root.right = buildTreeChild(preorder, inorder, indexOfInorder + 1, end);
        return root;
    }

    /**
     * 在指定的部分中序序列中查找 preIndex 对应的根节点下标
     */
    public int searchIndexOfRoot(int[] inorder, int begin, int end, int val) {
        for (int i = begin; i <= end; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }

}
