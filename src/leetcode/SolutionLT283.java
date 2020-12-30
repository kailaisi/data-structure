package leetcode;

import java.util.Arrays;

/**
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 思路：先将所有非0的左移到前边，然后将剩下的位置都清零。
 */
class SolutionLT283 {
    public static void main(String[] args) {
        SolutionLT283 lt = new SolutionLT283();
        int[] nums = {0,1,0,3,12};
        lt.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        int slow=0;
        int fast=0;
        while (fast<length){
            if (nums[fast]!=0){
                nums[slow]=nums[fast];
                slow++;
            }
            fast++;
        }
        while (slow<length){
            nums[slow++]=0;
        }
    }
}

