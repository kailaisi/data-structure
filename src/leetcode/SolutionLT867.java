package leetcode;

import java.util.Arrays;

/**
 * 给定一个矩阵 A， 返回 A 的转置矩阵。
 * <p>
 * 矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[1,4,7],[2,5,8],[3,6,9]]
 * 示例 2：
 * <p>
 * 输入：[[1,2,3],[4,5,6]]
 * 输出：[[1,4],[2,5],[3,6]]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 1000
 * 1 <= A[0].length <= 1000
 * <p>
 * 题解思路：属于数组的基础知识。需要将A[i][j]数据放到新数组B[j][i]的位置。
 * 只能通过不断的循环处理问题。
 */
class SolutionLT867 {

    public static void main(String[] args) {
        SolutionLT867 lt = new SolutionLT867();
        int[][] transpose = lt.transpose(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        // System.out.println(Arrays.toString(transpose));
        transpose = lt.transpose(new int[][]{{1, 2, 3}, {4, 5, 6}});
        System.out.println(Arrays.toString(transpose));
    }

    public int[][] transpose(int[][] A) {
        int height = A.length;
        int width = A[0].length;
        int[][] ints = new int[width][height];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                ints[j][i] = A[i][j];
            }
        }
        return ints;
    }
}