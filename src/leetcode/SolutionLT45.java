package leetcode;

import java.util.Arrays;

/**
 * 45. 跳跃游戏 II
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 *
 * 假设你总是可以到达数组的最后一个位置。
 *
 * 解题思路：贪心算法。我们考虑局部最优。我们反向思考，如果跳转到最后一个位置？如果末几位都能跳转到，那么我们考虑离该位置最远的那个点，
 *                 这样就可以达到最优解
 * 时间复杂度：O（N^2）：
 * 空间复杂度：O（1）
 */
class SolutionLT45 {
    public static void main(String[] args) {
        SolutionLT45 lt = new SolutionLT45();
        System.out.println(lt.jump(new int[]{2,3,1,1,4}));//2
    }

    public int jump(int[] nums) {
        int position=nums.length-1;
        int count=0;
        while (position>0){
            for (int i = 0; i < position; i++) {
                if (i+nums[i]>=position){
                    position=i;
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
