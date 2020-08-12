package leetcode;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 * 示例 1:
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 示例 2:
 * 输入: m = 7, n = 3
 * 输出: 28
 * 提示：
 * 1 <= m, n <= 100
 * 题目数据保证答案小于等于 2 * 10 ^ 9
 * 解题思路：迭代方法会造成超时。是因为计算过程中会重复进行多次的计算从而导致问题。
 * 优化方案：可以通过记录已经计算过的路径的和，然后直接从记录的答案中寻找。从而减少重复的处理过程
 * 这里会先从[1,1]位置开始，然后逐个迭代开始计算比[m,n]小的所有数据。
 * 时间复杂度为O(m*n)
 */
class SolutionL62Second {
    public static void main(String[] args) {
        SolutionL62Second lt1078 = new SolutionL62Second();
        System.out.println(lt1078.uniquePaths(100, 50));
    }

    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i]=1;
        }
        for (int i = 0; i <m; i++) {
            dp[i][0]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}