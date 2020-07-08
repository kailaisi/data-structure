package leetcode;

import java.util.HashMap;

/**
 * 描述：键值映射
 * 实现一个 MapSum 类里的两个方法，insert 和 sum。
 * 对于方法 insert，你将得到一对（字符串，整数）的键值对。字符串表示键，整数表示值。如果键已经存在，那么原来的键值对将被替代成新的键值对。
 * 对于方法 sum，你将得到一个表示前缀的字符串，你需要返回所有以该前缀开头的键的值的总和。
 * 示例 1:
 * <p>
 * 输入: insert("apple", 3), 输出: Null
 * 输入: sum("ap"), 输出: 3
 * 输入: insert("app", 2), 输出: Null
 * 输入: sum("ap"), 输出: 5
 * <p>
 * 说明:
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 * 知识点：trie
 */
class LeetCode677 {
    private Node root;

    /**
     * Initialize your data structure here.
     */
    public LeetCode677() {
        root = new Node();
    }

    public void insert(String key, int val) {
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        cur.isLast = true;
        cur.num = val;
    }

    public int sum(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return 0;
            }
            cur = cur.next.get(c);
        }
        return sum(cur);
    }

    private int sum(Node cur) {
        int sum = 0;
        if (cur.isLast) {
            sum += cur.num;
        }
        if (cur.next.size() == 0) {
            return sum;
        } else {
            for (Character character : cur.next.keySet()) {
                sum += sum(cur.next.get(character));
            }
        }
        return sum;
    }

    private static class Node {
        private int num;
        private boolean isLast = false;
        private HashMap<Character, Node> next = new HashMap<>();
    }
}
