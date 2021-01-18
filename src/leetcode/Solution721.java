package leetcode;

import java.util.*;

/**
 * @description: 账户合并
 * 给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其余元素是 emails 表示该账户的邮箱地址。
 * 现在，我们想合并这些账户。如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。
 * 请注意，即使两个账户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。
 * 合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是按顺序排列的邮箱地址。账户本身可以以任意顺序返回。
 *
 * 示例 1：
 * 输入：
 * accounts =   [["John", "johnsmith@mail.com", "john00@mail.com"],
 *              ["John", "johnnybravo@mail.com"],
 *              ["John", "johnsmith@mail.com", "john_newyork@mail.com"],
 *              ["Mary", "mary@mail.com"]]
 * 输出：
 *      [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],
 *      ["John", "johnnybravo@mail.com"],
 *      ["Mary", "mary@mail.com"]]
 * 解释：
 * 第一个和第三个 John 是同一个人，因为他们有共同的邮箱地址 "johnsmith@mail.com"。
 * 第二个 John 和 Mary 是不同的人，因为他们的邮箱地址没有被其他帐户使用。
 * 可以以任何顺序返回这些列表，例如答案 [['Mary'，'mary@mail.com']，['John'，'johnnybravo@mail.com']，
 * ['John'，'john00@mail.com'，'john_newyork@mail.com'，'johnsmith@mail.com']] 也是正确的。
 *  
 * 提示：
 *      accounts的长度将在[1，1000]的范围内。
 *      accounts[i]的长度将在[1，10]的范围内。
 *      accounts[i][j]的长度将在[1，30]的范围内。
 * @author: Deepcola
 * @time: 2021/1/18 8:29
 */
public class Solution721 {

    /**
     * 并查集: 当两个账户至少有一个共同的邮箱地址 -> 合并
     *    1.使用两个 map 分别存储: 邮箱对应的编号 和 邮箱对应的人名 -> 同一个邮箱地址在两个哈希表中都只能存储一次(两个邮箱地址相同属于同一个人)
     *    2.同一个账户的邮箱地址一定属于同一个人 -> 编号合并(并查集存储的是每个邮箱的编号)
     *    3.遍历所有的邮箱地址查找其属于哪个合并后的账户 -> 构建对于每个 id 所有的邮箱
     *    4.格式整理: 邮箱地址排序 + 任意一个邮箱地址所对应的账户
     */
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // 1.使用两个 map 分别存储: 邮箱对应的编号 和 邮箱对应的人名
        HashMap<String, Integer> emailToId = new HashMap<>();
        HashMap<String, String> emailToName = new HashMap<>();
        // 遍历账户存储两个 map
        int id = 0;
        for (List<String> account: accounts) {
            // 对于一个账户: 第一个位名字, 后面是邮箱
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                if (!emailToId.containsKey(email)) {
                    emailToId.put(email, id++);
                    emailToName.put(email, account.get(0));
                }
            }
        }
        // 2.同一个账户的邮箱地址一定属于同一个人
        // 连通一个账户内的所有邮箱
        UnionFind unionFind = new UnionFind(id);
        for (List<String> account: accounts) {
            String prevEmail = account.get(1);
            Integer prevId = emailToId.get(prevEmail);
            for (int i = 2; i < account.size(); i++) {
                String curEmail = account.get(i);
                Integer curId = emailToId.get(curEmail);
                unionFind.union(prevId, curId);
            }
        }
        // 3.遍历所有的邮箱地址查找其属于哪个合并后的账户 -> 构建对于每个 id 所有的邮箱
        Map<Integer, List<String>> idToEmails = new HashMap<>();
        for (String email: emailToId.keySet()) {
            int getId = unionFind.find(emailToId.get(email));
            List<String> emails = idToEmails.getOrDefault(getId, new ArrayList<>());
            emails.add(email);
            idToEmails.put(getId, emails);
        }
        // 4.格式整理: 邮箱地址排序 + 任意一个邮箱地址所对应的账户
        List<List<String>> result = new ArrayList<>();
        for (List<String> emails: idToEmails.values()) {
            // 每一个账户的邮箱需要进行排序
            Collections.sort(emails);
            String name = emailToName.get(emails.get(0));
            List<String> account = new ArrayList<>();
            account.add(name);
            account.addAll(emails);
            result.add(account);
        }
        return result;
    }

    static class UnionFind {
        private final int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        // 合并两个元素所在的子集
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            parent[rootX] = rootY;
        }
        // 查找元素所在子集
        private int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }
}
