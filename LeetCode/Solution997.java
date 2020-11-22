package LeetCode;

/**
 * @description: 找到小镇的法官
 * 在一个小镇里，按从 1 到 N 标记了 N 个人。传言称，这些人中有一个是小镇上的秘密法官。
 * 如果小镇的法官真的存在，那么：
 * 小镇的法官不相信任何人。
 * 每个人（除了小镇法官外）都信任小镇的法官。
 * 只有一个人同时满足属性 1 和属性 2 。
 * 给定数组 trust，该数组由信任对 trust[i] = [a, b] 组成，表示标记为 a 的人信任标记为 b 的人。
 * 如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的标记。否则，返回 -1。
 *
 * 输入：N = 3, trust = [[1,3],[2,3]]
 * 输出：3
 * @author: Deepcola
 * @time: 2020/11/22 17:49
 */
public class Solution997 {

    /**
     * 计算每个人的度. 出度 -1, 入度 +1; 最后度等于 N-1 的人是法官
     */
    public int findJudge(int N, int[][] trust) {
        int[] count = new int[N + 1];
        // 计算度
        for (int i = 0; i < trust.length; i++) {
            count[trust[i][0]]--;// 信任别人
            count[trust[i][1]]++;// 被人信任
        }
        for (int i = 1; i <= N; i++) {
            if (count[i] == N-1) return i;
        }
        return -1;
    }


}
