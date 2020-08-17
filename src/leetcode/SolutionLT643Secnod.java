package leetcode;

/**
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 * 示例 1:
 * 输入: [1,12,-5,-6,50,3], k = 4
 * 输出: 12.75
 * 解释: 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 * 注意:
 * 1 <= k <= n <= 30,000。
 * 所给数据范围 [-10,000，10,000]。
 * 解题思路：滑动窗口来计算对应的和
 */
public class SolutionLT643Secnod {
    public static void main(String[] args) {
        SolutionLT643Secnod lt = new SolutionLT643Secnod();
        int[] ints = {5};
        System.out.println(lt.findMaxAverage(ints, 1));
    }

    public double findMaxAverage(int[] nums, int k) {
        int length = nums.length;
        System.out.println(length);
        double max=Integer.MIN_VALUE;
        double res=0;
        for (int i = 0; i < length; i++) {
            if(i<k){//统计左侧的k个数据的和
                res+=nums[i];
                max = res;
            }else{
                //滑动窗口，并记录最大的数据和
                res=res+nums[i]-nums[i-k];
                max=Math.max(max,res);
            }

        }
        return  max / k;
    }
}
