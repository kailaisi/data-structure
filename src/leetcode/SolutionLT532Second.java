package leetcode;

import java.util.Arrays;

/**
 * 给定一个整数数组和一个整数 k, 你需要在数组里找到不同的 k-diff 数对。这里将 k-diff 数对定义为一个整数对 (i, j), 其中 i 和 j 都是数组中的数字，且两数之差的绝对值是 k.
 * 示例 1:
 * 输入: [3, 1, 4, 1, 5], k =
 * 输出: 2
 * 解释: 数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
 * 尽管数组中有两个1，但我们只应返回不同的数对的数量。
 * 示例 2:
 * 输入:[1, 2, 3, 4, 5], k = 1
 * 输出: 4
 * 解释: 数组中有四个 1-diff 数对, (1, 2), (2, 3), (3, 4) 和 (4, 5)。
 * 示例 3:
 * 输入: [1, 3, 1, 5, 4], k = 0
 * 输出: 1
 * 解释: 数组中只有一个 0-diff 数对，(1, 1)。
 * 注意:
 * 数对 (i, j) 和数对 (j, i) 被算作同一数对。
 * 数组的长度不超过10,000。
 * 所有输入的整数的范围在 [-1e7, 1e7]。
 * 数组，双指针
 * 解题方案。先进行排序
 * 双指针法，指定前后位置
 */
class SolutionLT532Second {
    public static void main(String[] args) {
       SolutionLT532Second lt = new SolutionLT532Second();
 /*        System.out.println(lt.findPairs(new int[]{3, 1, 4, 1, 5}, 2));
        System.out.println(lt.findPairs(new int[]{1, 2, 3, 4, 5}, 1));
        System.out.println(lt.findPairs(new int[]{1, 2, 3, 4, 5}, 0));
        System.out.println(lt.findPairs(new int[]{1, 3, 1, 5, 4}, 0));
        System.out.println(lt.findPairs(new int[]{1, 2, 3, 4, 5}, 0));*/
        System.out.println(lt.findPairs(new int[]{1, 1, 1, 1, 1}, 0));
    }

    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int length = nums.length;
        if (length < 2) {
            return 0;
        }
        if (k < 0) {
            return 0;
        }
        System.out.println(Arrays.toString(nums));
        int count = 0;
        int start = 0;
        int end = 1;
        k = Math.abs(k);
        while (end < length) {
            if (end < length - 1 && nums[end] == nums[end + 1]) {//如果前后相同，则直接往后跳转一个
                end++;
                continue;
            }
            int i = nums[end] - nums[start];
            if (i == k) {//相同则+1
                count++;
                end++;
            } else if (i < k) {
                end++;
            } else {
                start++;
                if (start == end) {
                    end++;
                }
            }
        }
        return count;
    }
}