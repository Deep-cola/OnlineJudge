package leetcode;

/**
 * @description: 比较版本号
 * 给你两个版本号 version1 和 version2 ，请你比较它们。
 * 版本号由一个或多个修订号组成，各修订号由一个 '.' 连接。每个修订号由 多位数字 组成，可能包含 前导零 。
 * 每个版本号至少包含一个字符。修订号从左到右编号，下标从 0 开始，最左边的修订号下标为 0 ，下一个修订号下标为 1 ，
 * 以此类推。例如，2.5.33 和 0.1 都是有效的版本号。
 * 比较版本号时，请按从左到右的顺序依次比较它们的修订号。比较修订号时，只需比较 忽略任何前导零后的整数值 。
 * 也就是说，修订号 1 和修订号 001 相等 。如果版本号没有指定某个下标处的修订号，则该修订号视为 0 。
 * 例如，版本 1.0 小于版本 1.1 ，因为它们下标为 0 的修订号相同，而下标为 1 的修订号分别为 0 和 1 ，0 < 1 。
 * 返回规则如下：
 * 如果 version1 > version2 返回 1，
 * 如果 version1 < version2 返回 -1，
 * 除此之外返回 0。
 * @author: Deepcola
 * @time: 2020/11/20 16:30
 */
public class Solution165 {

    /**
     * 1.以"."将版本号分割
     * 2.比较同样下标下两个版本号的大小
     * 3.长度不足的补 0
     */
    public int compareVersion(String version1, String version2) {
        // 分割版本号
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        // 比较版本号
        for (int i = 0; i < Math.max(v1.length,v2.length); i++) {
            // 取出当前下标下的修订号, 不足的补 0
            int i1 = (i < v1.length) ? Integer.parseInt(v1[i]) : 0;
            int i2 = (i < v2.length) ? Integer.parseInt(v2[i]) : 0;
            // 比较, 前面比较出结果后面就可以不用比较了
            if (i1 > i2) return 1;
            if (i2 > i1) return -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution165 solution = new Solution165();
        String version1 ="1.0.1";
        String version2 = "1";
        System.out.println(solution.compareVersion(version1, version2));
    }
}
