package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @description: 车队
 * N  辆车沿着一条车道驶向位于 target 英里之外的共同目的地。
 * 每辆车 i 以恒定的速度 speed[i] （英里/小时），从初始位置 position[i] （英里） 沿车道驶向目的地。
 * 一辆车永远不会超过前面的另一辆车，但它可以追上去，并与前车以相同的速度紧接着行驶。
 * 此时，我们会忽略这两辆车之间的距离，也就是说，它们被假定处于相同的位置。
 * 车队 是一些由行驶在相同位置、具有相同速度的车组成的非空集合。注意，一辆车也可以是一个车队。
 * 即便一辆车在目的地才赶上了一个车队，它们仍然会被视作是同一个车队。
 * @author: Deepcola
 * @time: 2020/11/22 14:07
 */
public class Solution853 {
    /**
     * Car 类
     */
    class Cars {
        int position; // 位置
        double time; // 到达终点 target 所需时间
        public Cars(int position, double time) {
            this.position = position;
            this.time = time;
        }
    }

    /**
     * 对于每一辆车, 如果追上前面的车, 那么就不能继续向前超车, 也就是说前面的车肯定在后面车的
     * 1.计算出每辆车正常情况下到达 target 的时间
     * 2.cars 按照距离由大到小排序
     * 3.有车就会存在至少一个车队, 所以记 result = 1, 如果还有车队继续增加
     * 4.遍历 cars, 如果后车到达时间小于前车, 并定会追上称为一个车队(到达时间一样), 所以修改后车时间为前车时间继续向后比较
     */
    public int carFleet(int target, int[] position, int[] speed) {
        if (position == null || position.length == 0) return 0;
        Cars[] cars = new Cars[position.length];
        // 计算每一辆车到达终点需要的时间
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Cars(position[i], (target - position[i]) * 1.0 / speed[i]);
        }
        // 按照距离从大到小进行排序
        Arrays.sort(cars, new Comparator<Cars>() {
            @Override
            public int compare(Cars o1, Cars o2) {
                return o2.position - o1.position;
            }
        });
        int result = 1;// 记录车队数量, 有车存在时至少为 1
        int i = 1;// 标记当前遍历 cars 数组的位置
        // 判断是否是同一车队
        while (i < cars.length) {
            // 后车到达时间小于前车时, 必然会追上前车成为一个车队
            // 由于不能超车, 所以到达时间相同, 所以把后车时间改为前车时间
            if (cars[i].time > cars[i-1].time) {
                result++;
            }else {
                cars[i].time = cars[i - 1].time;
            }
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution853 solution = new Solution853();
        int target = 12;
        int[] position = {10,8,0,5,3};
        int[] speed = {2,4,1,1,3};
        System.out.println(solution.carFleet(target, position, speed));
    }
}
