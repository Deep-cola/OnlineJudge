package newcode;

/**
 * @description: 约瑟夫问题Ⅱ
 * 现有n个人围坐一圈，顺时针给大家编号，第一个人编号为1，然后顺时针开始报数。第一轮依次报1，2，1，2...没报1的人出局。
 * 接着第二轮再从上一轮最后一个报数的人开始依次报1，2，3，1，2，3...没报1的人都出局。以此类推直到剩下以后一个人。现给定一个int n，要求返回最后一个人的编号。
 *
 * 测试样例：
 * 5
 * 返回：5
 * @author: Deepcola
 * @time: 2020/11/17 21:54
 */
public class Joseph {

    /**
     * 调用递归即可
     */
    public int getResult(int n) {
        return ysf(n, 2);
    }

    /**
     * 递归计算最后一个胜利者的编号并返回最初编号:
     * 首先需要计算下一轮游戏的剩余人数, 如果人数正好是 m 的倍数，那么剩余 n/m 人;反之，剩余 n/m + 1 人;
     * 如果剩余人数小于等于下一次 (m+1),就可以结束游戏了，这轮末尾下轮第一个的人必赢. 这也是递归的终止条件;
     * 此时计算返回胜利者的上一轮编号: (temp - 1) * m + 1 ————前面所有人都是完整组，除了胜利者是剩下的那个;
     * 计算返回的胜利者编号是上一轮在末尾人插队以后的编号，所以在继续向前计算返回编号时，需要先减去插队以后后移的 1.
     */
    public int ysf(int n, int m) {
        // 剩余人数
        int temp = (n % m) == 0 ? n / m : (n / m) + 1;
        // 剩余人数不够玩一轮 -> 上次末尾的人胜
        if (temp <= m + 1) {
            // 末尾的人上次编号
            // 剩余人数中，前面(temp - 1)个人都可以看作是完整一组，每组 m 个人,。最后末尾的人编号是前面所有人数 + 1
            return (temp - 1) * m + 1;
        }
        // 从后往前推，由于每一轮都会有一个末尾的人插队到最前面使得编号后移一位，所以除了减去因为不是完整组的 1 外，还有后移的一位
        return (ysf(temp, m + 1) - 2) * m + 1;
    }

    public static void main(String[] args) {
        Joseph joseph = new Joseph();
        System.out.println(joseph.getResult(5));
    }
}