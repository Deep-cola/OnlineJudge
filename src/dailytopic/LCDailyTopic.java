package dailytopic;

import java.util.*;

/**
 * @description: leetcode 每日一题 整理
 *                  每一次当然是保留下相对而言较好的, 但是这并不是唯一的.
 * @author: Deepcola
 * @time: 2020/11/16 11:41
 */
public class LCDailyTopic {

    /**
     * Definition for a singly-linked list
     */
    class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * Definition for a binary tree node
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 2020/11/14
     * Solution1122.数组的相对排序
     * 给你两个数组，arr1 和 arr2，
     *      arr2 中的元素各不相同
     *      arr2 中的每个元素都出现在 arr1 中
     * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
     *      1 <= arr1.length, arr2.length <= 1000
     *      0 <= arr1[i], arr2[i] <= 1000
     *      arr2 中的元素 arr2[i] 各不相同
     *      arr2 中的每个元素 arr2[i] 都出现在 arr1 中
     *
     * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
     * 输出：[2,2,2,1,4,3,3,9,6,7,19]
     */
    class Solution1122 {
        /**
         * 1.计数排序:
         *      (1)寻找 arr1 中的最大数
         *      (2)定义一个数组用于统计 arr1 出现数字以及对应的次数
         *      (3)双重循环遍历 arr2 和 arr1 存放相应次数的元素
         *      (4)存放其他元素
         * 时间复杂度O(m + n + max)————m n 分别是 arr1 arr2 长度 , max 是出现的最大值
         * 空间复杂度O(max)————用于计数数组
         */
        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            // 查找最大数
            int max = 0;
            for (int temp: arr1) {
                max = Math.max(temp, max);
            }
            // 统计出现数字以及对应次数
            int[] count = new int[max + 1];
            for (int temp: arr1) {
                count[temp]++;
            }
            // 遍历存放所有在 arr2 出现的数字
            int[] result = new int[arr1.length];
            int index = 0;
            for (int temp: arr2) {
                while (count[temp]-- > 0) {
                    result[index++] = temp;
                }
            }
            // 存放其他的元素
            for (int i = 0; i <= max; i++) {
                while (count[i]-- > 0) {
                    result[index++] = i;
                }
            }
            return result;
        }

        /**
         * 2.使用 HashMap
         *      (1)统计 arr1 出现元素以及对应次数,
         *      (2)根据 map 先存放出现在 arr2 的一部分, 其 key 对应的 value 就是出现次数
         *      (3)根据 map 存放未出现在 arr2 的元素
         *      (4)对后面存放的元素升序排序
         */
        /*public int[] relativeSortArray(int[] arr1, int[] arr2) {
            HashMap<Integer, Integer> map = new HashMap<>();
            // 统计出现次数
            for (int i = 0; i < arr1.length; i++) {
                map.put(arr1[i], map.getOrDefault(arr1[i], 0) + 1);
            }
            int index = 0;// 存放下标
            int num = 0;// arr1 在 arr2 中出现的所有数字个数
            // 存放 arr1 在 arr2 中出现的数字
            for (int i = 0; i < arr2.length; i++) {
                int count = map.get(arr2[i]);// arr1 当前元素在 arr2 中出现的数字个数
                num += count;
                while (count-- > 0) {
                    arr1[index++] = arr2[i];
                }
                map.remove(arr2[i]);
            }
            // 存放 arr1 未在 arr2 中出现的数字
            for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
                int count = entry.getValue();
                while (count-- > 0) {
                    arr1[index++] = entry.getKey();
                }
            }
            // 对后面的数字升序排序
            Arrays.sort(arr1, num, arr1.length);
            return arr1;
        }*/

        /**
         * 3.自定义比较顺序: 对于 arr1 中的两个数
         *      (1)如果两个数都没有在 arr2 中出现, 那么就升序排序
         *      (2)反之, 那么这两个数的顺序将是由 arr2 的元素出现顺序决定
         *              (只出现一个, 那么另一个必定在其后面, 最多只有 1000 个数, 可以假设他的位置在 1001 后面)
         */
        /*public int[] relativeSortArray(int[] arr1, int[] arr2) {
            HashMap<Integer, Integer> map = new HashMap<>();
            List<Integer> list = new ArrayList<>();
            // 存放 arr1
            for (int temp: arr1) {
                list.add(temp);
            }
            // 存放 arr2
            for (int i = 0; i < arr2.length; i++) {
                map.put(arr2[i], i);
            }
            // 自定义比较
            Collections.sort(list, (o1, o2) -> {
                if (map.containsKey(o1) || map.containsKey(o2)) {
                    return map.getOrDefault(o1, 1001) - map.getOrDefault(o2, 1001);
                }
                return o1 - o2;
            });
            for (int i = 0; i < list.size(); i++) {
                arr1[i] = list.get(i);
            }
            return arr1;
        }*/

