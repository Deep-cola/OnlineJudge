package leetcode;

/**
 * @description: 设计链表
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。
 * 如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 * 在链表类中实现这些功能：
 *      get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 *      addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 *      addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 *      addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 *      deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 * @author: Deepcola
 * @time: 2020/12/13 17:11
 */
public class Solution707 {

//    /**
//     * Definition for singly-linked list
//     */
//    class ListNode {
//        int val;
//        ListNode next;
//        public ListNode(int val) {
//            this.val = val;
//        }
//    }
//    class MyLinkedList {
//        ListNode head;
//        int size;
//        /** Initialize your data structure here. */
//        public MyLinkedList() {
//            this.size = 0;
//            this.head = new ListNode(0);
//        }
//
//        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
//        public int get(int index) {
//            if (index < 0 || index >= size) {
//                return -1;
//            }
//            ListNode cur = this.head;
//            for (int i = 0; i <= index; i++) {
//                cur = cur.next;
//            }
//            return cur.val;
//        }
//
//        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
//        public void addAtHead(int val) {
//            this.addAtIndex(0, val);
//        }
//
//        /** Append a node of value val to the last element of the linked list. */
//        public void addAtTail(int val) {
//            this.addAtIndex(size, val);
//        }
//
//        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
//        public void addAtIndex(int index, int val) {
//            if (index > this.size) return;
//            if (index < 0) index = 0;
//            size++;
//            ListNode prev = this.head;
//            ListNode node = new ListNode(val);
//            for (int i = 0; i < index; i++) {
//                prev = prev.next;
//            }
//            node.next = prev.next;
//            prev.next = node;
//        }
//
//        /** Delete the index-th node in the linked list, if the index is valid. */
//        public void deleteAtIndex(int index) {
//            if (index < 0 || index >= this.size) return;
//            ListNode cur = this.head;
//            for (int i = 0; i < index; i++) {
//                cur = cur.next;
//            }
//            cur.next = cur.next.next;
//            this.size--;
//        }
//    }

    /**
     * Definition for doubly-linked list
     */
    class ListNode {
        int val;
        ListNode prev;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    class MyLinkedList {
        ListNode head;// 虚拟头节点
        ListNode tail;// 虚拟尾结点
        int size;
        /** Initialize your data structure here. */
        public MyLinkedList() {
            this.size = 0;
            this.head = new ListNode(0);
            this.tail = new ListNode(0);
            this.head.next = this.tail;
            this.tail.prev = this.head;
        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
            if (index < 0 || index >= this.size) return -1;
            ListNode cur = this.head;
            // 头部开始还是尾部开始
            if (index + 1 < this.size - index){
                for (int i = 0; i < index+1; i++) {
                    cur = cur.next;
                }
            }else {
                cur = this.tail;
                for (int i = 0; i < size-index; i++) {
                    cur = cur.prev;
                }
            }
            return cur.val;
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
            ListNode prev = this.head;
            ListNode next = prev.next;
            ListNode node = new ListNode(val);
            prev.next = node;
            node.next = next;
            next.prev = node;
            node.prev = prev;
            this.size++;
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            ListNode next = this.tail;
            ListNode prev = next.prev;
            ListNode node = new ListNode(val);
            prev.next = node;
            node.next = next;
            next.prev = node;
            node.prev = prev;
            this.size++;
        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            if (index > this.size) return;
            if (index < 0) index = 0;
            ListNode prev,next;// 插入位置的前驱后继
            // 判断头部遍历还是尾部遍历
            if (index < this.size - index) {
                prev = this.head;
                for (int i = 0; i < index; i++) {
                    prev = prev.next;
                }
                next = prev.next;
            }else {
                next = this.tail;
                for (int i = 0; i < size-index; i++) {
                    next = next.prev;
                }
                prev = next.prev;
            }
            size++;
            ListNode node = new ListNode(val);
            prev.next = node;
            node.next = next;
            next.prev = node;
            node.prev = prev;
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            if (index < 0 || index >= this.size) return;
            // 判断头部遍历还是尾部遍历
            ListNode prev, next;
            if (index < this.size - index) {
                prev = this.head;
                for (int i = 0; i < index; i++) {
                    prev = prev.next;
                }
                next = prev.next.next;
            }else {
                next = this.tail;
                for (int i = 0; i < size-index-1; i++) {
                    next = next.prev;
                }
                prev = next.prev.prev;
            }
            prev.next = next;
            next.prev = prev;
            this.size--;
        }
    }
}
