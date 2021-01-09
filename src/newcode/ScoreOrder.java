package newcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @description: 查找和排序
 * 题目：输入任意（用户，成绩）序列，可以获得成绩从高到低或从低到高的排列,相同成绩
 * 都按先录入排列在前的规则处理。
 *
 * 示例：
 * jack      70
 * peter     96
 * Tom       70
 * smith     67
 *
 * 从高到低
 * peter     96
 * jack      70
 * Tom       70
 * smith     67
 *
 * 从低到高
 * smith     67
 * jack      70
 * Tom      70
 * peter     96
 * @author: Deepcola
 * @time: 2021/1/9 17:52
 */
public class ScoreOrder {

    static class Student {
        private String name;
        private int score;
        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int num = scan.nextInt();
            int order = scan.nextInt();
            List<Student> list = new ArrayList<>();
            for(int i = 0; i < num; i++) {
                list.add(new Student(scan.next(), scan.nextInt()));
            }
            if(order == 0) {
                // 从大到小
                Collections.sort(list, (a, b) -> {
                    return b.score - a.score;
                });
            }else {
                // 从小到大
                Collections.sort(list, (a, b) -> {
                    return a.score - b.score;
                });
            }
            // 输出
            for(Student s : list) {
                System.out.println(s.name + " " + s.score);
            }
        }
    }
}
