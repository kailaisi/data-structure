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
 * 解题思路：贪心算法。我们考虑局部最优。我们反向思考，如果跳转到最后一个位置？如果末几位都能跳转到，那么我们考虑离该位置最远的那个点，
 * 这样就可以达到最优解
 * 时间复杂度：O（N^2）：
 * 空间复杂度：O（1）
 */
class SolutionLT55 {
    public static void main(String[] args) {
        SolutionLT55 lt = new SolutionLT55();
        System.out.println(lt.jump(new int[]{2, 3, 1, 1, 4}));//2
    }

    public int jump(int[] nums) {
        int end = 0;
        int maxPos = 0;
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPos = Math.max(maxPos, nums[i] + i);
            if (i == end) {//跳转到了边界位置了
                end = maxPos;//更新边界
                count++;//跳一次
            }
        }
        return count;
    }
}
