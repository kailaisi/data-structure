package leetcode;

import java.util.HashMap;

/**
 * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 * 注意：每次拼写（指拼写词汇表中的一个单词）时，chars 中的每个字母都只能用一次。
 * 返回词汇表 words 中你掌握的所有单词的 长度之和。
 * 示例 1：
 * 输入：words = ["cat","bt","hat","tree"], chars = "atach"
 * 输出：6
 * 解释：
 * 可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
 * 示例 2：
 * 输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * 输出：10
 * 解释：
 * 可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
 * 提示：
 * 1 <= words.length <= 1000
 * 1 <= words[i].length, chars.length <= 100
 * 所有字符串中都仅包含小写英文字母
 * 解题思路：逐层遍历
 * 首先通过HashMap保存字母表的所有的字符的个数信息。
 * 在拼写词汇的时候，每次都讲字母表对应个数-1，如果为0了，则表示拼写不成功。
 */
class SolutionLT1160 {
    public static void main(String[] args) {
        String[] words=new String[]{"cat","bt","hat","tree"};
        String chars="atach";
        int i = new SolutionLT1160().countCharacters(words, chars);
        System.out.println(i);
    }
    public int countCharacters(String[] words, String chars) {
        if (chars.length() == 0) {
            return 0;
        }
        String a;
        HashMap<Character, Integer> map = getHashMap(chars);
        int len=0;
        for (String str : words) {
            HashMap<Character, Integer> newList= (HashMap<Character, Integer>) map.clone();
            if (chars.length() < str.length()) {
                continue;
            }
            boolean add=true;
            for (char c : str.toCharArray()) {
                if(newList.getOrDefault(c,0)<=0){
                    add=false;
                    break;
                }
                newList.put(c,newList.get(c)-1);
            }
            if(add) {
                len += str.length();
            }
        }
        return len;
    }

    private HashMap<Character, Integer> getHashMap(String chars) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c : chars.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }
}