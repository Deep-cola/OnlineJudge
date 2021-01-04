package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();
        int[] count = new int[26];
        // 数组计数
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        System.out.println(Arrays.toString(count));
        int index = 0;
        while (index < s.length()) {
            char ch = s.charAt(index);
            if (count[ch - 'a'] >= 3) {
                List<Integer> list = new ArrayList<>();
                list.add(index);
                list.add(index + count[ch - 'a'] - 1);
                result.add(list);
            }
            index = index + count[ch - 'a'] - 1;
        }
        Collections.sort(result, (o1, o2) -> {
            return o1.get(0) - o2.get(0);
        });
        return result;
    }
}
