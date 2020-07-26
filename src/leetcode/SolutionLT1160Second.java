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
 * 解题思路：都是小写字母，可以用数组表示？
 */
class SolutionLT1160Second {
    //todo 未完成
    public static void main(String[] args) {
        String[] words=new String[]{"hello","world","leetcode"};
        String chars="welldonehoneyr";
        int i = new SolutionLT1160Second().countCharacters(words, chars);
        System.out.println(i);
    }
    public int countCharacters(String[] words, String chars) {
        if (chars.length() == 0) {
            return 0;
        }
        int[] ints = new int[26];
        for (Character c:chars.toCharArray()){
            ints[c-'a']+=1;
        }
        int len=0;
        a:for (String str : words) {
            if(str.length()>chars.length()){
                continue;
            }
            int[] w = new int[26];
            for (Character c:str.toCharArray()){
                w[c-'a']+=1;
            }
            for(int i=0;i<26;i++){
                if(w[i]>ints[i]){
                    continue a;
                }
            }
            len+=str.length();
        }
        return len;
    }

}