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
 * 解题思路：交替二进制，那么右移一位之后，进行与操作，肯定=0
 */
class SolutionLT693Second {
    public static void main(String[] args) {
        boolean depth = new SolutionLT693Second().hasAlternatingBits(4);
        System.out.println(depth);
    }

    public boolean hasAlternatingBits(int n) {
        int num = (n ^ (n >> 1)) + 1;//错位异或全是1。+1之后，末尾全是0，
        return (num & (num - 1)) == 0;//全是1的和末尾全是0的进行与操作。就是0
    }

}