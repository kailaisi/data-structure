package leetcode;

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
 * 题解：暴力法：第k小，其实对于比较小的k来说，没有必要把所有的数据都存到list中去排序，只需要排前m*m>k即可。
 */
class SolutionLT378Second {
    public static void main(String[] args) {
        SolutionLT378Second lt = new SolutionLT378Second();
        System.out.println(lt.kthSmallest(new int[][]{{1,  5,  9}, {10, 11, 13}, {12, 13, 15}},8));
    }

    public int kthSmallest(int[][] matrix, int k) {
        int height = matrix.length;
        int width = matrix[0].length;
        List<Integer> res = new ArrayList();
        int m = (int) Math.ceil(Math.sqrt(k));
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(j>m && i>m){

                }else {
                    res.add(matrix[i][j]);
                }
            }
        }
        Collections.sort(res);
        return res.get(k-1);
    }
}