package LeetCode;

/**
 * @description: 扁平化多级双向链表
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
     *
     */
    public Node flatten(Node head) {
        if (head == null) return null;
        Node cur = head;
        while (cur.next != null) {
            if (cur.child == null) {
                cur = cur.next;
            }else {
                cur.next = cur.child;
                cur.child.prev = cur;
                flatten(cur.child);
            }
        }

    }
}
