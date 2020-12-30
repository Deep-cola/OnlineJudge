package leetcode;

/**
 * @description: 取出重复字母
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * 输入：s = "bcabc"
 * 输出："abc"
 *
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 * @author: Deepcola
 * @time: 2020/12/20 0:27
 */
public class Solution316 {

    /**
     * 1.首先记录每个字符出现的最后一次下标 lastIndex
     * 2.维护栈: 如果栈中已经有了该元素
     *                  就舍弃当前元素;
     *          如果栈中没有当前元素
     *                  是最小字典序(当前元素大于栈顶元素) -> 压栈
     *                  不是最小字典序 -> 判断后面是否还有栈顶元素(lastIndex > i)
     *                                          有的话就可以弹出当前元素
     */
    /*public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];// 最后一次出现的下标
        boolean[] flag = new boolean[26];// 栈中是否出现
        // 标记元素最后一次出现的下标
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        Stack<Character> stack = new Stack<>();
        // 维护栈
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // 栈中已经存在 -> 舍弃
            if (flag[ch - 'a']) {
                continue;
            }
            // 不满足字典序, 同时后面还有栈顶元素 -> 弹出栈顶元素 + 栈中已存在
            while (!stack.isEmpty() && stack.peek() > ch && lastIndex[stack.peek() - 'a'] > i) {
                char temp = stack.pop();
                // 已经弹出 -> 栈中存在
                flag[temp - 'a'] = false;
            }
            // 当前元素压栈 + 当前元素已经存在
            stack.push(ch);
            flag[ch - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }*/

    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];// 计数数组
        boolean[] flag = new boolean[26];// 栈中是否已存在
        // 计数
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        // 维护
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // "栈"中不存在
            if (!flag[ch - 'a']) {
                // 不满足最小字典序并且后面还有该元素
                while (sb.length() > 0 && sb.charAt(sb.length()-1) > ch && count[sb.charAt(sb.length()-1) - 'a'] > 0) {
                    // 不存在了
                    flag[sb.charAt(sb.length()-1) - 'a'] = false;
                    // 删除
                    sb.deleteCharAt(sb.length()-1);
                }
                // 进去
                sb.append(ch);
                flag[ch - 'a'] = true;
            }
            // 存在不存在都这个元素都已经遍历过
            count[ch - 'a']--;
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        Solution316 solution = new Solution316();
        String s = "cbacdcbc";
        System.out.println(solution.removeDuplicateLetters(s));
    }
}
