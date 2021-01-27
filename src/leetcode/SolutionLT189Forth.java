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
 * 解题思路：旋转会发生数据的覆盖，我们之前的方法都是一次只旋转一步，那么只有一个临时的值保存就可以了。
 * 如果我们现在是k个，我们需要将前k个临时值保存，然后再将后面的开始复制到k+1->len的长度即可
 * <p>
 * 空间复杂度：O(1)。只需要常量个数据来存储即可。常量为 k % length
 * 时间复杂度：O(n)
 */
class SolutionLT189Forth extends GuessGame {

    public static void main(String[] args) {
        SolutionLT189Forth lt = new SolutionLT189Forth();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
      //  lt.rotate(nums, 3);//
        System.out.println(Arrays.toString(nums));
        nums = new int[]{-1, -100, 3, 99};
       // lt.rotate(nums, 2);//
        System.out.println(Arrays.toString(nums));
        nums = new int[]{1,2,3};
        lt.rotate(nums, 2);//
        System.out.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        int length = nums.length;
        int copyLen = k % length;
        if (copyLen == 0) {
            return;
        }
        int[] copy = Arrays.copyOf(nums, copyLen);
        for (int i = length-1; i >=0; i--) {
            nums[(i + copyLen) % length] = nums[i];//i+k的位置保存的是原来的i的数值
        }
        //这时候，0-copyLen位置的数据，向后移动了k一部分位置。
        for (int i=0;i<copyLen;i++){
            nums[(i+copyLen)%length]=copy[i];
        }
    }
}