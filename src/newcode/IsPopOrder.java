package newcode;

import java.util.Stack;

/**
 * @description: 栈的压入弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。（注意：这两个序列的长度是相等的）
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * @author: Deepcola
 * @time: 2020/11/16 20:09
 */
public class IsPopOrder {

    /**
     * 定义一个栈用来模拟弹出序列,与 popA 的定位下标元素相等就出栈，不同就入栈，直到遍历完 popA ,查看栈是否为空
     */
    public boolean ispopOrder(int [] pushA,int [] popA) {
        if (pushA.length != popA.length) return false;
        Stack<Integer> stack = new Stack<>();
        // 标记 popA 遍历的位置下标
        int index = 0;
        for (int i = 0; i < pushA.length; i++) {
            // pushA 来一个进一个
            stack.push(pushA[i]);
            // 判断栈顶元素和弹出序列的 index 下标元素是否一致，如果一致就弹出栈顶元素，index+1 ,继续比较两者
            while (!stack.isEmpty() && popA[index] == stack.peek()) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        int[] pushA = {1,2,3,4,5};
        int[] popA = {4,3,5,1,2};
        IsPopOrder isPopOrder = new IsPopOrder();
        System.out.println(isPopOrder.ispopOrder(pushA, popA));
    }
}
