package leetcode;

import java.util.HashMap;
import java.util.Iterator;

/**
 * 给你一个整数 n 。请你先求出从 1 到 n 的每个整数 10 进制表示下的数位和（每一位上的数字相加），然后把数位和相等的数字放到同一个组中。
 * <p>
 * 请你统计每个组中的数字数目，并返回数字数目并列最多的组有多少个。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 13
 * 输出：4
 * 解释：总共有 9 个组，将 1 到 13 按数位求和后这些组分别是：
 * [1,10]，[2,11]，[3,12]，[4,13]，[5]，[6]，[7]，[8]，[9]。总共有 4 个组拥有的数字并列最多。
 * 示例 2：
 * <p>
 * 输入：n = 2
 * 输出：2
 * 解释：总共有 2 个大小为 1 的组 [1]，[2]。
 * 示例 3：
 * <p>
 * 输入：n = 15
 * 输出：6
 * 示例 4：
 * <p>
 * 输入：n = 24
 * 输出：5
 * <p>
 * 1 <= n <= 10^4
 * 数组
 * 解题思路：
 */
public class SolutionLT1399 {
    public static void main(String[] args) {
        int list = new SolutionLT1399().countLargestGroup(2);
        System.out.println(list);
    }

    public int countLargestGroup(int n) {
        int[] ints = new int[37];
        for (int i = 1; i <= n; i++) {
            int num = getNum(i);
            ints[num]++;
        }
        int count = 0;
        int max = 1;
        for (int i = 1; i < ints.length; i++) {
            if (ints[i] > max) {
                max = ints[i];
                count = 1;
            } else if (ints[i] == max) {
                count++;
            }
        }
        return count;
    }

    /**
     * 获取i的各个尾数的和
     *
     * @param i
     * @return
     */
    private int getNum(int i) {
        int num = 0;
        while (i >= 10) {
            num += i % 10;
            i = i / 10;
        }
        num += i;
        return num;
    }
}
