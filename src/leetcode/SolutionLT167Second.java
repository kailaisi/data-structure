package leetcode;

/**
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * 说明:
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 *
 * 解题思路：因为是有序的。所以我们可以使用夹逼定理来进行处理
 * 如果首末两个数的和比目标大，那么就末尾左移，使和减小
 * 如果首末两个数的和比目标小，那么就首位右移，使和增大
 * 直到找到目标数为止
 */
class SolutionLT167Second {
    public static void main(String[] args) {
        SolutionLT167Second lt167 = new SolutionLT167Second();
        int[] numbers = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] ints = lt167.twoSum(numbers, target);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            if (numbers[start] + numbers[end] == target) {
                return new int[]{start + 1, end + 1};
            }
            if (numbers[start] + numbers[end] > target) {
                end--;
            } else if (numbers[start] + numbers[end] < target) {
                start++;
            }
        }
        return new int[]{};
    }
}