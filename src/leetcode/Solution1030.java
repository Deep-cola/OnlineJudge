package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 距离顺序排列矩阵单元格
 * 给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。
 * 另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。
 * 返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，
 * 其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈顿距离，|r1 - r2| + |c1 - c2|。（你可以按任何满足此条件的顺序返回答案。）
 *      1 <= R <= 100
 *      1 <= C <= 100
 *      0 <= r0 < R
 *      0 <= c0 < C
 * 输入：R = 1, C = 2, r0 = 0, c0 = 0
 * 输出：[[0,0],[0,1]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1]
 *
 * 输入：R = 2, C = 2, r0 = 0, c0 = 1
 * 输出：[[0,1],[0,0],[1,1],[1,0]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2]
 * [[0,1],[1,1],[0,0],[1,0]] 也会被视作正确答案。
 *
 * 输入：R = 2, C = 3, r0 = 1, c0 = 2
 * 输出：[[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2,2,3]
 * 其他满足题目要求的答案也会被视为正确，例如 [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]]。
 * @author: Deepcola
 * @time: 2020/12/25 15:08
 */
public class Solution1030 {

    /**
     * 桶排序
     */
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        // 行距离和列距离都最大时, 距离取得最大值
        int maxDistance = Math.max(r0, R - 1 - r0) + Math.max(c0, C - 1 - c0);
        // 建桶
        List<List<int[]>> bucket = new ArrayList<>();
        for (int i = 0; i <= maxDistance; i++) {
            bucket.add(new ArrayList<>());
        }
        // 装桶
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                // 计算距离
                int distance = Math.abs(i - r0) + Math.abs(j - c0);;
                // 装进相应的桶
                bucket.get(distance).add(new int[]{i, j});
            }
        }
        // 取值
        int[][] result = new int[R * C][2];
        int index = 0;
        for (int i = 0; i <= maxDistance; i++) {
            for (int[] e: bucket.get(i)) {
                result[index++] = e;
            }
        }
        return result;
    }


    /**
     * 直接排序
     */
    /*public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        // 统计所有数
        int[][] result = new int[R * C][2];
        int index = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                result[index++] = new int[]{i, j};
            }
        }
        // 排序
        Arrays.sort(result, (o1, o2) -> {
            return (Math.abs(o1[0] - r0) + Math.abs(o1[1] - c0))- (Math.abs(o2[0] - r0) + Math.abs(o2[1] - c0));
        });
        return result;
    }*/

    public static void main(String[] args) {
        Solution1030 solution = new Solution1030();
        System.out.println(Arrays.deepToString(solution.allCellsDistOrder(2, 3, 1, 2)));
    }
}
