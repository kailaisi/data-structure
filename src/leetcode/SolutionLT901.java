package leetcode;


import java.util.ArrayList;
import java.util.Stack;

/**
 * 901. 股票价格跨度
 * 编写一个 StockSpanner 类，它收集某些股票的每日报价，并返回该股票当日价格的跨度。
 * 今天股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
 * 例如，如果未来7天股票的价格是 [100, 80, 60, 70, 60, 75, 85]，那么股票跨度将是 [1, 1, 1, 2, 1, 4, 6]。
 * 示例：
 * 输入：["StockSpanner","next","next","next","next","next","next","next"], [[],[100],[80],[60],[70],[60],[75],[85]]
 * 输出：[null,1,1,1,2,1,4,6]
 * 解释：
 * 首先，初始化 S = StockSpanner()，然后：
 * S.next(100) 被调用并返回 1，
 * S.next(80) 被调用并返回 1，
 * S.next(60) 被调用并返回 1，
 * S.next(70) 被调用并返回 2，
 * S.next(60) 被调用并返回 1，
 * S.next(75) 被调用并返回 4，
 * S.next(85) 被调用并返回 6。
 * 注意 (例如) S.next(75) 返回 4，因为截至今天的最后 4 个价格
 * (包括今天的价格 75) 小于或等于今天的价格。
 * 提示：
 * 调用 StockSpanner.next(int price) 时，将有 1 <= price <= 10^5。
 * 每个测试用例最多可以调用  10000 次 StockSpanner.next。
 * 在所有测试用例中，最多调用 150000 次 StockSpanner.next。
 * 此问题的总时间限制减少了 50%。
 * 解题思路：对于每一个输入的信息，其实就是找对于左边的数据，比他小的数据的数量。我们可以采用集合来保存我们的数据。但是这里我们需要注意的是，由于需要频繁的操作集合，所以还是使用链表的方式比较合适。
 * 时间复杂度：O（N）：每次都要进行一次遍历。
 * 空间复杂度：O（N）：需要使用我们的集合来保存输入的数据
 */
class SolutionLT901 {
    public static void main(String[] args) {
        StockSpanner spanner = new StockSpanner();
        System.out.println(spanner.next(100));
        System.out.println(spanner.next(80));
        System.out.println(spanner.next(60));
        System.out.println(spanner.next(70));
        System.out.println(spanner.next(60));
        System.out.println(spanner.next(75));
        System.out.println(spanner.next(85));
    }

    public static class StockSpanner {
        ArrayList<Integer> stack = new ArrayList<>();
        public int next(int price) {
            stack.add(price);
            for (int i = stack.size() - 2; i >= 0; i--) {
                if (stack.get(i) > price) {
                    return stack.size()-1 - i;
                }
            }
            return stack.size();
        }
    }

}
