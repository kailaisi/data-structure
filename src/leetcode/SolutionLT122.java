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
 * 解题思路：暴力法，因为是可以自由交易，不限制次数，所以我们可以选择当天是否交易，然后记录，交易之后手里持有的钱以及当前和是否持有股票。
 * 时间复杂度：O(2^n)
 * 空间复杂度：O(1)
 */
class SolutionLT122 {
    public static void main(String[] args) {
        SolutionLT122 lt = new SolutionLT122();
        System.out.println(lt.maxProfit(new int[]{7,1,5,3,6,4}));//7
        System.out.println(lt.maxProfit(new int[]{1,2,3,4,5}));//4
        System.out.println(lt.maxProfit(new int[]{7,6,4,3,1}));//0
    }


    int sum=0;
    public int maxProfit(int[] prices) {
        int res=0;
        sum=0;
        int len = prices.length;
        if (len<2){
            return 0;
        }
        sdf(prices,len,0,false,res);
        return sum;
    }

    private void sdf(int[] prices, int len, int index, boolean has, int res) {
        if (len==index){
            //当前已经遍历完了，比较当前链路的最终结果
            sum=Math.max(sum,res);
            return;
        }
        //不操作的分支
        sdf(prices,len,index+1,has,res);
        //操作的分支
        if (has){
            sdf(prices,len,index+1,false,res+prices[index]);
        }else{
            sdf(prices,len,index+1,true,res-prices[index]);
        }
    }
}