package leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * 503. 下一个更大元素 II
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 注意: 输入数组的长度不会超过 10000。
 * <p>
 * 解题思路：暴力法 遍历循环
 * 可以将链表的数据存入数组，然后从中间开始往前往后，逐一进行比较
 * * 时间复杂度：O（N^2）：需要2次遍历
 * * 空间复杂度：O（N）：需要用列表来保存
 */
class SolutionLT503Second {
    public static void main(String[] args) {
        SolutionLT503Second lt = new SolutionLT503Second();
        System.out.println(Arrays.toString(lt.nextGreaterElements(new int[]{1,2,1})));//true
    }

    public int[] nextGreaterElements(int[] nums) {
        //stack最好保存下标位置
        Stack<Integer> stack = new Stack<>();
        int length = nums.length;
        int[] res = new int[length];
        for (int i = 0; i < 2 * length; i++) {
            if (i<length) {
                res[i] = -1;
            }
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % length]) {
                Integer pop = stack.pop();
                res[pop] = nums[i % length];
            }
            stack.push(i % length);
        }
        return res;
    }
}