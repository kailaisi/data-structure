package leetcode;

/**
 * 1518. 换酒问题
 * 小区便利店正在促销，用 numExchange 个空酒瓶可以兑换一瓶新酒。你购入了 numBottles 瓶酒。
 * 如果喝掉了酒瓶中的酒，那么酒瓶就会变成空的。
 * 请你计算 最多 能喝到多少瓶酒。
 * <p>
 * 示例 1：
 * 输入：numBottles = 9, numExchange = 3
 * 输出：13
 * 解释：你可以用 3 个空酒瓶兑换 1 瓶酒。
 * 所以最多能喝到 9 + 3 + 1 = 13 瓶酒。
 * <p>
 * 示例 2：
 * 输入：numBottles = 15, numExchange = 4
 * 输出：19
 * 解释：你可以用 4 个空酒瓶兑换 1 瓶酒。
 * 所以最多能喝到 15 + 3 + 1 = 19 瓶酒。
 * <p>
 * 示例 3：
 * 输入：numBottles = 5, numExchange = 5
 * 输出：6
 * <p>
 * 示例 4：
 * 输入：numBottles = 2, numExchange = 3
 * 输出：2
 * 提示：
 * 1 <= numBottles <= 100
 * 2 <= numExchange <= 100
 * 解题思路：数学解法：我们打个比方：3个空瓶，兑换一瓶酒，然后可以产生一个空瓶。所以酒水=2个空瓶。如果我原来有20瓶酒，那么相当于总共拥有  20*2+20个空瓶子的量，也就是60个，最后是30份酒水。但是最后肯定是有一个空瓶子是兑换不了的。所以预留出来1个空瓶子。
 *
 * 时间复杂度：O(b/e)  需要循环的次数是：本身个数/兑换数
 * 空间复杂度：O(1)
 */
class SolutionLT1518Second {
    public static void main(String[] args) {
        SolutionLT1518Second lt = new SolutionLT1518Second();
        System.out.println(lt.numWaterBottles(9, 3));//13
        System.out.println(lt.numWaterBottles(5, 5));//6
        System.out.println(lt.numWaterBottles(2, 3));//2               2+2*2
    }


    public int numWaterBottles(int numBottles, int numExchange) {
        return (numBottles*numExchange-1)/(numExchange-1);
    }
}