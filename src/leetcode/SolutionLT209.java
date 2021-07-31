package leetcode;


/**
 * 209. 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * 示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 * 提示：
 * 1 <= target <= 10^9
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^5
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
 * 解题思路：典型的滑动窗口案例，非固定长度的窗口，所以使用模板即可
 * 时间复杂度：O（N）：1次遍历。
 * 空间复杂度：O（N）：需要使用我们的集合来保存输入的数据
 */
class SolutionLT209 {
    public static void main(String[] args) {
        SolutionLT209 lt = new SolutionLT209();
        System.out.println(lt.minSubArrayLen(7,new int[]{2,3,1,2,4,3}));//2
        System.out.println(lt.minSubArrayLen(4,new int[]{1,4,4}));//1
        System.out.println(lt.minSubArrayLen(11,new int[]{1,1,1,1,1,1,1,1}));//0
    }

    public int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int right = 0;
        int res = 0;
        int len = Integer.MAX_VALUE;
        int length = nums.length;
        while (right < length) {
            res += nums[right];
            right++;
            while (res >= s) {
                len=Math.min(len,right-left);
                res -= nums[left];
                left++;
            }
        }
        if (len== Integer.MAX_VALUE){
            len=0;
        }
        return len;
    }
}
