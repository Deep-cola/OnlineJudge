package newcode;

/**
 * @description: 二叉搜索树转换为排序的双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * @author: Deepcola
 * @time: 2020/11/19 15:15
 */
public class BST2DoubleLinkedList {
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
     * 二叉搜索树转有序双向链表
     */
    public TreeNode convert(TreeNode root) {
        // 空树
        if (root == null) return null;
        // 进行转换
        convertChild(root);
        TreeNode head = root;
        // 遍历完时，root 位于链表尾部
        while (head.left != null) {
            head = head.left;
        }
        return head;
    }


    /**
     * 转换
     * 二叉搜索树中序遍历有序，所以相当于将树型结构的二叉搜索树拉平，当然需要一定的转变。
     * 将某个结点的左孩子作为链表中的前驱结点 prev; 右孩子作为链表中的后继节点 next
     * 整体来说通过中序遍历进行，不同的是，在中序遍历的打印结点处，进行转换：
     * 将 prev 记录的结点记为当前节点 root 的左孩子(前驱结点), 将当前节点 root 赋给 prev 作为右孩子(后继节点)
     */
    // 存放二叉树结点的 left 也就是链表的前驱结点
    public TreeNode prev = null;
    public void convertChild(TreeNode root) {
        // 空树
        if (root == null) return;
        // 按照中序遍历的有序顺序，转换其中的关系：将某个结点的左孩子作为链表中的前驱结点 prev; 右孩子作为链表中的后继节点 next
        // 递归查找左子树
        convertChild(root.left);
        // prev 记录的时 root 结点的前驱结点 left
        root.left = prev;
        // 第一次时 prev 为空，需要判断掉
        if (prev != null) {
            // 当前结点作为前驱结点的 right
            prev.right = root;
        }
        // 向后
        prev = root;
        // 遍历右子树
        convertChild(root.right);
    }

}
