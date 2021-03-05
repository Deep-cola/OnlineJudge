package newcode;

import java.util.Scanner;

/**
 * @description: 字符串中找出最长的连续数字串
 *
 * 读入一个字符串str，输出字符串str中的连续最长的数字串
 *
 * 输入描述:
 * 个测试输入包含1个测试用例，一个字符串str，长度不超过255。
 *
 * 输出描述:
 * 在一行内输出str中里连续最长的数字串。
 * 示例1
 * 输入
 * abcd12345ed125ss123456789
 * 输出
 * 123456789
 * @author: Deepcola
 * @time: 2021/3/5 18:17
 */
public class GetLongestNumberString {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            String s = scan.nextLine();
            int max = 0;
            int count = 0;
            int end = 0;
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    count++;
                    if(max <= count) {
                        max = count;
                        end = i;
                    }
                }else {
                    count = 0;
                }
            }
            System.out.println(s.substring(end - max + 1, end + 1));
        }
    }
}
