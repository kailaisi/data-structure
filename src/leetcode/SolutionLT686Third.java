package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 几乎每一个人都用 乘法表。但是你能在乘法表中快速找到第k小的数字吗？
 * <p>
 * 给定高度m 、宽度n 的一张 m * n的乘法表，以及正整数k，你需要返回表中第k 小的数字。
 * <p>
 * 例 1：
 * <p>
 * 输入: m = 3, n = 3, k = 5
 * 输出: 3
 * 解释:
 * 乘法表:
 * 1	2	3
 * 2	4	6
 * 3	6	9
 * <p>
 * 第5小的数字是 3 (1, 2, 2, 3, 3).
 * 例 2：
 * <p>
 * 输入: m = 2, n = 3, k = 6
 * 输出: 6
 * 解释:
 * 乘法表:
 * 1	2	3
 * 2	4	6
 * <p>
 * 第6小的数字是 6 (1, 2, 2, 3, 4, 6).
 * 解题思路：利用二分查找法。这里会对m*n=num，进行二分，然后找到小于mid的数据。然后不断的进行二分查找
 * 这里最关键的是如何查找小于mid的数据。
 * 乘法表有个规律，横向竖向的基数都是+1的。
 * 所以第一行的<mid的个数是   ：  mid/1   和n的最小值
 * 第二行的<mid的个数是       mid/2   和n的最小值。
 * 第i行的<mid的个数是：      mid/i    和n的最小值。
 * 直到第mid行。则只有1个数据。
 */
class SolutionLT686Third {

    public static void main(String[] args) {
        SolutionLT686Third lt = new SolutionLT686Third();
        System.out.println(lt.findKthNumber(3, 3, 5));
        System.out.println(lt.findKthNumber(2, 3, 6));
        System.out.println(lt.findKthNumber(3, 1, 2));
        System.out.println(lt.findKthNumber(42, 34, 401));
    }

    public int findKthNumber(int m, int n, int k) {
        int start = 1;
        int end = m * n;
        while (start < end) {
            int mid = start + (end - start) / 2;
            int count = getNum(m, n, mid);
            if (count < k) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    private int getNum(int m, int n, int mid) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(n, mid / i);
        }
        return count;
    }

}