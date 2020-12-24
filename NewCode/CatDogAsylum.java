package newcode;

import java.util.ArrayList;

/**
 * @description: 分条件出栈(猫狗收容所)
 * 给定一个栈及一个操作序列int[][2] ope(C++中为vector<vector<int>>)，代表所进行的入栈出栈操作。
 * 第一个元素为1则入栈，第二个元素为数的正负号；第一个元素为2则出栈，第二个元素若为0则出最先入栈的那个数，为1则出最先入栈的正数，为-1则出最先入栈的负数。
 * 请按顺序返回出栈的序列，并做异常处理忽略错误操作。
 *
 * 测试样例：
 * [[1,1],[1,-1],[2,0],[2,-1]]
 * 返回：[1,-1]
 * @author: Deepcola
 * @time: 2020/11/17 21:27
 */
public class CatDogAsylum {

    /**
     *使用两个 list 来分别存放进入的数和出去的顺序，根据第一个元素判断是入还是出，根据第二个元素判断出去的数字正负
     */
    public ArrayList<Integer> asylum(int[][] ope) {
        if (ope == null || ope.length == 0) return null;
        ArrayList<Integer> input = new ArrayList<>();
        ArrayList<Integer> output = new ArrayList<>();
        // 遍历 ope 进行判断
        for (int i = 0; i < ope.length; i++) {
            switch (ope[i][0]) {
                // 入
                case 1:
                    input.add(ope[i][1]);
                    break;
                // 出
                case 2:
                    //为 0
                    if (ope[i][1] == 0) {
                        output.add(input.remove(0));
                    }else if (ope[i][1] == 1) {
                        // 为 1, 出最先进来的正数
                        for (int j = 0; j < input.size(); j++) {
                            if (input.get(j) > 0) {
                                output.add(input.remove(j));
                                break;
                            }
                        }
                    }else {
                        // 为 -1, 出最先进来的负数
                        for (int j = 0; j < input.size(); j++) {
                            if (input.get(j) < 0) {
                                output.add(input.remove(j));
                                break;
                            }
                        }
                    }
                    break;
            }
        }
        return output;
    }


    public static void main(String[] args) {
        CatDogAsylum catDogAsylum = new CatDogAsylum();
        int[][] ope = {{1,1},{1,-1},{2,0},{2,-1}};
        System.out.println(catDogAsylum.asylum(ope));
    }

}
