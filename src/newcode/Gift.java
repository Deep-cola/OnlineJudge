package newcode;

import java.util.Arrays;

/**
 * @description: 微信红包
 * 春节期间小明使用微信收到很多个红包，非常开心。
 * 在查看领取红包记录时发现，某个红包金额出现的次数超过了红包总数的一半。请帮小明找到该红包金额。写出具体算法思路和代码实现，要求算法尽可能高效。
 * 给定一个红包的金额数组gifts及它的大小n，请返回所求红包的金额。
 * 若没有金额超过总数的一半，返回0。
 *
 * 测试样例：
 * [1,2,3,2,2],5
 * 返回：2
 * @author: Deepcola
 * @time: 2021/1/9 18:27
 */
public class Gift {
    /**
     * 排序后数量超过一半的金额理应出现在中间
     */
   /* public int getValue(int[] gifts, int n) {
        // write code here
        Arrays.sort(gifts);
        int value = gifts[n / 2];// 理应的最大值
        int count = 0;
        // 验证是否为最大值
        for(int i = 0; i < n; i++) {
            if(gifts[i] == value) {
                count++;
            }
        }
        return (count < n / 2) ? 0 : value;
    }*/

    /**
     * 金额出现数量超过一半说明大于等于起亚所有金额的数量
     */
    public int getValue(int[] gifts, int n) {
        // write code here
        if(gifts.length < n) return 0;
        if(gifts.length == 0) return 0;
        int count = 0;// 计数
        int value = 0;
        for(int i = 0; i < n; i++) {
            if(count == 0) {
                value = gifts[i];
                count = 1;
            }else {
                if(gifts[i] == value) {
                    count++;
                }else {
                    count--;
                }
            }
        }
        int result = 0;
        for(int i = 0; i < n; i++) {
            if(gifts[i] == value) {
                result++;
            }
        }
        return (result < n / 2) ? 0 : value;
    }

}
