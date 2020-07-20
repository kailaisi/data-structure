package leetcode;

import java.util.HashMap;

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
 * 解题思路：使用Hashmap来保存。key是和目标的差值，value是当前位置值
 * 当进行遍历的时候，查找key是否存在，如果存在的话，证明之前有数字是和key相加的 和是target的
 */
class SolutionLT167 {
    public static void main(String[] args) {
        SolutionLT167 lt167 = new SolutionLT167();
        int[] numbers = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] ints = lt167.twoSum(numbers, target);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            if (map.get(number) != null) {
                return new int[]{map.get(number) + 1, i + 1};
            }
            map.put(target - number, i);
        }
        return new int[]{};
    }
}