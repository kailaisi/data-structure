package leetcode;

import java.util.Arrays;

/**
 * 1300. 转变数组后最接近目标值的数组和
 * 给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，使得将数组中所有大于 value 的值变成 value 后，数组的和最接近  target （最接近表示两者之差的绝对值最小）。
 * 如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。
 * 请注意，答案不一定是 arr 中的数字。
 * <p>
 * 示例 1：
 * 输入：arr = [4,9,3], target = 10
 * 输出：3
 * 解释：当选择 value 为 3 时，数组会变成 [3, 3, 3]，和为 9 ，这是最接近 target 的方案。
 * 示例 2：
 * <p>
 * 输入：arr = [2,3,5], target = 10
 * 输出：5
 * 示例 3：
 * <p>
 * 输入：arr = [60864,25176,27249,21296,20204], target = 56803
 * 输出：11361
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 10^4
 * 1 <= arr[i], target <= 10^5
 * 解题思路：在第一种方法的基础上，我们可以进行优化，将迭代优化为二分搜索树。
 * 当数组排序之后，当我们确定的res变大之后，所得到的和是严格递增的，
 * 所以我们可以找到一个唯一数据使得其和最接近target，并且<target
 * 所以我们可以找到一个唯一数据使得其和最接近target，并且>target
 * 当找到这两个数据之后，我们可以再进行一次比较，从而得到最接近target的那个数据
 */
class SolutionLT1300Second extends GuessGame {

    public static void main(String[] args) {
        SolutionLT1300Second lt = new SolutionLT1300Second();
        System.out.println(lt.findBestValue(new int[]{4, 9, 3}, 9));
        System.out.println(lt.findBestValue(new int[]{2, 3, 5}, 10));
        System.out.println(lt.findBestValue(new int[]{60864, 25176, 27249, 21296, 20204}, 56803));
    }

    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int length = arr.length;
        int[] ints = new int[length + 1];
        for (int i = 1; i <= length; i++) {
            ints[i] = ints[i - 1] + arr[i - 1];
        }
        int r = arr[length - 1];
        int left = 0;
        int res = -1;
        int right = arr[length - 1];
        while (left <= right) {
            int mid = (left + right) / 2;
            int index = Arrays.binarySearch(arr, mid);
            if (index < 0) {
                index = -index - 1;
            }
            int cur = ints[index] + (length - index) * mid;
            if (cur < target) {//比较当前的差值，是否比之前记录的小
                res = mid;
                left = mid + 1;
            } else {
                right = mid-1;
            }
        }
        int sumSmall = sum(arr, res);
        int sumBig = sum(arr, res + 1);
        return Math.abs(sumSmall - target) <= Math.abs(sumBig - target) ? res : res + 1;
    }

    private int sum(int[] arr, int res) {
        int ret = 0;
        for (int num : arr) {
            ret += Math.min(num, res);
        }
        return ret;
    }
}