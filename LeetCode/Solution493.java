package LeetCode;

/**
 * @description: 重要翻转对
 * 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
 * 你需要返回给定数组中的重要翻转对的数量。
 *
 * 示例:
 * 输入: [1,3,2,3,1]
 * 输出: 2
 * @author: Deepcola
 * @time: 2020/11/28 0:06
 */
public class Solution493 {

    /**
     * 1.把要处理的数组区域分成左右两段。
     * 2.两段各自计算“重要翻转对”。
     * 3.计算“左侧数在左段，右侧数在右段的翻转对”的数量。
     * 4.将左右段（均已排序）合并成一整段有序数组，
     */
    public int reversePairs(int[] nums) {
        if (nums.length == 0) return 0;
        return reversePairsRec(nums, 0, nums.length - 1);
    }


    /**
     * 递归
     */
    public int reversePairsRec(int[] nums, int start, int end) {
        if (start >= end) return 0;
        int mid = (start + end) / 2;
        // 分割
        int n1 = reversePairsRec(nums, start, mid);
        int n2 = reversePairsRec(nums, mid + 1, end);
        int result = n1 + n2;
        // 统计   翻转对的数量
        int left = start;
        int right = mid + 1;
        while (left <= mid) {
            while (right <= end && (long)nums[left] > 2 * (long)nums[right]) {
                right++;
            }
            result += right - mid - 1;
            left++;
        }
        // 归并
        merge(nums, start, end, mid);
        return result;
    }

    /**
     * 归并
     */
    public void merge(int[] nums, int start, int end, int mid) {
        int[] tempArr = new int[end - start + 1];
        int s1 = start;
        int s2 = mid + 1;
        int k = 0; // 排序数组存放下标
        while (s1 <= mid && s2 <= end) {
            if (nums[s1] <= nums[s2]) {
                tempArr[k++] = nums[s1++];
            }else {
                tempArr[k++] = nums[s2++];
            }
        }
        // 遍历完一个归并段
        while (s1 <= mid) {
            tempArr[k++] = nums[s1++];
        }
        while (s2 <= end) {
            tempArr[k++] = nums[s2++];
        }
        // 塞进原来的数组
        if (tempArr.length >= 0) System.arraycopy(tempArr, 0, nums, start, tempArr.length);
    }

    public static void main(String[] args) {
        Solution493 solution = new Solution493();
//        int[] nums = {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
        int[] nums = {2,4,3,5,1};
        System.out.println(solution.reversePairs(nums));
    }
}
