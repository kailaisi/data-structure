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
 * 解题思路：我们可以以长度为作为第一个的数据来处理。
 * 当长度为i时，从第一个长度为len的数组的和，然后移动一个单位，则减去前一个，然后加上len+1的位置的数据
 */
class SolutionLT1588Second {

    public static void main(String[] args) {
        SolutionLT1588Second lt = new SolutionLT1588Second();
        System.out.println(lt.sumOddLengthSubarrays(new int[]{1,4,2,5,3}));

    }


    public int sumOddLengthSubarrays(int[] arr) {
        int res=0;
        for (int i=1;i<=arr.length;i+=2){//奇数长度
            int sum=0;
            for(int j=0;j<arr.length;j++){
                if(j+1<i){//长度不够i
                    sum+=arr[j];
                }else if(j+1==i){//长度==i;
                    sum+=arr[j];
                    res+=sum;
                }else{//长度超过了i
                    sum-=arr[j-i];
                    sum+=arr[j];
                    res+=sum;
                }
            }
        }
        return res;
    }
}