package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 根据身高重建队列
 * 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。
 * 每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
 * 请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，
 * 其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
 *
 * 输入：people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
 * 输出：[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
 * 解释：
 * 编号为 0 的人身高为 5 ，没有身高更高或者相同的人排在他前面。
 * 编号为 1 的人身高为 7 ，没有身高更高或者相同的人排在他前面。
 * 编号为 2 的人身高为 5 ，有 2 个身高更高或者相同的人排在他前面，即编号为 0 和 1 的人。
 * 编号为 3 的人身高为 6 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
 * 编号为 4 的人身高为 4 ，有 4 个身高更高或者相同的人排在他前面，即编号为 0、1、2、3 的人。
 * 编号为 5 的人身高为 7 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
 * 因此 [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] 是重新构造后的队列。
 *
 * 输入：people = [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]
 * 输出：[[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]
 * @author: Deepcola
 * @time: 2020/12/25 8:20
 */
public class Solution406 {

    /**
     * 从高到低
     * 1.按照身高降序, k 升序的顺序排序
     * 2.插入由于身高较低的人对高的人没有影响, 所以插入时前面有几个人比自己高, 就插入到哪个位置
     */
    public int[][] reconstructQueue(int[][] people) {
        // 按照身高从高到低排序, k 降序排序
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }else {
                return o2[0] - o1[0];
            }
        });
        // 插入
        List<int[]> list = new ArrayList<>();
        for (int[] person: people) {
            list.add(person[1], person);
        }
        return list.toArray(new int[list.size()][]);
    }

    /**
     * 从低到高
     */
//    public int[][] reconstructQueue(int[][] people) {
//        // 按照身高从低到高, k 降序排序
//        Arrays.sort(people, (o1, o2) -> {
//            if (o1[0] == o2[0]) {
//                return o2[1] - o1[1];
//            }else {
//                return o1[0] - o2[0];
//            }
//        });
//        int[][] result = new int[people.length][];
//        // 插入
//        for (int[] person: people) {
//            /*int temp = person[1] + 1;// +1 是为了刚好找到插入的位置
//            for (int i = 0; i < people.length; i++) {
//                // 是否是空位置
//                if (result[i] == null) {
//                    temp--;
//                }
//                // 插入位置
//                if (temp == 0) {
//                    result[i] = person;
//                    break;
//                }
//            }*/
//            // 前面身高大于等于 person 的人数, 也就是前面应该存在的空位置数量
//            int temp = person[1];
//            // 寻找插入位置
//            int index = 0;
//            while (temp > 0) {
//                // 空位置
//                if (result[index] == null) {
//                    temp--;
//                }
//                index++;
//            }
//            // 查找到下一个空位置也就是插入位置
//            while (result[index] != null) {
//                index++;
//            }
//            // 插入
//            result[index] = person;
//        }
//        return result;
//    }

    public static void main(String[] args) {
        Solution406 solution = new Solution406();
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
//        int[][] people = {{6,0},{5,0},{4,0},{3,2},{2,2},{1,4}};
        System.out.println(Arrays.deepToString(solution.reconstructQueue(people)));
    }
}