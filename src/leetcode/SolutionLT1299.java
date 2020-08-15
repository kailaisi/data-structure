package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给你一个数组 arr ，请你将每个元素用它右边最大的元素替换，如果是最后一个元素，用 -1 替换。
 * 完成所有替换操作后，请你返回这个数组。
 * 示例：
 * 输入：arr = [17,18,5,4,6,1]
 * 输出：[18,6,6,6,1,-1]
 * 提示：
 * 1 <= arr.length <= 10^4
 * 1 <= arr[i] <= 10^5
 * 解题思路：既然是右侧的最大元素，那么这里可以通过逆序来遍历。取右侧位置的最大值，然后记录下来，进行处理
 */
class SolutionLT1299 {
    ArrayList<Integer> list = new ArrayList<Integer>();
    int size = 0;

    public static void main(String[] args) {
        SolutionLT1299 lt = new SolutionLT1299();
        int[] ints = {17, 18, 5, 4, 6, 1};
        int[] elements = lt.replaceElements(ints);
        System.out.println(Arrays.toString(elements));
    }

    public int[] replaceElements(int[] arr) {
        if (arr.length == 0) {
            return arr;
        }
        int max = Integer.MIN_VALUE;
        int tmp = max;
        for (int i = arr.length - 1; i >= 0; i--) {
            tmp = max;//先将最大值记录下来
            max = Math.max(max, arr[i]);//更新最大值
            arr[i] = tmp;//将i位置变更为之前的最大值
            if (i == arr.length - 1) {
                arr[i] = -1;
            }
        }
        return arr;
    }
}