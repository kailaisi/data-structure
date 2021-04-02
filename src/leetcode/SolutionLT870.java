package leetcode;

import javafx.util.Pair;

import java.util.*;

/**
 * 870. 优势洗牌
 * 给定两个大小相等的数组 A 和 B，A 相对于 B 的优势可以用满足 A[i] > B[i] 的索引 i 的数目来描述。
 * 返回 A 的任意排列，使其相对于 B 的优势最大化。
 * <p>
 * 示例 1：
 * 输入：A = [2,7,11,15], B = [1,10,4,11]
 * 输出：[2,11,7,15]
 * 示例 2：
 * <p>
 * 输入：A = [12,24,8,32], B = [13,25,32,11]
 * 输出：[24,32,8,12]
 * <p>
 * <p>
 * 提示：
 * 1 <= A.length = B.length <= 10000
 * 0 <= A[i] <= 10^9
 * 0 <= B[i] <= 10^9
 * 解题思路：为了能够获取最大的优势，可以将AB进行排序，然后只要A比B大，就算优势，否则就丢弃A中的前数据。这样就能保证每次都找到仅仅比B中的数字大一点的那个A中的数字
 * 因为要保证B的顺序，所以需要记录一下其在原来数组中的位置信息
 */
class SolutionLT870 {

    public static void main(String[] args) {
        SolutionLT870 lt = new SolutionLT870();
        System.out.println(lt.advantageCount(new int[]{2, 7, 11, 15}, new int[]{1, 10, 4, 11}));//[2,11,7,15]
        System.out.println(lt.advantageCount(new int[]{12, 24, 8, 32}, new int[]{13, 25, 32, 11}));//[24,32,8,12]
    }

    public int[] advantageCount(int[] A, int[] B) {
        int length = A.length;
        Arrays.sort(A);
        //排序的数组，key有序，value是原来的位置信息
        Pair<Integer, Integer>[] pair = new Pair[length];
        for (int i = 0; i < length; i++) {
            pair[i] = new Pair<>(B[i], i);
        }
        Arrays.sort(pair, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return o1.getKey() - o2.getKey();
            }
        });
        int indexA = 0;
        int indexB = 0;
        while (indexA < length) {
            if (A[indexA] > pair[indexB].getKey()) {//将该数值放入到B原来的位置
                B[pair[indexB].getValue()] = A[indexA];
                indexA++;
                indexB++;
            } else {//将该数字放入到什么位置呢？这时候因为A比B快，所以B末位的位置肯定会预留出来。只需要将这些数据放到到末尾位置即可。
                B[pair[length - (indexA - indexB + 1)].getValue()] = A[indexA];
                indexA++;
            }
        }
        return B;
    }
}
