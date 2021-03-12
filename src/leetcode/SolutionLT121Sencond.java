package leetcode;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * 注意：你不能在买入股票前卖出股票。
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *  解题思路：动态规划方法
 *  *  时间复杂度：O(n^2)
 *  *  空间复杂度：O(1)
 *
 */
class SolutionLT121Sencond {
    public static void main(String[] args) {
        SolutionLT121Sencond lt1078 = new SolutionLT121Sencond();
        System.out.println(lt1078.maxProfit(new int[]{7,6,4,3,1}));
    }

    public int maxProfit(int[] prices) {
        //记录最小值
        int minPrice = Integer.MAX_VALUE;
        //记录当前获取到的最大的差额
        int maxResult = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            int b = prices[i] - minPrice;//这里i的位置肯定比minprice的位置要靠右，
            //比如说[7,3,5,1,6,4]。那么当迭代到1之前，会记录maxResult是5-3的值，也就是2。
            //当迭代到1的时候，会记录1，然后继续遍历，6-1=5，会比之前的2大，所以maxResult这时候就修改为了5.
            maxResult = Math.max(maxResult, b);
        }
        return maxResult;
    }
}