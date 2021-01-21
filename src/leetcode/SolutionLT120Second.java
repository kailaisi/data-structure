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
 * 解题思路：迭代。对于[i][j]位置的最小和=min(D[i+1][j],D[i+1,j+1])+List[i][j]
 * 时间复杂度：O(n^2),对于计算D[i][j]位置的数据最小和的时候，会计算D[i+1][j+1]。但是很可能D[i][j+1]的时候，也会计算D[i+1][j+1]。属于重复计算，我们可以记录下来这个位置的sum值，下次就不再计算了
 *
 * 空间复杂度：O(1)
 */
class SolutionLT120Second {

    public static void main(String[] args) {
        SolutionLT120Second lt = new SolutionLT120Second();
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
        int width = triangle.get(height - 1).size();
        int[][] ints = new int[height][width];//用于保存i,j位置计算的数据
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                ints[i][j] = Integer.MIN_VALUE;
            }
        }
        int res = getMinSum(triangle, height, ints, 0, 0);
        return res;
    }

    /**
     * 迭代。计算triangle 列表，i,j位置的最小和。
     *
     * @param triangle
     * @param height   高度
     * @param ints
     * @param i        计算的
     * @param j
     * @return
     */
    private int getMinSum(List<List<Integer>> triangle, int height, int[][] ints, int i, int j) {
        if (height == i + 1) {
            return triangle.get(i).get(j);
        }
        if (ints[i][j]!=Integer.MIN_VALUE){
            return ints[i][j];
        }
        int left = getMinSum(triangle, height, ints, i + 1, j);
        int right = getMinSum(triangle, height, ints, i + 1, j + 1);
        ints[i][j]=Math.min(left, right) + triangle.get(i).get(j);
        return ints[i][j];
    }

}
