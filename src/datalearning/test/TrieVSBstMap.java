package datalearning.test;

import datalearning.tree.BSTSet;
import datalearning.trie.Trie;

import java.util.List;

/**
 * 描述：比较trie和bstset
 * <p/>作者：wu
 * <br/>创建时间：2020/7/7 8:59
 */
class TrieVSBstMap {
    public static void main(String[] args) {
        List<String> words = Utils.INSTANCE.readFile("F:\\workspace\\web\\data-structure\\Array\\src\\pride.txt");
        for (int i = 0; i < 10; i++) {
            words.addAll(words);
        }
        long start = System.nanoTime();
        BSTSet<String> set = new BSTSet<>();
        for (String word : words) {
            set.add(word);
        }
        for (String word : words) {
            set.contains(word);
        }
        long end = System.nanoTime();
        System.out.println("Total different words:" + set.getSize());
        System.out.println("BSTSet time:" + (end - start));

        start = System.nanoTime();
        Trie trie = new Trie();
        for (String word : words) {
            trie.add(word);
        }
        for (String word : words) {
            trie.contains(word);
        }
        end = System.nanoTime();
        System.out.println("Total different words:" + set.getSize());
        System.out.println("BSTSet time:" + (end - start));
    }
}
