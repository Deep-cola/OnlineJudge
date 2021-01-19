package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 连接所有点的最小费用
 * 给你一个points 数组，表示 2D 平面上的一些点，其中 points[i] = [xi, yi] 。
 * 连接点 [xi, yi] 和点 [xj, yj] 的费用为它们之间的 曼哈顿距离 ：|xi - xj| + |yi - yj| ，其中 |val| 表示 val 的绝对值。
 * 请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有 一条简单路径时，才认为所有点都已连接。
 *
 * 示例 1：
 * 输入：points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
 * 输出：20
 * 解释：
 * 我们可以按照上图所示连接所有点得到最小总费用，总费用为 20 。
 * 注意到任意两个点之间只有唯一一条路径互相到达。
 *
 * 示例 2：
 * 输入：points = [[3,12],[-2,5],[-4,1]]
 * 输出：18
 *
 * 示例 3：
 * 输入：points = [[0,0],[1,1],[1,0],[-1,1]]
 * 输出：4
 *
 * 示例 4：
 * 输入：points = [[-1000000,-1000000],[1000000,1000000]]
 * 输出：4000000
 *
 * 示例 5：
 * 输入：points = [[0,0]]
 * 输出：0
 *  
 * 提示：
 *      1 <= points.length <= 1000
 *      -106 <= xi, yi <= 106
 *      所有点 (xi, yi) 两两不同。
 * @author: Deepcola
 * @time: 2021/1/19 8:17
 */
public class Solution1584 {

    /**
     * Kruskal 算法
     */
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        UnionFind unionFind = new UnionFind(n);
        List<Edge> edgeList = new ArrayList<>();
        // 将任意两点之间连接一条线并标记权值
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                edgeList.add(new Edge(dist(points, i, j), i, j));
            }
        }
        // 对边的权值进行排序
        edgeList.sort((o1, o2) -> o1.length - o2.length);
        int result = 0;
        int point = 1;
        for (Edge edge: edgeList) {
            // 如果还没有连通这个点
            if (unionFind.unionSet(edge.x, edge.y)) {
                result += edge.length;
                point++;
                // 连通所有点
                if (point == n) {
                    break;
                }
            }
        }
        return result;
    }

    public int dist(int[][] points, int i, int j) {
        return Math.abs(points[j][0] - points[i][0]) + Math.abs(points[j][1] - points[i][1]);
    }

    static class UnionFind {
        public int[] parent;
        public  int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }
        // 路径压缩
        public boolean unionSet(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return false;
            }
            if (rank[rootX] < rank[rootY]) {
                int temp = rootX;
                rootX = rootY;
                rootY = temp;
            }
            rank[rootX] += rank[rootY];
            parent[rootY] = rootX;
            return true;
        }

        private int find(int x) {
            return (parent[x] == x) ? parent[x] : (parent[x] = find(parent[x]));
        }
    }

    static class Edge {
        int x;
        int y;
        int length;
        public Edge(int length, int x, int y) {
            this.length = length;
            this.x = x;
            this.y = y;
        }
    }
}
