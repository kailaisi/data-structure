package leetcode;

/**
 * 1137. 第 N 个泰波那契数
 * 泰波那契序列 Tn 定义如下：
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 * 示例 1：
 * 输入：n = 4
 * 输出：4
 * 解释：
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * 示例 2：
 * 输入：n = 25
 * 输出：1389537
 * 提示：
 * 0 <= n <= 37
 * 答案保证是一个 32 位整数，即 answer <= 2^31 - 1。
 * 解题思路：典型的迭代算法，通过公式来计算。但是该算法会存在大量的重复计算，导致耗时比较长
 * 空间复杂度：O（1）
 * 时间复杂度：O(n^3)
 */
class SolutionLT1137 {
    public static void main(String[] args) {
        SolutionLT1137 lt = new SolutionLT1137();
        System.out.println(lt.tribonacci(4));
        System.out.println(lt.tribonacci(25));
    }

    public int tribonacci(int n) {
        if (n==0 ){
            return 0;
        }
        if(n==1 ||n==2){
            return 1;
        }
        return tribonacci(n-1)+tribonacci(n-2)+tribonacci(n-3);
    }
}