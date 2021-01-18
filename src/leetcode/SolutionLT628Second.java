package leetcode;

import java.util.Arrays;

/**
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: 6
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: 24
 * 注意:
 * <p>
 * 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
 * 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
 *
 * <p>
 * 解题思路：无需排队，直接记录最大的3个数字和2个最小的数字即可。
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
class SolutionLT628Second {

    public static void main(String[] args) {
        SolutionLT628Second lt = new SolutionLT628Second();
      //  System.out.println(lt.maximumProduct(new int[]{1, 2, 3}));
      //  System.out.println(lt.maximumProduct(new int[]{1, 2, 3, 4}));
        System.out.println(lt.maximumProduct(new int[]{-5,-4,-3,0,1,2}));
    }

    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int i : nums) {
            if(i>=max1){
                max3=max2;
                max2=max1;
                max1=i;
            }else if(i>=max2){
                max3=max2;
                max2=i;
            }else if (i>max3){
                max3=i;
            }
            if(i<=min1){
                min2=min1;
                min1=i;
            }else if(i<min2){
                min2=i;
            }
        }
        return Math.max(max1*max2*max3,min1*min2*max1);
    }
}
