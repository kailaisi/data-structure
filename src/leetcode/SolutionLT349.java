package leetcode;

import java.sql.Array;
import java.util.*;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *  
 *
 * 说明：
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 *
 * 解题思路：先进行去重处理，用set进行保存，然后set保存的数据进行一次遍历，查看另一个是否存在。
 */
class SolutionLT349 extends GuessGame {

    public static void main(String[] args) {
        SolutionLT349 lt = new SolutionLT349();
        System.out.println(Arrays.toString(lt.rsection(new int[]{1,2,2,1},new int[]{2,2})));
        System.out.println(Arrays.toString(lt.rsection(new int[]{4,9,5},new int[]{9,4,9,8,4})));
    }

    public int[] rsection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int i=0;i<nums1.length;i++){
            set1.add(nums1[i]);
        }
        for (int j=0;j<nums2.length;j++){
            set2.add(nums2[j]);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i:set1){
            if(set2.contains(i)){
                list.add(i);
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
