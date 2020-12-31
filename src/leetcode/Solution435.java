package leetcode;

import java.util.Arrays;

/**
 * @description: 无重叠区间
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * 注意:
 *      可以认为区间的终点总是大于它的起点。
 *      区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 *
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 * 输出: 1
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 *
 * 输入: [ [1,2], [1,2], [1,2] ]
 * 输出: 2
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 *
 * 输入: [ [1,2], [2,3] ]
 * 输出: 0
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 * @author: Deepcola
 * @time: 2020/12/31 7:14
 */
public class Solution435 {

    /**
     * 贪心算法:
     *      1.按照结束坐标升序排序
     *      2.寻找不重复的区间个数
     */
    /*public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        // 自定义排序: 按照 end 升序排序
        Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1]);
        int count = 1;// 至少一个区间
        int end  = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            // 区间不重复
            if (intervals[i][0] >= end) {
                count++;
                end = intervals[i][1];
            }
        }
        return intervals.length - count;
    }*/


    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        // 排序 -> 根据开始坐标
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        // 判断
        int count = 0;// 删除区间数量
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                // 新区间
                end = intervals[i][1];
            }else {
                // 区间重复 -> 保留较小的区间
                count++;
                end = Math.min(end, intervals[i][1]);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution435 solution = new Solution435();
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        System.out.println(solution.eraseOverlapIntervals(intervals));
    }
}
