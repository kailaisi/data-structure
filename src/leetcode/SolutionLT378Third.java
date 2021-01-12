package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * matrix = [
 * [ 1,  5,  9],
 * [10, 11, 13],
 * [12, 13, 15]
 * ],
 * k = 8,
 * <p>
 * 返回 13。
 *  
 * <p>
 * 提示：
 * 你可以假设 k 的值永远是有效的，1 ≤ k ≤ n2 。
 * <p>
 * 题解：二分法。
 * 对于数组来说，由于每一行或者每一列都是有序的。每次通过二分法，找到mid值，然后计算比mid值小的数据，然后不断的减小范围。
 * 对于比mid小的数据的个数的计算。可以按照从左下角开始，向右，遇到比mid大的，则向上走，然后继续向右。
 *
 */
class SolutionLT378Third {
    public static void main(String[] args) {
        SolutionLT378Third lt = new SolutionLT378Third();
        System.out.println(lt.kthSmallest(new int[][]{{1,  5,  9}, {10, 11, 13}, {12, 13, 15}},8));
    }

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left=matrix[0][0];
        int right=matrix[n-1][n-1];
        while (left<right){//找到k位置
            int mid=left+(right-left)/2;
            if(check(matrix,mid,k,n)){
                right=mid;
            }else{
                left=mid+1;//这里可以使用mid+1，那么while循环条件就可以使用left<right
            }
        }
        return left;

    }

    private boolean check(int[][] matrix, int mid, int k, int n) {
        int i=n-1;
        int j=0;
        int num=0;
        while ((i>=0 && j<n)){
            if(matrix[i][j]<=mid){
                num+=i+1;//i+1列数据是满足条件的
                j++;
            }else{
                i--;
            }
            if(num>=k){
                return true;
            }
        }
        return num>=k;
    }
}