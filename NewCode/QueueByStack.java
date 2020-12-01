package NewCode;

import java.util.Stack;

/**
 * @description: 用栈实现队列
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * @author: Deepcola
 * @time: 2020/12/1 18:08
 */
public class QueueByStack {
    Stack<Integer> stack1 = new Stack<>();// 入
    Stack<Integer> stack2 = new Stack<>();// 出
    public void push(int val) {
        stack1.push(val);
    }

    public int pop() {
        if (stack2.isEmpty() && stack1.isEmpty()) {
            throw new RuntimeException("Queue is Empty");
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
