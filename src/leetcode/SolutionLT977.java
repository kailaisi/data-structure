package leetcode;

/**
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 示例 2：
 * <p>
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序。
 * 双指针，找到中间0点，然后向两边遍历
 */
class SolutionLT977 {
    public int[] sortedSquares(int[] A) {
        int start = 0, end = 0;
        int length = A.length;
        while (end < length && A[end] < 0) {
            end++;
        }
        start = end - 1;
        int[] result = new int[length];
        int index = 0;
        while (start >= 0 && end < length) {
            if (A[start] * A[start] < A[end] * A[end]) {
                result[index] = A[start] * A[start];
                start--;
            } else {
                result[index] = A[end] * A[end];
                end++;
            }
            index++;
        }
        while (start >= 0) {
            result[index] = A[start] * A[start];
            start--;
            index++;
        }
        while (end < length) {
            result[index] = A[end] * A[end];
            end++;
            index++;
        }
        return result;
    }
}