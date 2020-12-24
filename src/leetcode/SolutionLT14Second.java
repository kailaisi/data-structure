package leetcode;

import javax.lang.model.type.ErrorType;

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
 * 解题思路：横向遍历循环，前i个找到一个最小的公共字符。然后获得的字符串再和i+1个进行比较
 */
class SolutionLT14Second {
    public static void main(String[] args) {
        SolutionLT14Second lt = new SolutionLT14Second();
        System.out.println(lt.longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(lt.longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }

    public String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if(length ==0){
            return "";
        }
        if(length ==1){
            return  strs[0];
        }
        String str=strs[0];
        for(int i=1;i< length;i++){
            str=commonPrefix(str,strs[i]);
            if(str.isEmpty()){
                return "";
            }
        }
        return str;
    }

    private String commonPrefix(String str, String str1) {
        int len=Math.min(str.length(),str1.length());
        int index=0;
        while (index<len&& str.charAt(index)==str1.charAt(index)){
            index++;
        }
        return str.substring(0,index);
    }
}