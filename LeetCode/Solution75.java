package LeetCode;

/**
 * @description: 颜色分类
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * @author: Deepcola
 * @time: 2020/11/22 15:12
 */
public class Solution75 {

    /**
     * 对0 、1 、2 计数重新填充数组
     */
    public void sortColors(int[] nums) {
        int count0 = 0;
        int count1 = 0;
        // 计数
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count0++;
            }else if (nums[i] == 1) {
                count1++;
            }
        }
        // 重新填充数组
        int k = 0;
        while (count0-- > 0) {
            nums[k++] = 0;
        }
        while (count1-- > 0) {
            nums[k++] = 1;
        }
        while (k < nums.length) {
            nums[k++] = 2;
        }
    }


}
