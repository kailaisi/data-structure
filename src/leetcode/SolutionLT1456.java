package leetcode;


import java.util.Stack;

/**
 * 1456. 定长子串中元音的最大数目
 * 给你字符串 s 和整数 k 。
 * 请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
 * 英文中的 元音字母 为（a, e, i, o, u）。
 * 示例 1：
 * 输入：s = "abciiidef", k = 3
 * 输出：3
 * 解释：子字符串 "iii" 包含 3 个元音字母。
 * 示例 2：
 * 输入：s = "aeiou", k = 2
 * 输出：2
 * 解释：任意长度为 2 的子字符串都包含 2 个元音字母。
 * 示例 3：
 * 输入：s = "leetcode", k = 3
 * 输出：2
 * 解释："lee"、"eet" 和 "ode" 都包含 2 个元音字母。
 * 示例 4：
 * 输入：s = "rhythms", k = 4
 * 输出：0
 * 解释：字符串 s 中不含任何元音字母。
 * 示例 5：
 * 输入：s = "tryhard", k = 4
 * 输出：1
 * 提示：
 * 1 <= s.length <= 10^5
 * s 由小写英文字母组成
 * 1 <= k <= s.length
 * 解题思路：典型的滑动窗口案例，这个是固定窗口，所以使用模板即可
 * 时间复杂度：O（N）：1次遍历。
 * 空间复杂度：O（N）：需要使用我们的集合来保存输入的数据
 */
class SolutionLT1456 {
    public static void main(String[] args) {
        SolutionLT1456 lt = new SolutionLT1456();
        System.out.println(lt.maxVowels("abciiidef",3));//3
        System.out.println(lt.maxVowels("aeiou",2));//2
        System.out.println(lt.maxVowels("leetcode",3));//2
        System.out.println(lt.maxVowels("rhythms",4));//0
        System.out.println(lt.maxVowels("tryhard",4));//1
    }

    public int maxVowels(String s, int k) {
        int res = 0;
        int math=0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isVowel(c)){
                res++;
            }
            math=Math.max(res,math);
            if (i>=k-1){
                if (isVowel(s.charAt(i-k+1))){
                    res--;
                }
            }
        }
        return math;
    }

    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
