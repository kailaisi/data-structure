package leetcode;

/**
 * 给你一个整数数组 nums，每次 操作 会从中选择一个元素并 将该元素的值减少 1。
 * 如果符合下列情况之一，则数组 A 就是 锯齿数组：
 * 每个偶数索引对应的元素都大于相邻的元素，即 A[0] > A[1] < A[2] > A[3] < A[4] > ...
 * 或者，每个奇数索引对应的元素都大于相邻的元素，即 A[0] < A[1] > A[2] < A[3] > A[4] < ...
 * 返回将数组 nums 转换为锯齿数组所需的最小操作次数。
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：2
 * 解释：我们可以把 2 递减到 0，或把 3 递减到 1。
 * 示例 2：
 * 输入：nums = [9,6,1,6,2]
 * 输出：4
 * 提示：
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 1000
 * 解题思路：这里分为2种，奇数小或者偶数小。通过比较，来找到最小的值
 * 逐个比较，偶数都降低到跟两边的数据都小，然后计算降低的总和。
 * 奇数也如此，最后计算最小值
 */
class SolutionLT1144 {
    public static void main(String[] args) {
        SolutionLT1144 lt1078 = new SolutionLT1144();
        int[] ints = {1,2,3};
        System.out.println(lt1078.movesToMakeZigzag(ints));
    }

    public int movesToMakeZigzag(int[] nums) {
        int ans1=0;
        int ans2=0;
        for(int i=0;i<nums.length;i++){
            if(i%2==0){//偶数索引下降，降低到比两边都小
                ans1 = getAns(nums, ans1, i);
            }else{
                ans2 = getAns(nums, ans2, i);
            }
        }
        return Math.min(ans1,ans2);
    }

    private int getAns(int[] nums, int ans1, int i) {
        int down=0;
        int down2=0;
        if(i-1>=0) {
            //如果本身就比隔壁小，那么这里会得到负值，我们不需要+负数。直接取0即可
            down =Math.max(0,  nums[i]+1-nums[i - 1]);
        }
        if(i+1<nums.length) {
            down2 = Math.max(nums[i]+1- nums[i + 1] ,0);
        }
        ans1+=Math.max(down,down2);
        return ans1;
    }
}