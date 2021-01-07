package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 省份数量
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
 * 返回矩阵中 省份 的数量。
 *
 * 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * 输出：2
 *
 * 输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * 输出：3
 *  
 * 提示：
 *      1 <= n <= 200
 *      n == isConnected.length
 *      n == isConnected[i].length
 *      isConnected[i][j] 为 1 或 0
 *      isConnected[i][i] == 1
 *      isConnected[i][j] == isConnected[j][i]
 * @author: Deepcola
 * @time: 2021/1/7 7:44
 */
public class Solution547 {

    /**
     * 深度优先搜索
     */
    /*public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        // flag=true -> 已访问
        boolean[] flag = new boolean[n];
        int result = 0;
        for (int i = 0; i < n; i++) {
            // 未被访问过 -> 访问与该点所有连通的
            if (!flag[i]) {
                dfs(isConnected, flag, i);
                result++;
            }
        }
        return result;
    }
    // 访问所有连通的点
    private void dfs(int[][] isConnected, boolean[] flag, int i) {
        for (int j = 0; j < isConnected.length; j++) {
            // 连通并且没有被访问过
            if (isConnected[i][j] == 1 && !flag[j]) {
                flag[j] = true;
                dfs(isConnected, flag, j);
            }
        }
    }*/

    /**
     * 广度优先搜索
     */
    /*public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] flag = new boolean[n];
        // 使用队列存储遍历所有与当前点连通的点
        Queue<Integer> queue = new LinkedList<>();
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (!flag[i]) {// 未被访问过
                queue.offer(i);
                // 访问所有连通的点
                while (!queue.isEmpty()) {
                    int temp = queue.poll();
                    flag[temp] = true;// 已访问
                    for (int j = 0; j < n; j++) {
                        if (isConnected[temp][j] == 1 && !flag[j]) {
                            queue.offer(j);
                        }
                    }
                }
                result++;
            }
        }
        return result;
    }*/

    /**
     * 并查集
     */
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        // 存放元素以及元素对应的父节点
        int[] parent = new int[n];
        // 初始化每个点父节点为本身
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        // 所有连通的点进行合并(路径压缩)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    union(parent, i, j);
                }
            }
        }
        // 查询结果
        int result = 0;
        for (int i = 0; i < n; i++) {
            // 所有父节点为本身的必定是一个新的省份
            if (parent[i] == i) {
                result++;
            }
        }
        return result;
    }
    // 合并 / 联合 所有连通的点(路径压缩)
    private void union(int[] parent, int i, int j) {
        // 将两个点进行合并 / 联合
        int root1 = find(parent, i);
        int root2 = find(parent, j);
        parent[root1] = root2;
    }
    // 查找对于当前点来说的最终父节点
    private int find(int[] parent, int i) {
        // 一路向上查找直到找到最终的父节点
        if (parent[i] != i) {
            // 向上查找
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }
}
