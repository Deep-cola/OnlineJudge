package leetcode;

/**
 * @description: 分发糖果
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 *      每个孩子至少分配到 1 个糖果。
 *      相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 *
 * 输入: [1,0,2]
 * 输出: 5
 * 解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
 *
 * 输入: [1,2,2]
 * 输出: 4
 * 解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
 *      第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 * @author: Deepcola
 * @time: 2020/12/24 12:58
 */
public class Solution135 {

    /**
     * 相当于两个规则:
     *      左规则 : 当 ratings[i-1] < ratings[i] 时, left[i] = left[i-1] + 1;
     *      右规则 : 当 ratings[i+1] < ratings[i] 时, right[i] = right[i+1] + 1;
     * 由于右规则遍历结束后就已经完成计算, 所以可以考虑使用一个变量代替数组
     */
    public int candy(int[] ratings) {
        int[] left = new int[ratings.length];// 对应孩子糖果数
        // 从左到右
        for (int i = 0; i < ratings.length; i++) {
            // 相邻的孩子中得分高的多一个糖果, 得分低的只给一个
            // 注意第一个孩子先给 1 个
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }else {
                left[i] = 1;
            }
        }
        // 从右到左
        int candy = 0;// 总糖果数
        int right = 0;
        for (int i = ratings.length - 1; i >= 0; i--) {
            if (i < ratings.length - 1 && ratings[i] <= ratings[i + 1]) {
                right = 1;
            }else {
                right++;
            }
            candy += Math.max(left[i], right);
        }
        return candy;
    }

    public static void main(String[] args) {
        Solution135 solution =  new Solution135();
        int[] ratings = {1, 3, 2, 2, 1};
        System.out.println(solution.candy(ratings));
    }
}
