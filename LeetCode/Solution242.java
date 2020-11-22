package LeetCode;

import java.util.Arrays;

/**
 * @description: 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 :
 *      输入: s = "anagram", t = "nagaram"
 *      输出: true
 * @author: Deepcola
 * @time: 2020/11/22 0:03
 */
public class Solution242 {

    /**
     * 两个字符串转为数组排序, 相对应的位置字母应该是相同的, 不然就返回false；
     */
//    public boolean isAnagram(String s, String t) {
//        if (s.length() != t.length()) return false;
//        char[] chS = s.toCharArray();
//        char[] chT = t.toCharArray();
//        // 对两个字符串数组排序
//        Arrays.sort(chS);
//        Arrays.sort(chT);
//        return String.valueOf(chS).equals(String.valueOf(chT));
//        /*for (int i = 0; i < chS.length; i++) {
//            // 相对应位置字母不同就不是异位词
//            if (chS[i] != chT[i]) {
//                return false;
//            }
//        }
//        return true;*/
//    }

    /**
     * 哈希映射:
     *    1.判断两个字符串长度相等否？
     *    2.定义 alpha 装 26 个字母
     *    3.s 负责给字符相应位置 +1;t 负责给相应位置 -1
     *    4.遍历完成后 alpha 全为 0, 就是字母异位词
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] alpha = new int[26];
        // s 负责入, t 负责出
        for (int i = 0; i < s.length(); i++) {
            alpha[s.charAt(i) - 'a']++;
            alpha[t.charAt(i) - 'a']--;
        }
        for (int i: alpha) {
            if (i != 0) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        Solution242 solution = new Solution242();
        String s = "cat";
        String t = "cap";
        System.out.println(solution.isAnagram(s, t));
    }
}
