package leetcode;

import java.util.Arrays;

/**
 * 1005. K 次取反后最大化的数组和
 * 给定一个整数数组 A，我们只能用以下方法修改该数组：我们选择某个索引 i 并将 A[i] 替换为 -A[i]，然后总共重复这个过程 K 次。（我们可以多次选择同一个索引 i。）
 * 以这种方式修改数组后，返回数组可能的最大和。
 * 示例 1：
 * 输入：A = [4,2,3], K = 1
 * 输出：5
 * 解释：选择索引 (1,) ，然后 A 变为 [4,-2,3]。
 * 示例 2：
 * 输入：A = [3,-1,0,2], K = 3
 * 输出：6
 * 解释：选择索引 (1, 2, 2) ，然后 A 变为 [3,1,0,2]。
 * 示例 3：
 * 输入：A = [2,-3,-1,5,-4], K = 2
 * 输出：13
 * 解释：选择索引 (1, 4) ，然后 A 变为 [2,3,-1,5,4]。
 * 提示：
 * 1 <= A.length <= 10000
 * 1 <= K <= 10000
 * -100 <= A[i] <= 100
 * 解题思路：贪心算法。在第一种算法的时候，每次变完数据之后都进行一次排序，其实没有必要，我们只需要将数组中，从最小的负数，到最大的负数，都依次变为正数即可。
 *                  当然了，前提是K依然>0。后面的就是直接取最小的正数来不断的变正负即可。
 * 时间复杂度：O（N）：排序时间O（NlogN），计算和时间O（N），
 * 空间复杂度：O（NlogN）
 */
class SolutionLT1005Second {
    public static void main(String[] args) {
        SolutionLT1005Second lt = new SolutionLT1005Second();
        System.out.println( lt.largestSumAfterKNegations(new int[]{4,2,3},1));//5
        System.out.println( lt.largestSumAfterKNegations(new int[]{3,-1,0,2},3));//6
        System.out.println( lt.largestSumAfterKNegations(new int[]{2,-3,-1,5,-4},2));//13
    }

    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        int i;
        for (i=0; i < A.length && A[i] < 0; i++) {
            if (K>0){
                A[i]=-A[i];
                K--;
            }
        }
        //还需要变最后一次，这时候找到最小的正数去变化
        if (K%2==1){
            Arrays.sort(A);
            A[0]=-A[0];
        }
        int res=0;
        for (i = 0; i < A.length; i++) {
            res+=A[i];
        }
        return res;
    }
}
