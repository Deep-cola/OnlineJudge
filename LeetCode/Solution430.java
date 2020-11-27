package LeetCode;

import java.util.Stack;

/**
 * @description: 扁平化多级双向链表
 * 多级双向链表中，除了指向下一个节点和前一个节点指针之外，它还有一个子链表指针，可能指向单独的双向链表。
 * 这些子列表也可能会有一个或多个自己的子项，依此类推，生成多级数据结构，
 * 给你位于列表第一级的头节点，请你扁平化列表，使所有结点出现在单级双链表中。
 *
 * 输入：head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * 1---2---3---4---5---6--NULL
 *          |
 *          7---8---9---10--NULL
 *              |
 *              11--12--NULL
 * 输出：[1,2,3,7,8,11,12,9,10,4,5,6]
 * @author: Deepcola
 * @time: 2020/11/26 16:00
 */
public class Solution430 {

    /**
     * Definition for a node
     */
    class Node {
        int val;
        Node prev;
        Node next;
        Node child;
    }

    /**
     * 将 head 所在一级视为第一级, 子链表所在一级看作下一级, 依次向下; 将有 child 的结点看作 "父结点"————递归
     * 1.没有 child 的结点不需要改变, 向后遍历即可, 有 child 的 "父结点" 去遍历 child 这一子链表
     * 2.递归进行上一操作, 由上而下, 也就是有 child 就先去遍历子链表, 直到最后一个子链表被遍历
     * 3.递归到最后一层子链表, 将末尾结点的 next 指向上一级 "父结点" 的下一个连接起来,
     *              ！！注意需要修改 "父结点" 的 child = null(否则不是一个双向链表, 因为还存在 child)
     * 4.由下而上, 将每一级的子链表的最后一个连接到响应位置, 直到回到第一级链表遍历完
     */
    /*public Node flatten(Node head) {
        if (head == null) return null;
        Node cur = head;
        while (cur != null) {
            // 没有 child 结点就保持原有连接
            if (cur.child == null) {
                cur = cur.next;
            }else {
                // 有 child 结点
                // 保存有 child 结点这一级的 next -> 连接子链表的最后一个结点
                Node curNext = cur.next;
                // 递归遍历所有的子链表, 并把子链表连接在子链表 "父结点"（上一级）后面
                Node child = flatten(cur.child);
                cur.next = child;
                child.prev = cur;
                cur.child = null;
                // 向后遍历以连接 "父结点" 这一级之后的结点
                while (cur.next != null) {
                    cur = cur.next;
                }
                // 将子链表最后一个结点连接在 curNext 之前
                if (curNext != null) {
                    cur.next = curNext;
                    curNext.prev = cur;
                }
            }
        }
        return head;
    }*/

    /**
     * 将多级双向链表看作是二叉树, head 就是根节点, 前序遍历即可————迭代
     * 1.定义 prev 结点用于记录当前弹出结点 cur 的前驱结点
     * 2.判断 cur 的 next 和 child 是否为空, 不为空入栈
     * 3.child 结点入栈后需要将其"父结点"的 child 修改为 null
     */
    public Node flatten(Node head) {
        if (head == null) return null;

        // 傀儡头结点
        Node dummyHead = new Node();
        // 记录遍历结点的前驱结点 -> 为了方便进行结点之间的连接
        Node prev = dummyHead;
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            // 弹出栈顶结点, 同时连接它和它的前驱结点
            Node temp = stack.pop();
            prev.next = temp;
            temp.prev = prev;
            // next 不为空入栈————相当于右子树
            if (temp.next != null) {
                stack.push(temp.next);
            }
            // child 不为空入栈————相当于左子树
            // 注意需要将 child 置为 null, 否则不是一个双向链表, 还存在 child
            if (temp.child != null) {
                stack.push(temp.child);
                temp.child = null;
            }
            // prev 跟着 temp 移动
            prev = temp;
        }
        // 头结点的前驱是 null
        dummyHead.next.prev = null;
        return dummyHead.next;
    }
}
