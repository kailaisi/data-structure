package leetcode;

/**
 * 猜数字游戏的规则如下：
 * <p>
 * 每轮游戏，我都会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。
 * 如果你猜错了，我会告诉你，你猜测的数字比我选出的数字是大了还是小了。
 * 你可以通过调用一个预先定义好的接口 int guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1 或 0）：
 * <p>
 * -1：我选出的数字比你猜的数字小 pick < num
 * 1：我选出的数字比你猜的数字大 pick > num
 * 0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 10, pick = 6
 * 输出：6
 * 示例 2：
 * <p>
 * 输入：n = 1, pick = 1
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：n = 2, pick = 1
 * 输出：1
 * 示例 4：
 * <p>
 * 输入：n = 2, pick = 2
 * 输出：2
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 231 - 1
 * 1 <= pick <= n
 * 解题思路：暴力查找
 */
class SolutionLT374 extends GuessGame {

    public static void main(String[] args) {
        SolutionLT374 lt = new SolutionLT374();
    }

    public int guessNumber(int n) {
        for(int i=0;i<=n;i++){
            if (guess(i)==0){
                return i;
            }
        }
        return -1;
    }
}
