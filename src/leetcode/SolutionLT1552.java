package leetcode;

import java.util.Arrays;

/**
 * 1552. 两球之间的磁力
 * 在代号为 C-137 的地球上，Rick 发现如果他将两个球放在他新发明的篮子里，它们之间会形成特殊形式的磁力。Rick 有 n 个空的篮子，第 i 个篮子的位置在 position[i] ，Morty 想把 m 个球放到这些篮子里，使得任意两球间 最小磁力 最大。
 * 已知两个球如果分别位于 x 和 y ，那么它们之间的磁力为 |x - y| 。
 * 给你一个整数数组 position 和一个整数 m ，请你返回最大化的最小磁力。
 * <p>
 * 示例 1：
 * 输入：position = [1,2,3,4,7], m = 3
 * 输出：3
 * 解释：将 3 个球分别放入位于 1，4 和 7 的三个篮子，两球间的磁力分别为 [3, 3, 6]。最小磁力为 3 。我们没办法让最小磁力大于 3 。
 * <p>
 * 示例 2：
 * 输入：position = [5,4,3,2,1,1000000000], m = 2
 * 输出：999999999
 * 解释：我们使用位于 1 和 1000000000 的篮子时最小磁力最大。
 * 提示：
 * n == position.length
 * 2 <= n <= 10^5
 * 1 <= position[i] <= 10^9
 * 所有 position 中的整数 互不相同 。
 * 2 <= m <= position.length
 * 解题思路：假设我们返回的结果是res，那么肯定对于任何小于res的结果都是可以满足条件的。而大于res的结果都是不可行的。
 * 所以我们可以通过二分查找法来获取对应的符合条件的最大值。
 * 另一个需要处理的就是如何判断我们给定的x值是否满足条件。
 * 由贪心算法我们可以知道，第一个位置position[0]放小球，肯定是最好的。而第二个位置至少大于等于position[0]+x。我们可以从前往后扫描数组，看在当前的x
 * 下，我们的篮子最多放多少个小球，并记录数量cnt，如果cnt>=m，则满足条件，视为合法的答案。
 * 对于二分法，我们这里采用的是标准的left+1<right。那么循环方式就是 left=mid,right=mid;
 * 空间复杂度：O(1)
 * 时间复杂度：O(logn)
 */
class SolutionLT1552 extends GuessGame {

    public static void main(String[] args) {
        SolutionLT1552 lt = new SolutionLT1552();
        System.out.println(lt.maxDistance(new int[]{1,2,3,4,7},3));//3
        System.out.println(lt.maxDistance(new int[]{5,4,3,2,1,1000000000},2));//99999999
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int len = position.length;
        int left = 1;
        int right = position[len - 1]-position[0];
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (count(position, mid, m)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (count(position, right, m)) {
            return right;
        } else {
            return left;
        }
    }

    /**
     * 确定数组中的位置间距是mid的时候，能否放下m个小球
     */
    private boolean count(int[] position, int mid, int m) {
        int cnt = 1;
        int last = 0;
        for (int i = 1; i < position.length; i++) {
            if (position[i] - position[last] >= mid) {
                last = i;
                cnt++;
                if (cnt >= m) {
                    return true;
                }
            }
        }
        return cnt >= m;
    }
}