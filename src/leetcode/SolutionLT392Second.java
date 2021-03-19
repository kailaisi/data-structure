package leetcode;

/**
 * 392. 判断子序列
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * 进阶：
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 * 示例 1：
 * 输入：s = "abc", t = "ahbgdc"
 * 输出：true
 * 示例 2：
 * 输入：s = "axc", t = "ahbgdc"
 * 输出：false
 * 提示：
 * 0 <= s.length <= 100
 * 0 <= t.length <= 10^4
 * 两个字符串都只由小写字符组成。
 * 解题思路：在双指针算法中，如果我们每次都对t做一遍从左到右的遍历，而且有上亿次的操作的话，肯定是非常耗时的。
 * 题目给的是t不变，s有大量的输入，这其实是一种指点，告诉我们其实考虑对t进行一定的处理，从而可以达到减少一次次遍历的结果。
 * 换一种思路：我遍历s字符串的时候，我匹配到了某个字符k,而且知道这个字符在s和t中的位置。我是否有办法立刻就能知道我下一个字符在t中的位置(这个位置是在k字符之后第一次出现的位置)？
 * 当我拿到t的时候，肯定是不知道我要遍历的下一个是什么字符的，所以，我可以用一个数组保存从a到z这26个字符的方式
 * 时间复杂度：O(1)  因为每次都至少移动一次指针，而两个指针最多移动m+n次
 * 空间复杂度：O(1)
 */
class SolutionLT392Second {
    public static void main(String[] args) {
        SolutionLT392Second lt = new SolutionLT392Second();
        System.out.println(lt.isSubsequence("abc", "ahbgdc"));//true
        System.out.println(lt.isSubsequence("axc", "ahbgdc"));//false
    }


    public boolean isSubsequence(String s, String t) {
        int len = t.length();
        int[][] ints = new int[len][26];
        t = " " + t;
        for (char ch = 0; ch < 26; ch++) {
            int p = -1;
            for (int i = len - 1; i >= 0; i--) {
                ints[i][ch] = p;//i之后的第一个ch的位置
                if (t.charAt(i) == ch + 'a') p = i;//能够往前迭代了
            }
        }
        //进行匹配
        int i = 0;
        for (char ch : s.toCharArray()) {
            i = ints[i][ch - 'a'];
            if (i == -1) {
                return false;
            }
        }
        return true;
    }
}