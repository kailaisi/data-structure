package leetcode;

/**
 * 55. 跳跃游戏
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 * 示例 1：
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 示例 2：
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 * 提示：
 * 1 <= nums.length <= 3 * 104
 * 0 <= nums[i] <= 105
 * 解题思路：贪心算法。该算法可以基于45题进行处理。我们依然跳转最大的距离。那么，什么时候无法跳到最后呢？也就是下一个最大的跳转距离就是当前位置了
 * 时间复杂度：O（N）：
 * 空间复杂度：O（1）
 */
class SolutionLT55 {
    public static void main(String[] args) {
        SolutionLT55 lt = new SolutionLT55();
        System.out.println(lt.canJump(new int[]{2, 3, 1, 1, 4}));//true
        System.out.println(lt.canJump(new int[]{3, 2, 1, 0, 4}));//false
    }

    public boolean canJump(int[] nums) {
        int maxPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i>maxPos){
                return false;
            }
            maxPos = Math.max(maxPos, nums[i] + i);
        }
        return true;
    }
}
