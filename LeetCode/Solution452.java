package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @description: 用最少量的箭引爆气球
 * 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。
 * 由于它是水平的，所以纵坐标并不重要，因此只要知道开始和结束的横坐标就足够了。开始坐标总是小于结束坐标。
 * 一支弓箭可以沿着 x 轴从不同点完全垂直地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，
 * 则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
 * 给你一个数组 points ，其中 points [i] = [xstart,xend] ，返回引爆所有气球所必须射出的最小弓箭数。
 * @author: Deepcola
 * @time: 2020/11/23 23:38
 */
public class Solution452 {

    /**
     * 随机射出一支箭，假设它可以引爆气球, 那么它可以活动的范围最大就是这个气球的直径坐标范围
     * 1.按照气球结束坐标的大小从小到大排序
     * 2.第一支射出的箭最远只能到 pos[0][1]
     * 3.这个时候所有开始坐标小于这个位置的都可以被引爆, 不需要再增加箭
     * 4.当有一个气球开始坐标大于上一支箭的坐标时, 需要再射出一支, 而最好的射出位置就是新气球的结束坐标
     * 5.遍历数组进行比较即可
     */
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0 ) return 0;
        // 从小到大
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] > o2[1]) {
                    return 1;
                }else if (o1[1] < o2[1]) {
                    return -1;
                }else {
                    return 0;
                }
            }
        });

        // 至少一支箭
        int arrow = 1;
        int pos = points[0][1];
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] > pos) {
                arrow++;
                pos = points[i][1];
            }
        }
        return arrow;
    }


}
