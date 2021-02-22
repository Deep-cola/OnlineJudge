package leetcode;

/**
 * @description: 转换成小写字母
 * 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
 *
 * 示例 1：
 * 输入: "Hello"
 * 输出: "hello"
 *
 * 示例 2：
 * 输入: "here"
 * 输出: "here"
 *
 * 示例 3：
 * 输入: "LOVELY"
 * 输出: "lovely"
 * @author: Deepcola
 * @time: 2021/2/22 15:53
 */
public class Solution709 {

    /**
     * 使用函数
     */
    /*public String toLowerCase(String str) {
        return str.toLowerCase();
    }*/

    public String toLowerCase(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + 32);
            }
            result.append(ch);
        }
        return result.toString();
    }
}
