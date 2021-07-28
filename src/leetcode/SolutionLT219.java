package leetcode;

import datalearning.interf.Set;

import java.util.HashSet;

/**
 * 219. 存在重复元素 II
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
 * 示例 1:
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 * 解题思路：这种k个数据之间的一般就按照滑动窗口来处理。
 *      现有set，然后没到k大小的时候，直接添加，到达k的时候，先移除一个，再添加1个
 * 空间复杂度：O(n)，需要有个set来保存数据
 * 时间复杂度：O(n)，需要一次遍历
 */
class SolutionLT219 extends GuessGame {

    public static void main(String[] args) {
        SolutionLT219 lt = new SolutionLT219();
        System.out.println(lt.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));//true
        System.out.println(lt.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));//true
        System.out.println(lt.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));//false
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.size()>k){
                //超过窗口大小了，移除掉
                set.remove(nums[i-k-1]);
            }
            if (set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}