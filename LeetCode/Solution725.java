package LeetCode;

/**
 * @description: 分割链表
 * 给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。
 * 每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。
 * 这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。
 * 返回一个符合上述规则的链表的列表。
 * 输入: root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
 * 输出: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
 * 解释:
 * @author: Deepcola
 * @time: 2020/11/28 15:27
 */
public class Solution725 {

    /**
     * Definition for singly-linked list
     */
    class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 1.遍历求节点个数
     * 2.对于将链表分割为 k 组, 每组元素 n=size/k 个, 又有 m=size%k 是多出来的节点, 那么前 m 组每组节点个数是 n+1
     * 3.遍历链表进行分割:
     *          1.每组第一个结点作为头结点
     *          2.前 m 组每组节点个数是 n+1; 后面的每组节点个数 n 个,
     *          3.在一组装完之后, 需要将每组最后一个元素的 next 置为 null
     */
    public ListNode[] splitListToParts(ListNode root, int k) {
        int size = 0;
        // 链表节点个数
        ListNode cur = root;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        // 计算每组平均的节点个数 n, 以及结点个数 (n+1) 的组数 m
        int n = size / k;
        int m = size % k;
        // 截取相应节点个数给响应数组
        ListNode[] nodes = new ListNode[k];
        // 前 m 组每组 n+1 个节点
        // 后面的每组 n 个节点
        for (int i = 0; i < k && root != null; i++) {
            nodes[i] = root;
            int temp = ((m-- > 0) ? n+1 : n);
            while (temp-- > 1) {
                root = root.next;
            }
            ListNode rootNext = root.next;
            // 分割链表
            root.next = null;
            root = rootNext;
        }
        return nodes;
    }
}
