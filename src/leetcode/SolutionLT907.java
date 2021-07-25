package leetcode;


import java.util.Stack;

/**
 * 907. 子数组的最小值之和
 * 给定一个整数数组 arr，找到 min(b) 的总和，其中 b 的范围为 arr 的每个（连续）子数组。
 * <p>
 * 由于答案可能很大，因此 返回答案模 10^9 + 7 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,1,2,4]
 * 输出：17
 * 解释：
 * 子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。
 * 最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。
 * 示例 2：
 * <p>
 * 输入：arr = [11,81,94,43,3]
 * 输出：444
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 3 * 104
 * 1 <= arr[i] <= 3 * 104
 * 解题思路：对于这个题，我们要知道，最终计算的是什么。
 * 首先：将数组拆分成子数组，这里是所有的子数组，
 * 然后：将子数组的最小值拿出来，然后计算其和！
 * 那么，对于i位置的值 arr[i]，以它为最小值的最大子数组，左侧要找到第一个j使得arr[j]<arr[i] ，右侧要找到第一个k，使得arr[k]<arr[i]。当找到j,k以后，这区间包含i的有多少个子数组呢？i-j+1,  *   k-i+1。
 * 所以，现在的任务变简单了，对于任意位置i，找到i的左侧比他大的第一个，以及右边比他大的第一个。
 * 简化为了单调栈。单调栈，应该是单调递减栈针
 * 时间复杂度：O（N）：每次都要进行一次遍历。
 * 空间复杂度：O（N）：需要使用我们的集合来保存输入的数据
 */
class SolutionLT907 {
    public static void main(String[] args) {
        SolutionLT907 lt = new SolutionLT907();
        System.out.println(lt.sumSubarrayMins(new int[]{3, 1, 2, 4}));
    }

    public int sumSubarrayMins(int[] arr) {
        int mode = 1000000007;
        //这里我们保存的是坐标信息
        Stack<Integer> stack = new Stack<>();
        int length = arr.length;
        int res = 0;
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                //这里我们可以找到右侧比当前位置大的数据
                Integer pop = stack.pop();
                //左侧的呢？当然就是再pop一个了
                int right = i;
                int left = 0;
                if (!stack.isEmpty()) {
                    left = stack.peek();
                }
                res += arr[pop] * (right + 1 - pop) * (pop + 1 - left) % mode;
                res = res % mode;
            }
            stack.push(i);
        }
        return res;
    }
}
