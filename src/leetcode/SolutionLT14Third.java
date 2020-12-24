package leetcode;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 * 解题思路：分而治之。每次都取一半长度的公共前缀
 */
class SolutionLT14Third {
    public static void main(String[] args) {
        SolutionLT14Third lt = new SolutionLT14Third();
        System.out.println(lt.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(lt.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }

    public String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            return strs[0];
        }
        if (length == 2) {
            return commonPrefix(strs[0], strs[1]);
        }
        return longestCommonPrefix(strs, 0, length-1);
    }

    public String longestCommonPrefix(String[] strs, int start, int end) {
        if (start == end) {
            return strs[start];
        }
        int mid = (start+end)/2;
        return commonPrefix(longestCommonPrefix(strs, start, mid), longestCommonPrefix(strs, mid + 1, end));
    }

    private String commonPrefix(String str, String str1) {
        int len = Math.min(str.length(), str1.length());
        int index = 0;
        while (index < len && str.charAt(index) == str1.charAt(index)) {
            index++;
        }
        return str.substring(0, index);
    }
}