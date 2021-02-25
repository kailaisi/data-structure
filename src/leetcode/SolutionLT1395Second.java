package leetcode;

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
 * 解题思路：中间方案：因为是3个数据来组成一个数组。那么我们可以考虑以j为中间点，然后左边找比j大的，右边找比j小的。或者左边比j小，右边比j大。这样就可以相乘来得到以j为中间点的数据所组成的集合数据
 * 时间复杂度：O（n^2）
 * 空间复杂度：O（1）
 */
class SolutionLT1395Second {
    public static void main(String[] args) {
        SolutionLT1395Second lt = new SolutionLT1395Second();
        System.out.println(lt.numTeams(new int[]{2,5,3,4,1}));//3
        System.out.println(lt.numTeams(new int[]{2,1,3}));//0
        System.out.println(lt.numTeams(new int[]{1,2,3,4}));//4
    }
    public int numTeams(int[] rating) {
        int count=0;
        int length = rating.length;
        for (int j=0;j<length;j++){
            int leftSmall=0;
            int leftBig=0;
            int rightBig=0;
            int rightSmall=0;
            for (int i = 0; i < length; i++) {
                if (i<j){
                    if (rating[i]<rating[j]){
                        leftSmall++;
                    }else if (rating[i]>rating[j]){
                        leftBig++;
                    }
                }else if (i>j){
                    if (rating[i]<rating[j]){
                        rightSmall++;
                    }else if (rating[i]>rating[j]){
                        rightBig++;
                    }
                }
            }
            count+=leftSmall*rightBig;
            count+=leftBig*rightSmall;
        }
        return count;
    }
}