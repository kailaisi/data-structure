package leetcode;

import java.util.Arrays;

/**
 * 215. 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 * <p>
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 * 解题思路：这个是个排序的问题，可以看本项目的sort目录，是所有排序算法的实现
 * 这里要找到的是第k个最大的元素。我们可以尝试将数组排序，然后去查找，对于数组的排序，可以使用Arrays的方法的排序
 * 时间复杂度：O(logn)
 * 空间复杂度：O(1)
 */
class SolutionLT215 {
    public static void main(String[] args) {
        SolutionLT215 lt = new SolutionLT215();
        System.out.println(lt.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));//5
        System.out.println(lt.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));//4
    }

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}