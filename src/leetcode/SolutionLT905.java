package leetcode;

import java.util.Arrays;

/**
 * 给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
 * 你可以返回满足此条件的任何数组作为答案。
 * 示例：
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 * 解题思路：双指针方法。前后两个指针，前指针遇到奇数时停止，后指针遇到偶数时停止，然后二者交换数据，继续遍历，直到start<end为止
 */
class SolutionLT905 {

    public static void main(String[] args) {
        SolutionLT905 lt = new SolutionLT905();
        int[] ints = {3, 1, 2, 4};
        int[] ints1 = lt.sortArrayByParity(ints);
        System.out.println(Arrays.toString(ints1));

    }

    public int[] sortArrayByParity(int[] A) {
        int length = A.length;
        if (length < 2) {
            return A;
        }
        int start = 0;
        int end = length - 1;
        while (start < end) {
            if (A[start] % 2 == 0) {
                start++;
            } else if (A[end] % 2 == 1) {
                end--;
            } else {//这里证明start指向的位置是奇数，end指向的位置是偶数。交换二者的位置数据
                int temp = A[start];
                A[start] = A[end];
                A[end] = temp;
            }
        }
        return A;
    }
}