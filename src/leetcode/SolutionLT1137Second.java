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
 * 解题思路：我们可以保存3个数,x,y,z，然后通过循环去每次往后计算
 * 空间复杂度：O（1）
 * 时间复杂度：O (n)
 */
class SolutionLT1137Second {
    public static void main(String[] args) {
        SolutionLT1137Second lt = new SolutionLT1137Second();
        System.out.println(lt.tribonacci(4));//4
        System.out.println(lt.tribonacci(25));//1389537
    }


    public int tribonacci(int n) {
        if (n==0 ){
            return 0;
        }
        if(n==1 ||n==2){
            return 1;
        }
       int x=0;
       int y=1;
       int z=1;
       int res=0;
       int index=3;
       while (index<=n){
           res=x+y+z;
           x=y;
           y=z;
           z=res;
           index++;
       }
       return res;
    }
}