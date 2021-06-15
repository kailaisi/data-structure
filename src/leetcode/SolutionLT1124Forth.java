package leetcode;

import java.util.Stack;

/**
 * 给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。
 * 我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。
 * 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。
 * 请你返回「表现良好时间段」的最大长度。
 * 示例 1：
 * 输入：hours = [9,9,6,0,9，9,9]
 * 输出：3
 * 解释：最长的表现良好时间段是 [9,9,6]。
 * 解题思路：单调栈方案。本题本质上是寻找最长的上坡距离。也就是寻找最长的区间满足p[j]>p[i]。
 *          所以我们这里先找下坡路，然后每次都从后往前遍历。
 *          比如说找到的是[0,5,6]，那么从最后一个位置i=10开始找，那么直接跟6位置比较，如果大，
 *              再跟5位置比较，如果比5还大，则跟1位置比较，因为这时候，肯定10-5是递增了。那么只需要扩大范围即可。
 *              如果10位置比比6大，比5小。只需要再遍历即可。
 *          先找到单调递减的数组下标。然后从后往前遍历，如果发现
 * 本次仍然使用暴力法处理
 * 空间复杂度：O(n^2)
 * 时间复杂度：O(n)
 */
class SolutionLT1124Forth {
    public static void main(String[] args) {
        System.out.println(new SolutionLT1124Forth().longestWPI(new int[]{9, 9, 6, 0, 6, 6, 9}));
        System.out.println(new SolutionLT1124Forth().longestWPI(new int[]{6, 9, 9}));
        System.out.println(new SolutionLT1124Forth().longestWPI(new int[]{6, 6, 9}));
    }

    public int longestWPI(int[] hours) {
        int n = hours.length;
        /*前缀和*/
        int[] preRes = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preRes[i + 1] = preRes[i] + (hours[i] > 8 ? 1 : -1);
        }
        int res = 0;
        Stack<Integer> stack = new Stack<Integer>();
        /*找单调递减栈*/
        for (int i = 1; i <= n; i++) {
            if (stack.isEmpty()|| stack.peek()<preRes[i]){
                stack.push(i);
            }
        }
        for (int i=n;i>0;i--){
            while (!stack.isEmpty()  && preRes[i]>preRes[stack.peek()]){
                res=Math.max(res,i-stack.pop());
            }
        }
        return res;
    }
}