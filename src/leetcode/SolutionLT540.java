package leetcode;

/**
 * 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [3,3,7,7,10,11,11]
 * 输出: 10
 * 注意: 您的方案应该在 O(log n)时间复杂度和 O(1)空间复杂度中运行。
 * <p> 方案：使用暴力方法，能够增加对应的数据处理
 */
class SolutionLT540 {

    public static void main(String[] args) {
        SolutionLT540 lt = new SolutionLT540();
        System.out.println(lt.singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
        System.out.println(lt.singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}));
        System.out.println(lt.singleNonDuplicate(new int[]{3}));
        System.out.println(lt.singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 10, 11}));
    }

    public int singleNonDuplicate(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        for (int i = 0; i < length; i += 2) {
            if (i == length - 1) {
                return nums[i];
            }
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return 0;
    }
}