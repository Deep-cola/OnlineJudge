package leetcode;

import java.util.*;

/**
 * @description: 前 k 个高频单词
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 * @author: Deepcola
 * @time: 2020/11/20 18:19
 */
public class Solution692 {

    /**
     * 1.使用 hashMap 统计单词及次数
     * 2.根据出现次数进行排序
     */
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        // 统计所有出现的单词以及相对应的次数
        for (String word: words) {
            hashMap.put(word, hashMap.getOrDefault(word, 0) + 1);
        }
        // 小根堆
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return hashMap.get(o1) == hashMap.get(o2) ? o2.compareTo(o1) : hashMap.get(o1) - hashMap.get(o2);
            }
        });
        // 单词进入小根堆排序
        for (Map.Entry<String, Integer> entry: hashMap.entrySet()) {
            priorityQueue.offer(entry.getKey());
            // 弹出出现次数少或者同等次数下字母顺序靠后的单词
            if (priorityQueue.size() > k) priorityQueue.poll();
        }
        List<String> list = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            list.add(priorityQueue.poll());
        }

        Collections.reverse(list);
//        list.sort(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return hashMap.get(o1) == hashMap.get(o2) ? o1.compareTo(o2) : hashMap.get(o2) - hashMap.get(o1);
//            }
//        });

        return list;
    }

    public static void main(String[] args) {
        Solution692 solution = new Solution692();
//        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
//        int k = 2;
        String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k = 4;
        System.out.println(solution.topKFrequent(words, k));
    }

}
