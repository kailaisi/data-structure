package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1395. 统计作战单位数
 *  n 名士兵站成一排。每个士兵都有一个 独一无二 的评分 rating 。
 * 每 3 个士兵可以组成一个作战单位，分组规则如下：
 * 从队伍中选出下标分别为 i、j、k 的 3 名士兵，他们的评分分别为 rating[i]、rating[j]、rating[k]
 * 作战单位需满足： rating[i] < rating[j] < rating[k] 或者 rating[i] > rating[j] > rating[k] ，其中  0 <= i < j < k < n
 * 请你返回按上述条件可以组建的作战单位数量。每个士兵都可以是多个作战单位的一部分。
 * 示例 1：
 * 输入：rating = [2,5,3,4,1]
 * 输出：3
 * 解释：我们可以组建三个作战单位 (2,3,4)、(5,4,1)、(5,3,1) 。
 * 示例 2：
 * 输入：rating = [2,1,3]
 * 输出：0
 * 解释：根据题目条件，我们无法组建作战单位。
 * 示例 3：
 * 输入：rating = [1,2,3,4]
 * 输出：4
 * 提示：
 * n == rating.length
 * 3 <= n <= 1000
 * 1 <= rating[i] <= 10^5
 * rating 中的元素都是唯一的
 *
 * 解题思路：暴力方法：我们通过遍历，i，j,k只要满足条件就统计+1；
 * 时间复杂度：O（n^3）
 * 空间复杂度：O（1）
 */
class SolutionLT1395 {
    public static void main(String[] args) {
        SolutionLT1395 lt = new SolutionLT1395();
        System.out.println(lt.numTeams(new int[]{2,5,3,4,1}));//3
        System.out.println(lt.numTeams(new int[]{2,1,3}));//0
        System.out.println(lt.numTeams(new int[]{1,2,3,4}));//4
    }
    public int numTeams(int[] rating) {
        int count=0;
        int length = rating.length;
        for (int i=0;i<length;i++){
            for (int j = i+1; j < length; j++) {
                for (int k = j+1; k < length; k++) {
                    if (rating[i]<rating[j] && rating[j]<rating[k]  || rating[i]>rating[j] && rating[j]>rating[k]){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}