package leetcode;

import java.util.ArrayList;

/**
 * 我们来定义一个函数 f(s)，其中传入参数 s 是一个非空字符串；该函数的功能是统计 s  中（按字典序比较）最小字母的出现频次。
 * <p>
 * 例如，若 s = "dcce"，那么 f(s) = 2，因为最小的字母是 "c"，它出现了 2 次。
 * <p>
 * 现在，给你两个字符串数组待查表 queries 和词汇表 words，请你返回一个整数数组 answer 作为答案，其中每个 answer[i] 是满足 f(queries[i]) < f(W) 的词的数目，W 是词汇表 words 中的词。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：queries = ["cbd"], words = ["zaaaz"]
 * 输出：[1]
 * 解释：查询 f("cbd") = 1，而 f("zaaaz") = 3 所以 f("cbd") < f("zaaaz")。
 * 示例 2：
 * <p>
 * 输入：queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
 * 输出：[1,2]
 * 解释：第一个查询 f("bbb") < f("aaaa")，第二个查询 f("aaa") 和 f("aaaa") 都 > f("cc")。
 * 提示：
 * <p>
 * 1 <= queries.length <= 2000
 * 1 <= words.length <= 2000
 * 1 <= queries[i].length, words[i].length <= 10
 * queries[i][j], words[i][j] 都是小写英文字母
 */
class SolutionLT1170 {
    public static void main(String[] args) {
        System.out.println(new SolutionLT1170().numSmallerByFrequency(new String[]{"cbd"}, new String[]{"zaaaz"}));
    }

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] count = new int[12];//因为字符串得长度是1-10，所以字符串得长度肯定不会超过12.
        for (String word : words) {
            //统计对应得长度所包含的个数
            count[findSmaller(word)]++;
        }
        for (int i = 9; i >= 0; i--) {
            //count[i] 标识比i大的次数得个数
            count[i] += count[i + 1];
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int smaller = findSmaller(queries[i]);
            res[i] = count[smaller + 1];//这里+1，表示是比smaller大的数据
        }
        return res;
    }

    public int findSmaller(String str) {
        int[] ints = new int[26];
        for (char c : str.toCharArray()) {
            ints[c - 'a']++;
        }
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] != 0) {
                return ints[i];
            }
        }
        return 0;
    }
}
