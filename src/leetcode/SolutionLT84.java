package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 84. 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 * 解题思路：暴力法。对于每一个位置i，左边的比小的位置x，然后找到右边比他小的数据的位置y，然后height[i]*(j-i-1)
 * 空间复杂度：O(1)
 * 时间复杂度：O(n^2)
 */
class SolutionLT84 {
    public static void main(String[] args) {
        System.out.println(new SolutionLT84().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));//10
        System.out.println(new SolutionLT84().largestRectangleArea(new int[]{2, 4}));//4
    }

    public int largestRectangleArea(int[] heights) {
        int length = heights.length;
        int res = 0;
        for (int i = 0; i < length; i++) {
            int max = i;
            for (int j = i; j < length; j++) {
                if (heights[j] < heights[i]) {
                    break;
                }
                max = j;
            }
            int min = i;
            for (int j = i; j >= 0; j--) {
                if (heights[j] < heights[i]) {
                    break;
                }
                min = j;
            }
            res = Math.max(res, heights[i] * (max - min + 1));
        }
        return res;
    }
}