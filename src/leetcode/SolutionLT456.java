package leetcode;


import java.util.Stack;

/**
 * 456. 132 模式
 * 给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j] 。
 * 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。
 * 示例 1：
 * 输入：nums = [1,2,3,4]
 * 输出：false
 * 解释：序列中不存在 132 模式的子序列。
 * 示例 2：
 * 输入：nums = [3,1,4,2]
 * 输出：true
 * 解释：序列中有 1 个 132 模式的子序列： [1, 4, 2] 。
 * 示例 3：
 * 输入：nums = [-1,3,2,0]
 * 输出：true
 * 解释：序列中有 3 个 132 模式的的子序列：[-1, 3, 2]、[-1, 3, 0] 和 [-1, 2, 0] 。
 * 提示：
 * n == nums.length
 * 1 <= n <= 2 * 105
 * -109 <= nums[i] <= 109
 * 解题思路：对于该题，其实找的是一个驼峰。这里我们可以从前往后，使用单调栈，
 *          这里保存的是单调递减栈信息。
 *          那么一旦发现单调栈序列，那么弹出的j，k则是可以考虑的信息，这时候就可以遍历i了
 * 时间复杂度：O（N）：
 * 空间复杂度：O（1）
 */
class SolutionLT456 {
    public static void main(String[] args) {
        SolutionLT456 lt = new SolutionLT456();
        System.out.println(lt.find132pattern(new int[]{1, 2, 3, 4}));//false
        System.out.println(lt.find132pattern(new int[]{3, 1, 4, 2}));//true
        System.out.println(lt.find132pattern(new int[]{-1, 3, 2, 0}));//true
    }

    public boolean find132pattern(int[] nums) {
        int length = nums.length;
        if (nums.length<3){
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        //k保存的是上次记录的最大的那个右侧的数据
        int k=-1;
        for (int i = length-1; i >=0 ; i--) {
            if (k>-1 && nums[k]>nums[i]){
                return true;
            }
            while(!stack.isEmpty()&& nums[stack.peek()]<nums[i]){
                k=stack.pop();
            }
            stack.push(i);
        }
        return false;
    }
}
