package leetcode;

import java.util.List;

/**
 * @description: 员工的重要性
 * 给定一个保存员工信息的数据结构，它包含了员工唯一的id，重要度 和 直系下属的id。比如，员工1是员工2的领导，员工2是员工3的领导。他们相应的重要度为15, 10, 5。
 * 那么员工1的数据结构是[1, 15, [2]]，员工2的数据结构是[2, 10, [3]]，员工3的数据结构是[3, 5, []]。
 * 注意虽然员工3也是员工1的一个下属，但是由于并不是直系下属，因此没有体现在员工1的数据结构中。
 * 现在输入一个公司的所有员工信息，以及单个员工id，返回这个员工和他所有下属的重要度之和。
 *
 * 输入: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
 * 输出: 11
 * @author: Deepcola
 * @time: 2020/11/17 21:03
 */
public class Solution690 {

    /**
     * Definition for Employee
     */
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };

    /**
     * 递归求解: 先加上自己的重要度, 然后查看是否有直系下属，没有就返回; 有的话就继续求所有下属的重要度之和，直至所有下属都计算完
     */
    // 求所有重要度之和, 所以不能每次递归重新定义作为局部变量
    int importance = 0;
    public int getImportance(List<Employee> employees, int id) {
        for (Employee emp: employees) {
            if (emp.id == id) {
                importance += emp.importance;
                // 没有直系下属
                if (emp.subordinates.size() == 0) {
                    return importance;
                }
                // 有下属就求出所有下属之和
                for (int i: emp.subordinates) {
                    getImportance(employees, i);
                }
            }
        }
        return importance;
    }
}
