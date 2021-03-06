package leetcode;

import org.xml.sax.ext.Locator2;

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
class SolutionLT28Second {
    public static void main(String[] args) {
        SolutionLT28Second lt = new SolutionLT28Second();
        System.out.println(lt.strStr("hello","ll"));
        System.out.println(lt.strStr("aaaaa","ll"));
        System.out.println(lt.strStr("aaaaa",""));
        System.out.println(lt.strStr("aaaaa","aaaaaaaaa"));
    }
    public int strStr(String haystack, String needle) {
        if(needle.isEmpty()){
            return 0;
        }
        int l1 = haystack.length();
        int len = needle.length();
        if(len > l1){
            return -1;
        }
        int index1=0;//记录长串对比的字符坐标
        int index2=0;//记录短串对比的字符坐标
        for(int i=0;i<=l1-len;){
            if(haystack.charAt(index1++)==needle.charAt(index2++)){
                //对应字符位置相等，比较下一个
                if(index2==len){
                    return i;
                }
            }else {
                i++;
                //长串坐标右移一位，短串归零
                index1=i;
                index2=0;
            }
        }
        return -1;
    }
}