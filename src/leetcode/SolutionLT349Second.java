package leetcode;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

import java.util.*;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *  
 * <p>
 * 说明：
 * <p>
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 * <p>
 * 解题思路：双指针，先通过排序，然后数组用指针来指到对应的位置，判断是否相等。相等则两个指针都+1，否则就值低的那个数组的index+1操作。
 */
class SolutionLT349Second extends GuessGame {

    public static void main(String[] args) {
        SolutionLT349Second lt = new SolutionLT349Second();
        System.out.println(Arrays.toString(lt.rsection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(lt.rsection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }

    public int[] rsection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index1 = 0;
        int index2 = 0;
        Integer pre = null;
        ArrayList<Integer> list = new ArrayList<>();
        while (index1 < nums1.length && index2 < nums2.length) {
            int n1 = nums1[index1];
            int n2 = nums2[index2];
            if (n1 == n2) {
                if (pre == null || n2 != pre) {
                    list.add(n1);
                    pre = n2;
                }
                index1++;
                index2++;
            } else if (n1 < n2) {
                index1++;
            } else {
                index2++;
            }
        }
        int[] ints = new int[list.size()];
        int index=0;
        for (int i:list){
            ints[index++]=i;
        }
        return ints;
    }
}
