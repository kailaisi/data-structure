package leetcode;

import java.util.Arrays;
import java.util.Stack;

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
 * 解题思路：对于每一个位置i，左边的比小的位置x，然后找到右边比他小的数据的位置y，然后height[i]*(j-i-1)。那么可以采用单调栈的方式
 * 先从左边便利，然后从右遍历，通过两个数组找到i位置的左右位置信息。所以这里的数据，我们在stack中应该保留的是位置i的值
 * 空间复杂度：O(n),因为这里我们申请了数组来记录对应的左右的位置信息
 * 时间复杂度：O(n)
 */
class SolutionLT84Second {
    public static void main(String[] args) {
        System.out.println(new SolutionLT84Second().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));//10
        System.out.println(new SolutionLT84Second().largestRectangleArea(new int[]{2, 4}));//4
    }

    public int largestRectangleArea(int[] heights) {
        int length = heights.length;

        /*右侧小于的位置*/
        int[] right = new int[length];
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            //遍历右侧
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                Integer pop = stack.pop();
                right[pop] = i;
            }
            stack.push(i);
            //如果当前已经便利到最后一位了，那么这时候需要将栈中剩余的数据进行更行为最后一个位置+1
            if (i == length - 1) {
                while (!stack.isEmpty()) {
                    right[stack.pop()] = length;
                }
            }
        }
        System.out.println(Arrays.toString(right));
        //左侧栈
        /*左侧小于的位置*/
        int[] left = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            //遍历右侧
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                Integer pop = stack.pop();
                left[pop] = i;
            }
            stack.push(i);
            //如果当前已经便利到最后一位了，那么这时候需要将栈中剩余的数据进行更行为最后一个位置+1
            if (i == 0) {
                while (!stack.isEmpty()) {
                    left[stack.pop()] = -1;
                }
            }
        }
        System.out.println(Arrays.toString(left));
        for (int i = 0; i < length; i++) {
            res = Math.max(res, heights[i] * (right[i] - left[i] - 1));
        }
        return res;
    }
}