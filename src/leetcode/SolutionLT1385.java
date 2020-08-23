package leetcode;

import java.util.Arrays;

/**
 * 给你一个数组 candies 和一个整数 extraCandies ，其中 candies[i] 代表第 i 个孩子拥有的糖果数目。
 * 对每一个孩子，检查是否存在一种方案，将额外的 extraCandies 个糖果分配给孩子们之后，此孩子有 最多 的糖果。注意，允许有多个孩子同时拥有 最多 的糖果数目。
 * 示例 1：
 * 输入：candies = [2,3,5,1,3], extraCandies = 3
 * 输出：[true,true,true,false,true]
 * 解释：
 * 孩子 1 有 2 个糖果，如果他得到所有额外的糖果（3个），那么他总共有 5 个糖果，他将成为拥有最多糖果的孩子。
 * 孩子 2 有 3 个糖果，如果他得到至少 2 个额外糖果，那么他将成为拥有最多糖果的孩子。
 * 孩子 3 有 5 个糖果，他已经是拥有最多糖果的孩子。
 * 孩子 4 有 1 个糖果，即使他得到所有额外的糖果，他也只有 4 个糖果，无法成为拥有糖果最多的孩子。
 * 孩子 5 有 3 个糖果，如果他得到至少 2 个额外糖果，那么他将成为拥有最多糖果的孩子。
 * 示例 2：
 * 输入：candies = [4,2,1,1,2], extraCandies = 1
 * 输出：[true,false,false,false,false]
 * 解释：只有 1 个额外糖果，所以不管额外糖果给谁，只有孩子 1 可以成为拥有糖果最多的孩子。
 * 示例 3：
 * 输入：candies = [12,1,12], extraCandies = 10
 * 输出：[true,false,true]
 * 提示：
 * 2 <= candies.length <= 100
 * 1 <= candies[i] <= 100
 * 1 <= extraCandies <= 50
 */
class SolutionLT1385 {
    public static void main(String[] args) {
        SolutionLT1385 lt1078 = new SolutionLT1385();
        int num = lt1078.findTheDistanceValue(new int[]{2,1,100,3}, new int[]{-5,-2,10,-3,7}, 6);
        System.out.println(num);
    }

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int count = 0;
        int len1 = arr1.length;
        int len2 = arr2.length;
        for (int i = 0; i < len1; i++) {
            int i1 = arr1[i];
            if (arr2[0] - i1 > d) {//arr2最小的数据都比i1大d
                count++;
            } else if (i1 - arr2[len2 - 1] > d) {//arr2的最大值都比i1小d。
                count++;
            } else {
                int j;
                for ( j= 0; j < len2; j++) {
                    if (Math.abs(arr2[j] - i1) <= d) {
                        break;
                    }
                }
                if (j==len2) {
                    count++;
                }
            }
        }
        return count;
    }
}