package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 示例:
 * 输入: 5
 * 输出:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 * 数组
 * 解题思路：
 */
public class SolutionLT118 {
    public static void main(String[] args) {
        List<List<Integer>> list = new SolutionLT118().generate(0);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> inner = new ArrayList<>();
            //先放个1
            inner.add(1);
            if(list.size()>0){
                //如果已经有队列了，那么这里可以按照上一个队列来计算和
                List<Integer> integers = list.get(i-1);
                for (int j = 1; j < i; j++) {
                    inner.add(integers.get(j)+integers.get(j-1));
                }
                //队列尾放个1
                inner.add(1);
                list.add(inner);
            }else{
                list.add(inner);
            }
        }
        return list;
    }
}
