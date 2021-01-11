package leetcode;

import sun.nio.cs.ext.MacArabic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * matrix = [
 * [ 1,  5,  9],
 * [10, 11, 13],
 * [12, 13, 15]
 * ],
 * k = 8,
 * <p>
 * 返回 13。
 *  
 * <p>
 * 提示：
 * 你可以假设 k 的值永远是有效的，1 ≤ k ≤ n2 。
 * <p>
 * 题解：暴力法：将数组逐个添加到list中，然后使用Collections.sort方法进行排序，获取到对应的k位置的数据即可。
 */
class SolutionLT378 {
    public static void main(String[] args) {
        SolutionLT378 lt = new SolutionLT378();
        System.out.println(lt.kthSmallest(new int[][]{{1,  5,  9}, {10, 11, 13}, {12, 13, 15}},8));
    }

    public int kthSmallest(int[][] matrix, int k) {
        int height = matrix.length;
        int width = matrix[0].length;
        List<Integer> res = new ArrayList();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                res.add(matrix[i][j]);
            }
        }
        Collections.sort(res);
        return res.get(k-1);
    }
}