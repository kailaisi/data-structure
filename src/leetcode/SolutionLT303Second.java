package leetcode;

/**
 * 303. 区域和检索 - 数组不可变
 * 给定一个整数数组  nums，求出数组从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点。
 * 实现 NumArray 类：
 * NumArray(int[] nums) 使用数组 nums 初始化对象
 * int sumRange(int i, int j) 返回数组 nums 从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点（也就是 sum(nums[i], nums[i + 1], ... , nums[j])）
 * 示例：
 * 输入：
 * ["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * 输出：
 * [null, 1, -1, -3]
 * 解释：
 * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
 * numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
 * numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
 * <p>
 * 提示：
 * 0 <= nums.length <= 104
 * -105 <= nums[i] <= 105
 * 0 <= i <= j < nums.length
 * 最多调用 104 次 sumRange 方法
 * <p>
 * 解题思路：前缀求和法：这里其实主要式计算数组内一连串数组的和，我们可以直接通过一个数组，数组k位置的为前k个数据的和，这样，当计算【i,j】之间的数据和的时候，直接i，j数字的数据相减即可。
 *          这里需要注意的是，[i,j]区间是闭区间，i和j都是要进行和的结算的
 * 时间复杂度：构造函数的时间复杂度为O（n），检索的时间复杂度为O(1)
 * 空间复杂度：O(n)
 */
class SolutionLT303Second {

    public static void main(String[] args) {
        SolutionLT303Second lt = new SolutionLT303Second(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(lt.sumRange(0, 2));//1
        System.out.println(lt.sumRange(2, 5));//-1
        System.out.println(lt.sumRange(0, 5));//-3
    }

    int[] sum;

    public SolutionLT303Second(int[] nums) {
        int len = nums.length;
        sum=new int[len];
        for (int i = 0; i < len; i++) {
            if (i==0){
                sum[i]=nums[i];
            }else{
                sum[i]=nums[i]+sum[i-1];
            }
        }
    }

    public int sumRange(int i, int j) {
        if (i==0){
            return sum[j];
        }
        return sum[j]-sum[i-1];
    }
}