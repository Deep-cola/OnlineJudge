package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @description: 交换字符串中的元素
 * 给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0 开始）。
 * 你可以 任意多次交换 在 pairs 中任意一对索引处的字符。
 * 返回在经过若干次交换后，s 可以变成的按字典序最小的字符串。
 *
 * 输入：s = "dcab", pairs = [[0,3],[1,2]]
 * 输出："bacd"
 * 解释：
 * 交换 s[0] 和 s[3], s = "bcad"
 * 交换 s[1] 和 s[2], s = "bacd"
 *
 * 输入：s = "dcab", pairs = [[0,3],[1,2],[0,2]]
 * 输出："abcd"
 * 解释：
 * 交换 s[0] 和 s[3], s = "bcad"
 * 交换 s[0] 和 s[2], s = "acbd"
 * 交换 s[1] 和 s[2], s = "abcd"
 *
 * 输入：s = "cba", pairs = [[0,1],[1,2]]
 * 输出："abc"
 * 解释：
 * 交换 s[0] 和 s[1], s = "bca"
 * 交换 s[1] 和 s[2], s = "bac"
 * 交换 s[0] 和 s[1], s = "abc"
 *
 * 提示：
 *      1 <= s.length <= 10^5
 *      0 <= pairs.length <= 10^5
 *      0 <= pairs[i][0], pairs[i][1] < s.length
 *      s 中只含有小写英文字母
 * @author: Deepcola
 * @time: 2021/1/11 7:17
 */
public class Solution1202 {

    /**
     * 并查集
     */
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if (pairs.size() == 0) return s;
        UnionFind unionFind = new UnionFind(s.length());
        // 第一步 将节点对输入并查集
        for (List<Integer> pair: pairs) {
            unionFind.union(pair.get(0), pair.get(1));
        }
        // 第二步 构建映射关系
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int root = unionFind.find(i);
            if (map.containsKey(root)) {
                map.get(root).offer(s.charAt(i));
            }else {
                PriorityQueue<Character> priorityQueue = new PriorityQueue<>();
                priorityQueue.offer(s.charAt(i));
                map.put(root, priorityQueue);
            }
        }
        // 第三步 重组字符串
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int root = unionFind.find(i);
            sb.append(map.get(root).poll());
        }
        return sb.toString();
    }
    // 并查集
    private static class UnionFind {
        private int[] parent;
        private int[] size;
        // 每个节点初始父节点为自身
        public UnionFind(int n) {
            this.parent = new int[n];
            this.size = new int[n];
            for (int i = 0; i < n; i++) {
                this.parent[i] = i;
                this.size[i] = 1;
            }
        }

        // 将两个自己合并成一个集合———路径压缩 + 按秩合并
        public void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA == rootB) {
                return;
            }
            parent[rootA] = rootB;
//            // 按秩合并
//            if (size[rootA] > size[rootB]) {
//                int temp = rootA;
//                rootA = rootB;
//                rootB = temp;
//            }
//            parent[rootA] = rootB;
//            size[rootA] += rootB;
        }

        // 查找某个元素所属的子集
        public int find(int x) {
            if (parent[x] != x) {
                // 不是祖先就继续向上查找
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }
}
