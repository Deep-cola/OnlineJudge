package leetcode;

/**
 * @description: 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 说明:
 *      必须在原数组上操作，不能拷贝额外的数组。
 *      尽量减少操作次数。
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * @author: Deepcola
 * @time: 2020/12/25 17:02
 */
public class Solution283 {

    /**
     * 不是 0 的前移; 最后剩余的全是 0
     */
//    public void moveZeroes(int[] nums) {
//        int index = 0;
//        // 不是 0 的前移
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != 0) {
//                nums[index++] = nums[i];
//            }
//        }
//        // 剩余的全为 0
//        for (int i = index; i < nums.length; i++) {
//            nums[index++] = 0;
//        }
//    }

    /**
     * 双指针
     */
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        // 使 [0, left) 均不为 0, [left, right) 均为 0
        while (right < nums.length) {
            // 将 0 交换到后面
            if (nums[right] != 0) {
                // 交换
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
