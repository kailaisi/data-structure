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
 * 解题思路：双指针（贪心算法），快指针和满指针，快指针指向t字符串，慢指针指向s字符串，遇到二者相同的时候，则快慢指针都增加
 * 时间复杂度：O(m+n)  因为每次都至少移动一次指针，而两个指针最多移动m+n次
 * 空间复杂度：O(1)
 */
class SolutionLT392 {
    public static void main(String[] args) {
        SolutionLT392 lt = new SolutionLT392();
        System.out.println(lt.isSubsequence("abc","ahbgdc"));//true
        System.out.println(lt.isSubsequence("axc","ahbgdc"));//false
    }


    public boolean isSubsequence(String s, String t) {
        int slow=0;
        int fast=0;
        int sLen = s.length();
        int fLen = t.length();
        if(fLen<sLen){
            return false;
        }
        while (slow<sLen && fast<fLen){
            if (s.charAt(slow)==t.charAt(fast)){
                slow++;
            }
            fast++;
        }
        return slow==sLen;
    }
}