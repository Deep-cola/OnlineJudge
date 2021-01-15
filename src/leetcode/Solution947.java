package leetcode;

import java.util.HashMap;

/**
 * @description: 移动最多的同行或同列石头
 * n 块石头放置在二维平面中的一些整数坐标点上。每个坐标点上最多只能有一块石头。
 * 如果一块石头的 同行或者同列 上有其他石头存在，那么就可以移除这块石头。
 * 给你一个长度为 n 的数组 stones ，其中 stones[i] = [xi, yi] 表示第 i 块石头的位置，返回 可以移除的石子 的最大数量。
 *
 * 示例 1：
 * 输入：stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
 * 输出：5
 * 解释：一种移除 5 块石头的方法如下所示：
 * 1. 移除石头 [2,2] ，因为它和 [2,1] 同行。
 * 2. 移除石头 [2,1] ，因为它和 [0,1] 同列。
 * 3. 移除石头 [1,2] ，因为它和 [1,0] 同行。
 * 4. 移除石头 [1,0] ，因为它和 [0,0] 同列。
 * 5. 移除石头 [0,1] ，因为它和 [0,0] 同行。
 * 石头 [0,0] 不能移除，因为它没有与另一块石头同行/列。
 *
 * 示例 2：
 * 输入：stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
 * 输出：3
 * 解释：一种移除 3 块石头的方法如下所示：
 * 1. 移除石头 [2,2] ，因为它和 [2,0] 同行。
 * 2. 移除石头 [2,0] ，因为它和 [0,0] 同列。
 * 3. 移除石头 [0,2] ，因为它和 [0,0] 同行。
 * 石头 [0,0] 和 [1,1] 不能移除，因为它们没有与另一块石头同行/列。
 *
 * 示例 3：
 * 输入：stones = [[0,0]]
 * 输出：0
 * 解释：[0,0] 是平面上唯一一块石头，所以不可以移除它。
 *  
 * 提示：
 *      1 <= stones.length <= 1000
 *      0 <= xi, yi <= 104
 *      不会有两块石头放在同一个坐标点上
 * @author: Deepcola
 * @time: 2021/1/15 14:33
 */
public class Solution947 {

    /**
     * 并查集
     */
    /*public int removeStones(int[][] stones) {
        int n = stones.length;
        UnionFind unionFind = new UnionFind(n);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // 当处于同一行或者同一列就合并为一个子集
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    unionFind.union(i, j);
                }
            }
        }
        int result = 0;// 留下的石头数量
        for (int i = 0; i < n; i++) {
            // 需要被移除的石头
            if (unionFind.parent[i] != i) {
                result++;
            }
        }
        return result;
    }

    static class UnionFind {
        private int[] parent;
        public UnionFind(int n) {
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        // 合并两个子集
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            parent[rootX] = rootY;
        }
        // 查询所在子集
        private int find(int i) {
            if (parent[i] != i) {
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }
    }*/

    public int removeStones(int[][] stones) {
        int n = stones.length;
        UnionFind unionFind = new UnionFind(n);

        for (int[] stone: stones) {
            // 横坐标和纵坐标不能相同
            // 存放近 map 的是 stone[0] 坐在的根节点 指向 stone[1] 所在的根节点
            unionFind.union(stone[0] + 10001, stone[1]);
        }
        return stones.length - unionFind.count;
    }

    static class UnionFind {
        private final HashMap<Integer, Integer> map;
        private int count;// 连通分量的个数
        public UnionFind(int n) {
            this.map = new HashMap<>();
            this.count = 0;
        }
        // 合并两个子集
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            // 把 x 所在的根节点指向 y 坐在的根节点
            this.map.put(rootX, rootY);
            this.count--;
        }
        // 查询所在子集
        private int find(int i) {
            // 没有这个连通分量
            if (!map.containsKey(i)) {
                map.put(i, i);
                this.count++;
            }
            // 查找所在子集
            if (map.get(i) != i) {
                map.put(i, find(map.get(i)));
            }
            return map.get(i);
        }
    }
}
