package leetcode;

/**
 * 122. 买卖股票的最佳时机 II
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * 示例 2:
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 * 注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 * 因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * 提示：
 * <p>
 * 1 <= prices.length <= 3 * 10 ^ 4
 * 0 <= prices[i] <= 10 ^ 4
 * 解题思路：动态规划。暴力法其实是将所有的情况都表现为一个分支来处理。但是实际情况当第i天的时候，我们只关心前一天可能的最大值。
 *          也就是，如果前一天持有股票，最大值是多少，前一天不持有股票，最大值是多少。
 *          可以使用迭代方式来处理。第一天我们的按照0来处理，第一天可以买入，那么当前的现金就是-price[0]
 * 时间复杂度：O(2^n)
 * 空间复杂度：O(1)
 */
class SolutionLT122Second {
    public static void main(String[] args) {
        SolutionLT122Second lt = new SolutionLT122Second();
        System.out.println(lt.maxProfit(new int[]{7,1,5,3,6,4}));//7
        System.out.println(lt.maxProfit(new int[]{1,2,3,4,5}));//4
        System.out.println(lt.maxProfit(new int[]{7,6,4,3,1}));//0
    }


    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len<2){
            return 0;
        }
        int[][] dp=new int[len][2];
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        for (int i=1;i<len;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return dp[len-1][0];
    }

}