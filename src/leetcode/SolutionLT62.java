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
 * 解题思路:超时
 * 对于f(m,n),是由f(m-1,n) 和f(m,n-1)两个函数之和
 * 如果其中一个为1了，那么就只有一种选择，
 */
class SolutionLT62 {
    public static void main(String[] args) {
        SolutionLT62 lt1078 = new SolutionLT62();
        System.out.println(lt1078.uniquePaths(100,100));
    }

    public int uniquePaths(int m, int n) {
        if(m==1){
            return 1;
        }
        if(n==1){
            return 1;
        }
        return uniquePaths(m-1,n)+uniquePaths(m,n-1);
    }
}