package leetcode;

/**
 * 28. 实现 strStr()
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 * 题解：最常用的方法，逐个滑动窗口，判断对应的字符串是否相等->没必要每次都判断整个字符串是否相等，只要判断第一个字符开始。然后逐个去判断即可。
 * 时间复杂度减少了，
 * 空间复杂度未变。
 */
class SolutionLT28Third {
    public static void main(String[] args) {
        SolutionLT28Third lt = new SolutionLT28Third();
        System.out.println(lt.strStr("hello","ll"));
        System.out.println(lt.strStr("aaaaa","ll"));
        System.out.println(lt.strStr("aaaaa",""));
        System.out.println(lt.strStr("aaaaa","aaaaaaaaa"));
    }
    public int strStr(String haystack, String needle) {
        //todo kmp算法
        return 0;
    }
}