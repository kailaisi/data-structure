package leetcode;

/**
 * 学校在拍年度纪念照时，一般要求学生按照 非递减 的高度顺序排列。
 * 请你返回能让所有学生以 非递减 高度排列的最小必要移动人数。
 * 注意，当一组学生被选中时，他们之间可以以任何可能的方式重新排序，而未被选中的学生应该保持不动。
 * 示例：
 * 输入：heights = [1,1,4,2,1,3]
 * 输出：3
 * 解释：
 * 当前数组：[1,1,4,2,1,3]
 * 目标数组：[1,1,1,2,3,4]
 * 在下标 2 处（从 0 开始计数）出现 4 vs 1 ，所以我们必须移动这名学生。
 * 在下标 4 处（从 0 开始计数）出现 1 vs 3 ，所以我们必须移动这名学生。
 * 在下标 5 处（从 0 开始计数）出现 3 vs 4 ，所以我们必须移动这名学生。
 * 示例 2：
 * 输入：heights = [5,1,2,3,4]
 * 输出：5
 * 示例 3：
 * 输入：heights = [1,2,3,4,5]
 * 输出：0
 * 提示：
 * 1 <= heights.length <= 100
 * 1 <= heights[i] <= 100
 * 解题思路：其实我们关心的只是排名，只要排名一致，那么就不需要变换位置。而数字的大小和范围已经固定是100以内，所以可以使用
 * 统计算法
 */
class SolutionLT1051Second {
    public static void main(String[] args) {
        SolutionLT1051Second lt1078 = new SolutionLT1051Second();
        System.out.println(lt1078.heightChecker(new int[]{1,1,4,2,1,3}));
    }

    public int heightChecker(int[] heights) {
        int[] ints = new int[101];
        //统计每个数字出现的次数
        for(int i=0;i<heights.length;i++){
            ints[heights[i]]++;
        }
        int count=0;
        for(int i=1,j=0;i<ints.length;i++){
            while (ints[i]-- > 0) {//每次从筒中取出一个
                //如果桶数据和当前height数据不一致，表明其并不在其应该在的位置
                if(heights[j++]!=i){
                    count++;
                }
            }
        }
        return count;
    }
}