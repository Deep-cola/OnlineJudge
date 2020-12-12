package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 复制带随机指针的链表
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * 要求返回这个链表的 深拷贝。 
 * 我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 *
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * @author: Deepcola
 * @time: 2020/12/12 18:00
 */
public class Solution138 {

    /**
     * Definition for a node
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
     * 两次 map: 一次存放, 一次获取
     *          00      11     22      33     44
     *          0       1      2       3      4
     *          null    22     33      null   44
     * 1.存放
     *      key     00  11  22  33  44
     *      value   aa  bb  cc  dd  ee
     * 2.获取
     */
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        // 存放
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        // 获取
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
