package leetcode;

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
 * 解题思路：采用大顶堆的排序算法，每次都找到最大的值。然后将堆顶的数字末尾的数字交换并移除掉。
 * <p>
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(1)
 */
class SolutionLT215Third {
    Random random = new Random();

    public static void main(String[] args) {
        SolutionLT215Third lt = new SolutionLT215Third();
        System.out.println(lt.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));//5
        System.out.println(lt.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));//4
    }

    public int findKthLargest(int[] nums, int k) {
        int length = nums.length;
        buildMaxHeap(nums,length);
        for (int i=nums.length-1;i>=nums.length-k+1;i--){
            //将堆顶的数字移到末尾，
            swap(nums,0,i);
            //移除末尾位置的数字，也就是最大的数字
            --length;
            //重新构建0位置的即可。因为现在除了0位置，已经是最大堆了
            downAdjust(nums,0,length);
        }
        return nums[0];
    }

    /**
     * 构建最大堆
     */
    private void buildMaxHeap(int[] nums, int length) {
        for (int i=(length-2)/2;i>=0;i--){
            //从最小的堆进行构建（也就是从左下角的第一个不为叶子节点的节点来进行排序）
            downAdjust(nums,i,length);
        }

    }

    private void downAdjust(int[] nums, int i, int length) {
        int  left=2*i+1;
        int right=2*i+2;
        int largst=i;
        if (left<length && nums[left]>nums[largst]){
            largst=left;
        }
        if (right<length && nums[right]>nums[largst]){
            largst=right;
        }
        if(largst!=i){
            swap(nums,i,largst);
            //largest现在保存的是原来的i位置的数据。可能会比其子节点的小，所以这里遍历处理
            downAdjust(nums,largst,length);
        }
    }

    private void swap(int[] nums, int i, int end) {
        int temp = nums[i];
        nums[i] = nums[end];
        nums[end] = temp;
    }

}