package leetcode;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * 输入: [1,3,5,6], 0
 * 输出: 0
 */
class SolutionLT35 {
//todo 未完成
    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 5, 6};
        int i = new SolutionLT35().searchInsert(a, 3);
        System.out.println(i);
    }

    public int searchInsert(int[] nums, int target) {
        int i = 0, j = nums.length-1, mid = 0;
        while (i < j) {
            mid = (i + j) / 2 + 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return mid;
    }
}