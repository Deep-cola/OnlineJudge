package newcode;

import java.util.Arrays;

/**
 * @description: 构建乘积数组
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
 * 对于A长度为1的情况，B无意义，故而无法构建，因此该情况不会存在。
 * 输入       [1,2,3,4,5]
 * 输出       [120,60,40,30,24]
 * @author: Deepcola
 * @time: 2020/12/6 21:52
 */
public class BuildArray {

    /**
     * B0       1   A1   A2  A3  ...     A(n-1)
     * B1       A0   1   A2  A3  ...     A(n-1)
     * B2       A1   A1   1  A3  ...     A(n-1)
     * B3       A2   A1  A2  1  ...      A(n-1)
     * ...
     * B(n-1)   A0   A1  A2  A3  ...     1
     * 每一行的乘积就是结果
     */

    public static int[] multiply(int[] A) {
        int[] B = new int[A.length];
        // 构建下三角, 从上向下构造
        if (A.length != 0) {
            B[0] = 1;
            for (int i = 1; i < B.length; i++) {
                B[i] = A[i-1] * B[i-1];
            }
            // 对角线
            int temp = 1;
            // 构建上三角
            // 最后一行计算完毕, 从倒数第二行开始向上构造
            for (int i = A.length - 2; i >= 0; i--) {
                temp *= A[i+1];
                B[i] *= temp;
            }
        }
        return B;
    }


    public static void main(String[] args) {
        int[] A = {1,2,3,4,5};
        System.out.println(Arrays.toString(multiply(A)));
    }
}
