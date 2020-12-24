package newcode;

import java.util.*;

/**
 * @description: 火车进站
 * 给定一个正整数N代表火车数量，0<N<10，接下来输入火车入站的序列，一共N辆火车，每辆火车以数字1-9编号，
 * 火车站只有一个方向进出，同时停靠在火车站的列车中，只有后进站的出站了，先进站的才能出站。
 * 要求输出所有火车出站的方案，以字典序排序输出。
 * 输入描述:    有多组测试用例，每一组第一行输入一个正整数N（0
 * 输出描述:    输出以字典序从小到大排序的火车出站序列号，每个编号以空格隔开，每个输出序列换行，具体见sample。
 * 输入
 *      3
 *      1 2 3
 * 输出
 *      1 2 3
 *      1 3 2
 *      2 1 3
 *      2 3 1
 *      3 2 1
 * @author: Deepcola
 * @time: 2020/12/16 23:12
 */
public class TrainToStation {

    /**
     * 交换两个元素
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 排列组合所有顺序
     */
    static List<int[]> list = new ArrayList<>();
    public static void getAllOrder(int[] train, int start, int end) {
        if (start == end) {
            int[] copy = train.clone();
            list.add(copy);
            return;
        }
        for (int i = start; i <= end; i++) {
            swap(train, i, start);
            getAllOrder(train, start+1, end);
            swap(train, i, start);
        }
    }

    /**
     * 判断是否可能是出站顺序
     */
    public static boolean isPop(int[] push, int[] pop) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;// pop 的遍历位置
        for (int i = 0; i < push.length; i++) {
            stack.push(push[i]);
            while (!stack.isEmpty() && stack.peek() == pop[index]) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }

    /**
     * 数组转换为字符串
     */
    public static String arrToStr(int[] arr) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(" ");
        }
        return sb.deleteCharAt(sb.length()-1).toString();
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int N = scan.nextInt();// 火车数量
            int[] train = new int[N];// 火车进站顺序
            for (int i = 0; i < N; i++) {
                train[i] = scan.nextInt();
            }
            getAllOrder(train, 0, N-1);// 求出所有可能
            List<String> result = new ArrayList<>();
            // 判断可能是否合理
            for (int[] pop: list) {
                if (isPop(train, pop)) {
                    result.add(arrToStr(pop));
                }
            }
            // 排序
            Collections.sort(result);
            // 输出
            for (String str: result) {
                System.out.println(str);
            }
        }
    }
}