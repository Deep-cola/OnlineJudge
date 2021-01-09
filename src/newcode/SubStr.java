package newcode;

/**
 * @description: 子串判断
 * 给定一个string数组p及其大小n，同时给定长字符串string s，请返回一个bool数组，
 * 元素为true或false对应p中的对应字符串是否为s的子串。要求p中的串长度小于等于8，且p中的串的个数小于等于500，同时要求s的长度小于等于1000。
 * 测试样例：        ["a","b","c","d"],4,"abc"
 * 返回：           [true,true,true,false]
 * @author: Deepcola
 * @time: 2021/1/9 17:48
 */
public class SubStr {

    /**
     * 使用 contains() 方法判断
     */
    public boolean[] chkSubStr(String[] p, int n, String s) {
        // write code here
        boolean[] flag = new boolean[n];
        for(int i = 0; i < n; i++) {
            flag[i] = s.contains(p[i]);
        }
        return flag;
    }
}
