package leetcode;

import java.util.Stack;

/**
 * @description: 棒球比赛
 * 你现在是一场采特殊赛制棒球比赛的记录员。这场比赛由若干回合组成，过去几回合的得分可能会影响以后几回合的得分。
 * 比赛开始时，记录是空白的。你会得到一个记录操作的字符串列表 ops，其中 ops[i] 是你需要记录的第 i 项操作，ops 遵循下述规则：
 * 整数 x - 表示本回合新获得分数 x
 *   "+" - 表示本回合新获得的得分是前两次得分的总和。题目数据保证记录此操作时前面总是存在两个有效的分数。
 *   "D" - 表示本回合新获得的得分是前一次得分的两倍。题目数据保证记录此操作时前面总是存在一个有效的分数。
 *   "C" - 表示前一次得分无效，将其从记录中移除。题目数据保证记录此操作时前面总是存在一个有效的分数。
 * 请你返回记录中所有得分的总和。
 * @author: Deepcola
 * @time: 2020/11/16 22:34
 */
public class Solution682 {

    /**
     * 使用栈实现各种操作:
     * 整数 x - 分数入栈
     *   "+" - 查看栈顶两个元素相加以后结果入栈
     *   "D" - 获取栈顶元素，*2入栈
     *   "C" - 弹出栈顶元素
     */
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < ops.length; i++) {
            String temp = ops[i];
            switch (temp) {
                case "+":
                    int oldScore = stack.pop();
                    int newScore = oldScore + stack.peek();
                    stack.push(oldScore);
                    stack.push(newScore);
                    break;
                case "D":
                    stack.push(stack.peek() * 2);
                    break;
                case "C":
                    stack.pop();
                    break;
                default:
                    stack.push(Integer.parseInt(temp));
            }
        }
        int score = 0;
        while (!stack.isEmpty()) {
            score += stack.pop();
        }
        return score;
    }


    public static void main(String[] args) {
        Solution682 solution = new Solution682();
        String[] ops = {"5","-2","4","C","D","9","+","+"};
        System.out.println(solution.calPoints(ops));
    }
}
