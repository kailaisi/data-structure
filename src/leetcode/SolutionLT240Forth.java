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
 * 解题思路：使用二分法。对于行或者列数据，都是有序的。所以我们可以通过对行或者列进行二分搜索来处理数据。还有一个比较好的地方是，对于[i][j]位置，右下方都是比他大的。
 * 当我们按照对角线找到比target数据大的时候，就没必要再向下查找了。
 * 这时候，从0行开始到index，按照行和列进行二分查找即可。
 * 时间复杂度：O(m*n)
 */
class SolutionLT240Forth {
    public static void main(String[] args) {
        SolutionLT240Forth lt = new SolutionLT240Forth();
        System.out.println(lt.searchMatrix(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 5));
        System.out.println(lt.searchMatrix(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 18));
        System.out.println(lt.searchMatrix(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 20));
        System.out.println(lt.searchMatrix(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 1));
        System.out.println(lt.searchMatrix(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 30));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int height = matrix.length;
        int width = matrix[0].length;
        int right = Math.max(height-1, width-1);
        //查找对角线上第一个>target的坐标数据
        int left = 0;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (matrix[mid][mid] == target) {
                return true;
            } else if (matrix[mid][mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        //从0-mid二分搜索数据
        for (int i = 0; i <= left; i++) {
            boolean b = bineryRowSearch(matrix, i, width-1, target);
            boolean b1 = bineryColSearch(matrix, i, height-1, target);
            if (b||b1){
                return true;
            }
        }
        return bineryRowSearch(matrix, left, left, target);
    }

    private boolean bineryColSearch(int[][] matrix, int left, int right, int target) {
        int col=left;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[mid][col] == target) {
                return true;
            } else if (matrix[mid][col] > target) {
                right = mid-1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    //行搜索
    private boolean bineryRowSearch(int[][] matrix, int left, int right, int target) {
        int row=left;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] > target) {
                right = mid-1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}