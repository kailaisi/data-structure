package leetcode;

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1：
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 * 解题思路：暴力排解+n分查找。因为是有序的，所以我们可以通过最后一列，来判断最终的数据是在哪一行，然后再遍历具体的某一行数据。这里需要两次遍历，时间是m+n;
 */
class SolutionLT74Third {
    public static void main(String[] args) {
        SolutionLT74Third lt = new SolutionLT74Third();
        System.out.println(lt.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 7));
        System.out.println(lt.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 13));
        System.out.println(lt.searchMatrix(new int[][]{{2, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 1));
        System.out.println(lt.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 34));
        System.out.println(lt.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 60));
        System.out.println(lt.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 62));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int height = matrix.length;
        int width = matrix[0].length;
        int line = 0;
        for (int i = 0; i < height; i++) {//确定到具体的行数
            if (matrix[i][width - 1] >= target) {
                line = i;
                break;
            }
        }
        for (int j = 0; j < width; j++) {//然后查找具体的列数
            if (matrix[line][j] == target) {
                return true;
            }

            if (matrix[line][j] > target) {
                return false;
            }
        }
        return false;
    }
}