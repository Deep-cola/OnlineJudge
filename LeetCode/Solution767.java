package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @description: 重构字符串
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 * @author: Deepcola
 * @time: 2020/11/30 0:12
 */
public class Solution767 {

    /**
     * 1.统计每个字符出现的次数以及出现最多次数的字符 maxChar 和数量 maxValue
     * 2.分类讨论：
     *      1.如果 maxValue 大于长度的一半(+1) ； 说明不能使得相邻字符不同
     *      2.反之可行, 先将所有 maxChar 插入到偶数下标的位置;
     *        将剩下字符依次插入偶数下标位置, 如果下标越界了, 就令下标为 1 继续插入直至查完所有字符
     */
    /*public String reorganizeString(String S) {
        if (S == null || S.length() == 0) return "";
        int[] count = new int[26];
        int maxValue = 0; // 字符出现次数最多的数量
        char maxChar = 'a';// 出现次数最多的字符
        // 统计字符出现次数以及出现次数最多的字符
        for (int i = 0; i < S.length(); i++) {
            if (++count[S.charAt(i) - 'a'] > maxValue) {
                maxValue = count[S.charAt(i) - 'a'];
                maxChar = S.charAt(i);
            }
        }
        // 出现次数最多的超过了长度的一半, 必定不可行
        if (maxValue > (S.length()+1) / 2) {
            return "";
        }
        char[] result = new char[S.length()];
        // 运行到这里就说明可以插入
        // 先将次数最多的插入偶数下标, 然后依次分隔插入剩下的字符
        // 上一步下标越界时, 让从 1 号下标开始
        int index = 0;// 插入的下标
        for (int i = 0; i < maxValue; i++) {
            result[index] = maxChar;
            index += 2;
        }
        count[maxChar - 'a'] = 0;// 需要将已经插完元素置为 0
        for (int i = 0; i < 26; i++) {
            char ch = (char) (i + 'a');
            while (count[ch - 'a'] > 0) {
                if (index > S.length()-1) {
                    index = 1;
                }
                result[index] = ch;
                index += 2;
                count[ch - 'a']--;
            }
        }
        return new String(result);
    }*/

    /**
     * 1.统计每个字符出现的次数以及出现最多次数的字符 maxChar 和数量 maxValue
     * 2.分类讨论：
     *      1.如果 maxValue 大于长度的一半(+1) ； 说明不能使得相邻字符不同
     *      2.反之可行, 先将所有 maxChar 插入到偶数下标的位置;
     *        将剩下字符依次插入偶数下标位置, 如果下标越界了, 就令下标为 1 继续插入直至查完所有字符
     */

    /**
     * 定义一个类用于保存属性
     */
    static class NewChar {
        private int count;
        private char letter;
        public NewChar(char letter, int count) {
            this.letter = letter;
            this.count = count;
        }
    }
    public String reorganizeString(String S) {
        if (S == null || S.length() == 0) return "";
        int[] count = new int[26];
        int maxValue = 0; // 字符出现次数最多的数量
        // 统计字符出现次数以及出现次数最多的字符
        for (int i = 0; i < S.length(); i++) {
            maxValue = Math.max(++count[S.charAt(i) - 'a'], maxValue);
        }
        // 出现次数最多的超过了长度的一半, 必定不可行
        if (maxValue > (S.length()+1) / 2) {
            return "";
        }
        // 定义规则
        PriorityQueue<NewChar> queue = new PriorityQueue(new Comparator<NewChar>() {
            @Override
            public int compare(NewChar o1, NewChar o2) {
                return o2.count - o1.count;
            }
        });
        // 构建大根堆
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                queue.offer(new NewChar((char) ('a' + i), count[i]));
            }
        }
        // 重构字符串
        StringBuffer result = new StringBuffer();
        while (queue.size() > 1) {
            NewChar ch1 = queue.poll();
            NewChar ch2 = queue.poll();
            result.append(ch1.letter).append(ch2.letter);
            if (--ch1.count > 0) queue.offer(ch1);
            if (--ch2.count > 0) queue.offer(ch2);
        }
        if (queue.size() == 1) {
            result.append(queue.poll().letter);
        }
        return result.toString();
    }


    public static void main(String[] args) {
        Solution767 solution = new Solution767();
        String S = "abbabbaaab";
        System.out.println(solution.reorganizeString(S));
    }
}
