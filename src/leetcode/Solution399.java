package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 除法求值
 * 给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，
 * 其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。
 * 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
 * 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。
 * 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
 *
 * 输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * 输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * 解释：
 * 条件：a / b = 2.0, b / c = 3.0
 * 问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * 结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
 *
 * 输入：equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * 输出：[3.75000,0.40000,5.00000,0.20000]
 *
 * 输入：equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
 * 输出：[0.50000,2.00000,-1.00000,-1.00000]
 *  
 *
 * 提示：
 *      1 <= equations.length <= 20
 *      equations[i].length == 2
 *      1 <= Ai.length, Bi.length <= 5
 *      values.length == equations.length
 *      0.0 < values[i] <= 20.0
 *      1 <= queries.length <= 20
 *      queries[i].length == 2
 *      1 <= Cj.length, Dj.length <= 5
 *      Ai, Bi, Cj, Dj 由小写英文字母与数字组成
 * @author: Deepcola
 * @time: 2021/1/6 8:30
 */
public class Solution399 {

    /**
     * 并查集
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int size = equations.size();

        UnionFind unionFind = new UnionFind(2 * size);

        // 第 1 步：预处理，将变量的值与 id 进行映射，使得并查集的底层使用数组实现，方便编码
        Map<String, Integer> map = new HashMap<>(2 * size);
        int id = 0;// 记录 id
        for (int i = 0; i < size; i++) {
            String var1 = equations.get(i).get(0);
            String var2 = equations.get(i).get(1);

            // 存放进 map
            if (!map.containsKey(var1)) {
                map.put(var1, id);
                id++;
            }
            if (!map.containsKey(var2)) {
                map.put(var2, id);
                id++;
            }
            // 查找根节点并通过 路径压缩 指向根节点
            unionFind.union(map.get(var1), map.get(var2), values[i]);
        }

        // 第 2 步：做查询
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            Integer id1 = map.get(queries.get(i).get(0));
            Integer id2 = map.get(queries.get(i).get(1));

            // 判断字符是否存在于 equations 中
            if (id1 == null || id2 == null) {
                result[i] = -1;
            }else {
                result[i] = unionFind.isConnected(id1, id2);
            }
        }
        return result;
    }

    //
    private class UnionFind {

        // 存放 某一节点的父节点的数组
        private int[] parent;
        // 指向 父节点的权值
        private double[] weight;
        public UnionFind(int size) {
            parent = new int[size];
            weight = new double[size];
            for (int i = 0; i < size; i++) {
                // 默认父节点是自己本身
                parent[i] = i;
                weight[i] = 1;
            }
        }

        // 查找 根节点
        public void union(int id1, int id2, double value) {
            int root1 = findRoot(id1);
            int root2 = findRoot(id2);
            if (root1 == root2) {
                return;
            }
            parent[root1] = root2;
            weight[root1] = weight[id2] * value / weight[id1];
        }

        // 路径压缩
        private int findRoot(int id) {
            if (id != parent[id]) {
                int origin = parent[id];
                parent[id] = findRoot(parent[id]);
                weight[id] *= weight[origin];
            }
            return parent[id];
        }

        public double isConnected(int id1, int id2) {
            int root1 = findRoot(id1);
            int root2 = findRoot(id2);
            if (root1 == root2) {
                return weight[id1] / weight[id2];
            }else {
                return -1.0d;
            }
        }
    }
}
