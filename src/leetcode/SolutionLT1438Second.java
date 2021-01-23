package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1438  绝对差不超过限制的最长连续子数组
 * 给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
 * 如果不存在满足条件的子数组，则返回 0 。
 * <p>
 * 示例 1：
 * 输入：nums = [8,2,4,7], limit = 4
 * 输出：2
 * 解释：所有子数组如下：
 * [8] 最大绝对差 |8-8| = 0 <= 4.
 * [8,2] 最大绝对差 |8-2| = 6 > 4.
 * [8,2,4] 最大绝对差 |8-2| = 6 > 4.
 * [8,2,4,7] 最大绝对差 |8-2| = 6 > 4.
 * [2] 最大绝对差 |2-2| = 0 <= 4.
 * [2,4] 最大绝对差 |2-4| = 2 <= 4.
 * [2,4,7] 最大绝对差 |2-7| = 5 > 4.
 * [4] 最大绝对差 |4-4| = 0 <= 4.
 * [4,7] 最大绝对差 |4-7| = 3 <= 4.
 * [7] 最大绝对差 |7-7| = 0 <= 4.
 * 因此，满足题意的最长子数组的长度为 2 。
 * 示例 2：
 * <p>
 * 输入：nums = [10,1,2,4,7,2], limit = 5
 * 输出：4
 * 解释：满足题意的最长子数组是 [2,4,7,2]，其最大绝对差 |2-7| = 5 <= 5 。
 * 示例 3：
 * <p>
 * 输入：nums = [4,2,2,2,4,4,2,2], limit = 0
 * 输出：3
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 * 0 <= limit <= 10^9
 * <p>
 * 解题思路：滑动窗口法。由于获取的是最大的满足条件的子序列，所以如果找到了满足长度为i，那么就可以保持窗口长度为i,然后向右滑动1个单位，检测i+1个长度是否满足。一直到最后。
 * 这里有个难点就是要记录窗口长度为i的最大最小值。
 * 可以使用两个有序的队列。一个队列使用最大值队列，一个是最小值队列
 * 窗口滑动的时候，从队列中移除左边的，然后增加右边的，看队列的最大最小值是否满足需求
 * 时间复杂度：O(n^2),
 * 空间复杂度：O(1)
 */
class SolutionLT1438Second {

    public static void main(String[] args) {
        SolutionLT1438Second lt = new SolutionLT1438Second();
        System.out.println(lt.longestSubarray(new int[]{8, 2, 4, 7}, 4));
        System.out.println(lt.longestSubarray(new int[]{10, 1, 2, 4, 7, 2}, 5));
        System.out.println(lt.longestSubarray(new int[]{4, 2, 2, 2, 4, 4, 2, 2}, 0));
    }

    public int longestSubarray(int[] nums, int limit) {
        int start=0;
        int end=1;
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        min.add(nums[0]);
        max.add(nums[0]);
        while (end<nums.length){
            min.add(nums[end]);
            max.add(nums[end]);
            if ((max.peek()-min.peek())>limit) {//超限制了，那么将start位置的移除
                min.remove(nums[start]);
                max.remove(nums[start]);
                start++;
                end++;
            }else{//满足条件，窗口向右扩大一个
                end++;
            }
        }
        return end-start;
    }

}
