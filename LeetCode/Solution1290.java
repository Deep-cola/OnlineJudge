package LeetCode;

/**
 * @description: 二进制链表转整数
 * 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
 * 请你返回该链表所表示数字的 十进制值 。
 *
 * 输入：head = [1,0,1]
 * 输出：5
 * 解释：二进制数 (101) 转化为十进制数 (5)
 * @author: Deepcola
 * @time: 2020/11/24 15:57
 */
public class Solution1290 {

    /**
     * Definition for singly-linked list
     */
    class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 1.使用 StringBuffer 将遍历链表的值连接起来,
     * 2.使用Integer.parseInt() 转换为十进制
     */
    /*public int getDecimalValue(ListNode head) {
        if (head == null) return 0;
        ListNode cur = head;
        int result = 0;// 求和
        int count = 0;// 计算链表的结点位置
        StringBuffer sb = new StringBuffer();
        while (cur != null) {
            sb.append(cur.val);
            cur = cur.next;
        }
        return Integer.parseInt(sb.toString(), 2);
    }*/

    /**
     * 位运算
     */
    public int getDecimalValue(ListNode head) {
        if (head == null) return 0;
        int result = 0;
        while (head != null) {
            result += (result << 1) + head.val;
            head = head.next;
        }
        return result;
    }
}
