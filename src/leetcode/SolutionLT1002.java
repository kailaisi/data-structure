package leetcode;

import java.util.*;

/**
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 * <p>
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] 是小写字母
 * 解题思路：先将第一个字符串和第二个字符串分别保存到对应的数组ints 和tempHash中，然后取二者最小值存入到ints中。将ints和第三个字符串的tempHesh继续取最小集
 */
class SolutionLT1002 {
    public static void main(String[] args) {
        SolutionLT1002 lt167 = new SolutionLT1002();
        int[] numbers = new int[]{1, 2, 3, 4};
        List<String> ints = lt167.commonChars(new String[]{"cool","lock","cook"});
        System.out.println(ints.toString());
    }

    public List<String> commonChars(String[] A) {
        if (A.length <= 1 || A == null) {
            return null;
        }
        //记录第一个单词所拥有的字符集
        int[] ints = new int[26];
        for (int i=0;i<A[0].length();i++){
            int i1 = A[0].charAt(i) - 'a';
            ints[i1]++;
        }
        //用于保存要对比的数据
        int[] tempHash = new int[26];
        for (int i = 1; i < A.length; i++) {
            for(char a:A[i].toCharArray()){
                int i1 =a - 'a';
                tempHash[i1]++;
            }
            //取二者的交集
            for(int j=0;j<26;j++){
                //去两个字符串对应的字符的最小值
                ints[j]=Math.min(ints[j],tempHash[j]);
                tempHash[j]=0;//将temp归零
            }
        }
        List<String> list = new LinkedList<String>();
        for(int i = 0; i < 26; i++)
        {
            while(ints[i] > 0)
            {
                list.add(String.valueOf((char)(i + 'a')));
                ints[i]--;
            }
        }
        return list;
    }
}