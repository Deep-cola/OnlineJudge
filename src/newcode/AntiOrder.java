package newcode;

/**
 * @description: 数组中的逆序对
 * 给定一个int数组A和它的大小n，对于这组数能组成的任意两个数组，若前面一个大于后面一个数字，则这两个数字组成一个逆序对。
 * 请设计一种高效的算法返回A中存在的逆序对个数。要求n不大于5000。
 *
 * 测试样例：    [1,2,3,4,5,6,7,0],8
 * 返回：      7
 * @author: Deepcola
 * @time: 2020/12/1 0:10
 */
public class AntiOrder {

    /**
     * 利用归并排序进行分支统计左边和右边的逆序对数量之和
     */
    public static int count(int[] A, int n) {
        if (A == null || A.length == 0) return 0;
        return mergeSortRec(A, 0, n-1);
    }

    /**
     * 递归分治法
     */
    public static int mergeSortRec(int[] A, int start, int end) {
        if (start >= end) return 0;
        int mid = (start + end) / 2;
        // 递归分散
        int left = mergeSortRec(A, start, mid);
        int right = mergeSortRec(A, mid + 1, end);
        // 归并计算逆序对
        int count = merge(A, start, mid, end);
        return left + right + count;
    }

    /**
     * 归并计算逆序对
     */
    public static int merge(int[] A, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int s1 = left;
        int s2 = mid + 1;
        int k = 0;
        int count = 0; // 逆序对数量
        while (s1 <= mid && s2 <= right) {
            // 前面小于后面————正常
            if (A[s1] <= A[s2]) {
                temp[k++] = A[s1++];
            }else {
                // 前面A[s1]大于后面A[S2]————逆序对增加————由于每一个数组都升序，所以第一个数组A[s1]后面的元素都大于当前的A[s2]
                temp[k++] = A[s2++];
                count += mid - s1 + 1;
            }
        }
        while (s1 <= mid) {
            temp[k++] = A[s1++];
        }
        while (s2 <= right) {
            temp[k++] = A[s2++];
        }

        for (int i = 0; i < temp.length; i++) {
            A[i + left] = temp[i];
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,4,5,6,7,0};
        System.out.println(count(A, 8));
    }
}
