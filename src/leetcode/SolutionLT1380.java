package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。
 * 幸运数是指矩阵中满足同时下列两个条件的元素：
 * 在同一行的所有元素中最小
 * 在同一列的所有元素中最大
 * 示例 1：
 * 输入：matrix = [[3,7,8],[9,11,13],[15,16,17]]
 * 输出：[15]
 * 解释：15 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
 * 示例 2：
 * 输入：matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
 * 输出：[12]
 * 解释：12 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
 * 示例 3：
 * 输入：matrix = [[7,8],[1,2]]
 * 输出：[7]
 * 提示：
 * m == mat.length
 * n == mat[i].length
 * 1 <= n, m <= 50
 * 1 <= matrix[i][j] <= 10^5
 * 矩阵中的所有元素都是不同的
 *
 * 解题思路：暴力破解。
 * 找到每行的最小值，每列的最大值。
 * 然后遍历，看ij位置的值，是否同时和i行的最小值以及j列的最大值相等。
 */
public class SolutionLT1380 {
    public static void main(String[] args) {
        int[][] ints = {{3, 7, 8}, {9, 11, 13}, {15, 16, 17}};
        List<Integer> list = new SolutionLT1380().luckyNumbers(ints);
        System.out.println(list);
    }
    public List<Integer> luckyNumbers (int[][] matrix) {
        int row = matrix.length;
        int width = matrix[0].length;
        int[] rowsMin = new int[row];
        for(int i=0;i<row;i++){//这里要设置为最大值。否则数组默认为0，0比任何数据都小，导致数据出现问题。
            rowsMin[i]=Integer.MAX_VALUE;
        }
        int[] widthMax = new int[width];
        for(int i=0;i<row;i++){
            for(int j=0;j<width;j++){
                rowsMin[i]=Math.min(rowsMin[i],matrix[i][j]);
                widthMax[j]=Math.max(widthMax[j],matrix[i][j]);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<width;j++){
               if(matrix[i][j]==rowsMin[i] && matrix[i][j]==widthMax[j]){
                   list.add(matrix[i][j]);
               }
            }
        }
        return list;
    }
}
