package leetcode;

/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
 *
 * 示例:
 *
 * 输入: "Hello World"
 * 输出: 5
 *
 * 题解：先去掉尾部的空格。然后指针指向最后一个位置，通过不断的前移，找到是空格的地方。然后计算长度即可
 */
class SolutionLT58Second {
    public static void main(String[] args) {
        SolutionLT58Second lt = new SolutionLT58Second();
        System.out.println(lt.lengthOfLastWord("Hello World"));
        System.out.println(lt.lengthOfLastWord(""));
        System.out.println(lt.lengthOfLastWord("a"));
    }
    public int lengthOfLastWord(String s) {
        s=s.trim();
        int length = s.length();
        int start=length-1;
        while (start>=0 && s.charAt(start)!=' '){
            start--;
        }
        return length-start-1;
    }
}