package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 设计前中后队列
 * 请你设计一个队列，支持在前，中，后三个位置的 push 和 pop 操作。
 * 请你完成 FrontMiddleBack 类：
 *      FrontMiddleBack() 初始化队列。
 *      void pushFront(int val) 将 val 添加到队列的 最前面 。
 *      void pushMiddle(int val) 将 val 添加到队列的 正中间 。
 *      void pushBack(int val) 将 val 添加到队里的 最后面 。
 *      int popFront() 将 最前面 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1 。
 *      int popMiddle() 将 正中间 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1 。
 *      int popBack() 将 最后面 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1 。
 * 请注意当有 两个 中间位置的时候，选择靠前面的位置进行操作。比方说：
 *      将 6 添加到 [1, 2, 3, 4, 5] 的中间位置，结果数组为 [1, 2, 6, 3, 4, 5] 。
 *      从 [1, 2, 3, 4, 5, 6] 的中间位置弹出元素，返回 3 ，数组变为 [1, 2, 4, 5, 6] 。
 * 输入：
 * ["FrontMiddleBackQueue", "pushFront", "pushBack", "pushMiddle", "pushMiddle", "popFront", "popMiddle", "popMiddle", "popBack", "popFront"]
 * [[], [1], [2], [3], [4], [], [], [], [], []]
 * 输出：
 * [null, null, null, null, null, 1, 3, 4, 2, -1]
 *
 * 解释：
 * FrontMiddleBackQueue q = new FrontMiddleBackQueue();
 * q.pushFront(1);   // [1]
 * q.pushBack(2);    // [1, 2]
 * q.pushMiddle(3);  // [1, 3, 2]
 * q.pushMiddle(4);  // [1, 4, 3, 2]
 * q.popFront();     // 返回 1 -> [4, 3, 2]
 * q.popMiddle();    // 返回 3 -> [4, 2]
 * q.popMiddle();    // 返回 4 -> [2]
 * q.popBack();      // 返回 2 -> []
 * q.popFront();     // 返回 -1 -> [] （队列为空）
 * @author: Deepcola
 * @time: 2020/12/14 12:39
 */
public class Solution1670 {

    /**
     * 使用 list 设计前中后队列
     */
    class FrontMiddleBackQueue {

        List<Integer> list;
        /** 初始化队列 */
        public FrontMiddleBackQueue() {
            list = new ArrayList<>(1000);
        }
        /** 将 val 添加到队列的 最前面  */
        public void pushFront(int val) {
            list.add(0, val);
        }
        /** 将 val 添加到队列的 正中间 */
        public void pushMiddle(int val) {
            int middle = list.size()/2;
            list.add(middle, val);
        }
        /** 将 val 添加到队列的 最后面 */
        public void pushBack(int val) {
            list.add(list.size(), val);
        }
        /** 将 最前面 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1 */
        public int popFront() {
            if (list.isEmpty()) {
                return -1;
            }
            return list.remove(0);
        }
        /** 将 正中间 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1 */
        public int popMiddle() {
            if (list.isEmpty()) {
                return -1;
            }
            return list.remove((list.size()-1) / 2);
        }
        /** 将 最后面 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1 */
        public int popBack() {
            if (list.isEmpty()) {
                return -1;
            }
            return list.remove(list.size()-1);
        }
    }


//    /**
//     * Definition for doubly-linked list
//     */
//    class ListNode {
//        int val;
//        ListNode prev;
//        ListNode next;
//        public ListNode(int val) {
//            this.val = val;
//        }
//    }
//
//    /**
//     * 使用 双向链表 设计前中后队列
//     */
//    class FrontMiddleBackQueue {
//
//        ListNode head;// 虚拟头节点
//        ListNode middle;// 中间节点
//        ListNode tail;// 虚拟尾结点
//        int size;
//        /** 初始化队列 */
//        public FrontMiddleBackQueue() {
//            this.size = 0;
//            head = new ListNode(0);
//            tail = new ListNode(0);
//            this.head.next = this.tail;
//            this.tail.prev = this.head;
//        }
//        /** 查找中间节点  */
//        public ListNode findPushMiddle() {
//            ListNode pHead = this.head;
//            ListNode pTail = this.tail;
//            while (pHead != pTail && pHead.next != pTail) {
//                pHead = pHead.next;
//                pTail =  pTail.prev;
//            }
//            return pTail;
//        }
//        public ListNode findPpoMiddle() {
//            ListNode pHead = this.head;
//            ListNode pTail = this.tail;
//            while (pHead != pTail && pHead.next != pTail) {
//                pHead = pHead.next;
//                pTail =  pTail.prev;
//            }
//            return pHead;
//        }
//
//
//        /** 将 val 添加到队列的 最前面  */
//        public void pushFront(int val) {
//            ListNode prev = this.head;
//            ListNode next = prev.next;
//            ListNode node = new ListNode(val);
//            prev.next = node;
//            node.next = next;
//            next.prev = node;
//            node.prev = prev;
//        }
//        /** 将 val 添加到队列的 正中间 */
//        public void pushMiddle(int val) {
//            ListNode middle = findPushMiddle();
//            ListNode prev = middle.prev;
//            ListNode node = new ListNode(val);
//            prev.next = node;
//            node.next = middle;
//            middle.prev = node;
//            node.prev = prev;
//        }
//        /** 将 val 添加到队列的 最后面 */
//        public void pushBack(int val) {
//            ListNode next = this.tail;
//            ListNode prev = next.prev;
//            ListNode node = new ListNode(val);
//            prev.next = node;
//            node.next = next;
//            next.prev = node;
//            node.prev = prev;
//        }
//        /** 将 最前面 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1 */
//        public int popFront() {
//            if (this.head == findPpoMiddle()) {
//                return -1;
//            }
//            int front = this.head.next.val;
//            ListNode next = this.head.next.next;
//            this.head.next = next;
//            next.prev = this.head;
//            return front;
//        }
//        /** 将 正中间 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1 */
//        public int popMiddle() {
//            ListNode middle = findPpoMiddle();
//            if (this.head == middle) {
//                return -1;
//            }
//            ListNode prev = middle.prev;
//            ListNode next = middle.next;
//            prev.next = next;
//            next.prev = prev;
//            return middle.val;
//        }
//        /** 将 最后面 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1 */
//        public int popBack() {
//            if (this.head == findPpoMiddle()) {
//                return -1;
//            }
//            int back = this.tail.prev.val;
//            ListNode prev = this.tail.prev.prev;
//            this.tail.prev = prev;
//            prev.next = this.tail;
//            return back;
//        }
//    }
}
