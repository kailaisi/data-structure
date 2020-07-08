package leetcode;

import datalearning.trie.Trie;

import java.util.TreeMap;

/**
 * 描述：设计一个支持以下两种操作的数据结构：
 * <p>
 * void addWord(word)
 * bool search(word)
 * search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。
 * <p>
 * 示例:
 * <p>
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * 说明:
 * <p>
 * 你可以假设所有单词都是由小写字母 a-z 组成的。
 * <p>
 * 知识点：Trid
 * 解题思路：通过Trie来进行数据的添加。
 * 当搜索的时候，通过递归的方式去匹配。
 * 如果遇到了*，那么就匹配所有的下一个节点信息
 */
class LeetCode211 {
    private Node root;

    /**
     * Initialize your data structure here.
     */
    public LeetCode211() {
        root = new Node();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        Node cur=root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if (cur.next.get(c)==null) {
                cur.next.put(c,new Node());
            }
            cur=cur.next.get(c);
        }
        cur.isWrod=true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return match(root,word,0);
    }

    private boolean match(Node node,String word,int index){
        if(index==word.length()){
            return node.isWrod;
        }
        char c = word.charAt(index);
        if(c!='.'){
            if (node.next.get(c)==null) {
                return false;
            }else{
               return match(node.next.get(c),word,index+1);
            }
        }else{
            TreeMap<Character, Node> next = node.next;
            for (char nextChar:next.keySet()){
                if(match(node.next.get(nextChar),word,index+1)){
                    return true;
                }
            }
            return false;
        }
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

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */