package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * 870. 优势洗牌
 * 给定两个大小相等的数组 A 和 B，A 相对于 B 的优势可以用满足 A[i] > B[i] 的索引 i 的数目来描述。
 * 返回 A 的任意排列，使其相对于 B 的优势最大化。
 *
 * 示例 1：
 * 输入：A = [2,7,11,15], B = [1,10,4,11]
 * 输出：[2,11,7,15]
 * 示例 2：
 *
 * 输入：A = [12,24,8,32], B = [13,25,32,11]
 * 输出：[24,32,8,12]
 *
 *
 * 提示：
 * 1 <= A.length = B.length <= 10000
 * 0 <= A[i] <= 10^9
 * 0 <= B[i] <= 10^9
 * 解题思路：为了能够获取最大的优势，可以将AB进行排序，然后只要A比B大，就算优势，否则就丢弃A中的前数据
 */
class SolutionLT870 {

    public static void main(String[] args) {
        SolutionLT870 lt = new SolutionLT870();
        System.out.println(lt.advantageCount(new int[]{2,7,11,15},new int[]{1,10,4,11}));
        System.out.println(lt.advantageCount(new int[]{12,24,8,32},new int[]{13,25,32,11}));
    }

    public int[] advantageCount(int[] A, int[] B) {
        int[] AC=A.clone();
        int[] BC = B.clone();
        Arrays.sort(AC);
        Arrays.sort(BC);
        int length = A.length;
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> remain = new ArrayList<>();
        int indexA=0;
        int indexB=0;
        while (indexA<length){
            if (A[indexA]>B[indexB]){
                list.add(A[indexA]);
                indexA++;
                indexB++;
            }else{
                remain.add(A[indexA]);
                indexA++;
            }
        }
        list.addAll(remain);
        int[] ints = new int[length];
        for (int i = 0; i < list.size(); i++) {
            ints[i]=list.get(i);
        }
        return ints;
    }
}
