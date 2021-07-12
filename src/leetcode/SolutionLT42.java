package leetcode;

import java.util.Stack;

/**
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 * <p>
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == height.length
 * 0 <= n <= 3 * 104
 * 0 <= height[i] <= 105
 * 解题思路：暴力法。首先我们将问题进行拆分一下
 * 对于某个位置i，存水量如何最大？是左边最高值，右边最高值的两个数字的最小值，和它自己的高度之差。
 * 空间复杂度：O(1)
 * 时间复杂度：O(n^2)
 */
class SolutionLT42 {
    public static void main(String[] args) {
        System.out.println(new SolutionLT42().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));//6
        System.out.println(new SolutionLT42().trap(new int[]{4, 2, 0, 3, 2, 5}));//9
    }

    public int trap(int[] heights) {
        int sum = 0;
        int length = heights.length;
        for (int i = 0; i < length; i++) {
            //右侧最高的墙
            int right_max = heights[i];
            for (int j = i + 1; j < length; j++) {
                if (heights[j] > right_max) {
                    right_max = heights[j];
                }
            }
            //左侧最高的墙
            int left_max = heights[i];
            for (int j = 0; j < i; j++) {
                if (heights[j] > left_max) {
                    left_max = heights[j];
                }
            }
            int min = Math.min(left_max, right_max);
            sum += (min - heights[i]);
        }
        return sum;
    }
}