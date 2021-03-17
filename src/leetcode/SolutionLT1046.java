package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1217. 玩筹码
 * 数轴上放置了一些筹码，每个筹码的位置存在数组 chips 当中。
 *
 * 你可以对 任何筹码 执行下面两种操作之一（不限操作次数，0 次也可以）：
 *
 * 将第 i 个筹码向左或者右移动 2 个单位，代价为 0。
 * 将第 i 个筹码向左或者右移动 1 个单位，代价为 1。
 * 最开始的时候，同一位置上也可能放着两个或者更多的筹码。
 * 返回将所有筹码移动到同一位置（任意位置）上所需要的最小代价。
 * 示例 1：
 * 输入：chips = [1,2,3]
 * 输出：1
 * 解释：第二个筹码移动到位置三的代价是 1，第一个筹码移动到位置三的代价是 0，总代价为 1。
 * 示例 2：
 * 输入：chips = [2,2,2,3,3]
 * 输出：2
 * 解释：第四和第五个筹码移动到位置二的代价都是 1，所以最小总代价为 2。
 * 提示：
 *
 * 1 <= chips.length <= 100
 * 1 <= chips[i] <= 10^9
 * 解题思路：贪心算法。因为向左向右移动2个单位代价是0，移动一个单位代价是1，所以奇数位置到奇数位置代价为0，偶到偶代价为0，只有奇到偶，或者偶到奇，才会需要代价。而且代价为1，所以只需要考虑奇数偶数个数即可。
 *                              如果奇数少，就 移动奇数位，如果偶数少就移动偶数位，而且相应代价为其对应的个数。
 * 时间复杂度：O(nlogn)  每次取出石头都需要logn级别的时间，而最多需要粉碎n次
 * 空间复杂度：O(n)
 */
class SolutionLT1046 {
    public static void main(String[] args) {
        SolutionLT1046 lt = new SolutionLT1046();
        System.out.println(lt.minCostToMoveChips(new int[]{1,2,3}));//1
        System.out.println(lt.minCostToMoveChips(new int[]{2,2,2,3,3}));//2
        System.out.println(lt.minCostToMoveChips(new int[]{1,2,2,2,2}));//1
    }


    public int minCostToMoveChips(int[] position) {
        int length = position.length;
        int odd=0;
        int ans=0;
        for (int i=0;i<length;i++){
            if (position[i]%2==0){
                odd++;
            }else{
                ans++;
            }
        }
        return Math.min(odd,ans);
    }
}