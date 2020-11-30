package NewCode;

import java.util.Scanner;

/**
 * @description: 寻找第 k 大
 * 有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。
 * 给定一个整数数组a,同时给定它的大小n和要找的K(K在1到n之间)，请返回第K大的数，保证答案存在。
 * 示例1
 * 输入
 *      [1,3,5,2,2],5,3
 * 输出
 *      2
 * @author: Deepcola
 * @time: 2020/11/30 18:58
 */
public class Finder {

    /**
     *
     * @param array 数组
     * @param n 元素个数
     * @param k 第 k 大
     * @return
     */
    public static int findKth(int[] array, int n,int k) {
        return findKth(array,0, n-1, k);
    }

    public static int findKth(int[] array, int start, int end, int k) {
        if (start > end) return -1;
        int prior = partition(array, start, end);

        if (prior - start + 1 == k) {
            return array[prior];
        }else if (prior - start + 1 > k) {
            return findKth(array, start, prior-1, k);
        }else {
            // 当 k 在后半部分时, 直接相当于删除了前半部分元素, 从 prior+1 开始查找
            // k 也就不再是之前的第 k 大, 因为删除的元素都比他大
            return findKth(array, prior+1, end,  k - (prior - start + 1));
        }
    }

    public static int partition(int[] array, int start, int end) {
        int temp = array[start];
        while (start < end) {
            // 从大到小
            while (start < end && array[end] <= temp) {
                end--;
            }
            array[start] = array[end];

            while (start < end && array[start] >= temp) {
                start++;
            }
            array[end] = array[start];
        }
        array[start] = temp;
        return start;
    }


    public static void main(String[] args) {
        int[] array = {1,3,5,2,2};
        System.out.println(findKth(array, 5, 3));
    }
}
