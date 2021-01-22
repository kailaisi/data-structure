package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 954. 二倍数对数组
 * 给定一个长度为偶数的整数数组 A，只有对 A 进行重组后可以满足 “对于每个 0 <= i < len(A) / 2，都有 A[2 * i + 1] = 2 * A[2 * i]” 时，返回 true；否则，返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3,1,3,6]
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：[2,1,2,6]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：[4,-2,2,-4]
 * 输出：true
 * 解释：我们可以用 [-2,-4] 和 [2,4] 这两组组成 [-2,-4,2,4] 或是 [2,4,-2,-4]
 * 示例 4：
 * <p>
 * 输入：[1,2,4,16,8,4]
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= A.length <= 30000
 * A.length 为偶数
 * -100000 <= A[i] <= 100000
 * <p>
 * 解题思路：按照数组的顺序逐个进行比较。我们需要记录每个启动顺序区间的start位置，对于end位置，则可以通过i和i-1位置的数字进行比较。如果不连续，则start->i-1位置是一个区间。
 * 遍历完成以后，那么需要进行最后一组数据的添加。
 * 这里，如果start==i-1和二者不相等时，输出的格式是不一样的
 * 时间复杂度：O(n)，一次遍历循环
 * 空间复杂度：O(1)，没有任何新空间的申请
 */
class SolutionLT954 {

    public static void main(String[] args) {
        SolutionLT954 lt = new SolutionLT954();
        System.out.println(lt.canReorderDoubled(new int[]{3,1,3,6}));//false
        System.out.println(lt.canReorderDoubled(new int[]{2,1,2,6}));//false
        System.out.println(lt.canReorderDoubled(new int[]{4,-2,2,-4}));//true
        System.out.println(lt.canReorderDoubled(new int[]{1,2,4,16,8,4}));//false
    }

    public boolean canReorderDoubled(int[] arr) {
        //todo 未完成
        HashMap<Double,Double> set = new HashMap<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            double num = arr[i];
        }
        return set.isEmpty();
    }

}
