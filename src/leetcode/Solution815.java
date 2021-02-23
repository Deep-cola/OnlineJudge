package leetcode;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * @description: 公交路线
 * 给你一个数组 routes ，表示一系列公交线路，其中每个 routes[i] 表示一条公交线路，第 i 辆公交车将会在上面循环行驶。
 *
 * 例如，路线 routes[0] = [1, 5, 7] 表示第 0 辆公交车会一直按序列 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... 这样的车站路线行驶。
 * 现在从 source 车站出发（初始时不在公交车上），要前往 target 车站。 期间仅可乘坐公交车。
 *
 * 求出 最少乘坐的公交车数量 。如果不可能到达终点车站，返回 -1 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：routes = [[1,2,7],[3,6,7]], source = 1, target = 6
 * 输出：2
 * 解释：最优策略是先乘坐第一辆公交车到达车站 7 , 然后换乘第二辆公交车到车站 6 。
 * 示例 2：
 *
 * 输入：routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
 * 输出：-1
 *  
 *
 * 提示：
 *
 * 1 <= routes.length <= 500.
 * 1 <= routes[i].length <= 105
 * routes[i] 中的所有值 互不相同
 * sum(routes[i].length) <= 105
 * 0 <= routes[i][j] < 106
 * 0 <= source, target < 106
 * @author: Deepcola
 * @time: 2021/2/23 18:58
 */
public class Solution815 {


    /**
     * 广度优先搜索
     */
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;
        int n = routes.length;

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Arrays.sort(routes[i]);
            graph.add(new ArrayList<>());
        }
        Set<Integer> seen = new HashSet<>();// 坐过的公交集合
        Set<Integer> targets = new HashSet<>();// 含有目标站的集合
        Queue<Point> queue = new ArrayDeque<>();// 坐过的公交队列(公交编号, 第几辆公交)

        // 建图: 量量公交车存在相同站就连通
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected(routes[i], routes[j])) {// 连通
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        // 初始化 seen、targets、queue
        for (int i = 0; i < n; i++) {
            if (Arrays.binarySearch(routes[i], source) >= 0) {// 找到起点
                seen.add(i);
                queue.offer(new Point(i, 0));
            }
            if (Arrays.binarySearch(routes[i], target) >= 0) {// 找到目标
                targets.add(i);
            }
        }

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int node = point.x;
            int depth = point.y;
            // 可以到达目标站
            if (targets.contains(node)) return depth + 1;
            for (int i : graph.get(node)){
                if (!seen.contains(i)) {
                    seen.add(i);
                    queue.offer(new Point(i, depth + 1));
                }
            }
        }
        return -1;
    }

    private boolean isConnected(int[] A, int[] B) {
        for (int i = 0, j = 0; i < A.length && j < B.length;) {
            if (A[i] == B[j]) return true;
            if (A[i] < B[j]) {
                i++;
            }else {
                j++;
            }
        }
        return false;
    }
}
