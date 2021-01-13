package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给定一个排序好的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
 * <p>
 * 整数 a 比整数 b 更接近 x 需要满足：
 * <p>
 * |a - x| < |b - x| 或者
 * |a - x| == |b - x| 且 a < b
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,2,3,4,5], k = 4, x = 3
 * 输出：[1,2,3,4]
 * 示例 2：
 * <p>
 * 输入：arr = [1,2,3,4,5], k = 4, x = -1
 * 输出：[1,2,3,4]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= arr.length
 * 1 <= arr.length <= 104
 * 数组里的每个元素与 x 的绝对值不超过 104
 * <p>
 * 题解：合理使用Colloction的排序功能，将数组按照绝对值的大小进行排序，然后取钱k个值即可。
 * Colloction使用的二分排序，时间复杂度是nlogn。但是空间复杂度是k。因为需要k个数据
 */
class SolutionLT658 {
    public static void main(String[] args) {
        SolutionLT658 lt = new SolutionLT658();
        List<Integer> list = lt.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3);
        for (int j = 0; j < list.size(); j++) {
            System.out.println(list.get(j));
        }
        list = lt.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, -1);
        for (int j = 0; j < list.size(); j++) {
            System.out.println(list.get(j));
        }
        list = lt.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 6);
        for (int j = 0; j < list.size(); j++) {
            System.out.println(list.get(j));
        }
        list = lt.findClosestElements(new int[]{1, 2, 3, 3, 4, 7, 7, 8}, 3, 5);
        for (int j = 0; j < list.size(); j++) {
            System.out.println(list.get(j));
        }
    }

    //从数组中找到最靠近 x（两数之差最小）的 k 个数
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ret=Arrays.stream(arr).boxed().collect(Collectors.toList());
       Collections.sort(ret, new Comparator<Integer>() {
           @Override
           public int compare(Integer o1, Integer o2) {
               return o1.equals(o2) ?0:Math.abs(o1-x)-Math.abs(o2-x);
           }
       });
       ret=ret.subList(0,k);
       Collections.sort(ret);
       return ret;
    }

}