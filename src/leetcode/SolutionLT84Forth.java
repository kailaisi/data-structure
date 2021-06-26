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
 * 解题思路：对于单调栈，我们之前的方式是通过两次遍历来处理的，如果是单调递增栈，所以当数据入栈的时候，如果栈为空，则左侧不存在比他小的，如果存在，则栈中上一个就是比他小的
 * 比如[2,1,5,6,2,3]这个数组，我们可以逐一分析一下
 *      2入栈，当比较1的时候，我们可以知道2出栈，右侧会是1，那么左侧呢？没有数据，那么就是-1。
 *      1入栈。1入栈的时候栈为空，则比他小的是-1位置。
 *      5入栈，栈不是空，左侧是1，那么他左侧比他小的位置就是1所在的position，
 *      5入栈，栈不是空，左侧是5，那么他左侧比他小的位置就是5所在的position，
 *
 *  所以，其实每个位置入栈的时候，知道了左位置，弹出来的时候知道了右位置。那么我们就不需要再使用右边的数组了，直接计算就可以了
 * 空间复杂度：O(n),因为这里我们申请了数组来记录对应的左右的位置信息
 * 时间复杂度：O(n)
 */
class SolutionLT84Forth {
    public static void main(String[] args) {
        System.out.println(new SolutionLT84Forth().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));//10
        System.out.println(new SolutionLT84Forth().largestRectangleArea(new int[]{2, 4}));//4
    }

    public int largestRectangleArea(int[] heights) {
        int length = heights.length;
        /*左侧小于的位置*/
        int[] left = new int[length];
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            //遍历右侧
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                //弹出当前位置
                Integer pop = stack.pop();
                //当前位置的右侧最低是i，左侧最低是left[pop],计算高度
                int val=heights[pop] * (i - left[pop] - 1);
                res = Math.max(res,val);
            }
            /*左侧位置入栈*/
            if (stack.isEmpty()){
                left[i]=-1;
            }else{
                left[i]=stack.peek();
            }
            stack.push(i);
            //如果当前已经便利到最后一位了，那么这时候需要将栈中剩余的数据进行更行为最后一个位置+1
            if (i == length - 1) {
                while (!stack.isEmpty()) {
                    Integer pop = stack.pop();
                    int val=heights[pop] * (length - left[pop] - 1);
                    res = Math.max(res,val);
                }
            }
        }
        System.out.println(Arrays.toString(left));
        return res;
    }
}