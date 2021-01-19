package leetcode;

/**
 * 1438  绝对差不超过限制的最长连续子数组
 * 给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
 * 如果不存在满足条件的子数组，则返回 0 。
 *
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
 *
 * 输入：nums = [10,1,2,4,7,2], limit = 5
 * 输出：4
 * 解释：满足题意的最长子数组是 [2,4,7,2]，其最大绝对差 |2-7| = 5 <= 5 。
 * 示例 3：
 *
 * 输入：nums = [4,2,2,2,4,4,2,2], limit = 0
 * 输出：3
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 * 0 <= limit <= 10^9
 *
 * 解题思路：遍历方法，每次i的位置的时候，向后查找满足条件的最长数组。
 * 时间复杂度：O(n^2),
 * 空间复杂度：O(1)
 */
class SolutionLT1438 {

    public static void main(String[] args) {
        SolutionLT1438 lt = new SolutionLT1438();
          System.out.println(lt.longestSubarray(new int[]{8,2,4,7},4));   //2
        System.out.println(lt.longestSubarray(new int[]{10,1,2,4,7,2},5));  //4
        System.out.println(lt.longestSubarray(new int[]{4,2,2,2,4,4,2,2},0));  //3
    }

    public int longestSubarray(int[] nums, int limit) {
        int length = nums.length;
        int max=0;
        for(int i=0;i<length;i++){
            max=Math.max(findMaxLength(nums,i,limit),max);
        }
        return max;
    }

    /**
     * 查找i之后满足条件的数据个数
     */
    private int findMaxLength(int[] nums, int i, int limit) {
        int min=nums[i];
        int max=nums[i];
        for (int j=i;j<nums.length;j++){
            if(nums[j]<min){
                min=nums[j];
            }
            if (nums[j]>max){
                max=nums[j];
            }
            if(max-min>limit){
                return j-i;
            }
        }
        return nums.length-i;
    }
}
