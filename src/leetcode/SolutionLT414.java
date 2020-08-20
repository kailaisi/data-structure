package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3, 2, 1]
 * <p>
 * 输出: 1
 * <p>
 * 解释: 第三大的数是 1.
 * 示例 2:
 * <p>
 * 输入: [1, 2]
 * <p>
 * 输出: 2
 * <p>
 * 解释: 第三大的数不存在, 所以返回最大的数 2 .
 * 示例 3:
 * <p>
 * 输入: [2, 2, 3, 1]
 * <p>
 * 输出: 1
 * <p>
 * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
 * 存在两个值为2的数，它们都排第二。
 */
class SolutionLT414 {

    public static void main(String[] args) {
        SolutionLT414 lt = new SolutionLT414();
        int i = lt.thirdMax(new int[]{2, 2, 3, 1});
        System.out.println(i);
    }

    public int thirdMax(int[] nums) {
        Integer one = nums[0];
        Integer two = nums[0];
        Integer three =nums[0];
        for (int num : nums) {
            if (num == one || num == two || num == three) {
                continue;
            }
            if(num>one){
                three=two;
                two=one;
                one=num;
            }else if(num>two){
                three=two;
                two=num;
            }else if(num>three){
                three=num;
            }
        }
        if (three==null){
            return (int) one;
        }
        return (int) three;
    }
}