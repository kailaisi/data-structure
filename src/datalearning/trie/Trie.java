package datalearning.trie;

import java.util.TreeMap;

/**
 * 描述：字典
 * <p/>作者：wu
 * <br/>创建时间：2020/7/7 8:33
 */
public class Trie {

    private Node root;
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWrod) {//如果已经添加过这个work，不做处理
            cur.isWrod = true;
            size++;
        }
    }

    public boolean contains(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWrod;
    }

    /**
     * 判断是否有以prfix为前缀的单词
     * @param prefix
     * @return
     */
    public boolean isPrefix(String prefix){
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }

    private static class Node {
        //标识是否是最后一个字符。比如  pan,panda，那么在n的位置必须要有一个标识，否则就无法识别pan这个字符了
        boolean isWrod;
        //通过key来保存对应的节点的值，不需要再通过单独的字符来保存了。
        TreeMap<Character, Node> next;

        public Node() {
            this(false);
        }

        public Node(boolean isWrod) {
            this.isWrod = isWrod;
            this.next = new TreeMap<>();
        }
    }
}
