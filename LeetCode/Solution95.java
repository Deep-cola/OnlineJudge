package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 不同的二叉搜索树Ⅱ
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 * 输入：3
 * 输出：
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释：
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * @author: Deepcola
 * @time: 2020/12/23 16:41
 */
public class Solution95 {

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
     * 二叉搜索树中序遍历有序, 换一句话说: 根节点的左子树都比他小, 右子树都比他大
     * 所以将遍历的 i 作为根节点: 左子树区间(start, i-1); 右子树区间(i+1, end)
     *      递归求出所有可行的左子树和右子树, 然后分别从中取出一个进行组合, 将组合后的二叉树加入列表返回
     */
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return generateTree(1, n);
    }

    /**
     * 递归
     */
    public List<TreeNode> generateTree(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        // 终止条件
        if (start > end) {
            list.add(null);
            return list;
        }
        // 单层动作: 尝试每个节点作为根节点
        for (int i = start; i <= end; i++) {
            // 遍历查询所有可行的左子树和右子树
            List<TreeNode> leftTree = generateTree(start, i - 1);
            List<TreeNode> rightTree = generateTree(i + 1, end);
            // 左子树和右子树各取一个进行组合
            for (TreeNode left: leftTree) {
                for (TreeNode right: rightTree) {
                    // 为什么放在这里?
                    // 如果放在上面，由于在取组合里面每次都会取出一个新的左右子树组合, 需要及时更新根节点，以防止共用根节点。
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
