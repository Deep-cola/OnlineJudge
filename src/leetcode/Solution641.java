package leetcode;

/**
 * @description: 设计循环双端队列
 * 设计实现双端队列。
 * 你的实现需要支持以下操作：
 *      MyCircularDeque(k)：构造函数,双端队列的大小为k。
 *      insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
 *      insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
 *      deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
 *      deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
 *      getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
 *      getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
 *      isEmpty()：检查双端队列是否为空。
 *      isFull()：检查双端队列是否满了。
 * @author: Deepcola
 * @time: 2020/11/16 23:26
 */
public class Solution641 {
    class MyCircularDeque {
        private int[] elem;
        private int usedSize;
        private int front;
        private int rear;

        /** Initialize your data structure here. Set the size of the deque to be k. */
        public MyCircularDeque(int k) {
            // 多出一个空间是为了区分 front == rear 时为空还是满了
            this.elem = new int[k + 1];
        }

        /** Adds an item at the front of Deque. Return true if the operation is successful. */
        public boolean insertFront(int value) {
            // 队列已满
            if (isFull()) return false;
            // 需要判断队列当前 front 所在下标是否为 0
            this.front = (this.front == 0) ? this.elem.length - 1 : this.front - 1 ;
            this.elem[this.front] = value;
            return true;
        }

        /** Adds an item at the rear of Deque. Return true if the operation is successful. */
        public boolean insertLast(int value) {
            // 队列已满
            if (isFull()) return false;
            // 插入元素，尾部指针后移(需要判断下一个位置下标)
            this.elem[this.rear] = value;
            this.rear = (this.rear + 1) % this.elem.length;
            return true;
        }

        /** Deletes an item from the front of Deque. Return true if the operation is successful. */
        public boolean deleteFront() {
            // 队列为空
            if (isEmpty()) return false;
            // 判断头部指针下一个下标位置
            this.front = (this.front + 1) % this.elem.length;
            return true;
        }

        /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
        public boolean deleteLast() {
            // 队列为空
            if (isEmpty()) return false;
            // 判断尾部指针下一个下标位置
            this.rear = (this.rear == 0) ? this.elem.length - 1 : this.rear - 1;
            return true;
        }

        /** Get the front item from the deque. */
        public int getFront() {
            // 队列为空
            if (isEmpty()) return -1;
            return this.elem[this.front];
        }

        /** Get the last item from the deque. */
        public int getRear() {
            // 队列为空
            if (isEmpty()) return -1;
            return this.elem[this.rear == 0 ? this.elem.length - 1 : this.rear - 1];
        }

        /** Checks whether the circular deque is empty or not. */
        public boolean isEmpty() {
            return this.front == this.rear;
        }

        /** Checks whether the circular deque is full or not. */
        public boolean isFull() {
            return this.front == (this.rear + 1) % this.elem.length;
        }
    }

    public static void main(String[] args) {
        Solution641 solution = new Solution641();
        MyCircularDeque myCircularDeque = solution.new MyCircularDeque(3);
        myCircularDeque.insertLast(1);
        myCircularDeque.insertLast(2);
        myCircularDeque.insertFront(3);
        myCircularDeque.insertFront(4);
        System.out.println(myCircularDeque.getRear());
        System.out.println(myCircularDeque.isFull());
        System.out.println(myCircularDeque.deleteLast());
        myCircularDeque.insertFront(4);
        System.out.println(myCircularDeque.getFront());
    }
}
