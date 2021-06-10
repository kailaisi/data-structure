package leetcode;

/**
 * 给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。
 * 我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。
 * 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。
 * 请你返回「表现良好时间段」的最大长度。
 * 示例 1：
 * 输入：hours = [9,9,6,0,9，9,9]
 * 输出：3
 * 解释：最长的表现良好时间段是 [9,9,6]。
 * 解题思路：在暴力法2的基础上，我们可以做一个统计，计算前缀和，这样i，j之间是否是严格的劳累数据，则直接pre[j]-pre[i]就可以得出结果
 *          而且如果i<j<k,i，k满足条件，那么其实就无须再处理k了，因此我们可以考虑从后面开始迭代处理
 * 本次仍然使用暴力法处理
 * 空间复杂度：O(n^2)
 * 时间复杂度：O(n)
 */
class SolutionLT1124Third {
    public static void main(String[] args) {
        System.out.println(new SolutionLT1124Third().longestWPI(new int[]{9, 9, 6, 0, 6, 6, 9}));
        System.out.println(new SolutionLT1124Third().longestWPI(new int[]{6, 9, 9}));
    }

    public int longestWPI(int[] hours) {
        int n = hours.length;
        /*前缀和*/
        int[] preRes = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preRes[i + 1] = preRes[i] + (hours[i] > 8 ? 1 : -1);
        }
        int res = 0;
        int sub;
        for (int i = 0; i < n; i++) {
            for (int j = n; j >=i; j--) {
                /*i到j之间的差值*/
                sub = preRes[j + 1] - preRes[i];
                if (sub > 0)
                    res = Math.max(res, j - i + 1);
            }
            /*可以停止遍历了*/
            if (n - i <= res)
                return res;
        }
        return res;
    }
}