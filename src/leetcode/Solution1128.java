package leetcode;

/**
 * @description: 等价多米诺骨牌对的数量
 * 给你一个由一些多米诺骨牌组成的列表 dominoes。
 * 如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。
 * 形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且 b==c。
 * 在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i, j) 的数量。
 *
 * 示例：
 * 输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
 * 输出：1
 *  
 * 提示：
 *      1 <= dominoes.length <= 40000
 *      1 <= dominoes[i][j] <= 9
 * @author: Deepcola
 * @time: 2021/1/26 20:50
 */
public class Solution1128 {

    /**
     * 模拟
     */
    /*public int numEquivDominoPairs(int[][] dominoes) {
        int result = 0;
        boolean[] flag = new boolean[dominoes.length];
        for (int i = 0; i < dominoes.length; i++) {
            // 还未配对
            if (!flag[i]) {
                int count = 1;
                for (int j = i + 1; j < dominoes.length; j++) {
                    if (!flag[j]) {
                        // 满足等价多米诺骨牌
                        if (dominoes[i][0] == dominoes[j][0] && dominoes[i][1] == dominoes[j][1] ||
                                dominoes[i][0] == dominoes[j][1] && dominoes[i][1] == dominoes[j][0]) {
                            // 匹配数量++
                            count++;
                            // 已配对
                            flag[j] = true;
                        }
                    }
                }
                flag[i] = true;
                if (count > 1) {
                    // 组合数: n(n-1) / 2
                    result += count * (count - 1) / 2;
                }
            }
        }
        return result;
    }*/

    /**
     * 二元组表示 + 计数
     * 指定二元组的格式
     * 每个元素不大于 9, 有 10x+y 不大于 100, 使用数组计数
     */
    public int numEquivDominoPairs(int[][] dominoes) {
        int n = dominoes.length;
        int result = 0;
        int[] count = new int[100];
        for (int[] domino : dominoes) {
            // 计算二元组的指定格式值
            int value = domino[0] > domino[1] ? domino[1] * 10 + domino[0] : domino[0] * 10 + domino[1];
            // 组合数: 1+2+3+4+...
            result += count[value];
            count[value]++;
        }
        return result;
    }
}
