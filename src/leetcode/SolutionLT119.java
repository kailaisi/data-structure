package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 示例:
 * 输入: 3
 * 输出: [1,3,3,1]
 * 进阶：
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 * 数组
 * 解题思路：
 */
public class SolutionLT119 {
    public static void main(String[] args) {
        List<Integer> list = new SolutionLT119().getRow(3);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public List<Integer> getRow(int numRows) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <=numRows; i++) {
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
        return list.get(numRows);
    }
}
