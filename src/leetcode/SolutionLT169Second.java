package leetcode;

import java.util.Arrays;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 示例 1:
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 * 思路：由于次数超过一半，所以我们进行排序，那么中间的位置肯定就是我们的数据
 */
class SolutionLT169Second {

    public static void main(String[] args) {
        SolutionLT169Second lt = new SolutionLT169Second();
        int[] ints = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(lt.majorityElement(ints));
    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}