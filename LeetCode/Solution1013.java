package LeetCode;

/**
 * @description: 将数组分成相等的三部分
 * 给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
 * 形式上，如果可以找出索引 i+1 < j 且满足 
 *      A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1] 就可以将数组三等分。
 *
 * 输入：[0,2,1,-6,6,-7,9,1,2,0,1]
 * 输出：true
 * 解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 * @author: Deepcola
 * @time: 2020/11/22 18:36
 */
public class Solution1013 {

    /**
     * 1.计算所有元素的和, 和不是 3 的倍数, 肯定不行
     * 2.每一部分之和 temp = sum / 3;
     * 3.遍历数组, 依次相加数组元素, 查找第一部分(和为 temp)；
     * 5.查找第二部分(和为 temp*2), 此时下标应该不是最后一个元素. 那么就 true
     */
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        // 计算数组元素之和
        for (int i: A) {
            sum += i;
        }
        // 不能整除3
        if (sum % 3 != 0) return false;
        int temp = sum / 3;// 每一部分之和
        sum = 0;
        // 第一部分
        int i = 0;// 遍历数组下标
        for (; i < A.length; i++) {
            sum += A[i];
            if (sum == temp) {
                break;
            }
        }
        // 第二部分
        for (int j = i + 1; j < A.length; j++) {
            sum += A[j];
            if (sum == temp * 2 && j < A.length - 1) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Solution1013 solution = new Solution1013();
        int[] A = {0,2,1,-6,6,-7,9,1,2,0,1};
        System.out.println(solution.canThreePartsEqualSum(A));
    }
}
