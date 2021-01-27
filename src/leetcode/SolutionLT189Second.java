package leetcode;

import java.util.Arrays;

/**
 * 189. 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 进阶：
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 * 示例 1:
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * <p>
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2 * 104
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 * <p>
 * 解题思路：暴力法优化：在第一步的操作上优化，如果k>len的话，前n*len次操作的话，相当于是没有移动的。所以可以使用k%len来优化。比如我数组长度是10，k给了501。这相当于前500次右旋转数组是没有变化的，只有第501次是有效果的
 * 空间复杂度：O(1)
 * 时间复杂度：O(kn)
 */
class SolutionLT189Second extends GuessGame {

    public static void main(String[] args) {
        SolutionLT189Second lt = new SolutionLT189Second();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        lt.rotate(nums, 3);//
        System.out.println(Arrays.toString(nums));
        nums = new int[]{-1, -100, 3, 99};
        lt.rotate(nums, 2);//
        System.out.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        int length = nums.length;
        int rote=k%length;
        for (int i = 0; i < rote; i++) {
            rotateOne(nums);
        }
    }

    /**
     * 旋转一步
     */
    private void rotateOne(int[] nums) {
        int temp = nums[0];
        int length = nums.length;
        if (length==1){
            return;
        }
        for (int i = length -1; i>=0; i--){
            nums[(i+1)%length]=nums[i];
        }
        nums[1]=temp;
    }
}