        /**
         * 4.双重循环检索存放
         * 时间复杂度肯定高一点, 易于理解,
         * 由于没有使用额外空间, 所以空间复杂度能更好
         */
        /*public int[] relativeSortArray(int[] arr1, int[] arr2) {
            int index = 0;// 标记已经存放好的最后一个元素位置
            for (int i = 0; i < arr2.length; i++) {
                for (int j = 0; j < arr1.length; j++) {
                    // 相等就需要交换到前面已经存放的最后一个位置
                    if (arr1[j] == arr2[i]) {
                        int temp = arr1[index];
                        arr1[index] = arr1[j];
                        arr1[j] = temp;
                        index++;
                    }
                }
            }
            // 后面的部分排序
            Arrays.sort(arr1, index, arr1.length);
            return arr1;
        }*/
    }

    /**
     * 2020/11/15
     * Solution402.移掉 k 位数字
     * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
     * 注意: (1)num 的长度小于 10002 且 ≥ k。(2)num 不会包含任何前导零。
     * 输入: num = "1432219", k = 3
     * 输出: "1219"
     * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
     *
     * 输入: num = "10200", k = 1
     * 输出: "200"
     * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
     *
     * 输入: num = "10", k = 2
     * 输出: "0"
     * 解释: 从原数字移除所有的数字，剩余为空就是0。
     */
    class Solution402 {
        /**
         * 1.从左到右遍历 k 次, 每次删除掉相邻元素中后一个小于前一个的前面的元素, 在删除掉前导零之后就是结果
         */
        public String removeKdigits(String num, int k) {
            if (num.length() == k) return "0";
            StringBuilder sb = new StringBuilder(num);
            // 遍历 k 次
            while (k-- > 0){
                int index = 0;// 应该删除的元素
                int i = 1;// 遍历查找
                // 查找第一对相邻元素中后一个小于前一个的前面的元素
                while (i < sb.length() && sb.charAt(i) >= sb.charAt(i - 1)) {
                    index = i;
                    i++;
                }
                sb.deleteCharAt(index);
                // 删除前导零
                while (sb.length() > 1 && sb.charAt(0) == '0') {
                    sb.deleteCharAt(0);
                }
            }
            return sb.toString();
        }
    }

    /**
     * 2020/11/16
     * Solution406.根据身高重建队列
     * 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。
     * 每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。请你重新构造并返回输入数组 people 所表示的队列。
     * 返回的队列应该格式化为数组 queue ，其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
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
     */
    class Solution406 {
        /**
         * 1.从低到高:
         *      (1) 按照身高升序, k 降序的顺序排序
         *      (2) 由于每一个人都不会对后面添加的人造成影响, 所以有影响的只能是后面添加的人
         *         -> 对于一个 person(h, k), 寻找第 k+1 个空位置(前面有 k 个空位置留给后面能造成影响的人)插入即可
         */
        /*public int[][] reconstructQueue(int[][] people) {
            // 按照身高从低到高, k 降序排序
            Arrays.sort(people, (o1, o2) -> {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }else {
                    return o1[0] - o2[0];
                }
            });
            int[][] result = new int[people.length][2];
            // 插入
            for (int[] person: people) {
//                // +1 可以在查找过程中: 当 temp 等于 0 时, 刚好是插入位置
//                int temp = person[1] + 1;
//                for (int i = 0; i < result.length; i++) {
//                    // 空位置
//                    if (result[i] == null) {
//                        temp--;
//                    }
//                    // 插入位置
//                    if (temp == 0) {
//                        result[i] = person;
//                        break;
//                    }
//                }
                // 前面身高大于等于 person 的人数, 也就是前面应该存在的空位置数量
                int temp = person[1];
                // 寻找插入位置
                int index = 0;
                while (temp > 0) {
                    // 空位置
                    if (result[index] == null) {
                        temp--;
                    }
                    index++;
                }
                // 查找到下一个空位置也就是插入位置
                while (result[index] != null) {
                    index++;
                }
                // 插入
                result[index] = person;
            }
            return result;
        }*/

        /**
         * 2.从高到低
         *      (1) 按照身高降序, k 升序的顺序排序
         *      (2) 由于每一个前面的人都会对后面的人有影响
         *        -> 对于一个 person(h, k) , 在第 k 个位置(前面插入每个人都有影响)插入即可
         */
        public int[][] reconstructQueue(int[][] people) {
            // 按照身高降序, k 升序排序
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
    }

    /**
     * 2020/11/17
     * Solution1030.距离顺序排列矩阵单元格
     * 给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。
     * 另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。
     * 返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，
     * 其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈顿距离，|r1 - r2| + |c1 - c2|。（你可以按任何满足此条件的顺序返回答案。）
     *      1 <= R <= 100
     *      1 <= C <= 100
     *      0 <= r0 < R
     *      0 <= c0 < C
     * 输入：R = 1, C = 2, r0 = 0, c0 = 0
     * 输出：[[0,0],[0,1]]
     * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1]
     *
     * 输入：R = 2, C = 2, r0 = 0, c0 = 1
     * 输出：[[0,1],[0,0],[1,1],[1,0]]
     * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2]
     * [[0,1],[1,1],[0,0],[1,0]] 也会被视作正确答案。
     *
     * 输入：R = 2, C = 3, r0 = 1, c0 = 2
     * 输出：[[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
     * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2,2,3]
     * 其他满足题目要求的答案也会被视为正确，例如 [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]]。
     */
    class Solution1030 {
        /**
         * 1.暴力: 直接排序
         */
        /*public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
            // 统计所有点
            int[][] result = new int[R * C][0];
            int index = 0;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    result[index++] = new int[]{i, j};
                }
            }
            // 排序
            Arrays.sort(result, (o1, o2) -> {
                return (Math.abs(o1[0] - r0) + Math.abs(o1[1] - c0)) - (Math.abs(o2[0] - r0) + Math.abs(o2[1] - c0));
            });
            return result;
        }*/

        /**
         * 2.桶排序: 求出最远距离, 建桶，装桶, 取值
         */
        public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
            // 行距离和列距离都最大时, 距离取得最大值
            int maxDistance = Math.max(r0, R - 1 - r0) + Math.max(c0, C - 1 - c0);
            // 建桶
            List<List<int[]>> bucket = new ArrayList<>();
            for (int i = 0; i <= maxDistance; i++) {
                bucket.add(new ArrayList<>());
            }
            // 装桶
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    // 计算距离
                    int distance = Math.abs(i - r0) + Math.abs(j - c0);;
                    // 装进相应的桶
                    bucket.get(distance).add(new int[]{i, j});
                }
            }
            // 取值
            int[][] result = new int[R * C][2];
            int index = 0;
            for (int i = 0; i <= maxDistance; i++) {
                for (int[] e: bucket.get(i)) {
                    result[index++] = e;
                }
            }
            return result;
        }
    }

    /**
     * 2020/11/18
     * Solution134.加油站
     * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
     * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
     * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
     * 说明: 
     *      如果题目有解，该答案即为唯一答案。
     *      输入数组均为非空数组，且长度相同。
     *      输入数组中的元素均为非负数。
     *
     * 输入:
     * gas  = [1,2,3,4,5]
     * cost = [3,4,5,1,2]
     * 输出: 3
     * 解释:
     * 从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
     * 开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
     * 开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
     * 开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
     * 开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
     * 开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
     * 因此，3 可为起始索引。
     *
     * 输入:
     * gas  = [2,3,4]
     * cost = [3,4,3]
     * 输出: -1
     * 解释:
     * 你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
     * 我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
     * 开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
     * 开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
     * 你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
     * 因此，无论怎样，你都不可能绕环路行驶一周。
     */
    class Solution134 {
        /**
         * 1.模拟:
         *      寻找可以作为起点的位置模拟是否可以行驶一圈
         * 时间复杂度: 龟速 ———— 仅作理解
         */
        /*public int canCompleteCircuit(int[] gas, int[] cost) {
            int n = gas.length;
            for (int i = 0; i < n; i++) {
                // 是否可以作为起点？
                if (gas[i] < cost[i]) {
                    continue;
                }
                // 开始模拟
                int sum = gas[i] - cost[i];// 剩余油量
                int j = (i + 1) % n;// 行驶一圈可能需要重新回到前面的下标位置
                while (j != i) {
                    sum += gas[j] - cost[j];// 到达下一站的剩余油量
                    // 无法到达下一站
                    if (sum < 0) {
                        break;
                    }
                    j = (j + 1) % n;
                }
                // 行驶完一周？
                if (j == i) {
                    return i;
                }
            }
            return -1;
        }*/

        /**
         * 使用图
         */
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int spare = 0;// 剩余油量
            int minSpare = Integer.MAX_VALUE;
            int minIndex = 0;// 最低点下标
            // 计算最低点下标
            for (int i = 0; i < gas.length; i++) {
                spare += gas[i] - cost[i];
                if (spare < minSpare) {
                    minSpare = spare;
                    minIndex = i;;
                }
            }
            // 最终的油量是否大于 0
            return spare < 0 ? -1 : (minIndex + 1) % gas.length;
        }
    }

    /**
     * 2020/11/19
     * Solution283.移动零
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * 说明:
     *      必须在原数组上操作，不能拷贝额外的数组。
     *      尽量减少操作次数。
     *
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     */
    class Solution283 {
        /**
         * 1.重组数组: 不是 0 的前移, 后面的全为 0
         */
        /*public void moveZeroes(int[] nums) {
            int index = 0;// 重组数组遍历位置
            // 不是 0 的前移
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[index++] = nums[i];
                }
            }
            // 剩余的全为 0
            for (int i = index; i < nums.length; i++) {
                nums[index++] = 0;
            }
        }*/

        /**
         * 2.双指针: 使用双指针遍历数组, 使得 [0, left) 全都不为 0; [left, right) 全都是 0.
         */
        public void moveZeroes(int[] nums) {
            int left = 0;
            int right = 0;
            while (right < nums.length) {
                if (nums[right] == 0) {
                    // 交换
                    int temp = nums[right];
                    nums[right] = nums[left];
                    nums[left] = temp;
                    left++;
                }
                right++;
            }
        }
    }

    /**
     * 2020/11/20
     * Solution147.对链表进行插入排序
     * 从第一个元素开始，该链表可以被认为已经部分排序。每次迭代时，从输入数据中移除一个元素，并原地将其插入到已排好序的链表中。
     * 插入排序算法：
     *      插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
     *      每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
     *      重复直到所有输入数据插入完为止。
     *
     * 输入: 4->2->1->3
     * 输出: 1->2->3->4
     *
     * 输入: -1->5->3->4->0
     * 输出: -1->0->3->4->5
     */
    class Solution147 {
        /**
         * 插入排序
         */
        public ListNode insertionSortList(ListNode head) {
            // 判空
            if (head == null) {
                return null;
            }
            // 可能改变头节点 -> 定义傀儡头节点
            ListNode dummyHead = new ListNode(0);
            dummyHead.next = head;// 连接头节点
            ListNode cur = head.next;// 遍历节点
            ListNode prev = head;// 有序链表序列的最后一个节点
            while (cur != null) {
                // 大于有序链表序列的最大值
                if (cur.val > prev.val) {
                    // 同步后移
                    prev = cur;
                    cur = cur.next;
                }else {
                    // 查找合适的插入位置 -> 也就是插入位置的前一个节点
                    ListNode temp = dummyHead;// 查找节点
                    // 查找第一个大于 待排序节点 的节点
                    while (temp.next.val < cur.val) {
                        temp = temp.next;
                    }
                    // 已经找到 -> 插入 (插入之前保存遍历位置)
                    prev.next = cur.next;
                    cur.next = temp.next;
                    temp.next = cur;
                    // 归位
                    cur = prev.next;
                }
            }
            return dummyHead.next;
        }
    }

    /**
     * 2020/11/21
     * Solution148.排序链表
     * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
     *      进阶: 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
     *
     * 输入：head = [4,2,1,3]
     * 输出：[1,2,3,4]
     *
     * 输入：head = [-1,5,3,4,0]
     * 输出：[-1,0,3,4,5]
     * 示例 3：
     *
     * 输入：head = []
     * 输出：[]
     */
    class Solution148 {
        /**
         * 1.自底向上归并排序: 根据 subLen (初始为1)的长度切割链表, 直到 subLen 的长度不小于链表长度
         */
        /*public ListNode sortList(ListNode head) {
            if (head == null) {
                return null;
            }
            // 计算链表长度
            int size = 0;
            ListNode cur = head;
            while (cur != null) {
                size++;
                cur = cur.next;
            }
            // 分割链表进行归并排序
            ListNode dummyHead = new ListNode(0);// 傀儡头节点
            dummyHead.next = head;// 连接
            int subLen = 1;// 每个子链表的长度 -> 初始为 1
            while (subLen < size) {
                ListNode temp = dummyHead;// 有序链表序列的尾结点
                cur = temp.next;// 每一轮归并排序从头开始
                while (cur != null) {
                    // 第一段子链表
                    ListNode head1 = cur;
                    for (int i = 0; i < subLen-1 && cur.next != null; i++) {
                        cur = cur.next;
                    }
                    // 第二段子链表
                    ListNode head2 = cur.next;// 第二个链表头节点
                    cur.next = null;// 断开链表一
                    cur = head2;
                    for (int i = 0; i < subLen - 1 && cur != null && cur.next != null; i++) {
                        cur = cur.next;
                    }
                    // 是否有第二段链表？
                    // 存在需要断开 -> 保存遍历位置
                    ListNode cueNext = null;
                    if (cur != null) {
                        cueNext = cur.next;
                        cur.next = null;// 断开
                    }
                    // 归并排序
                    temp.next = mergeSortList(head1, head2);
                    // 移至有序链表序列尾结点
                    while (temp.next != null) {
                        temp = temp.next;
                    }
                    cur = cueNext;
                }
                subLen *= 2;
            }
            return dummyHead.next;
        }
        // 辅助-归并排序
        public ListNode mergeSortList(ListNode head1, ListNode head2) {
            ListNode dummyHead = new ListNode(0);
            ListNode temp = dummyHead;
            // 归并排序
            while (head1 != null && head2 !=null) {
                if (head1.val < head2.val) {
                    temp.next = head1;
                    head1 = head1.next;
                }else {
                    temp.next = head2;
                    head2 = head2.next;
                }
                temp = temp.next;
            }
            // 此时有一个链表连接完
            temp.next = (head1 == null) ? head2 : head1;
            return dummyHead.next;
        }*/

        /**
         * 2.自顶向下归并排序: 每一次根据中间节点将链表分割, 从上到下分割完毕后再进行归并
         */
        public ListNode sortList(ListNode head) {
            return mergeList(head, null);
        }
        // 辅助函数-分治: 根据中间结点加链表分割为两部分
        public ListNode mergeList(ListNode head, ListNode tail) {
            // 剩余 0 / 2 个节点
            if (head == null) {
                return head;
            }
            if (head.next == tail) {
                head.next = null;
                return head;
            }
            // 寻找中间节点
            ListNode fast = head;
            ListNode slow = head;
            while (fast != tail && fast.next != tail) {
                fast = fast.next.next;
                slow = slow.next;
            }
            // 继续向下分割
            ListNode head1 = mergeList(head, slow);
            ListNode head2 = mergeList(slow, tail);
            // 合并
            return merge(head1, head2);
        }
        // 辅助函数-合并: 合并两个有序链表
        public ListNode merge(ListNode head1, ListNode head2) {
            ListNode dummyHead = new ListNode(0);
            ListNode temp = dummyHead;
            while (head1 != null && head2 != null) {
                if (head1.val < head2.val) {
                    temp.next = head1;
                    head1 = head1.next;
                }else {
                    temp.next = head2;
                    head2 = head2.next;
                }
                temp = temp.next;
            }
            // 此时一个链表归并完毕
            temp.next = (head1 == null) ? head2 : head1;
            return dummyHead.next;
        }
    }

    /**
     * 2020/11/22
     * Solution242.有效的字母异位词
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     *
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     *
     * 输入: s = "rat", t = "car"
     * 输出: false
     */
    class Solution242 {
        /**
         * 1.排序
         */
        public boolean isAnagram(String s, String t) {
            // 转换数组
            char[] charS = s.toCharArray();
            char[] charT = t.toCharArray();
            // 排序
            Arrays.sort(charS);
            Arrays.sort(charT);
            // 是否相等?
            return Arrays.equals(charS, charT);
        }

        /**
         * 2.计数数组: 使用数组统计两个字符串相同字符的出现次数之差 -> 只能为 0
         */
        /*public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) return false;
            int[] count = new int[26];
            // s 中相应字符 +1, t 中相应字符 -1
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a']++;
                count[t.charAt(i) - 'a']--;
            }
            // 判断
            for (int e: count) {
                if (e != 0) {
                    return false;
                }
            }
            return true;
        }*/
    }

    /**
     * 2020/11/23
     * Solution452.用最少数量的箭引爆气球
     * 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。
     * 由于它是水平的，所以纵坐标并不重要，因此只要知道开始和结束的横坐标就足够了。开始坐标总是小于结束坐标。
     * 一支弓箭可以沿着 x 轴从不同点完全垂直地射出。
     * 在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend，且满足  xstart ≤ x ≤ xend，则该气球会被引爆。
     * 可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
     * 给你一个数组 points ，其中 points [i] = [xstart,xend] ，返回引爆所有气球所必须射出的最小弓箭数。
     *
     * 输入：points = [[10,16],[2,8],[1,6],[7,12]]
     * 输出：2
     * 解释：对于该样例，x = 6 可以射爆 [2,8],[1,6] 两个气球，以及 x = 11 射爆另外两个气球
     *
     * 输入：points = [[1,2],[3,4],[5,6],[7,8]]
     * 输出：4
     *
     * 输入：points = [[1,2],[2,3],[3,4],[4,5]]
     * 输出：2
     *
     * 输入：points = [[1,2]]
     * 输出：1
     *
     * 输入：points = [[2,3],[2,3]]
     * 输出：1
     */
    class Solution452 {
        /**
         * 1.自定义排序
         */
        public int findMinArrowShots(int[][] points) {
            if (points == null || points.length == 0) return 0;
            int arrow = 1;//至少一只箭
            // 自定义排序, 根据结束坐标 -> 由于射出箭的位置必定在某一结束坐标出最佳
            Arrays.sort(points, (o1, o2) -> {
                if (o1[1] == o2[1]) {
                    return 0;
                }else {
                    return o1[1] > o2[1] ? 1 : -1;// 防止两数相减溢出
                }
            });
            // 射箭
            int pos = points[0][1];// 射出点
            for (int i = 0; i < points.length; i++) {
                // 当前位置的箭无法射爆
                if (points[i][0] > pos) {
                    pos = points[i][1];// 新的射出点
                    arrow++;
                }
            }
            return arrow;
        }
    }

    /**
     * 2020/11/24
     * Solution222.完全二叉树的节点个数
     * 给出一个完全二叉树，求出该树的节点个数。
     * 说明：
     *      完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，
     *      并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
     *
     * 输入:
     *     1
     *    / \
     *   2   3
     *  / \  /
     * 4  5 6
     *
     * 输出: 6
     */
    class Solution222 {
        /**
         * 1.层序遍历?(划掉) 有点慢了, 递归就可
         */
        public int countNodes(TreeNode root) {
            if (root == null) return 0;
            // 左子树和右子树节点个数之和
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }

    /**
     * 2020/11/25
     * Solution1370.上升下降字符串
     * 给你一个字符串 s ，请你根据下面的算法重新构造字符串：
     *      从 s 中选出 最小 的字符，将它 接在 结果字符串的后面。
     *      从 s 剩余字符中选出 最小 的字符，且该字符比上一个添加的字符大，将它 接在 结果字符串后面。
     *      重复步骤 2 ，直到你没法从 s 中选择字符。
     *      从 s 中选出 最大 的字符，将它 接在 结果字符串的后面。
     *      从 s 剩余字符中选出 最大 的字符，且该字符比上一个添加的字符小，将它 接在 结果字符串后面。
     *      重复步骤 5 ，直到你没法从 s 中选择字符。
     *      重复步骤 1 到 6 ，直到 s 中所有字符都已经被选过。
     * 在任何一步中，如果最小或者最大字符不止一个 ，你可以选择其中任意一个，并将其添加到结果字符串。请你返回将 s 中字符重新排序后的 结果字符串 。
     *      1 <= s.length <= 500
     *      s 只包含小写英文字母。
     * 输入：s = "aaaabbbbcccc"
     * 输出："abccbaabccba"
     * 解释：第一轮的步骤 1，2，3 后，结果字符串为 result = "abc"
     * 第一轮的步骤 4，5，6 后，结果字符串为 result = "abccba"
     * 第一轮结束，现在 s = "aabbcc" ，我们再次回到步骤 1
     * 第二轮的步骤 1，2，3 后，结果字符串为 result = "abccbaabc"
     * 第二轮的步骤 4，5，6 后，结果字符串为 result = "abccbaabccba"
     *
     * 输入：s = "rat"
     * 输出："art"
     * 解释：单词 "rat" 在上述算法重排序以后变成 "art"
     *
     * 输入：s = "leetcode"
     * 输出："cdelotee"
     *
     * 输入：s = "ggggggg"
     * 输出："ggggggg"
     *
     * 输入：s = "spo"
     * 输出："ops"
     */
    class Solution1370 {
        /**
         * 1.数组计数: 使用数组计数, 将 从小到大 + 从大到小 作为一次遍历, 直至结果串和原字符串长度相等
         */
        public String sortString(String s) {
            int[] count = new int[26];
            // 统计出现字符以及相应的次数
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            // 重新构造字符串
            while (sb.length() != s.length()) {
                // 从小到大
                for (int i = 0; i < 26; i++) {
                    if (count[i] != 0) {
                        sb.append((char) (i + 'a'));
                        count[i]--;
                    }
                }
                // 从大到小
                for (int i = 25; i >= 0; i--) {
                    if (count[i] != 0) {
                        sb.append((char) (i + 'a'));
                        count[i]--;
                    }
                }
            }
            return sb.toString();
        }
    }

    /**
     * 2020/11/26
     * Solution164.最大间距
     * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。如果数组元素个数小于 2，则返回 0。
     *      你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。
     * 输入: [3,6,9,1]
     * 输出: 3
     * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
     *
     * 输入: [10]
     * 输出: 0
     * 解释: 数组元素个数小于 2，因此返回 0。
     */
    class Solution164 {
        /**
         * 1.基于排序函数: 先排序再求差值
         */
        public int maximumGap(int[] nums) {
            // 排序
            Arrays.sort(nums);
            // 计算差值
            int maxSub = 0;
            for (int i = 1; i < nums.length; i++) {
                int sub = nums[i] - nums[i-1];
                maxSub = Math.max(sub, maxSub);
            }
            return maxSub;
        }
        // 基数排序
    }

    /**
     * 2020/11/27
     * Solution454.四数相加Ⅱ
     * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
     * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
     *
     * 输入:
     *      A = [ 1, 2]
     *      B = [-2,-1]
     *      C = [-1, 2]
     *      D = [ 0, 2]
     * 输出:
     *      2
     * 解释:
     * 两个元组如下:
     *      1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
     *      2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
     */
    class Solution454 {
        /**
         * 1.两数之和 = - 另两数之和
         */
        public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
            // 两数之和
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < B.length; j++) {
                    int sum = A[i] + B[j];
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
            // 另两数之和 -> 与上面的两数之和互为相反数
            int count = 0;
            int[] sumCD = new int[C.length * D.length];
            for (int i = 0; i < C.length; i++) {
                for (int j = 0; j < D.length; j++) {
                    int sum = -(C[i] + D[j]);
                    // 互为相反数的和
                    count += map.getOrDefault(sum, 0);
                }
            }
            return count;
        }
    }

    /**
     * 2020/11/28
     * Solution493.翻转对
     * 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
     * 你需要返回给定数组中的重要翻转对的数量。
     *
     * 输入: [1,3,2,3,1]
     * 输出: 2
     *
     * 输入: [2,4,3,5,1]
     * 输出: 3
     */
    class Solution493 {
        /**
         * 自顶向上归并计算反转对
         */
        public int reversePairs(int[] nums) {
            if (nums.length == 0) return 0;
            return reversePairs(nums, 0, nums.length - 1);
        }
        // 辅助方法——递归分支:计算翻转对
        public int reversePairs(int[] nums, int start, int end) {
            if (start >= end) return 0;
            // 计算中间位置
            int mid = (start + end) / 2;
            // 分割 + 计算左右两边的反转对
            int leftPairs = reversePairs(nums, start, mid);
            int rightPairs = reversePairs(nums, mid + 1, end);
            int result = leftPairs + rightPairs;
            // 统计翻转对数量-此时的链表是有序的
            int left = start;
            int right = mid + 1;
            while (left <= mid) {
                // 计算对于当前的 left 翻转对的停止位置
                while (right <= end && (long) nums[left] > 2 * (long) nums[right]) {
                    right++;
                }
                // 翻转对数量: 此时的 right 不满足 所以是 right - (mid + 1) + 1 - 1
                result += right - mid - 1;
                left++;
            }
            // 归并
            merge(nums, start, end, mid);
            return result;
        }
        // 辅助方法——归并排序
        public void merge(int[] nums, int start, int end, int mid) {
            int[] temp = new int[end - start + 1];
            int left = start;
            int right = mid + 1;
            int index = 0;
            while (left <= mid && right <= end) {
                if (nums[left] <= nums[right]) {
                    temp[index++] = nums[left++];
                }else {
                    temp[index++] = nums[right++];
                }
            }
            // 此时有一个序列遍历完
            while (left <= mid) {
                temp[index++] = nums[left++];
            }
            while (right <= end) {
                temp[index++] = nums[right++];
            }
            // 存放进原来的数组
            for (int i = 0; i < temp.length; i++) {
                nums[start + i] = temp[i];
            }
        }
    }

    /**
     * 2020/11/29
     * Solution976.三角形的最大周长
     * 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。如果不能形成任何面积不为零的三角形，返回 0。
     *          3 <= A.length <= 10000
     *          1 <= A[i] <= 10^6
     * 输入：[2,1,2]
     * 输出：5
     *
     * 输入：[1,2,1]
     * 输出：0
     *
     * 输入：[3,2,3,4]
     * 输出：10
     *
     * 输入：[3,6,2,3]
     * 输出：8
     */
    class Solution976 {
        /**
         * 贪心 + 排序 : 排序依次判断最后三个数是否可以构成三角形
         */
        public int largestPerimeter(int[] A) {
            // 排序
            Arrays.sort(A);
            // 对于从后向前连续三个数
            // 1.可以组成三角形 : 周长最大
            // 2.不能组成三角形 : 前面的肯定也不可以
            for (int i = A.length - 1; i >= 2; i--) {
                // 可以构成三角形
                if (A[i - 1] + A[i - 2] > A[i]) {
                    return A[i] + A[i - 1] + A[i - 2];
                }
            }
            return 0;
        }
    }

    /**
     * 2020/11/30
     * Solution767.重构字符串
     * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。若可行，输出任意可行的结果。若不可行，返回空字符串。
     * S 只包含小写字母并且长度在[1, 500]区间内。
     *
     * 输入: S = "aab"
     * 输出: "aba"
     *
     * 输入: S = "aaab"
     * 输出: ""
     */
    class Solution767 {
        /**
         * 贪心 + 计数
         */
        public String reorganizeString(String S) {
            int[] count = new int[26];
            // 计数 + 最多次数字符
            int maxNum = 0;// 最大次数
            char maxChar = 'a';// 出现次数最多字符
            for (int i = 0; i < S.length(); i++) {
                char ch = S.charAt(i);
                count[ch - 'a']++;
                if (count[ch - 'a'] > maxNum) {
                    maxNum = count[ch - 'a'];
                    maxChar = ch;
                }
            }
            // 长度大于整体的一半肯定不行
            if (maxNum > (S.length() + 1) / 2) return "";
            // 插入
            char[] result = new char[S.length()];
            // 1.插入 maxChar 到偶数下标
            int index = 0;
            while (maxNum-- >0) {
                result[index] = maxChar;
                index += 2;
            }
            count[maxChar - 'a'] = 0;
            // 2.插入其他元素
            for (int i = 0; i < 26; i++) {
                char ch = (char) (i + 'a');
                while (count[i]-- > 0) {
                    // 偶数插完从奇数开始
                    if (index > result.length - 1) {
                        index = 1;
                    }
                    result[index] = ch;
                    index += 2;
                }
            }
            return new String(result);
        }
    }

    /**
     * 2020/12/01
     * Solution34.在排序数组中查找元素的第一个和最后一个位置
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     * 如果数组中不存在目标值 target，返回 [-1, -1]。
     * 进阶：你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
     *       0 <= nums.length <= 105
     *       -10^9 <= nums[i] <= 10^9
     *       nums 是一个非递减数组
     *       -10^9 <= target <= 10^9
     * 输入：nums = [5,7,7,8,8,10], target = 8
     * 输出：[3,4]
     *
     * 输入：nums = [5,7,7,8,8,10], target = 6
     * 输出：[-1,-1]
     *
     * 输入：nums = [], target = 0
     * 输出：[-1,-1]
     */
    class Solution34 {
        /**
         * 升序排列 -> 二分查找目标元素 -> 查找第一次和最后一次出现的元素
         */
        public int[] searchRange(int[] nums, int target) {
            int first = 0;
            int last = 0;
            int index = binarySearch(nums, target);
            if (index != -1) {
                int temp = index;
                // 查找第一个
                while (temp >= 0 && nums[temp] == target) {
                    temp--;
                }
                first = temp + 1;
                // 查找最后一个
                while (index < nums.length && nums[index] == target) {
                    index++;
                }
                last = index - 1;
                return new int[]{first, last};
            }
            return new int[]{-1, -1};
        }
        // 辅助方法——二分查找目标元素
        public int binarySearch(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                // 在右区间找
                if (nums[mid] < target) {
                    left = mid + 1;
                }else if (nums[mid] > target){
                    // 在左区间找
                    right = mid - 1;
                }else {
                    // 找到
                    return mid;
                }
            }
            return -1;
        }

        /**
         * 优化: 使用 flag 代表查找的目标元素位置
         */
        /*public int[] searchRange(int[] nums, int target) {
            // flag = true -> 查找第一个大于等于目标值的下标
            // flag = false -> 查找第一个大于目标值的下标
            int first = binarySearch(nums, target, true);
            int last = binarySearch(nums, target, false) - 1;
            // 判断合理性
            if (first <= last && last < nums.length && nums[first] == target && nums[last] == target) {
                return new int[]{first, last};
            }
            return new int[]{-1, -1};
        }
        // 辅助方法——二分查找
        public int binarySearch(int[] nums, int target, boolean flag) {
            int left = 0;
            int right = nums.length - 1;
            int result = nums.length;
            while (left <= right) {
                int mid = (left + right) / 2;
                // flag = true -> 查找第一个大于等于的
                // flag = false -> 查找第一个大于的
                if (nums[mid] > target || (nums[mid] >= target && flag)) {
                    // 左区间查找
                    right = mid - 1;
                    result = mid;
                }else {
                    // 右区间查找
                    left = mid + 1;
                }
            }
            return result;
        }*/
    }

    /**
     * 2020/12/02
     * Solution321.拼接最大数
     * 给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。
     * 现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
     * 求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。
     * 说明: 请尽可能地优化你算法的时间和空间复杂度。
     *
     * 输入:
     * nums1 = [3, 4, 6, 5]
     * nums2 = [9, 1, 2, 5, 8, 3]
     * k = 5
     * 输出:
     * [9, 8, 6, 5, 3]
     *
     * 输入:
     * nums1 = [6, 7]
     * nums2 = [6, 0, 4]
     * k = 5
     * 输出:
     * [6, 7, 6, 0, 4]
     *
     * 输入:
     * nums1 = [3, 9]
     * nums2 = [8, 9]
     * k = 3
     * 输出:
     * [9, 8, 9]
     */
    class Solution321 {
        /**
         * 单调栈获取相应的最大子序列 -> 归并排序两个子序列 -> 比较所有的子序列取最大子序列即可
         *      对于一个数组:
         *          如果长度大于 k, 另一个数组可以从 0 开始作为子序列的长度直到 k;
         *          反之, 由于该数组最多只能取数组长度个元素, 另一数字至少取 k-数组长度 个元素
         */
        public int[] maxNumber(int[] nums1, int[] nums2, int k) {
            int[] result = new int[k];
            // 如果长度大于 k, 另一个数组可以从 0 开始作为子序列的长度直到 k;
            // 反之, 由于该数组最多只能取数组长度个元素, 另一数字至少取 k-数组长度 个元素
            // 对于 nums1 进行子序列长度判断:
            int start = Math.max(0, k - nums2.length);
            int end = Math.min(k, nums1.length);
            for (int i = start; i <= end; i++) {
                // 构造子序列
                int[] subSequence1 = maxSubSequence(nums1, i);
                int[] subSequence2 = maxSubSequence(nums2, k - i);
                // 合并
                int[] maxSubSequence = merge(subSequence1, subSequence2, k);
                // 比较选择最大子序列
                if (compare(maxSubSequence, 0, result, 0) > 0) {
                    System.arraycopy(maxSubSequence, 0, result, 0, k);
                }
            }
            return result;
        }
        // 辅助方法——单调栈:构造长度为 k 的最大子序列
        public int[] maxSubSequence(int[] nums, int k) {
            // 使用数组模拟单调栈
            int[] stack = new int[k];
            int top = -1;// 栈顶指针
            int remain = nums.length - k;// 应该移除的元素数量
            // 维护一个单调递减的栈
            for (int i = 0; i < nums.length; i++) {
                // 维护单调栈
                while (top >= 0 && stack[top] < nums[i] && remain > 0) {
                    top--;
                    remain--;
                }
                // 入栈 或者 移除当前元素
                if (top < k - 1) {
                    stack[++top] = nums[i];
                }else {
                    remain--;
                }
            }
            return stack;
        }
        // 辅助方法——合并两个序列
        public int[] merge(int[] nums1, int[] nums2, int k) {
            if (nums1.length == 0) return nums2;
            if (nums2.length == 0) return nums1;
            int[] result = new int[k];
            int index1 = 0;
            int index2 = 0;
            for (int i = 0; i < k; i++) {
                // 比较合并
                if (compare(nums1, index1, nums2, index2) > 0) {
                    result[i] = nums1[index1++];
                }else {
                    result[i] = nums2[index2++];
                }
            }
            return result;
        }
        // 辅助方法——比较两个序列
        public int compare(int[] nums1, int index1, int[] nums2, int index2) {
            while (index1 < nums1.length && index2 < nums2.length) {
                if (nums1[index1] - nums2[index2] != 0) {
                    return nums1[index1] - nums2[index2];
                }else {
                    index1++;
                    index2++;
                }
            }
            return (nums1.length - index1) - (nums2.length - index2);
        }
    }

    /**
     * 2020/12/03
     * Solution204.计数质数
     * 统计所有小于非负整数 n 的质数的数量。
     * 输入：n = 10
     * 输出：4
     * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
     *
     * 输入：n = 0
     * 输出：0
     *
     * 输入：n = 1
     * 输出：0
     */
    class Solution204 {
        /**
         * 一个数是否为质数: 使用平方根变形(j * j <= i)判断
         */
        /*public int countPrimes(int n) {
            if (n <= 2) return 0;
            int count = 0;
            for (int i = 3; i < n; i += 2) {
                boolean flag = true;
                for (int j = 2; j * j < i; j++) {
                    if (i % j == 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    count++;
                }
            }
            return count;
        }*/

        /**
         * 一个数是否为质数:去除不可能为质数的数
         */
        public int countPrimes(int n) {
            boolean[] flag = new boolean[n];
            Arrays.fill(flag, true);
            // 去除不是质数的数
            // 保证当前的数字在规定的范围内
            for (int i = 2; i * i < n; i++) {
                // 当前元素是质数, 那么其平方、倍数不为质数
                if (flag[i]) {
                    for (int j = i * i; j < n; j += i) {
                        flag[j] = false;
                    }
                }
            }
            // 统计质数
            int count = 0;
            for (int i = 2; i < n; i++) {
                if (flag[i]) {
                    count++;
                }
            }
            return count;
        }
    }

    /**
     * 2020/12/04
     * Solution659.分割数组为连续子序列
     * 给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个长度至少为 3 的子序列，其中每个子序列都由连续整数组成。
     * 如果可以完成上述分割，则返回 true ；否则，返回 false 。
     *
     * 输入: [1,2,3,3,4,5]
     * 输出: True
     * 解释:
     * 你可以分割出这样两个连续子序列 :
     * 1, 2, 3
     * 3, 4, 5
     *
     * 输入: [1,2,3,3,4,4,5,5]
     * 输出: True
     * 解释:
     * 你可以分割出这样两个连续子序列 :
     * 1, 2, 3, 4, 5
     * 3, 4, 5
     *
     * 输入: [1,2,3,4,4,5]
     * 输出: False
     */
    class Solution659 {
        /**
         * 贪心算法: 使用两个 map 分别保存剩余元素和相对应数量以及以某个元素结尾的子序列个数
         */
        public boolean isPossible(int[] nums) {
            HashMap<Integer, Integer> countMap = new HashMap<>();
            HashMap<Integer, Integer> endMap = new HashMap<>();
            // 统计数组中的元素以及相应数量
            for (int e: nums) {
                countMap.put(e, countMap.getOrDefault(e, 0) + 1);
            }
            // 分割数组
            for (int e: nums) {
                // 判断当前元素是否有剩余
                if (countMap.getOrDefault(e, 0) != 0) {
                    // 判断是否有以 e-1 结尾的子序列
                    if (endMap.getOrDefault(e - 1, 0) != 0) {
                        // 如果有就可以加入到该子序列
                        countMap.put(e, countMap.getOrDefault(e, 0) - 1);// 元素个数 - 1
                        endMap.put(e - 1, endMap.getOrDefault(e - 1, 0) - 1);// 以 e-1 结尾子序列 -1
                        endMap.put(e, endMap.getOrDefault(e, 0) + 1);// 以 e 结尾子序列 +1
                    }else {
                        // 如果没有, 判断后面是否可以组成一个子序列
                        if (countMap.getOrDefault(e + 1, 0) != 0 && countMap.getOrDefault(e + 2, 0) != 0) {
                            countMap.put(e, countMap.getOrDefault(e, 0) - 1);// 元素个数 - 1
                            countMap.put(e + 1, countMap.getOrDefault(e + 1, 0) - 1);
                            countMap.put(e + 2, countMap.getOrDefault(e + 2, 0) - 1);
                            endMap.put(e + 2, endMap.getOrDefault(e + 2, 0) + 1);// 以 e+2 结尾子序列 +1
                        }else {
                            // 不能构成
                            return false;
                        }
                    }
                }
            }
            return true;
        }
    }

    /**
     * 2020/12/05
     * Solution621.任务调度器
     * 给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。
     * 任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。
     * 然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
     * 你需要计算完成所有任务所需要的 最短时间 。
     *
     * 输入：tasks = ["A","A","A","B","B","B"], n = 2
     * 输出：8
     * 解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B
     *      在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。
     *
     * 输入：tasks = ["A","A","A","B","B","B"], n = 0
     * 输出：6
     * 解释：在这种情况下，任何大小为 6 的排列都可以满足要求，因为 n = 0
     *
     * 输入：tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
     * 输出：16
     * 解释：一种可能的解决方案是：
     *      A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> (待命) -> (待命) -> A -> (待命) -> (待命) -> A
     */
    class Solution621 {
        /**
         * 模拟: 
         *      由于求最短时间, 每一次冷却次数最多的都需要调度：
         *          如果次数最多的任务数量大于等于其他元素之和, 每次都需调度
         *          反之, 冷却时间相当于没有作用, 数组长度就是时间
         */
        public int leastInterval(char[] tasks, int n) {
            int[] count = new int[26];
            // 统计次数
            for (char ch: tasks) {
                count[ch - 'A']++;
            }
            // 求最大数量的任务个数
            Arrays.sort(count);
            int max = 0;// 最大数量的任务个数
            for (int i = 25; i >= 0; i--) {
                if (count[i] != count[25]) {
                    break;
                }
                max++;
            }
            return Math.max(tasks.length, (count[25] - 1) * ( n + 1) + max);
        }
    }

    /**
     * 2020/12/06
     * Solution118.杨辉三角
     * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
     * 在杨辉三角中，每个数是它左上方和右上方的数的和。
     *
     * 输入: 5
     * 输出:
     * [
     *      [1],
     *     [1,1],
     *    [1,2,1],
     *   [1,3,3,1],
     *  [1,4,6,4,1]
     * ]
     */
    class Solution118 {
        /**
         * 模拟
         */
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i < numRows; i++) {// 行
                List<Integer> list = new ArrayList<>();
                // 第一行
                list.add(1);
                for (int j = 1; j < i; j++) {// 列
                    // 上一行正上方和左上方之和
                    list.add(result.get(i - 1).get(j) + result.get(i - 1).get(j - 1));
                }
                // 最后一列
                if (i > 0) {
                    list.add(1);
                }
                result.add(list);
            }
            return result;
        }
    }

    /**
     * 2020/12/07
     * Solution861.反转矩阵后的得分
     * 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
     * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。返回尽可能高的分数。
     *      1 <= A.length <= 20
     *      1 <= A[0].length <= 20
     *      A[i][j] 是 0 或 1
     *
     * 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
     * 输出：39
     * 解释：
     * 转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
     * 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
     */
    class Solution861 {
        /**
         * 模拟转换: 在转换使得第一列全为 1 的情况下, 后面每一列的 1 尽可能多
         */
        public int matrixScore(int[][] A) {
            int score = 0;
            // 第一列全为 1
            score += A.length * (1 << (A[0].length - 1));
            for (int i = 1; i < A[0].length; i++) {// 列
                int count = 0;// 每一列 1 的个数
                for (int j = 0; j < A.length; j++) {//行
                    // 当前行第一个元素为 0,就需要翻转: 0 -> 1
                    if (A[j][0] == 0 && A[j][i] == 0) {
                        count++;
                    }else if (A[j][0] == 1 && A[j][i] == 1){
                        // 当前行第一个元素为 1,就不需要翻转
                        count++;
                    }
                }
                // 1 的个数应该大于 0 的个数
                count = Math.max(count, A.length - count);
                score += count * (1 << (A[0].length - 1 - i));
            }
            return score;
        }
    }

    /**
     * 2020/12/08
     * Solution842.将数组拆分成斐波那契数列
     * 给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。
     * 形式上，斐波那契式序列是一个非负整数列表 F，且满足：
     *      0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
     *      F.length >= 3；
     * 对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
     * 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
     * 返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。
     *
     * 输入："123456579"
     * 输出：[123,456,579]
     *
     * 输入: "11235813"
     * 输出: [1,1,2,3,5,8,13]
     *
     * 输入: "112358130"
     * 输出: []
     * 解释: 这项任务无法完成。
     *
     * 输入："0123"
     * 输出：[]
     * 解释：每个块的数字不能以零开头，因此 "01"，"2"，"3" 不是有效答案。
     *
     * 输入: "1101111"
     * 输出: [110, 1, 111]
     * 解释: 输出 [11,0,11,11] 也同样被接受。
     */
    class Solution842 {
        /**
         * 回溯 + 剪枝
         */
        public List<Integer> splitIntoFibonacci(String S) {
            List<Integer> list = new ArrayList<>();
            backtrack(list, S, S.length(), 0, 0, 0);
            return list;
        }
        // 辅助方法——回溯
        public boolean backtrack(List<Integer> list, String S, int length, int index, int sum, int prev) {
            // 满足要求 -> 字符串分割完成并且分割的序列至少有 3 个
            if (index == length && list.size() > 2) return true;
            // 回溯分割序列
            long cur = 0L;
            for (int i = index; i < length; i++) {
                // 剪枝: 以 0 开头 -> 不符合要求
                if (i > index && S.charAt(index) == '0') {
                    break;
                }
                // 当前的数字序列
                cur = cur * 10 + S.charAt(i) - '0';
                // 剪枝: 不在有效的取值范围内
                if (cur > Integer.MAX_VALUE) {
                    break;
                }
                int num = (int) cur;
                // 判断是否是前两数之和
                if (list.size() >= 2) {
                    // 剪枝: 拆分出的数大于前面 2 数之和
                    if (num > sum) {
                        break;
                    }else if (num < sum) {
                        // 需要继续拆分
                        continue;
                    }
                }
                // 此时当前数是前面两数之和
                list.add(num);
                // 回溯判断
                if (backtrack(list, S, length, i + 1, prev + num, num)) {
                    return true;
                }else {
                    // 移除最后一个元素
                    list.remove(list.size() - 1);
                }
            }
            return false;
        }
    }

    /**
     * 2020/12/09
     * Solution62.不同路径
     * 一个机器人位于一个 m x n 网格的左上角。 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角。
     * 问总共有多少条不同的路径？
     *      1 <= m, n <= 100
     *      题目数据保证答案小于等于 2 * 109
     *
     * 输入：m = 3, n = 7
     * 输出：28
     *
     * 输入：m = 3, n = 2
     * 输出：3
     * 解释：
     * 从左上角开始，总共有 3 条路径可以到达右下角。
     * 1. 向右 -> 向右 -> 向下
     * 2. 向右 -> 向下 -> 向右
     * 3. 向下 -> 向右 -> 向右
     *
     * 输入：m = 7, n = 3
     * 输出：28
     *
     * 输入：m = 3, n = 3
     * 输出：6
     */
    class Solution62 {
        /**
         * 动态规划:
         *      转移方程: dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
         */
        /*public int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];
            // 左边或者上边的路径数只有1
            for (int i = 0; i < m; i++) {
                dp[i][0] = 1;
            }
            for (int i = 0; i < n; i++) {
                dp[0][i] = 1;
            }
            // 动态规划转移到其他位置
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
            return dp[m - 1][n - 1];
        }*/

        /**
         * 组合数学：移动过程相当于向下 m-1 次, 向右 n-1 次; 一共需要移动 m+n-2 次
         *      也就是从 m+n-2 中选取 m-1 次向下移动
         *      C((m-1) (m+n-2)) = (m+n-2)! / (m-1)!(n-1)! = (m+n-2)(m+n-3)...n / (m-1)!
         *                       = (m+n-2) / (m-1)... n / 1
         */
        public int uniquePaths(int m, int n) {
            long result = 1;
            for (int i = 1, j = n; i < m; i++, j++) {
                result = result * j / i;
            }
            return (int) result;
        }
    }

    /**
     * 2020/12/10
     * Solution860.柠檬水找零
     * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
     * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
     * 注意，一开始你手头没有任何零钱。
     * 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
     *      0 <= bills.length <= 10000
     *      bills[i] 不是 5 就是 10 或是 20 
     *
     * 输入：[5,5,5,10,20]
     * 输出：true
     * 解释：
     * 前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
     * 第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
     * 第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
     * 由于所有客户都得到了正确的找零，所以我们输出 true。
     *
     * 输入：[5,5,10]
     * 输出：true
     *
     * 输入：[10,10]
     * 输出：false
     *
     * 输入：[5,5,10,10,20]
     * 输出：false
     * 解释：
     * 前 2 位顾客那里，我们按顺序收取 2 张 5 美元的钞票。
     * 对于接下来的 2 位顾客，我们收取一张 10 美元的钞票，然后返还 5 美元。
     * 对于最后一位顾客，我们无法退回 15 美元，因为我们现在只有两张 10 美元的钞票。
     * 由于不是每位顾客都得到了正确的找零，所以答案是 false。
     */
    class Solution860 {
        /**
         * 模拟
         */
        /*public boolean lemonadeChange(int[] bills) {
            int five = 0;// 5
            int ten = 0;// 10
            // 模拟
            for (int i = 0; i < bills.length; i++) {
                if (bills[i] == 5) {
                    five++;
                }else if (bills[i] == 10 && five != 0) {
                    five--;
                    ten++;
                }else if (bills[i] == 20 && five != 0) {
                    if (ten != 0) {
                        ten--;
                        five--;
                    }else if (five >= 3){
                        five -= 3;
                    }else {
                        return false;
                    }
                }else {
                    return false;
                }
            }
            return true;
        }*/

        /**
         * 模拟
         */
        public boolean lemonadeChange(int[] bills) {
            int five = 0;
            int ten = 0;
            for (int i = 0; i < bills.length; i++) {
                if (bills[i] == 5) {
                    five++;
                }else if (bills[i] == 10 && five > 0) {
                    five--;
                    ten++;
                }else {
                    if (ten > 0 && five > 0) {
                        ten--;
                        five--;
                    }else if (five >= 3) {
                        five -= 3;
                    }else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    /**
     * 2020/12/11
     * Solution649.Dota2参议院
     * Dota2 的世界里有两个阵营：Radiant(天辉)和 Dire(夜魇)
     * Dota2 参议院由来自两派的参议员组成。现在参议院希望对一个 Dota2 游戏里的改变作出决定。
     * 他们以一个基于轮为过程的投票进行。在每一轮中，每一位参议员都可以行使两项权利中的一项：
     *      禁止一名参议员的权利：参议员可以让另一位参议员在这一轮和随后的几轮中丧失所有的权利。
     *      宣布胜利：如果参议员发现有权利投票的参议员都是同一个阵营的，他可以宣布胜利并决定在游戏中的有关变化。
     * 给定一个字符串代表每个参议员的阵营。字母 “R” 和 “D” 分别代表了 Radiant（天辉）和 Dire（夜魇）。然后，如果有 n 个参议员，给定字符串的大小将是 n。
     * 以轮为基础的过程从给定顺序的第一个参议员开始到最后一个参议员结束。这一过程将持续到投票结束。所有失去权利的参议员将在过程中被跳过。
     * 假设每一位参议员都足够聪明，会为自己的政党做出最好的策略，你需要预测哪一方最终会宣布胜利并在 Dota2 游戏中决定改变。输出应该是 Radiant 或 Dire。
     *      给定字符串的长度在 [1, 10,000] 之间.
     *
     * 输入："RD"
     * 输出："Radiant"
     * 解释：第一个参议员来自 Radiant 阵营并且他可以使用第一项权利让第二个参议员失去权力，因此第二个参议员将被跳过因为他没有任何权利。
     *      然后在第二轮的时候，第一个参议员可以宣布胜利，因为他是唯一一个有投票权的人
     *
     * 输入："RDD"
     * 输出："Dire"
     * 解释：第一轮中,第一个来自 Radiant 阵营的参议员可以使用第一项权利禁止第二个参议员的权利
     *      第二个来自 Dire 阵营的参议员会被跳过因为他的权利被禁止
     *      第三个来自 Dire 阵营的参议员可以使用他的第一项权利禁止第一个参议员的权利
     *      因此在第二轮只剩下第三个参议员拥有投票的权利,于是他可以宣布胜利
     */
    class Solution649 {
        /**
         * 模拟: 使用两个队列模拟会议过程
         */
        /*public String predictPartyVictory(String senate) {
            Queue<Integer> radiant = new LinkedList<>();
            Queue<Integer> dire = new LinkedList<>();
            // 进入会议——使用编号统计
            for (int i = 0; i < senate.length(); i++) {
                if (senate.charAt(i) == 'R') {
                    radiant.offer(i);
                }else {
                    dire.offer(i);
                }
            }
            // 开始会议——模拟
            while (!radiant.isEmpty() && !dire.isEmpty()) {
                int rad = radiant.poll();
                int dir = dire.poll();
                if (rad < dir) {
                    // 进入下一轮
                    radiant.offer(rad + senate.length());
                }else {
                    dire.offer(dir + senate.length());
                }
            }
            return radiant.isEmpty() ? "Dire" : "Radiant";
        }*/

        /**
         * 模拟-优化
         */
        public String predictPartyVictory(String senate) {
            int totalR = 0;// R 总人数
            int totalD = 0;// D 总人数
            int curBanR = 0;// 当前 ban 掉的 R 人数
            int curBanD = 0;// 当前 ban 掉的 D 人数
            int totalBanR = 0;// ban 掉的 R 总人数
            int totalBanD = 0;// ban 掉的 D 总人数
            char[] chars = senate.toCharArray();
            boolean flag = true;// 是否统计总人数? --- 只在第一轮统计
            while (true) {
                for (int i = 0; i < chars.length; i++) {
                    // 当前参议院阵营判断
                    if (chars[i] == 'R') {
                        // 统计人数
                        if (flag) {
                            totalR++;
                        }
                        // 是否被 ban 掉
                        if (curBanR == 0) {
                            // 行使权力, ban 掉一个人
                            curBanD++;
                            totalBanD++;
                            // 最后一轮可以不用遍历完
                            if (totalBanD == totalD && !flag) return "Radiant";
                        }else {
                            curBanR--;
                            chars[i] = 'r';// 永久被 ban 掉
                        }
                    }else if (chars[i] == 'D'){
                        // 统计人数
                        if (flag) {
                            totalD++;
                        }
                        // 是否被 ban 掉
                        if (curBanD == 0) {
                            // 行使权力, ban 掉一个人
                            curBanR++;
                            totalBanR++;
                            // 最后一轮可以不用遍历完
                            if (totalBanR == totalR && !flag) return "Dire";
                        }else {
                            curBanD--;
                            chars[i] = 'd';// 永久被 ban 掉
                        }
                    }
                }
                flag = false;// 只在第一轮统计人数
                // 是否有一方阵营被全部 ban 掉
                if (totalBanD >= totalD) return "Radiant";
                if (totalBanR >= totalR) return "Dire";
            }
        }
    }

    /**
     * 2020/12/12
     * Solution376.摆动序列
     * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。
     * 例如， [1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3) 是正负交替出现的。
     *      相反, [1,4,7,2,5] 和 [1,7,4,5,5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
     * 给定一个整数序列，返回作为摆动序列的最长子序列的长度。 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。
     *
     * 输入: [1,7,4,9,2,5]
     * 输出: 6
     * 解释: 整个序列均为摆动序列。
     *
     * 输入: [1,17,5,10,13,15,10,5,16,8]
     * 输出: 7
     * 解释: 这个序列包含几个长度为 7 摆动序列，其中一个可为[1,17,10,13,10,16,8]。
     *
     * 输入: [1,2,3,4,5,6,7,8,9]
     * 输出: 2
     */
    class Solution376 {
        /**
         * 动态规划
         */
        public int wiggleMaxLength(int[] nums) {
            if (nums.length == 0) return 0;
            int down = 1;// 递减数量
            int up = 1;// 递增数量
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > nums[i - 1]) {
                    up = down + 1;
                }else if (nums[i] < nums[i - 1]){
                    down = up + 1;
                }
            }
            return Math.max(up, down);
        }
    }

    /**
     * 2020/12/13
     * Solution217.存在重复元素
     * 给定一个整数数组，判断是否存在重复元素。
     * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
     *
     * 输入: [1,2,3,1]
     * 输出: true
     *
     * 输入: [1,2,3,4]
     * 输出: false
     *
     * 输入: [1,1,1,3,3,4,3,2,4,2]
     * 输出: true
     */
    class Solution217 {
        /**
         * 集合 set 去重判断
         */
        /*public boolean containsDuplicate(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int e: nums) {
                set.add(e);
            }
            return !(set.size() == nums.length);
        }*/

        /**
         * 集合 set 的方法性质
         */
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int e: nums) {
                if (!set.add(e)) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * 2020/12/14
     * Solution49.字母异位词分组
     * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
     *
     * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出:
     * [
     *   ["ate","eat","tea"],
     *   ["nat","tan"],
     *   ["bat"]
     * ]
     */
    class Solution49 {
        /**
         * HashMap 计数统计
         */
        /*public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String, List<String>> map = new HashMap<>();
            for (String str: strs) {
                // 排序
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                // 异位词分组判断
                String key = new String(chars);
                List<String> value = map.getOrDefault(key, new ArrayList<>());
                value.add(str);
                map.put(key, value);
            }
            return new ArrayList<>(map.values());
        }*/

        /**
         * 使用质数代替
         */
        public List<List<String>> groupAnagrams(String[] strs) {
            int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
            HashMap<Double, List<String>> map = new HashMap<>();
            for (String str: strs) {
                double key = 1;
                for (int i = 0; i < str.length(); i++) {
                    key *= prime[str.charAt(i) - 'a'];
                }
                List<String> value = map.getOrDefault(key, new ArrayList<>());
                value.add(str);
                map.put(key, value);
            }
            return new ArrayList<>(map.values());
        }
    }

    /**
     * 2020/12/15
     * Solution738.单调递增的数字
     * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
     * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
     *
     * 输入: N = 10
     * 输出: 9
     *
     * 输入: N = 1234
     * 输出: 1234
     *
     * 输入: N = 332
     * 输出: 299
     */
    class Solution738 {
        /**
         * 从后向前
         */
        /*public int monotoneIncreasingDigits(int N) {
            char[] chars = String.valueOf(N).toCharArray();
            for (int i = chars.length - 1; i > 0; i--) {
                // 前面一位大于后面一位: 前面一位 - 1, 后面的都是 9
                if (chars[i] < chars[i - 1]) {
                    chars[i - 1]--;
                    for (int j = i; j < chars.length; j++) {
                        chars[j] = '9';
                    }
                }
            }
            return Integer.parseInt(new String(chars));
        }*/

        /**
         * 贪心算法: 从前向后
         */
        public int monotoneIncreasingDigits(int N) {
            char[] chars = String.valueOf(N).toCharArray();
            int index = 1;
            // 寻找第一个非递增元素
            while (index < chars.length && chars[index] >= chars[index - 1]) {
                index++;
            }
            // 给位置 -1, 后面的都是 9
            if (index < chars.length) {
                // -1 后防止非递增
                while (index > 0 && chars[index] < chars[index-1]) {
                    chars[index - 1]--;
                    index--;
                }
                // 后面填充 9
                for (int i = index + 1; i < chars.length; i++) {
                    chars[i] = '9';
                }
            }
            return Integer.parseInt(new String(chars));
        }
    }

    /**
     * 2020/12/16
     * Solution290.单词规律
     * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
     * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
     *
     * 输入: pattern = "abba", str = "dog cat cat dog"
     * 输出: true
     *
     * 输入:pattern = "abba", str = "dog cat cat fish"
     * 输出: false
     *
     * 输入: pattern = "aaaa", str = "dog cat cat dog"
     * 输出: false
     *
     * 输入: pattern = "abba", str = "dog dog dog dog"
     * 输出: false
     */
    class Solution290 {
        /**
         * 双射: 使用两个 map 进行双射验证
         */
        public boolean wordPattern(String pattern, String s) {
            HashMap<Character, String> ch2str = new HashMap<>();
            HashMap<String, Character> str2ch = new HashMap<>();
            int index = 0;// 用以分割字符串
            for (int i = 0; i < pattern.length(); i++) {
                if (index > s.length()) {
                    return false;
                }
                char ch = pattern.charAt(i);
                int temp = index;
                while (index < s.length() && s.charAt(index) != ' ') {
                    index++;
                }
                String str = s.substring(temp, index);
                // 验证
                if (ch2str.containsKey(ch) && !ch2str.get(ch).equals(str) || str2ch.containsKey(str) && str2ch.get(str) != ch) {
                    return false;
                }
                ch2str.put(ch, str);
                str2ch.put(str, ch);
                index++;
            }
            return index >= s.length();
        }

        /**
         * 模拟
         */
        /*public boolean wordPattern(String pattern, String s) {
            String[] strings =s.split(" ");
            HashMap<Character, String> map = new HashMap<>();
            if (pattern.length() != strings.length) return false;
            // 判断
            for (int i = 0; i < pattern.length(); i++) {
                String temp = map.getOrDefault(pattern.charAt(i), "0");
                if (temp.equals("0")) {
                    // 不应该存在相同的 value
                    if (map.containsValue(strings[i])) {
                        return false;
                    }
                    map.put(pattern.charAt(i), strings[i]);
                }else {
                    // value 应该相同
                    if (!temp.equals(strings[i])) {
                        return false;
                    }
                }
            }
            return true;
        }*/
    }

    /**
     * 2020/12/17
     * Solution714.买卖股票的最佳时机
     * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
     * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
     * 返回获得利润的最大值。
     * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
     *      0 < prices.length <= 50000.
     *      0 < prices[i] < 50000.
     *      0 <= fee < 50000.
     *
     * 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
     * 输出: 8
     * 解释: 能够达到的最大利润:
     * 在此处买入 prices[0] = 1
     * 在此处卖出 prices[3] = 8
     * 在此处买入 prices[4] = 4
     * 在此处卖出 prices[5] = 9
     * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
     */
    class Solution714 {
        /**
         * 1.动态规划
         */
        /*public int maxProfit(int[] prices, int fee) {
            int buy = -prices[0];// 第一天买入
            int sell = 0;// 第一天卖出
            for (int i = 0; i < prices.length; i++) {
                sell = Math.max(sell, buy + prices[i] - fee);
                buy = Math.max(buy, sell - prices[i]);
            }
            return sell;
        }*/

        /**
         * 2.贪心算法
         */
        public int maxProfit(int[] prices, int fee) {
            int buy = prices[0] + fee;// 假定该点买入
            int profit = 0;
            for (int i = 0; i < prices.length; i++) {
                if (prices[i] + fee < buy) {
                    // 更适合买入点
                    buy = prices[i] + fee;
                }else if (prices[i] > buy){
                    profit += prices[i] - buy;// 假定卖出
                    buy = prices[i];// 更新买入价格
                }
            }
            return profit;
        }
    }

    /**
     * 2020/12/18
     * Solution389.找不同
     * 给定两个字符串 s 和 t，它们只包含小写字母。字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
     * 请找出在 t 中被添加的字母。
     *
     * 输入：s = "abcd", t = "abcde"
     * 输出："e"
     * 解释：'e' 是那个被添加的字母。
     *
     * 输入：s = "", t = "y"
     * 输出："y"
     *
     * 输入：s = "a", t = "aa"
     * 输出："a"
     *
     * 输入：s = "ae", t = "aea"
     * 输出："a"
     */
    class Solution389 {
        /**
         * 位运算
         */
        public char findTheDifference(String s, String t) {
            int result = 0;
            for (int i = 0; i < s.length(); i++) {
                result ^= s.charAt(i) ^ t.charAt(i);
            }
            return (char) (result ^ t.charAt(t.length() - 1));
        }
    }

    /**
     * 2020/12/19
     * Solution48.旋转图像
     * 给定一个 n × n 的二维矩阵表示一个图像。将图像顺时针旋转 90 度。
     * 说明：你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
     *
     * 给定 matrix =
     * [
     *   [1,2,3],
     *   [4,5,6],
     *   [7,8,9]
     * ],
     *
     * 原地旋转输入矩阵，使其变为:
     * [
     *   [7,4,1],
     *   [8,5,2],
     *   [9,6,3]
     * ]
     *
     * 给定 matrix =
     * [
     *   [ 5, 1, 9,11],
     *   [ 2, 4, 8,10],
     *   [13, 3, 6, 7],
     *   [15,14,12,16]
     * ],
     *
     * 原地旋转输入矩阵，使其变为:
     * [
     *   [15,13, 2, 5],
     *   [14, 3, 4, 1],
     *   [12, 6, 8, 9],
     *   [16, 7,10,11]
     * ]
     */
    class Solution48 {
        /**
         * 交换: 上下交换 -> 主对角线交换
         */
        /*public void rotate(int[][] matrix) {
            // 上下交换
            for (int i = 0; i < matrix.length / 2; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[matrix.length - 1- i][j];
                    matrix[matrix.length - 1- i][j] = temp;
                }
            }
            // 关于主对角线交换
            for (int i = 0; i < matrix.length; i++) {
                for (int j = i; j < matrix.length; j++) {
                    // 对角线不交换
                    if (i == j) {
                        continue;
                    }
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }*/

        /**
         * 模拟——每次旋转四个元素的相对位置
         */
        public void rotate(int[][] matrix) {
            int n =matrix.length;
            for (int i = 0; i < n / 2; i++) {
                for (int j = 0; j < (n + 1) / 2; j++) {
                    int temp = matrix[i][j];// 取出左上
                    matrix[i][j] = matrix[n - 1- j][i];
                    matrix[n - 1- j][i] = matrix[n - 1 - i][n - 1 - j];
                    matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                    matrix[j][n - 1 - i] = temp;
                }
            }
        }
    }

    /**
     * 2020/12/20
     * Solution316.去除重复字母
     * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
     *      1 <= s.length <= 10^4;   s 由小写英文字母组成
     * 输入：s = "bcabc"
     * 输出："abc"
     *
     * 输入：s = "cbacdcbc"
     * 输出："acdb"
     */
    class Solution316 {
        /**
         * 1.维护部分单调栈: 首先使用一个标志数组标志当前字符在不在栈中;
         *      (1)如果栈中不存在字符, 需要压栈
         *      (2)反之, 需要判断是否满足最小的字典序
         */
        public String removeDuplicateLetters(String s) {
            int[] lastIndex = new int[26];
            boolean[] flag = new boolean[26];// 标志数组
            // 该字符最后一次出现的下标
            for (int i = 0; i < s.length(); i++) {
                lastIndex[s.charAt(i) - 'a'] = i;
            }
            Stack<Character> stack = new Stack<>();
            // 维护单调栈
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                // 当前字符已经存在就跳过
                if (flag[ch - 'a']) {
                    continue;
                }
                // 是否满足字典序?
                while (!stack.isEmpty() && stack.peek() > ch && lastIndex[stack.peek() - 'a'] > i) {
                    // 不满足并且后面还有该字符
                    // 弹出栈顶元素 + 该元素不存在
                    char temp = stack.pop();
                    flag[temp - 'a'] = false;
                }
                // 压栈
                stack.push(ch);
                // 栈中已存在
                flag[ch - 'a'] = true;
            }
            // 逆序连接结果
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.insert(0, stack.pop());
            }
            return sb.toString();
        }

        /**
         * 2.统计出现次数: 过程类似
         */
        /*public String removeDuplicateLetters(String s) {
            int[] count = new int[26];
            boolean[] flag = new boolean[26];// 是否应经存在?
            // 统计出现次数
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                // 当前字符不存在
                if (!flag[ch - 'a']) {
                    // 不满足字典序 + 后面还有
                    while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch && count[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                        // 删除 + 该字符不存在
                        flag[sb.charAt(sb.length() - 1) - 'a'] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    // 连接 + 该字符已存在
                    sb.append(ch);
                    flag[ch - 'a'] = true;
                }
                // 删除遍历过的字符一次
                count[ch - 'a']--;
            }
            return sb.toString();
        }*/
    }

    /**
     * 2020/12/21
     * Solution746.使用最小花费爬楼梯
     * 数组的每个索引作为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
     * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
     * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
     * 输入: cost = [10, 15, 20]
     * 输出: 15
     * 解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
     *
     * 输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
     * 输出: 6
     * 解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。
     */
    class Solution746 {
        /**
         * 1.动态规划: 对于dp[i]
         *      (1)dp[i-1] 花费 cost[i-1] 到达 dp[i]
         *      (2)dp[i-2] 花费 cost[i-2] 到达 dp[i]
         * 每次需要取两者之中的最小值
         * 最后的 dp 元素值就是对应的最小花费
         */
        /*public int minCostClimbingStairs(int[] cost) {
            int[] dp = new int[cost.length + 1];
            dp[0] = dp[1] = 0;
            for (int i = 2; i <= cost.length; i++) {
                dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
            }
            return dp[cost.length];
        }*/

        /**
         * 2.动态规划: 使用滚动数组的思想优化空间使用
         */
        public int minCostClimbingStairs(int[] cost) {
            int prev = 0;// 走到前一个台阶需要的体力
            int curr = 0;// 走到当前台阶需要的体力
            for (int i = 2; i <= cost.length; i++) {
                // 到达下一个台阶需要的最小体力
                int next = Math.min(prev + cost[i - 2], curr + cost[i - 1]);
                // 滚动
                prev = curr;
                curr = next;
            }
            return curr;
        }

        /**
         * 3.使用原数组代替动态规划数组
         */
        /*public int minCostClimbingStairs(int[] cost) {
            for (int i = 2; i < cost.length; i++) {
                cost[i] += Math.min(cost[i - 1], cost[i - 2]);
            }
            // 最后两个台阶一部到顶, 选取最小的
            return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
        }*/
    }

    /**
     * 2020/12/22
     * Solution103.二叉树的锯齿形层序遍历
     * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
     * 例如：
     * 给定二叉树 [3,9,20,null,null,15,7],       返回锯齿形层序遍历如下：
     *     3                                    [
     *    / \                                     [3],
     *   9  20                                    [20,9],
     *     /  \                                   [15,7]
     *    15   7                                ]
     */
    class Solution103 {
        /**
         * 1.先使用队列层序遍历, 使用一个标志位判断每一层的遍历顺序(也就是 list 的装入顺序)
         */
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            // 判空
            if (root == null) {
                return result;
            }
            Queue<TreeNode> queue = new LinkedList<>();// 用于层序遍历的队列
            boolean flag = false;// 用于标志当前层遍历的顺序: false 为 从左到右
            // 根节点入队
            queue.offer(root);

            while (!queue.isEmpty()) {
                // 当前层节点个数
                int count = queue.size();
                // 每一层的节点值
                List<Integer> list = new ArrayList<>();
                while (count-- > 0) {
                    TreeNode temp = queue.poll();
                    // 当前层遍历顺序
                    if (!flag) {
                        // 从左到右
                        list.add(temp.val);
                    }else {
                        // 从右到左
                        list.add(0, temp.val);
                    }
                    // 加入下一层的节点用于层序遍历
                    if (temp.left != null) {
                        queue.offer(temp.left);
                    }
                    if (temp.right != null) {
                        queue.offer(temp.right);
                    }
                }
                // 修改下一层的遍历顺序
                flag = !flag;
                result.add(list);
            }
            return result;
        }

        /**
         * 2.使用双端队列, 基本操作差不多, 使用 Deque 代替 list 就好
         */
        /*public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            // 判空
            if (root == null) {
                return result;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            boolean flag = false;// 用于标志当前层遍历的顺序: false 为 从左到右
            queue.offer(root);
            while (!queue.isEmpty()) {
                // 当前层的节点个数
                int count = queue.size();
                Deque<Integer> deque = new LinkedList<>();
                while (count-- > 0) {
                    TreeNode temp = queue.poll();
                    // 遍历顺序
                    if (!flag) {
                        // 从左到右
                        deque.offerLast(temp.val);
                    }else {
                        // 从右到左
                        deque.offerFirst(temp.val);
                    }
                    // 加入下一层的节点用于层序遍历
                    if (temp.left != null) {
                        queue.offer(temp.left);
                    }
                    if (temp.right != null) {
                        queue.offer(temp.right);
                    }
                }
                // 修改遍历顺序
                flag = !flag;
                result.add(new ArrayList<>(deque));
            }
            return result;
        }*/
    }

    /**
     * 2020/12/23
     * Solution387.字符串中的第一个唯一字符
     * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。假定该字符串只包含小写字母
     * s = "leetcode"
     * 返回 0
     * s = "loveleetcode"
     * 返回 2
     */
    class Solution387 {
        /**
         * 1.数组计数: 遍历字符串统计 26 个字母出现次数, 再次遍历寻找第一个不重复的字符. 注意第二次遍历的还是字符串(不然顺序会被打乱)
         */
        public int firstUniqChar(String s) {
            // 计数数组
            int[] count = new int[26];
            // 统计次数
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a']++;
            }
            // 查找第一个出现次数为 1 的字符下标
            for (int i = 0; i < s.length(); i++) {
                if (count[s.charAt(i) - 'a'] == 1) {
                    return i;
                }
            }
            // 没找到?
            return -1;
        }

        /**
         * 2.哈希表计数: 遍历字符串使用哈希表统计次数, 再次遍历查找第一个不重复的字符. 注意第二次遍历的还是字符串(不然顺序会被打乱)
         * 时间复杂度 O(N) -> N 为字符串长度, 遍历了两次字符串
         * 空间复杂度 O(Σ) -> Σ 为不同字符个数, 因为使用哈希表存储
         */
        /*public int firstUniqChar(String s) {
            // 统计的哈希表
            Map<Character, Integer> map = new HashMap<>();
            // 统计次数
            for (int i = 0; i < s.length(); i++) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            }
            // 查找第一个 value 为 1 的字符下标
            for (int i = 0; i < s.length(); i++) {
                if (map.get(s.charAt(i)) == 1) {
                    return i;
                }
            }
            return -1;
        }*/
    }


}