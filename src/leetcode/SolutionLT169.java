package leetcode;

import java.util.HashMap;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 示例 1:
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 * 思路：通过暴力查找
 */
class SolutionLT169 {

    public static void main(String[] args) {
        SolutionLT169 lt = new SolutionLT169();
        int[] ints = {2,2,1,1,1,2,2};
        System.out.println(lt.majorityElement(ints));
    }

    public int majorityElement(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            int value = map.getOrDefault(num, 0) + 1;
            if (value > length / 2) {
                return num;
            }
            map.put(num, value);
        }
        return 0;
    }
}