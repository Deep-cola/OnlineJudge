package leetcode;

/**
 * @description: BiNode
 * 二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。
 * 实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
 * 返回转换后的单向链表的头节点。
 *
 * 示例：
 * 输入： [4,2,5,1,3,null,6,0]
 * 输出： [0,null,1,null,2,null,3,null,4,null,5,null,6]
 *
 * 提示：
 *      节点数量不会超过 100000。
 * @author: Deepcola
 * @time: 2021/1/18 16:39
 */
public class Interview1712 {
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
     * 中序遍历 BST
     * 1.将中序遍历时节点 right 指向下一个遍历节点, 左子树为 null
     * 2.修改指针时应该注意第一次修改时 前驱节点为 null -> 申请傀儡头节点解决
     */
    TreeNode dummyHead = new TreeNode(0);
    TreeNode prev = null;// 指向前驱节点(中序遍历的前一个节点)
    public TreeNode convertBiNode(TreeNode root) {
        convert(root);
        return dummyHead.right;
    }
    // 中序遍历实现修改指向
    public void convert(TreeNode root) {
        if (root == null) return;
        convert(root.left);
        // 第一次修改
        if (prev == null) {
            // 第一次需要将傀儡头节点和”链表头结点“相连
            prev = root;
            dummyHead.right = root;
        }else {
            // 将中序遍历前一个节点的 right 指向下一个节点
            prev.right = root;
            prev = root;
        }
        // 左子树为 null
        root.left = null;
        convert(root.right);
    }
}
