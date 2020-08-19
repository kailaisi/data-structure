package leetcode;

import java.util.HashMap;

/**
 * 给你一个整数数组 arr，请你检查是否存在两个整数 N 和 M，满足 N 是 M 的两倍（即，N = 2 * M）。
 * 更正式地，检查是否存在两个下标 i 和 j 满足：
 * i != j
 * 0 <= i, j < arr.length
 * arr[i] == 2 * arr[j]
 * 示例 1：
 * 输入：arr = [10,2,5,3]
 * 输出：true
 * 解释：N = 10 是 M = 5 的两倍，即 10 = 2 * 5 。
 * 示例 2：
 * 输入：arr = [7,1,14,11]
 * 输出：true
 * 解释：N = 14 是 M = 7 的两倍，即 14 = 2 * 7 。
 * 示例 3：
 * 输入：arr = [3,1,7,11]
 * 输出：false
 * 解释：在该情况下不存在 N 和 M 满足 N = 2 * M 。
 * 提示：
 * 2 <= arr.length <= 500
 * -10^3 <= arr[i] <= 10^3
 *
 * 解题思路：通过hashmap记录对应的2倍或者一半的值信息
 */
public class SolutionLT1346 {
    public static void main(String[] args) {
        int[] ints = new int[]{3,1,7,11};
        System.out.println(new SolutionLT1346().checkIfExist(ints));
    }

    public boolean checkIfExist(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) != null) {
                return true;
            }
            map.put(2 * arr[i], i);
            if(arr[i]%2==0) {
                map.put(arr[i]/2, i);
            }
        }
        return false;
    }
}
