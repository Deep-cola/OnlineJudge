package leetcode;

import java.util.HashMap;

/**
 * @description: 复杂链表的复制
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 *
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * @author: Deepcola
 * @time: 2020/11/27 16:28
 */
public class Offer35 {

    /**
     * Definition for a Node.
     */
    class Node {
        int val;
        Node next;
        Node random;
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
     * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
     *
     * 使用 hashMap 存放新旧结点的地址, 举个例子
     * node     0       1       2       3       4
     * val      7       13      11      10      1
     * next     13      11      10      1       null
     * random   null    0       4       2       0
     *
     * key      0     1     2     3     4
     * value    a     b     c     d     e
     *
     * 很明显: 使用 map.get(key) 可以得到 value(node),给 value 的 next 和 random 进行复制
     *      map.get(cur).next = map.get(cur.next);
     *      map.get(cur).random = map.get(cur.random);
     */
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        // 将新旧结点装入 map
        while (cur != null) {
            // 根据结点的值创建新结点
            Node node = new Node(cur.val);
            map.put(cur, node);
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            // 看图很明显
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

}
