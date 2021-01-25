package leetcode;

import java.util.Arrays;

/**
 * 581. 最短无序连续子数组
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 * 示例 1：
 * 输入：nums = [2,6,4,8,10,9,15]
 * 输出：5
 * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * 示例 2：
 * 输入：nums = [1,2,3,4]
 * 输出：0
 * 示例 3：
 * 输入：nums = [1]
 * 输出：0
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 104
 * -105 <= nums[i] <= 105
 * <p>
 * 解题思路：这里需要找到的是某个子数组排序之后，整个数组都是有序的。
 *          那么我们是不是可以先将数组copy一份，然后进行排序，找到起始和末尾的数据不同的位置？然后这两个之间的就是进行了重排序的？
 *  空间复杂度：O(n)
 *  时间复杂度：O(n)
 */
class SolutionLT581 extends GuessGame {

    public static void main(String[] args) {
        SolutionLT581 lt = new SolutionLT581();
        System.out.println(lt.findUnsortedSubarray(new int[]{2,6,4,8,10,9,15}));
        System.out.println(lt.findUnsortedSubarray(new int[]{1,2,3,4}));
        System.out.println(lt.findUnsortedSubarray(new int[]{1}));
    }

    public int findUnsortedSubarray(int[] nums) {
        int length = nums.length;
        if(length==1){
            return 0;
        }
        int[] copy = Arrays.copyOf(nums, length);
        Arrays.sort(copy);
        int start = -1;
        int end = -1;
        for (int i = 0; i < length; i++) {
            if (start == -1 && nums[i] != copy[i]) {
                start = i;
            } else if (nums[i] != copy[i]) {
                end = i;
            }
        }
        if(end==start){
            return 0;
        }
        return end - start+1;
    }
}