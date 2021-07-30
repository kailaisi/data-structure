package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 239. 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * 示例 2：
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * <p>
 * 示例 3：
 * 输入：nums = [1,-1], k = 1
 * 输出：[1,-1]
 * 示例 4：
 * <p>
 * 输入：nums = [9,11], k = 2
 * 输出：[11]
 * 示例 5：
 * <p>
 * 输入：nums = [4,-2], k = 2
 * 输出：[4]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 * 解题思路：典型的滑动窗口案例，这里给了指定了窗口大小，
 * 所以我们现在需要考虑的是如何保存我们的数据，从而能够知道我们数组中的最大值。
 * 空间复杂度：O(n)，需要有个set来保存数据
 * 时间复杂度：O(n)，需要一次遍历
 */
class SolutionLT239 extends GuessGame {

    public static void main(String[] args) {
        SolutionLT239 lt = new SolutionLT239();
        System.out.println(Arrays.toString(lt.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));//[3,3,5,5,6,7]
        System.out.println(Arrays.toString(lt.maxSlidingWindow(new int[]{1}, 1)));//[1]
        System.out.println(Arrays.toString(lt.maxSlidingWindow(new int[]{1, -1}, 1)));//[1,-1]
        System.out.println(Arrays.toString(lt.maxSlidingWindow(new int[]{9, 11}, 2)));//[11]
        System.out.println(Arrays.toString(lt.maxSlidingWindow(new int[]{4, -2}, 2)));//[4]
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
            if (i >= k) {
                list.add(queue.peek());
                queue.remove(i - k);
            }
        }
        int[] ints = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ints[i] = list.get(i);
        }
        return ints;
    }
}