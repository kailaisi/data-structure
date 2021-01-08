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
 * 解题思路：既然所有的数据都是有序的，那么我们可以将其放入到一个一维数组，然后通过二分查找法进行排序处理。
 * 这里的时间为O(logn)，空间为log(m*n)
 */
class SolutionLT74Second {
    public static void main(String[] args) {
        SolutionLT74Second lt = new SolutionLT74Second();
        System.out.println(lt.searchMatrix(new int[][]{{1,3,5,7}, {10,11,16,20}, {23,30,34,60}},7));
        System.out.println(lt.searchMatrix(new int[][]{{1,3,5,7}, {10,11,16,20}, {23,30,34,60}},13));
        System.out.println(lt.searchMatrix(new int[][]{{2,3,5,7}, {10,11,16,20}, {23,30,34,60}},1));
        System.out.println(lt.searchMatrix(new int[][]{{1,3,5,7}, {10,11,16,20}, {23,30,34,60}},34));
        System.out.println(lt.searchMatrix(new int[][]{{1,3,5,7}, {10,11,16,20}, {23,30,34,60}},60));
        System.out.println(lt.searchMatrix(new int[][]{{1,3,5,7}, {10,11,16,20}, {23,30,34,60}},62));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int height = matrix.length;
        int width = matrix[0].length;
        int[] ints = new int[height * width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                ints[i * width + j] = matrix[i][j];
            }
        }
        int start = 0;
        int end = ints.length-1;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (ints[mid] < target) {
                start = mid;
            } else if (ints[mid] > target) {
                end = mid;
            } else {
                return true;
            }
        }
        if (ints[end] != target & ints[start] != target) {
            return false;
        }
        return true;

    }
}