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
 * 解题思路：可以采用最大栈的方式，这里由于能够进行循环搜索，所以我们可以将遍历的长度设置为2len，这样当第一遍数据保存上以后，就可以通过第二轮的遍历来进行处理
 * 时间复杂度：O（N），会进行两次的遍历
 * 空间复杂度：O（N） 会申请栈信息，
 */
class SolutionLT503 {
    public static void main(String[] args) {
        SolutionLT503 lt167 = new SolutionLT503();
        System.out.println(Arrays.toString(lt167.nextGreaterElements(new int[]{1,2,1})));
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
