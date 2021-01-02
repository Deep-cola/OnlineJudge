package leetcode;

import java.util.*;

/**
 * @description: 二叉搜索树中的众数
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * 假定 BST 有如下定义：
 *      结点左子树中所含结点的值小于等于当前结点的值
 *      结点右子树中所含结点的值大于等于当前结点的值
 *      左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 *    1
 *     \
 *      2
 *     /
 *    2
 * 返回[2].
 *
 * 提示：
 *      如果众数超过1个，不需考虑输出顺序
 *      进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 * @author: Deepcola
 * @time: 2021/1/2 16:21
 */
public class Solution501 {
    /**
     * Definition for a binary node
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
     * 中序遍历： BST 中序遍历有序, 所以相等数值的节点会在一起
     */
    List<Integer> list = new ArrayList<>();
    int maxCount, base, count;// 出现的最多次数, 当前判断节点数值, 当前判断节点出现次数
    public int[] findMode(TreeNode root) {
        inOrderTraversal(root);
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
    // 中序遍历
    public void inOrderTraversal(TreeNode root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        update(root.val);
        inOrderTraversal(root.right);
    }
    // 更新
    public void update(int val) {
        // 判断当前节点是否和统计节点相同
        if (val == base) {
            count++;
        }else {
            count = 1;
            base = val;
        }
        // 在当前看来是众数
        if (count == maxCount) {
            list.add(base);
        }
        // 更新众数
        if (count > maxCount) {
            maxCount = count;
            list.clear();
            list.add(base);
        }
    }

    /**
     * Marris 中序遍历
     * 修改前驱节点的 right 指针遍历整个二叉树 -> 在遍历完左子树的情况下再跳回到当前节点
     * Morris 中序遍历的一个重要步骤就是寻找当前节点的前驱节点，并且 Morris 中序遍历寻找下一个点始终是通过转移到 right 指针指向的位置来完成的。
     *  1.是否有左子树
     *      (1)没有左子树 -> 更新遍历当前节点并跳转到右子树
     *      (2)有左子树 -> 那么当前节点的前驱节点一定在左子树上, 遍历左子树寻找前驱节点:
     *          (1)前驱节点的 right 指向 null -> 更改前驱节点的 right 指向当前节点, 并去遍历左子树
     *          (2)前驱节点的 right 指向 当前节点 -> 说明前驱节点已经被遍历过并且修改了 right 指针,
     *                                        -> 重新将前驱的右孩子设置为空，遍历当前的点，然后跳转到当前节点的右子树。
     */
    /*List<Integer> list = new ArrayList<>();
    int maxCount, base, count;// 出现的最多次数, 当前判断节点数值, 当前判断节点出现次数
    public int[] findMode(TreeNode root) {
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur != null) {
            // 没有左子树 -> 遍历当前节点并跳转到右子树
            if (cur.left == null) {
                update(cur.val);
                cur = cur.right;
                continue;
            }
            // 存在左子节点 -> 当前节点的前驱节点一定在左子树上, 去查找
            prev = cur.left;
            // 左子树的最右节点, 或者下一节点就是当前节点
            while (prev.right != null && prev.right != cur) {
                prev = prev.right;
            }
            // 判断前驱节点状况
            if (prev.right == null) {
                // 前驱节点是左子树的最右节点
                // 连接为当前节点的前驱节点, 为了能够在遍历完前驱节点后找到当前节点
                prev.right = cur;
                cur = cur.left;
            }else {
                // 下一节点是当前节点 -> 前驱节点已经被遍历过并且修改了指针
                // 前驱节点连接 null, 遍历当前节点, 跳转到右子树
                prev.right = null;
                update(cur.val);
                cur = cur.right;
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
    // 更新
    public void update(int val) {
        // 判断当前节点是否和统计节点相同
        if (val == base) {
            count++;
        }else {
            count = 1;
            base = val;
        }
        // 在当前看来是众数
        if (count == maxCount) {
            list.add(base);
        }
        // 更新众数
        if (count > maxCount) {
            maxCount = count;
            list.clear();
            list.add(base);
        }
    }*/
}
