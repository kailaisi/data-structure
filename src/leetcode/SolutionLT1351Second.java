package leetcode;

/**
 * 给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。 
 * <p>
 * 请你统计并返回 grid 中 负数 的数目。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
 * 输出：8
 * 解释：矩阵中共有 8 个负数。
 * 示例 2：
 * <p>
 * 输入：grid = [[3,2],[1,0]]
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：grid = [[1,-1],[-1,-1]]
 * 输出：3
 * 示例 4：
 * <p>
 * 输入：grid = [[-1]]
 * 输出：1
 *  
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 100
 * -100 <= grid[i][j] <= 100
 * 解题思路：由于每一行都是有序的，所以每一行可以通过二分法来查找对应的<0的位置点，然后进行计算。
 *
 */
class SolutionLT1351Second {

    public static void main(String[] args) {
        SolutionLT1351Second lt = new SolutionLT1351Second();
        int[][] ints = new int[][]{
                {4, 3, 2, -1},
                {3, 2, 1, -1},
                {1, 1, -1, -2},
                {-1, -1, -2, -3}};
        System.out.println(lt.countNegatives(ints));
        ints = new int[][]{
                {3, 2},
                {1, 0}
        };
        System.out.println(lt.countNegatives(ints));
        ints = new int[][]{
                {1, -1},
                {1, -1}
        };
        System.out.println(lt.countNegatives(ints));
        ints = new int[][]{
                {-1},
        };
        System.out.println(lt.countNegatives(ints));
    }

    public int countNegatives(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            count += count(grid[i]);
        }
        return count;
    }

    public int count(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        if (arr[0] < 0) {
            return end + 1;
        }
        if (arr[end] >= 0) {
            return 0;
        }
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (arr[mid] >= 0) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (arr[start] >= 0) {
            return arr.length - (start + 1);
        } else {
            return arr.length - (start);
        }
    }
}