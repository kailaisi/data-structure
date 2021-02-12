package jianzhi;

/**
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：n = 7
 * 输出：21
 * 示例 3：
 * <p>
 * 输入：n = 0
 * 输出：1
 * 提示：
 * <p>
 * 0 <= n <= 100
 * 解题思路：既然n是100以内的数据，那么我们可以先将这些数据保存起来，然后当获取值的时候，直接返回对应位置的数据即可
 */
public class SolutionJZ10Second {
    public static void main(String[] args) {
        SolutionJZ10Second jz = new SolutionJZ10Second();
        System.out.println(jz.numWays(2));//2
        System.out.println(jz.numWays(7));//21
        System.out.println(jz.numWays(0));//0
        System.out.println(jz.numWays(100));//0
    }

    int[] ints = new int[101];

    public SolutionJZ10Second() {
        for (int i = 0; i <= 100; i++) {
            if (i == 0 || i==1 ) {
                ints[i] = 1;
            }  else {
                ints[i] = (ints[i - 1] + ints[i - 2])%1000000007;
            }
        }
    }

    public int numWays(int n) {
        return ints[n];
    }
}