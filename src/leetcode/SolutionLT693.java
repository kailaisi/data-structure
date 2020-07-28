package leetcode;

/**
 * 给定一个正整数，检查他是否为交替位二进制数：换句话说，就是他的二进制数相邻的两个位数永不相等。
 * 示例 1:
 * 输入: 5
 * 输出: True
 * 解释:
 * 5的二进制数是: 101
 * 示例 2:
 * 输入: 7
 * 输出: False
 * 解释:
 * 7的二进制数是: 111
 * 示例 3:
 * 输入: 11
 * 输出: False
 * 解释:
 * 11的二进制数是: 1011
 *  示例 4:
 * 输入: 10
 * 输出: True
 * 解释:
 * 10的二进制数是: 1010
 */
class SolutionLT693 {
    public static void main(String[] args) {
        boolean depth = new SolutionLT693().hasAlternatingBits(10);
        System.out.println(depth);
    }

    public boolean hasAlternatingBits(int n) {
        Boolean b = null;//上一次是否是基数
        while (n != 0) {
            int i = n % 2;
            if (null == b) {
                b = i == 1;
            } else {
                if (b && i == 1) {
                    return false;
                } else if (!b && i == 0) {
                    return false;
                } else {
                    b = i == 1;

                }
            }
            n = n / 2;
        }
        return true;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}