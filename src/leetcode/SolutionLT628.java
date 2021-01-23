package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: 6
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: 24
 * 注意:
 *
 * 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
 * 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
 *
 * <p>
 * 解题思路：直接使用已有的Arrays函数进行排序
 * 注意：这里存在负数的情况，所以可能存在最大的两个负数*最大的整数才是需要的结果
 * eg:-5,-4,-3,0,1,2。  显然（-5）*（-4）*2才是最大的结果
 *  时间复杂度：O(nlogn),
 *  空间复杂度：O(logn)
 */
class SolutionLT628 {

    public static void main(String[] args) {
        SolutionLT628 lt = new SolutionLT628();
        System.out.println(lt.maximumProduct(new int[]{1, 2,3}));
        System.out.println(lt.maximumProduct(new int[]{1, 2,3,4}));
    }

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        return Math.max(nums[length-1]*nums[length-2]*nums[length-3],nums[0]*nums[1]*nums[length-1]);
    }
}
