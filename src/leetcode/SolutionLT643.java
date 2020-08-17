package leetcode;

import java.util.Arrays;

/**
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 * 示例 1:
 * 输入: [1,12,-5,-6,50,3], k = 4
 * 输出: 12.75
 * 解释: 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 * 注意:
 * 1 <= k <= n <= 30,000。
 * 所给数据范围 [-10,000，10,000]。
 * 解题思路：遍历，每个位置都修改为左边的数组的和。
 * <p>
 * 然后再次迭代，计算对应的k间距的差值，求平均值
 */
public class SolutionLT643 {
    public static void main(String[] args) {
        SolutionLT643 lt = new SolutionLT643();
        int[] ints = {1,12,-5,-6,50,3};
        System.out.println(lt.findMaxAverage(ints, 4));
    }

    public double findMaxAverage(int[] nums, int k) {
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            //遍历，将数组i的位置，变为左侧所有的数据之和
            nums[i] = nums[i - 1] + nums[i];
        }
        //第k-1个位置的数据是，前k个数据之和
        int max = nums[k-1];
        //遍历求最大差值
        for (int i = 0; i < length - k; i++) {
            max = Math.max(max, nums[k + i] - nums[i]);
        }
        return (double) max / k;
    }
}
