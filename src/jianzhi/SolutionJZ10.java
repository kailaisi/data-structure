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
 * 解题思路：对于n个台阶的，我们可以知道，第一个可以走1个或者走2个，这时候剩下的步数就是f(n-1)和f(n-2)。我们可以使用迭代的方式来获取结果
 *
 */
public class SolutionJZ10 {
    public static void main(String[] args) {
        SolutionJZ10 jz = new SolutionJZ10();
        System.out.println(jz.numWays(2));//2
        System.out.println(jz.numWays(7));//21
        System.out.println(jz.numWays(0));//0
        System.out.println(jz.numWays(100));//0
    }

    public int numWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        return (numWays(n-2)%1000000007)+(numWays(n-1)%1000000007);
    }
}