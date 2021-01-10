package leetcode;

/**
 * @description: 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 *
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * @author: Deepcola
 * @time: 2021/1/8 7:30
 */
public class Solution189 {

    /**
     * 使用额外数组进行旋转
     */
    /*public void rotate(int[] nums, int k) {
        // 实际需求
        k = k % nums.length;
        // 不需要旋转
        if (k == 0) return;
        // 旋转
        int[] result = new int[nums.length];
        int index = 0;
        for (int i = nums.length - k; i < nums.length; i++) {
            result[index++] = nums[i];
        }
        for (int i = 0; i < nums.length - k; i++) {
            result[index++] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }
    }*/

    /**
     * 1.分别翻转前面部分和后面部分
     * 2.翻转整体数组
     */
    /*public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1 - k);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }
    // 翻转
    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }*/

    /**
     * 环状翻转
     */
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;// 记录访问次数
        for (int i = 0; count != nums.length; i++) {
            int start = i;
            int prev = nums[start];
            do {
                int next = (start + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                // 更新下一次交换初始值
                start = next;
                prev = temp;
                count++;
            } while (start != i);// 回到原始位置停止
        }
    }
}
