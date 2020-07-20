package leetcode;

/**
 * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 *
 * 示例 1:
 *
 * 输入: nums = [4,2,3]
 * 输出: true
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 * 示例 2:
 * 输入: nums = [4,2,1]
 * 输出: false
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 * 说明：
 * 1 <= n <= 10 ^ 4
 * - 10 ^ 5 <= nums[i] <= 10 ^ 5
 * 解题思路：对于不同的数组，因为需要改变某个数据的大小来形成排序。那么遍历数组的时候，需要改变某个位置的数字位置。
 * 2，3，3，2，4
 * -1，4，2，3
 * 4,2,3
 * 对于找到i>i+1的位置。进行数据变化。具体变化i,还是i+1。
 * 需要根据i-1位置进行判断。
 * 1. i-1>i+1     例如：2，3，3，2，4   变化i+1位置，变i+1的大小和i相同。
 * 2. i-1<i+1     例如：-1，4，2，3     变化i位置  ，变i的大小和i+1相同
 */
class SolutionLT665 {
    public static void main(String[] args) {
        int[] a = new int[]{4,2,3};
        boolean i = new SolutionLT665().checkPossibility(a);
        System.out.println(i);
    }

    public boolean checkPossibility(int[] nums) {
        if(nums==null || nums.length<=2){
            return true;
        }
        boolean has=false;
        for (int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                if(has){
                    return false;
                }
                if(i-1>=0 && nums[i-1]>nums[i+1]){//2，3，3，2，4
                    nums[i+1]=nums[i];
                }else{//-1，4，2，3->-1,2,2,3。变前面这个
                    nums[i]=nums[i+1];
                }
                has=true;
            }
        }
        return true;
    }
}