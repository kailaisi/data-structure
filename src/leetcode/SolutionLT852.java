package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

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
 * 解题思路：通过二分法不断地去找中间点，根据中间点来判断。
 */
class SolutionLT852 {
    public static void main(String[] args) {
        SolutionLT852 lt = new SolutionLT852();
        System.out.println(lt.peakIndexInMountainArray(new int[]{0,1,0}));
        System.out.println(lt.peakIndexInMountainArray(new int[]{0,1,2,0}));
        System.out.println(lt.peakIndexInMountainArray(new int[]{0,1,3,2,1,0}));
    }

    public int peakIndexInMountainArray(int[] arr) {
        if(arr[0]>arr[1]){
            return 0;
        }
        int start=0;
        int end=arr.length-1;
        if(arr[end]>arr[end-1]){
            return end;
        }
        while (start+1<end){
            int mid=(start+end)/2;
            if(arr[mid-1]>arr[mid]){
                end=mid;
            }else{
                start=mid;
            }
        }
        if(arr[start]>arr[end]){
            return start;
        }else{
            return end;
        }
    }
}