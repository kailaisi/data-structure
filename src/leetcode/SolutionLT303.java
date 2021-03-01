package leetcode;

import java.util.ArrayList;
import java.util.List;

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
 * 解题思路：暴力法：这里其实主要式计算数组内一连串数组的和，我们可以每次都计算数据来处理
 * 时间复杂度：O（n）
 * 空间复杂度：O(1)
 */
class SolutionLT303 {

    public static void main(String[] args) {
        SolutionLT303 lt = new SolutionLT303(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(lt.sumRange(0, 2));//1
        System.out.println(lt.sumRange(2, 5));//-1
        System.out.println(lt.sumRange(0, 5));//-3
    }

    int[] arr;

    public SolutionLT303(int[] nums) {
        arr = nums;
    }

    public int sumRange(int i, int j) {
        int res = 0;
        for (int k = i; k <= j; k++) {
            res += arr[k];
        }
        return res;
    }
}