package leetcode;

/**
 * 1004. 最大连续1的个数 III
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 * 返回仅包含 1 的最长（连续）子数组的长度。
 * 示例 1：
 * 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：
 * [1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 * 示例 2：
 * 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：
 * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 * 提示：
 * 1 <= A.length <= 20000
 * 0 <= K <= A.length
 * A[i] 为 0 或 1
 * 解题思路：这里是要变化1之后，找到最长的子数组，我们可以变化一个想法，就是我们可以弄个滑动窗口，然后窗口里面有k个0
 * 通过左右指针
 * 时间复杂度：
 * 空间复杂度：1
 */
class SolutionLT1004 {
    public static void main(String[] args) {
        SolutionLT1004 lt = new SolutionLT1004();
        System.out.println(lt.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));//6
        System.out.println(lt.longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));//6
        System.out.println(lt.longestOnes(new int[]{0, 0, 0, 1}, 4));//6
    }

    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int res = 0;
        int length = nums.length;
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                res++;
            }
            right++;
            while (res > k) {
                if (nums[left] == 0) {
                    res--;
                }
                left++;
            }
            count = Math.max(count, right - left);
        }
        return count;
    }
}
