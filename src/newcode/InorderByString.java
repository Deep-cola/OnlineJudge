package newcode;

/**
 * @description: 二叉树的创建及遍历
 * 编一个程序，读入用户输入的一串先序遍历字符串，根据此字符串建立一个二叉树（以指针方式存储）。
 * 例如如下的先序遍历字符串： ABC##DE#G##F### 其中“#”表示的是空格，空格字符代表空树。建立起此二叉树以后，再对二叉树进行中序遍历，输出遍历结果。
 *
 * 输入  abc##de#g##f###
 * 输出  c b e g d f a
 * @author: Deepcola
 * @time: 2020/11/19 13:51
 */
public class InorderByString {

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
     * 根据字符串创建二叉树
     * 根据前序遍历字符串: 第一个应该是根节点, 然后向下递归创建左子树和右子树
     * 输入  abc##de#g##f###
     * 输出  c b e g d f a
     */
    // 标记访问字符串的下标
    static int i = 0;
    public TreeNode createTreeByString(String str) {
        TreeNode root = null;
        if (str.charAt(i) == '#') {
            // 继续向后访问
            i++;
        }else {
            root = new TreeNode(str.charAt(i));
            i++;
            // 递归创建子树
            root.left = createTreeByString(str);
            root.right = createTreeByString(str);
        }
        return root;
    }

    /**
     * 中序遍历二叉树
     */
    public void inOrderTraversal(TreeNode root) {
        // 空树
        if (root == null) return;
        // 递归遍历
        inOrderTraversal(root.left);
        System.out.print(root.val + " ");
        inOrderTraversal(root.right);
    }


    public static void main(String[] args) {
        InorderByString inorderByString = new InorderByString();

        String str = "abc##de#g##f###";
        // 创建二叉树
        TreeNode root = inorderByString.createTreeByString(str);
        // 中序遍历
        inorderByString.inOrderTraversal(root);
    }
}
