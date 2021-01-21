package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 120 三角形最小路径和
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 * 2
 * 3 4
 * 6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 示例 2：
 * 输入：triangle = [[-10]]
 * 输出：-10
 * <p>
 * 提示：
 * 1 <= triangle.length <= 200
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -104 <= triangle[i][j] <= 104
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？
 * <p>
 * 解题思路：我们可以从最后一行开始，往上进行叠加处理，这样的话，我们对于第i行数据，可以拿计算出来的i+1行的和进行计算。取最小值
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(n)
 */
class SolutionLT120Third {

    public static void main(String[] args) {
        SolutionLT120Third lt = new SolutionLT120Third();
        ArrayList<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(-10));
        System.out.println(lt.minimumTotal(list));   //2
        list.clear();
        list.add(Arrays.asList(2));
        list.add(Arrays.asList(3, 4));
        list.add(Arrays.asList(6, 5, 7));
        list.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(lt.minimumTotal(list));   //2
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int height = triangle.size();
        int[] ints1 = new int[height];
        for (int i=height-1;i>=0;i--){
            for(int j=0;j<=i;j++){//这里需要注意，需要从前往后计算。否则如果先计算了[j+1]位置的数据，再计算[j]位置的时候，[j+1]的数据已经不是下一行的计算的和了
                if(i==height-1){
                    ints1[j]=triangle.get(i).get(j);//当前是最后一行，那么最小和，就是当前数据
                }else{
                    ints1[j]=Math.min(ints1[j],ints1[j+1])+triangle.get(i).get(j);//根据下一行的数据计算当前行的最小和
                }
            }
        }
        return ints1[0];
    }

}
