package newcode;

import java.util.Scanner;

/**
 * @description: DNA序列
 * 一个DNA序列由A/C/G/T四个字母的排列组合组成。G和C的比例（定义为GC-Ratio）是序列中G和C两个字母的总的出现次数除以总的字母数目（也就是序列长度）。
 * 在基因工程中，这个比例非常重要。因为高的GC-Ratio可能是基因的起始点。
 * 给定一个很长的DNA序列，以及要求的最小子序列长度，研究人员经常会需要在其中找出GC-Ratio最高的子序列。
 *
 * 本题含有多组样例输入。
 * 输入描述:        输入一个string型基因序列，和int型子串的长度
 * 输出描述:        找出GC比例最高的子串,如果有多个输出第一个的子串
 *
 * 输入   AACTGTGCACGACCTGA       5
 * 输出   GCACG
 * @author: Deepcola
 * @time: 2020/12/15 23:55
 */
public class DNASequence {

    public static String maxGCRatio(String DNA, int length) {
        int index = 0;// 字串最后一个下标
        int maxGC = 0;
        for (int i = 0; i <= DNA.length()-length; i++) {
            int count = 0;// 计数
            for (int j = i; j < i+length; j++) {
                if (DNA.charAt(j) == 'G' || DNA.charAt(j) == 'C') {
                    count++;
                }
            }

            if (count > maxGC) {
                maxGC = count;
                index = i;
            }
        }
        return DNA.substring(index, index+length);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String DNA = scan.nextLine();
            int length = scan.nextInt();
            System.out.println(maxGCRatio(DNA, length));
        }
    }
}
