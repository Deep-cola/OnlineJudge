package leetcode;

/**
 * @description: 打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * 示例 1：
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * 示例 2：
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *  
 * 提示：
 *      0 <= nums.length <= 100
 *      0 <= nums[i] <= 400
 * @author: Deepcola
 * @time: 2021/1/17 14:53
 */
public class Solution198 {

    /**
     * 动态规划
     *      使用 dp[i] 表示偷取到 i 号房屋后的总金额 -> 考虑要不要偷取这一间房屋
     *      (1)不偷取 -> 最大金额就是前一天的最大金额
     *      (2)偷取 -> 最大金额只能为两天前的最大金额
     *      dp[i] = Math.max(dp[i - 1], dp[i - 2] + num[i])
     * 初始时: dp[0] = nums[0];   dp[1] = Math.max(nums[0], nums[1]);
     */
    /*public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];// 对于第一间房
        dp[1] = Math.max(nums[1], nums[0]);// 对于第二间房
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }*/

    /**
     * 空间优化——滚动数组:
     *      由于每一次的最大金额只与前一天或者前两天的最大金额有关, 所以利用滚动数组进行优化
     */
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int pre1 = Math.max(nums[0], nums[1]);// 前一天
        int pre2 = nums[0];// 前两天
        int cur = 0;// 当前
        for (int i = 2; i < nums.length; i++) {
            cur = Math.max(pre1, pre2 + nums[i]);
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }
}
