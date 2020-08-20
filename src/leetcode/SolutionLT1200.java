package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你个整数数组 arr，其中每个元素都 不相同。
 * <p>
 * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [4,2,1,3]
 * 输出：[[1,2],[2,3],[3,4]]
 * 示例 2：
 * <p>
 * 输入：arr = [1,3,6,10,15]
 * 输出：[[1,3]]
 * 示例 3：
 * <p>
 * 输入：arr = [3,8,-10,23,19,-4,-14,27]
 * 输出：[[-14,-10],[19,23],[23,27]]
 *  
 * <p>
 * 提示：
 * <p>
 * 2 <= arr.length <= 10^5
 * -10^6 <= arr[i] <= 10^6
 */
class SolutionLT1200 {

    public static void main(String[] args) {
        SolutionLT1200 lt = new SolutionLT1200();
        List<List<Integer>> lists = lt.minimumAbsDifference(new int[]{3, 8, -10, 23, 19, -4, -14, 27});
        System.out.println(lists.size());
    }

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        ArrayList<List<Integer>> lists = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            int i1 = arr[i + 1] - arr[i];
            if (i1 <= min) {
                if (i1 < min) {
                    lists.clear();
                }
                ArrayList<Integer> list = new ArrayList<>();
                list.add(arr[i]);
                list.add(arr[i + 1]);
                lists.add(list);
                min = i1;
            }
        }
        return lists;
    }
}