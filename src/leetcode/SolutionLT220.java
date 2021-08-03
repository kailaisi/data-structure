package leetcode;

/**
 * 220. 存在重复元素 III
 * 给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
 * 如果存在则返回 true，不存在返回 false。
 * 示例 1：
 * 输入：nums = [1,2,3,1], k = 3, t = 0
 * 输出：true
 * 示例 2：
 * 输入：nums = [1,0,1,1], k = 1, t = 2
 * 输出：true
 * 示例 3：
 * 输入：nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出：false
 * 解题思路：对于改问题，其实可以理解为，在大小为k的窗口中，是否存在这两个数的差值比t小。
 * 那么这里就存在一个问题了，我们怎么知道窗口中的数据呢？总不能暴力法吧？
 * 暴力法也可以哈
 * 空间复杂度：O(n)，需要有个set来保存数据
 * 时间复杂度：O(n)，需要一次遍历
 */
class SolutionLT220 {

    public static void main(String[] args) {
        SolutionLT220 lt = new SolutionLT220();
        /*System.out.println(lt.containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0));//true
        System.out.println(lt.containsNearbyAlmostDuplicate(new int[]{1, 0, 1, 1}, 1, 2));//true
        System.out.println(lt.containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9}, 2, 3));//false
  */      System.out.println(lt.containsNearbyAlmostDuplicate(new int[]{-2147483648,2147483647}, 1, 1));//false
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i - k ; j <= i + k; j++) {
                if (j >= 0 && j != i && j < nums.length) {
                    if (Math.abs((long)nums[i] - (long)nums[j]) <= t) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}