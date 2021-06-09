package leetcode;

/**
 * 给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。
 * 我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。
 * 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。
 * 请你返回「表现良好时间段」的最大长度。
 * 示例 1：
 * 输入：hours = [9,9,6,0,6,6,9]
 * 输出：3
 * 解释：最长的表现良好时间段是 [9,9,6]。
 * 解题思路：暴力法。我们可以先对数组进行一下处理，如果大于8小时，则计数+1，小于则-1。然后统计最大子数组，其和大于0。
 * 空间复杂度：O(n)
 * 时间复杂度：O(n)
 */
class SolutionLT1124Second {
    public static void main(String[] args) {
        System.out.println(new SolutionLT1124Second().longestWPI(new int[]{9, 9, 6, 0, 6, 6, 9}));
        System.out.println(new SolutionLT1124Second().longestWPI(new int[]{6, 9, 9}));
    }

    public int longestWPI(int[] hours) {
        int n = hours.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            if (hours[i] > 8) {
                arr[i] = 1;
            } else {
                arr[i] = -1;
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = i; j < n; j++) {
                count += arr[j];
                if (count > 0)
                    res = Math.max(res, j - i + 1);
            }
            if (n - i <= res)
                return res;
        }
        return res;
    }
}