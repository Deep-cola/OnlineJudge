package newcode;

import java.util.Scanner;

/**
 * @description: 最难得问题
 * NowCoder生活在充满危险和阴谋的年代。为了生存，他首次发明了密码，用于军队的消息传递。假设你是军团中的一名军官，需要把发送来的消息破译出来、并提
 * 供给你的将军。
 * 消息加密的办法是：对消息原文中的每个字母，分别用该字母之后的第5个字母替换（例如：消息原文中的每个字母A 都分别替换成字母F），其他字符不 变，并且消息原文的所有字母都是大写的。密码中的字母与原文中的字母对应关系如下。
 * 密码字母：A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
 * 原文字母：V W X Y Z A B C D E F G H I J K L M N O P Q R S T U
 *
 * 输入描述:
 * 输入包括多组数据，每组数据一行，为收到的密文。
 * 密文仅有空格和大写字母组成。
 *
 * 输出描述:
 * 对应每一组数据，输出解密后的明文。
 *
 * 示例1
 * 输入
 * HELLO WORLD
 * SNHJ
 * 输出
 * CZGGJ RJMGY
 * NICE
 * @author: Deepcola
 * @time: 2021/1/13 0:13
 */
public class HardestQuestion {

    /**
     * 使用 E 作为分界线
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            String str = scan.nextLine();
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if(ch >= 'A') {
                    ch = (char) ((ch > 'E') ? ch - 5 : ch + 21);
                }
                sb.append(ch);
            }
            System.out.println(sb.toString());
        }
    }


    /**
     * 直接转换
     */
    /*public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            String str = scan.nextLine();
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if(ch != ' ') {
                    int index = (ch - 'A' - 5 + 26) % 26;
                    ch = (char) (index + 'A');
                }
                sb.append(ch);
            }
            System.out.println(sb.toString());
        }
    }*/
}
