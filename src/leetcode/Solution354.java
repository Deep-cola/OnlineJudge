package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 俄罗斯套娃信封问题
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 *
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 * 说明:
 * 不允许旋转信封。
 *
 * 示例:
 *
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 * @author: Deepcola
 * @time: 2021/3/4 14:24
 */
public class Solution354 {

    /**
     * 动态规划
     */
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) return 0;
        Arrays.sort(envelopes, (a, b) -> {
            return (a[0] == b[0]) ? (b[1] - a[1]) : (a[0] - b[0]);
        });
        List<Integer> result = new ArrayList<>();
        result.add(envelopes[0][1]);
        for (int i = 1; i < envelopes.length; i++) {
            int num = envelopes[i][1];
            if (num > result.get(result.size() - 1)) {
                result.add(num);
            }else {
                int index = binarySearch(result, num);
                result.set(index, num);
            }
        }
        return result.size();
    }

    private int binarySearch(List<Integer> result, int target) {
        int left = 0;
        int right = result.size() - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (result.get(mid) < target) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left;
    }
}
