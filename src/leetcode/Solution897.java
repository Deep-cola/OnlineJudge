package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 递增顺序查找树
 * 给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 * @author: Deepcola
 * @time: 2020/11/19 23:18
 */
public class Solution897 {
    /**
     * Definition for a binary tree node
     */
    class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 递增顺序查找树
     * 只需要将中序遍历后的 有序list 变成结点，每次给上一结点的 right 就行。 第一个结点由于没有前一个结点，所以申请一个临时头结点
     */
    public TreeNode increasingBST(TreeNode root) {
        // 空树
        if (root == null) return null;
        List<Integer> list = new ArrayList<>();
        // 中序遍历
        inOrderTraversal(root, list);
        TreeNode temp = new TreeNode(0);
        TreeNode cur = temp;
        for (int i: list) {
            cur.right = new TreeNode(i);
            cur = cur.right;
        }
        return temp.right;
    }

    /**
     * 中序遍历
     */
    public void inOrderTraversal(TreeNode root,List<Integer> list) {
        // 空树
        if (root == null) return;
        inOrderTraversal(root.left, list);
        list.add(root.val);
        inOrderTraversal(root.right, list);
    }
}
