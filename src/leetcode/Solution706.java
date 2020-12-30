package leetcode;

/**
 * @description: 设计哈希映射
 * 不使用任何内建的哈希表库设计一个哈希映射具体地说，你的设计应该包含以下的功能
 *      put(key, value)：向哈希映射中插入(键,值)的数值对。如果键对应的值已经存在，更新这个值。
 *      get(key)：返回给定的键所对应的值，如果映射中不包含这个键，返回-1。
 *      remove(key)：如果映射中存在这个键，删除这个数值对。
 *
 * MyHashMap hashMap = new MyHashMap();
 * hashMap.put(1, 1);          
 * hashMap.put(2, 2);        
 * hashMap.get(1);            // 返回 1
 * hashMap.get(3);            // 返回 -1 (未找到)
 * hashMap.put(2, 1);         // 更新已有的值
 * hashMap.get(2);            // 返回 1
 * hashMap.remove(2);         // 删除键为2的数据
 * hashMap.get(2);            // 返回 -1 (未找到)
 * @author: Deepcola
 * @time: 2020/12/30 19:51
 */
public class Solution706 {

    class MyHashMap {

        class Node {
            int key;
            int value;
            Node next;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private Node[] array;
        private int usedSize;

        /**
         * Initialize your data structure here.
         */
        public MyHashMap() {
            this.array = new Node[997];
            this.usedSize = 0;
        }

        /**
         * value will always be non-negative.
         */
        public void put(int key, int value) {
            int index = key % this.array.length;
            // 判断是否发生冲突
            for (Node cur = this.array[index]; cur != null; cur = cur.next) {
                if (cur.key == key) {
                    cur.value = value;
                    return;
                }
            }
            // 没有冲突 -> 插入(头插法)
            Node node = new Node(key, value);
            node.next = this.array[index];
            this.array[index] = node;
            this.usedSize++;
        }

        /**
         * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
         */
        public int get(int key) {
            int index = key % this.array.length;
            for (Node cur = this.array[index]; cur != null; cur = cur.next) {
                if (cur.key == key) {
                    return cur.value;
                }
            }
            return -1;
        }

        /**
         * Removes the mapping of the specified value key if this map contains a mapping for the key
         */
        public void remove(int key) {
            int index = key % this.array.length;
            // 元素不存在
            if (this.array[index] == null) return;
            // 删除的是头节点
            if (this.array[index].key == key) {
                this.usedSize--;
                this.array[index] = this.array[index].next;
                return;
            }
            // 前驱节点
            Node prev = null;
            for (Node cur = this.array[index]; cur != null; cur = cur.next) {
                if (cur.key == key && prev != null) {
                    prev.next = cur.next;
                    this.usedSize--;
                    return;
                }
                prev = cur;
            }
        }
    }
}