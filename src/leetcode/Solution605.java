package leetcode;

/**
 * @description: 种花问题
 * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
 *
 * 输入: flowerbed = [1,0,0,0,1], n = 1
 * 输出: True
 *
 * 输入: flowerbed = [1,0,0,0,1], n = 2
 * 输出: False
 *
 * 注意:
 *      数组内已种好的花不会违反种植规则。
 *      输入的数组长度范围为 [1, 20000]。
 *      n 是非负整数，且不会超过输入数组的大小。
 * @author: Deepcola
 * @time: 2021/1/1 7:22
 */
public class Solution605 {
    /**
     * 跳格子:
     *      当当前位置 i 为 1, 由于原来保证的有规则, 所以可以种花的位置必然在 i+2， 去判断
     *      当当前位置 i 为 0, 由于碰到 1 跳两格, 所以前一格必定是 0,只需要判断下一格是否为 0 即可
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length;) {
            if (flowerbed[i] == 1) {// 种花 -> 去判断 i+2 是否为 0
                i += 2;
            }else if (i == flowerbed.length - 1 || flowerbed[i + 1] == 0) {// 未种花 -> 判断下一格有没有花 / 当前位置在末尾
                i += 2;
                count++;
            }else {// 下一格位置已种花 -> 从下一个位置连跳两格
                i += 3;
            }
        }
        return count >= n;
    }

    /**
     * 模拟
     */
    /*public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i += 2) {
            if (flowerbed[i] == 0) {
                // 连续三个 0 / 在末尾处 就可以种花
                if (i == flowerbed.length - 1 || flowerbed[i + 1] == 0) {
                    n--;
                }else {
                    i++;
                }
            }
        }
        return n <= 0;
    }*/
}
