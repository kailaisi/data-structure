package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * <p>
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * 输出:
 * [5,6]
 * 解题技巧：巧妙的利用1 ≤ a[i] ≤ n ( n = 数组大小 ) 这个条件
 * 这个说明我们任何的a[i]的值-1在数组中都能找到对应的位置信息。所以我们可以将这个位置的变为负数。
 */
class SolutionLT830 {
    public static void main(String[] args) {
        SolutionLT830 lt167 = new SolutionLT830();
        System.out.println(lt167.largeGroupPositions("abcdddeeeeaabbbcd"));
    }


    public List<List<Integer>> largeGroupPositions(String S) {
        char[] chars = S.toCharArray();
        ArrayList<List<Integer>> lists = new ArrayList<>();
        int start=0;//记录某个字母的起始位置
        for (int i=0;i<chars.length-1;i++){
            if(chars[i]==chars[i+1]){//一样，那么就遍历

            }else if (chars[i]!=chars[i+1]){//不一样了
                if(i-start+1>=3){//计算字母的首个位置和当前i的差值
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(start);
                    list.add(i);
                    lists.add(list);
                }
                //将起始位置修改为i+1
                start=i+1;
            }
        }
        if(chars.length-start+1>3){//用于记录最后一个字母相同的情况
            ArrayList<Integer> list = new ArrayList<>();
            list.add(start);
            list.add(chars.length-1);
            lists.add(list);
        }
        return lists;
    }
}
