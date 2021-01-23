package leetcode;

/**
 * 搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= n, m <= 300
 * -109 <= matix[i][j] <= 109
 * 每行的所有元素从左到右升序排列
 * 每列的所有元素从上到下升序排列
 * -109 <= target <= 109
 * <p>
 * 相似题目：74
 * <p>
 * 解题思路：减而治之。由于行或者列都是递增的序列，当我们从左上角开始，找到某个数据的时候比target小的时候，那么往右或者往下，都会比当前位置变大。所以不知道如何去行走。
 * 但是我们可以通过路线去掉一种情况，比如说，从右往左？或者从下往上？。从右往左，遇到target，返回，遇到比target小了。这时因为是从右侧遍历过来的，所以只能向下。然后向左，向下，不断的遍历情况
 *
 * 时间复杂度：O(m+n)
 */
class SolutionLT240Second {
    public static void main(String[] args) {
        SolutionLT240Second lt = new SolutionLT240Second();
        System.out.println(lt.searchMatrix(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 5));
        System.out.println(lt.searchMatrix(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 18));
        System.out.println(lt.searchMatrix(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 20));
        System.out.println(lt.searchMatrix(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 1));
        System.out.println(lt.searchMatrix(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 30));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int height = matrix.length;
        int width = matrix[0].length;
        int j = width - 1;
        int i = 0;
        while (j >= 0 && i < height) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {//如果当前数据比target大，那么可以直接往左移动。也就是j--
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}