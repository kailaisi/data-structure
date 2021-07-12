package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 739. 每日温度
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * <p>
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 * <p>
 * 解题思路：暴力法，两次迭代，依次往后找比当前数据大的数值
 * 时间复杂度：O（N2）：两次迭代
 * 空间复杂度：O（1）：未占用任何新的空间
 */
class LeetCode739 {
    public static void main(String[] args) {
        int[] ints = new LeetCode739().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        System.out.println(Arrays.toString(ints));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] ints = new int[length];
        for (int i = 0; i < length - 1; i++) {
            int j;
            for (j = i + 1; j < length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    ints[i] = j - i;
                    break;
                }
            }
            if (j==length+1){
                ints[i]=0;
            }
        }
        return ints;
    }
}
