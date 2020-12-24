package leetcode;

/**
 * @description: 比较含有退格的字符串
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * @author: Deepcola
 * @time: 2020/11/16 22:50
 */
public class Solution844 {

    /**
     * 定义两个栈,遇到普通字符压栈, 遇到退格("#")时，根据情况弹出元素或者不变。最后比较是否相等
     */
    /*public boolean backspaceCompare(String S, String T) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        // 处理 S 字符串
        for (int i = 0; i < S.length(); i++) {
            // 不是退格符
            if (S.charAt(i) != '#') {
                stack1.push(S.charAt(i));
            }else {
                // 栈不为空时，弹出栈顶元素；栈为空时，退格符不做任何动作
                if (!stack1.isEmpty()) {
                    stack1.pop();
                }else {
                    continue;
                }
            }
        }
        // 处理 T 字符串
        for (int i = 0; i < T.length(); i++) {
            // 不是退格符
            if (T.charAt(i) != '#') {
                stack2.push(T.charAt(i));
            }else {
                if (!stack2.isEmpty()) {
                    stack2.pop();
                }else {
                    continue;
                }
            }
        }
        // 栈长度不一样时肯定不相同
        if (stack1.size() == stack2.size()) {
            // 弹出元素不一样就不相同
            while (!stack1.isEmpty()) {
                if (stack1.pop() != stack2.pop()) return false;
            }
        }else {
            return false;
        }
        return true;
    }*/

    /**
     * 使用 StringBuffer 来处理字符串。遇到普通字符就连接到后面; 遇到‘#’就根据情况删除字符或者不变
     */
    public boolean backspaceCompare(String S, String T) {
        return reBuildString(S).equals(reBuildString(T));
    }

    /**
     * 处理字符串 -> 重构字符串方法
     */
    public String reBuildString(String str) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            // 普通字符
            if (str.charAt(i) != '#') {
                sb.append(str.charAt(i));
            }else {
                // 判断是否能够删除一个字符
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }else {
                    continue;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String S = "##a";
        String T ="a##";
        Solution844 solution = new Solution844();
        System.out.println(solution.backspaceCompare(S, T));
    }
}
