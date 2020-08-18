package leetcode;

/**
 * 给你两个整数，n 和 start 。
 * 数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。
 * 请返回 nums 中所有元素按位异或（XOR）后得到的结果。
 * 示例 1：
 * 输入：n = 5, start = 0
 * 输出：8
 * 解释：数组 nums 为 [0, 2, 4, 6, 8]，其中 (0 ^ 2 ^ 4 ^ 6 ^ 8) = 8 。
 * "^" 为按位异或 XOR 运算符。
 * 示例 2：
 * 输入：n = 4, start = 3
 * 输出：8
 * 解释：数组 nums 为 [3, 5, 7, 9]，其中 (3 ^ 5 ^ 7 ^ 9) = 8.
 * 示例 3：
 * 输入：n = 1, start = 7
 * 输出：7
 * 示例 4：
 * <p>
 * 输入：n = 10, start = 5
 * 输出：2
 * 提示：
 * 1 <= n <= 1000
 * 0 <= start <= 1000
 * n == nums.length
 */
class SolutionLT1252 {

    public static void main(String[] args) {
        SolutionLT1252 lt = new SolutionLT1252();
        int[][] ints = {{0, 1}, {1, 1}};
        System.out.println(lt.oddCells(10, 5,ints));
    }

    public int oddCells(int n, int m, int[][] indices) {
        // TODO: 2020/8/18 未完，有错误
        int[][] ints = new int[n][m];
        int count = 0;
        for (int[] index : indices) {
            int i = ints[index[0]][index[1]];
            if (i % 2 == 0) {
                count++;
            } else {
                count--;
            }
            ints[index[0]][index[1]]++;
        }
        return count;
    }
}