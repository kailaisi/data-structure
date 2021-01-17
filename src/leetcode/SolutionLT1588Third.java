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
 *
 * 输入：arr = [1,2]
 * 输出：3
 * 解释：总共只有 2 个长度为奇数的子数组，[1] 和 [2]。它们的和为 3 。
 * 示例 3：
 *
 * 输入：arr = [10,11,12]
 * 输出：66
 *  
 *
 * 提示：
 *
 * 1 <= arr.length <= 100
 * 1 <= arr[i] <= 1000
 * 解题思路：
 * 我们去掉奇数长度的子数组这个限制。那么对于长度为length的一个数组，坐标为i的数字,其添加的次数可以统计：
 * 左边有0->i总共个i+1可供选择的数字。其中奇数个数：（i+1）/2。偶数个数为i/2+1
 * 右边有0->len-i-1，总共len-i个可供选择的数字。其中奇数个数为(n-i)/2,偶数个数为(n-i+1)/2。
 * 如果要有奇数个数字相加，那么肯定左+本身+右边=奇数。所以左边+右边=偶数个。
 *
 */
class SolutionLT1588Third {

    public static void main(String[] args) {
        SolutionLT1588Third lt = new SolutionLT1588Third();
        System.out.println(lt.sumOddLengthSubarrays(new int[]{1,4,2,5,3}));
        System.out.println(lt.sumOddLengthSubarrays(new int[]{1,2}));
        System.out.println(lt.sumOddLengthSubarrays(new int[]{10,11,12}));
    }


    public int sumOddLengthSubarrays(int[] arr) {
        int res=0;
        int arrSize = arr.length;
        for (int i = 0; i < arrSize; i++) {
            int lOdd = (i+1)/2;
            int lEven = i/2 + 1;
            int rOdd = (arrSize-i)/2;
            int rEven = (arrSize-i+1)/2;
            res += (lOdd*rOdd + lEven*rEven) * arr[i];
        }
        return res;
    }
}