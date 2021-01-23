package leetcode;

/**
 * 搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * 输出：false
 *
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= n, m <= 300
 * -109 <= matix[i][j] <= 109
 * 每行的所有元素从左到右升序排列
 * 每列的所有元素从上到下升序排列
 * -109 <= target <= 109
 *
 * 相似题目：74
 *
 * 解题思路：由于每一行或者每一列都是有序的，所以我们可以
 *
 * 时间复杂度：O(m*n)
 */
class SolutionLT240 {
    public static void main(String[] args) {
        SolutionLT240 lt = new SolutionLT240();
        System.out.println(lt.searchMatrix(new int[][]{{1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}},5));
        System.out.println(lt.searchMatrix(new int[][]{{1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}},20));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int height = matrix.length;
        int width = matrix[0].length;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (matrix[i][j]==target){
                    return true;
                }
            }
        }
        return false;
    }
}