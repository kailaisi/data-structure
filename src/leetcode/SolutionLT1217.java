package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1046. 最后一块石头的重量
 * 有一堆石头，每块石头的重量都是正整数。
 * 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 * 示例：
 * 输入：[2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 先选出 7 和 8，得到 1，所以数组转换为 [2,4,1,1,1]，
 * 再选出 2 和 4，得到 2，所以数组转换为 [2,1,1,1]，
 * 接着是 2 和 1，得到 1，所以数组转换为 [1,1,1]，
 * 最后选出 1 和 1，得到 0，最终数组转换为 [1]，这就是最后剩下那块石头的重量。
 * 提示：
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 1000
 * 解题思路：双指针（贪心算法）。每次都取出最大的两个石头，然后粉碎。
 * 我们每次粉碎都进行排序，然后取最大的两个，粉碎，再排序。可以考虑使用PrioryQueue来进行数据的保存。
 * 时间复杂度：O(nlogn)  每次取出石头都需要logn级别的时间，而最多需要粉碎n次
 * 空间复杂度：O(n)
 */
class SolutionLT1217 {
    public static void main(String[] args) {
        SolutionLT1217 lt = new SolutionLT1217();
        System.out.println(lt.lastStoneWeight(new int[]{2,7,4,1,8,1}));//1
    }


    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i : stones) {
            queue.add(i);
        }
        while (queue.size() >= 2) {
            Integer first = queue.poll();
            Integer second = queue.poll();
            if (first > second) {
                queue.add(first - second);
            }
        }
        if (queue.size() > 0) {
            return queue.poll();
        } else {
            return 0;
        }
    }
}