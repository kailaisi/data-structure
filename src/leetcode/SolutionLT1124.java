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
 * 解题思路：
 */
class SolutionLT1124 {
    //todo 动态规划
    public static void main(String[] args) {
        int[] hours = new int[]{9, 9, 6, 0, 6, 6, 9};
        System.out.println(new SolutionLT1124().longestWPI(hours));
    }

    public int longestWPI(int[] hours) {
        int[] arr=new int[hours.length+1];
        arr[0]=0;
        for (int i = 0; i < hours.length; i++) {
            arr[i+1]=arr[i]+hours[i]>8?1:-1;
        }
        return 0;
    }
}