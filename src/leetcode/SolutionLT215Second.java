package leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * 215. 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 * <p>
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 * 解题思路：分治算法。
 * 分解：随机一个位置x，然后将数组分为比num[x]大和小的部分。
 * 解决：通过递归调用快速排序，将两边的数组进行排序
 * 合并：子数组是有序的，所以不需要合并了。
 * 这里我们看到当拆分了两个数组之后，如果发现比num[x]大的数组的个数cnt正好为k的话，那么就直接返回即可。如果比k小。那么我们只需要在比较小的数组里面去迭代即可，比他大的不再需要考虑了
 * <p>
 * 时间复杂度：O(logn)
 * 空间复杂度：O(1)
 */
class SolutionLT215Second {
    Random random = new Random();

    public static void main(String[] args) {
        SolutionLT215Second lt = new SolutionLT215Second();
        System.out.println(lt.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));//5
        System.out.println(lt.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));//4
    }

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    /**
     * @param nums
     * @param start 数组起始位置
     * @param end   结束位置
     * @param index 随机位置，需要将index位置的数字进行分组
     * @return 返回的是比index位置小的数组的个数
     */
    private int quickSelect(int[] nums, int start, int end, int index) {
        int q = randomPartition(nums, start, end);
        if (q == index) {
            return nums[q];
        }
        if (q < index) {//这时候，start->q位置的不需要再进行排序了
            return quickSelect(nums, q+1, end,index);
        } else {
            return quickSelect(nums, start, q-1,index);
        }
    }

    private int randomPartition(int[] nums, int start, int end) {
        //从始末位置中间随机一个数字出来。
        int i = random.nextInt(end - start + 1) + start;
        //先将随机位置的数字移到末尾
        swap(nums, i, end);
        return partion(nums, start, end);
    }

    private int partion(int[] nums, int start, int end) {
        //需要比较的数据
        int x = nums[end];
        //i表示比x小的数组的坐标位置，如果发现某个位置j的数字比x小，那么就将i的位置的数字和j的位置互换，然后将i指向下一个坐标位置
        int i = start - 1;
        for (int j = start; j < end ; ++j) {
            if (nums[j] <= x) {
                swap(nums, ++i, j);
            }
        }
        //将末尾的数字和i+1d的位置互换。这时候，i+1左边的都比x小，右边的都比x大。
        swap(nums, i + 1, end);
        //返回分割点坐标。
        return i + 1;
    }

    private void swap(int[] nums, int i, int end) {
        int temp = nums[i];
        nums[i] = nums[end];
        nums[end] = temp;
    }
}