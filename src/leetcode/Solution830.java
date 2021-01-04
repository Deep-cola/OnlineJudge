package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 较大分组位置
 * 在一个由小写字母构成的字符串 s 中，包含由一些连续的相同字符所构成的分组。
 * 例如，在字符串 s = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
 * 分组可以用区间 [start, end] 表示，其中 start 和 end 分别表示该分组的起始和终止位置的下标。上例中的 "xxxx" 分组用区间表示为 [3,6] 。
 * 我们称所有包含大于或等于三个连续字符的分组为 较大分组 。
 * 找到每一个 较大分组 的区间，按起始位置下标递增顺序排序后，返回结果。
 *
 * 输入：s = "abbxxxxzzy"
 * 输出：[[3,6]]
 * 解释："xxxx" 是一个起始于 3 且终止于 6 的较大分组。
 *
 * 输入：s = "abc"
 * 输出：[]
 * 解释："a","b" 和 "c" 均不是符合要求的较大分组。
 *
 * 输入：s = "abcdddeeeeaabbbcd"
 * 输出：[[3,5],[6,9],[12,14]]
 * 解释：较大分组为 "ddd", "eeee" 和 "bbb"
 *
 * 输入：s = "aba"
 * 输出：[]
 *  
 * 提示：
 *      1 <= s.length <= 1000
 *      s 仅含小写英文字母
 * @author: Deepcola
 * @time: 2021/1/5 0:01
 */
public class Solution830 {
    /**
     * 一次遍历
     */
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() - 1 || s.charAt(i) != s.charAt(i + 1)) {
                // 此时 i 是最后一个与前面字符同分组的 或者 是遍历至字符串结尾
                if (i - start >= 2) {
                    result.add(Arrays.asList(start, i));
                }
                start = i + 1;
            }
        }
        return result;
    }

    /**
     * 模拟
     */
    /*public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();
        int start = 0;
        while (start < s.length()) {
            int end = start;
            // 查找连续相同的结尾字符
            while (end < s.length() && s.charAt(end) == s.charAt(start)) {
                end++;
            }
            // 长度不够
            if (end - start < 3) {
                start = end;
                continue;
            }else {
                // 添加
                List<Integer> list = new ArrayList<>();
                list.add(start);
                list.add(end - 1);
                result.add(list);
                start = end;
            }
        }
        return result;
    }*/
}
