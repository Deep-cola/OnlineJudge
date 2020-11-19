package LeetCode;

/**
 * @description: 根据二叉树创建字符串
 * 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
 * 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
 *
 * 输入: 二叉树: [1,2,3,4]
 *        1
 *      /   \
 *     2     3
 *    /
 *   4
 * 输出: "1(2(4))(3)"
 * 解释: 原本将是“1(2(4)())(3())”，在你省略所有不必要的空括号对之后，它将是“1(2(4))(3)”。
 * @author: Deepcola
 * @time: 2020/11/19 19:04
 */
public class Solution606 {
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
     * 1.当前节点有两个孩子: 两个孩子结果外都要加一层括号;
     * 2.当前节点没有孩子: 节点后面不需要加括号;
     * 3.只有左孩子: 左孩子加括号;
     * 4.只有右孩子: 前面加一对括号
     */
   /* public String tree2str(TreeNode t) {
        // 空树
        if (t == null) return "";
        // 没有孩子
        if (t.left == null && t.right == null) return t.val + "";
        // 只有左孩子
        if (t.right == null) return t.val + "(" + tree2str(t.left) + ")";
        // 只有右孩子
        return t.val + "(" + tree2str(t.left) + ")(" + tree2str(t.right) + ")";
    }*/


    /**
     * 根据二叉树创建字符串
     */
    public String tree2str(TreeNode t) {
        // 空树
        if (t == null) return "";
        StringBuffer sb = new StringBuffer();
        tree2strChild(t, sb);
        return sb.toString();
    }

    /**
     * 1.左数为空，右树不为空 -> 需要打印一对"()"；
     * 2.左树为空，右树为空 -> 无操作
     * 3.左树不为空  -> 打印"(val)"
     * 首先需要连接根节点。然后基于前序遍历方式，先判断左树是否为空，不为空连接"(val)"; 为空就判断右树是否为空，右树不为空，连接"()"，右树为空就进行下个节点遍历
     */
    public void tree2strChild(TreeNode t, StringBuffer sb) {
        // 根结点
        sb.append(t.val);
        // 左树不为空
        if (t.left != null) {
            sb.append("(");
            tree2strChild(t.left, sb);
            sb.append(")");
        }else {
            // 左树为空
            // 右树不为空
            if (t.right != null) {
                sb.append("()");
            }else {
                return;
            }
        }
        // 右树不为空
        if (t.right != null) {
            sb.append("(");
            tree2strChild(t.right, sb);
            sb.append(")");
        }
    }
}
