package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 描述：乐扣350的
 * <p/>作者：wu
 * <br/>创建时间：2020/7/13 9:00
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 示例 1:
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 解题思路：通过多次遍历，将数组的数据先进行保存。
 */
class LtSolution350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        int len1 = nums1.length;
        int len2 = nums2.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len1; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }
        for (int i = 0; i < len2; i++) {
            int i1 = nums2[i];
            Integer integer = map.getOrDefault(i1, 0);
            if (integer >= 1) {
                list.add(i1);
                map.put(i1, integer - 1);
            }
        }
        int[] ints = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ints[i] = list.get(i);
        }
        return ints;
    }
}
