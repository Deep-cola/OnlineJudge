package newcode;

import java.util.Scanner;

/**
 * @description: 字符串中找出连续最长的数字字符串
 * 读入一个字符串str，输出字符串str中的连续最长的数字串
 *
 * 输入   abcd12345ed125ss123456789
 * 输出   123456789
 * @author: Deepcola
 * @time: 2020/12/1 16:38
 */
public class NumString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String s = scan.nextLine();
            int max = 0;// 最大长度
            int count = 0;// 数字串计数
            int end = 0;// 最大长度对应的数字串最后一个数字的下标
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    count++;
                    // 判断是否需要更新 max
                    if (max <= count) {
                        max = count;
                        end = i;
                    }
                }else {
                    count = 0;
                }
            }
            // end+1 因为左闭右开
            System.out.println(s.substring(end - max + 1, end + 1));
        }
    }
}
