package leetcode;

import java.util.Arrays;

/**
 * @description: 火车上的最大单元数
 * 请你将一些箱子装在 一辆卡车 上。给你一个二维数组 boxTypes ，其中 boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi] ：
 *      numberOfBoxesi 是类型 i 的箱子的数量。
 *      numberOfUnitsPerBoxi 是类型 i 每个箱子可以装载的单元数量。
 * 整数 truckSize 表示卡车上可以装载 箱子 的 最大数量 。只要箱子数量不超过 truckSize ，你就可以选择任意箱子装到卡车上。
 * 返回卡车可以装载 单元 的 最大 总数。
 *
 * 输入：boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
 * 输出：8
 * 解释：箱子的情况如下：
 * - 1 个第一类的箱子，里面含 3 个单元。
 * - 2 个第二类的箱子，每个里面含 2 个单元。
 * - 3 个第三类的箱子，每个里面含 1 个单元。
 * 可以选择第一类和第二类的所有箱子，以及第三类的一个箱子。
 * 单元总数 = (1 * 3) + (2 * 2) + (1 * 1) = 8
 *
 * 输入：boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10
 * 输出：91
 *
 * 提示：
 *      1 <= boxTypes.length <= 1000
 *      1 <= numberOfBoxesi, numberOfUnitsPerBoxi <= 1000
 *      1 <= truckSize <= 106
 * @author: Deepcola
 * @time: 2021/1/3 15:09
 */
public class Solution5641 {

    /**
     * 贪心算法
     */
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // 排序
        Arrays.sort(boxTypes, (o1, o2) -> {
            return o2[1] - o1[1];
        });
        // 贪心
        int result = 0;
        for (int[] box: boxTypes) {
            if (truckSize > 0) {
                int num = Math.min(truckSize, box[0]);
                result += num * box[1];
                truckSize -= box[0];
            }
        }
        return result;
    }
}
