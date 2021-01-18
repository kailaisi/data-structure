package leetcode;

import java.util.Arrays;

/**
 * 这里有一幅服务器分布图，服务器的位置标识在 m * n 的整数矩阵网格 grid 中，1 表示单元格上有服务器，0 表示没有。
 * 如果两台服务器位于同一行或者同一列，我们就认为它们之间可以进行通信。
 * 请你统计并返回能够与至少一台其他服务器进行通信的服务器的数量。
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[1,0],[0,1]]
 * 输出：0
 * 解释：没有一台服务器能与其他服务器进行通信。
 * 示例 2：
 * 输入：grid = [[1,0],[1,1]]
 * 输出：3
 * 解释：所有这些服务器都至少可以与一台别的服务器进行通信。
 * 示例 3：
 * 输入：grid = [[1,1,0,0],[0,0,1,0],[0,0,1,0],[0,0,0,1]]
 * 输出：4
 * 解释：第一行的两台服务器互相通信，第三列的两台服务器互相通信，但右下角的服务器无法与其他服务器通信。
 *  
 * 提示：
 * m == grid.length
 * n == grid[i].length
 * 1 <= m <= 250
 * 1 <= n <= 250
 * grid[i][j] == 0 or 1
 * <p>
 * 解题思路：机器能和其他机器通信的一个判断条件就是：同一行或者同一列的数据的和>=2即可。
 * 所以可以进行2次遍历，
 * 第一次，统计各行各列的个数（这里没有必要全部统计完，只需要发现行或者列的和>1即可停止）
 * 第二次，遍历各个位置，然后查找对应的行或者列的个数是否>1.
 * 时间复杂度：O(m*n),
 * 空间复杂度：O(m+n)
 */
class SolutionLT1267 {

    public static void main(String[] args) {
        SolutionLT1267 lt = new SolutionLT1267();
        System.out.println(lt.countServers(new int[][]{{1, 0},{0,1}}));
        System.out.println(lt.countServers(new int[][]{{1, 0},{1,1}}));
        System.out.println(lt.countServers(new int[][]{{1,1,0,0},{0,0,1,0},{0,0,1,0},{0,0,0,1}}));
    }

    public int countServers(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        int[] lines = new int[height];
        int[] vers = new int[width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                lines[i] += grid[i][j];
                vers[j] += grid[i][j];
            }
        }
        int count = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((lines[i] > 1 || vers[j] > 1 )&& grid[i][j]==1) {
                    count++;
                }
            }
        }
        return count;

    }
}
