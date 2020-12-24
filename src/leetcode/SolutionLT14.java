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
 * 解题思路：纵向遍历循环，每次都是遍历同一个位置的字符是否相同
 */
class SolutionLT14 {
    public static void main(String[] args) {
        SolutionLT14 lt = new SolutionLT14();
        System.out.println(lt.longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(lt.longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        int len=strs[0].length();
        for(int i=1;i<strs.length;i++){
            len=Math.min(len,strs[i].length());
        }
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<len;i++){
            char c=strs[0].charAt(i);
            for(int j=0;j<strs.length;j++){
                if(c!=strs[j].charAt(i)){
                    return builder.toString();
                }
            }
            builder.append(c);
        }
        return builder.toString();
    }
}