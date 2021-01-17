package leetcode;

/**
 * 给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。
 * 子数组 定义为原数组中的一个连续子序列。
 * 请你返回 arr 中 所有奇数长度子数组的和 。
 * 示例 1：
 * 输入：arr = [1,4,2,5,3]
 * 输出：58
 * 解释：所有奇数长度子数组和它们的和为：
 * [1] = 1
 * [4] = 4
 * [2] = 2
 * [5] = 5
 * [3] = 3
 * [1,4,2] = 7
 * [4,2,5] = 11
 * [2,5,3] = 10
 * [1,4,2,5,3] = 15
 * 我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
 * 示例 2：
 * <p>
 * 输入：arr = [1,2]
 * 输出：3
 * 解释：总共只有 2 个长度为奇数的子数组，[1] 和 [2]。它们的和为 3 。
 * 示例 3：
 * <p>
 * 输入：arr = [10,11,12]
 * 输出：66
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 100
 * 1 <= arr[i] <= 1000
 * 解题思路：暴力法，每次以某个点位起点，然后计算后面的奇数长度的数组
 */
class SolutionLT1588 {

    public static void main(String[] args) {
        SolutionLT1588 lt = new SolutionLT1588();
        System.out.println(lt.sumOddLengthSubarrays(new int[]{1, 4, 2, 5, 3}));
        System.out.println(lt.sumOddLengthSubarrays(new int[]{1,2}));
        System.out.println(lt.sumOddLengthSubarrays(new int[]{10,11,12}));
    }


    public int sumOddLengthSubarrays(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {//已i为起点
            for (int j = i; j < arr.length; j += 2) {//长度为奇数个
                for (int k = i; k <= j; k++) {
                    res += arr[k];
                }
            }
        }
        return res;
    }
}