package leetcode;

/**
 * 我们把符合下列属性的数组 A 称作山脉：
 *
 * A.length >= 3
 * 存在 0 < i < A.length - 1 使得A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 * 给定一个确定为山脉的数组，返回任何满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 的 i 的值。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[0,1,0]
 * 输出：1
 * 示例 2：
 *
 * 输入：[0,2,1,0]
 * 输出：1
 *  
 *
 * 提示：
 *
 * 3 <= A.length <= 10000
 * 0 <= A[i] <= 10^6
 * A 是如上定义的山脉
 * 解题思路：暴力查找。
 */
class SolutionLT852Second {
    public static void main(String[] args) {
        SolutionLT852Second lt = new SolutionLT852Second();
        System.out.println(lt.peakIndexInMountainArray(new int[]{0,1,0}));
        System.out.println(lt.peakIndexInMountainArray(new int[]{0,1,2,0}));
        System.out.println(lt.peakIndexInMountainArray(new int[]{0,1,3,2,1,0}));
    }

    public int peakIndexInMountainArray(int[] arr) {
        int length = arr.length;
        for (int i=0;i<length-1;i++){
            if(arr[i+1]<arr[i]){
                return  i;
            }
        }
        return 0;
    }
}