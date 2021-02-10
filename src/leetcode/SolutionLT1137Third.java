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
 * 解题思路：如果每次都计算，肯定很麻烦，而我们知道这里的n值是0到37。所以我们可以用一个数组来存，然后每次查的时候都直接返回数组的固定值即可
 * 空间复杂度：O（1）
 * 时间复杂度：O (1)
 */
class SolutionLT1137Third {
    public static void main(String[] args) {
        SolutionLT1137Third lt = new SolutionLT1137Third();
        System.out.println(lt.tribonacci(4));//4
        System.out.println(lt.tribonacci(25));//1389537
        System.out.println(lt.tribonacci(37));//1389537
    }

    int[] res=new int[38];

    public SolutionLT1137Third() {
        res[0]=0;res[1]=1;res[2]=1;
        for (int i = 3; i <= 37; i++) {
            res[i]=res[i-1]+res[i-2]+res[i-3];
        }
    }

    public int tribonacci(int n) {
       return res[n];
    }
}