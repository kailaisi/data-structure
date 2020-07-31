package leetcode;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * 解题思路：动态规划
 * 每次都取之前的子序的最大和，如果<0的话，就抛弃
 */
class SolutionLT53 {
    public static void main(String[] args) {
        SolutionLT53 lt53 = new SolutionLT53();
        int[] ints = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(lt53.maxSubArray(ints));
    }

    public int maxSubArray(int[] nums) {
        int result;
        int length = nums.length;
        result = nums[0];
        //保存到i为止的最大子序的和
        int[] ints = new int[length];
        for (int i = 1; i < length; i++) {
            //获取以i结尾的最大子序的和。如果int[i-1]<0的话，这步能够将之前的<0的子序列重新计算和。因为它+i<i。
            ints[i] = Math.max(ints[i - 1] + nums[i], nums[i]);
            //i和之前的result取最大值
            result = Math.max(result, ints[i]);
        }
        return 0;
    }
}