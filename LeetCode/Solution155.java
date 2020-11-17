package LeetCode;

import java.util.Stack;

/**
 * @description: 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *      push(x) —— 将元素 x 推入栈中。
 *      pop() —— 删除栈顶的元素。
 *      top() —— 获取栈顶元素。
 *      getMin() —— 检索栈中的最小元素。
 * @author: Deepcola
 * @time: 2020/11/16 18:05
 */
public class Solution155 {

    /**
     * 定义两个栈。一个用于正常 push、pop等，另一个用作最小栈，每次存放所有元素中的最小元素
     */
    class MinStack {
        private Stack<Integer> stack;
        private Stack<Integer> minStack;
        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        /**
         * 将元素压入栈中
         */
        public void push(int x) {
            // 将元素压入栈中
            stack.push(x);
            // 判断最小栈中是否需要放入元素
            if (minStack.isEmpty()) {
                minStack.push(x);
            }else {
                if (x <= minStack.peek()) {
                    minStack.push(x);
                }
            }
        }

        /**
         * 删除栈顶元素
         */
        public void pop() {
            // 弹出元素
            int temp = stack.pop();
            // 判断最小栈是否需要弹出元素
            if (temp == minStack.peek()) {
                minStack.pop();
            }
        }

        /**
         * 获取栈顶元素
         */
        public int top() {
            return stack.peek();
        }

        /**
         * 检索栈中最小元素
         */
        public int getMin() {
            return minStack.peek();
        }
    }

    public static void main(String[] args) {
        Solution155 solution = new Solution155();
        MinStack minStack = solution.new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}