package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 用队列实现栈
 * 使用队列实现栈的下列操作：
 *      push(x) -- 元素 x 入栈
 *      pop() -- 移除栈顶元素
 *      top() -- 获取栈顶元素
 *      empty() -- 返回栈是否为空
 * 注意:
 *      你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 *      你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 *      你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 * @author: Deepcola
 * @time: 2020/11/16 16:58
 */

public class Solution225 {

    /**
     * 使用两个队列实现栈
     *      push(x) -- 元素进入有元素队列，
     *      pop() -- 除了队尾元素，其他全部元素进入另一空队列，队尾元素弹出
     *      top() -- 全部元素进入空队列
     *      empty() -- 判断两个队列是否全为空
     */
    class MyStack {
        private Queue<Integer> queue1;
        private Queue<Integer> queue2;

        /** Initialize your data structure here. */
        public MyStack() {
            queue1 = new LinkedList();
            queue2 = new LinkedList();
        }

        /** Push element x onto stack. */
        /**
         * 元素 x 应进入有元素队列以保证后续操作
         */
        public void push(int x) {
            // 栈为空 - 两个队列都为空
            if (empty()) {
                queue1.offer(x);
                return;
            }
            // 进入不为空的队列
            if (queue1.isEmpty()) {
                queue2.offer(x);
            }else {
                queue1.offer(x);
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            // 栈为空
            if (empty()) return -1;
            // 除了最后一个元素全部元素进入空队列
            if (!queue1.isEmpty()) {
                while (queue1.size() > 1) {
                    queue2.offer( queue1.poll());
                }
                return queue1.poll();
            }else {
                while (queue2.size() > 1) {
                    queue1.offer( queue2.poll());
                }
                return queue2.poll();
            }
        }

        /** Get the top element. */
        public int top() {
            if (empty()) return -1;
            if (!queue1.isEmpty()) {
                while (queue1.size() > 1) {
                    queue2.offer( queue1.poll());
                }
                // 记住最后一个元素
                int temp = queue1.poll();
                queue2.offer(temp);
                return temp;
            }else {
                while (queue2.size() > 1) {
                    queue1.offer( queue2.poll());
                }
                int temp = queue2.poll();
                queue1.offer(temp);
                return temp;
            }
        }

        /** Returns whether the stack is empty. */
        /**
         * 两个队列都为空时栈为空
         */
        public boolean empty() {
            return queue1.isEmpty() && queue2.isEmpty();
        }
    }

    public static void main(String[] args) {
        Solution225 solution = new Solution225();
        MyStack myStack = solution.new MyStack();
        myStack.push(1);
        myStack.push(2);

        System.out.println(myStack.empty());
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());

    }
}
