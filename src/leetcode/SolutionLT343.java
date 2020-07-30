package leetcode;

/**
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * 示例 1:
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 * 解题思路：按照3进行拆分。
 */
class SolutionLT343 {
    public static void main(String[] args) {
        int aBreak = new SolutionLT343().integerBreak(11);
        System.out.println(aBreak);
    }

    public int integerBreak(int n) {
        if (n == 3) {
            return 2;
        }
        if(n==2){
            return 1;
        }
        int num = 1;
        while (n > 0) {
            if (n <= 4) {
                num = num * n;
                n = 0;
            } else {
                n = n - 3;
                num = 3 * num;
            }
        }
        return num;
    }
}