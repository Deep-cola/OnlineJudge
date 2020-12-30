package leetcode;

import java.util.Stack;

/**
 * @description: 使用栈实现队列
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列的支持的所有操作（push、pop、peek、empty）：
 * 实现 MyQueue 类：
 *      void push(int x) 将元素 x 推到队列的末尾
 *      int pop() 从队列的开头移除并返回元素
 *      int peek() 返回队列开头的元素
 *      boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * 说明：
 *      你只能使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 *      你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * @author: Deepcola
 * @time: 2020/11/16 17:38
 */
public class Solution232 {

    /**
     * 使用两个栈实现队列(先进先出)
     * void push(int x) : 插入元素时，将所有元素弹出到另一个为空的栈中，保证每次进入时都在队列末尾,然后将所有元素返回到原来的栈
     * int pop() : 弹出栈顶元素
     * int peek() : 查看栈顶元素
     * boolean empty() : 两个栈都为空时，队列为空
     */
    class MyQueue {
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        /** Initialize your data structure here. */
        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            // 将非空栈的所有元素移至另一空栈，插入元素后再将所有元素弹回原来的栈
            if (stack1.isEmpty()) {
                while (!stack2.isEmpty()) {
                    stack1.push(stack2.pop());
                }
                stack1.push(x);
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }else {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
                stack2.push(x);
                while (!stack2.isEmpty()) {
                    stack1.push(stack2.pop());
                }
            }
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            // 队列为空
            if (empty()) return -1;
            // 弹出非空栈的栈顶元素
            if (stack1.isEmpty()) {
                return stack2.pop();
            }else {
                return stack1.pop();
            }
        }

        /** Get the front element. */
        public int peek() {
            // 队列为空
            if (empty()) return -1;
            // 查看非空栈的栈顶元素
            if (stack1.isEmpty()) {
                return stack2.peek();
            }else {
                return stack1.peek();
            }
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }
    }

    public static void main(String[] args) {
        Solution232 solution = new Solution232();
        MyQueue myQueue = solution.new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);

        System.out.println(myQueue.pop());
    }
}
