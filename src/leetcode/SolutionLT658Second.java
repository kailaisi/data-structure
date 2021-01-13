package leetcode;

import java.util.ArrayList;
import java.util.List;

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
 * 题解：通过二分法找到找对应的最接近x的位置。然后向左向右去扩展，直到right-left=k为止
 */
class SolutionLT658Second {
    public static void main(String[] args) {
        SolutionLT658Second lt = new SolutionLT658Second();
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
        //todo 解决此问题
        list = lt.findClosestElements(new int[]{1, 2, 3, 3, 4, 7, 7, 8}, 3, 5);
        for (int j = 0; j < list.size(); j++) {
            System.out.println(list.get(j));
        }
    }

    //从数组中找到最靠近 x（两数之差最小）的 k 个数
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int postion = findClosestPostion(arr, x);
        int left = postion;
        int right = postion;
        while (right - left + 1 < k) {
            if (left == 0) {//如果已经到边界了，那么直接向左或者向右
                right++;
            } else if (right == arr.length - 1) {
                left--;
            } else {
                //这里我们应该判断的是下一个游标对应的数据，然后再移动。移动之后再比较的话，可能会造成3347->寻找5的时候，先找了7，然后再找3的情况
                if (find(arr, left - 1, right + 1, x) == left - 1) {
                    left--;
                } else {
                    right++;
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            list.add(arr[i]);
        }
        return list;
    }

    /**
     * 找到最接近k的positon位置
     */
    private int findClosestPostion(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;
        while (left + 1 < right) {
            int mid = (right + left) / 2;
            if (arr[mid] < k) {
                left = mid;
            } else
                right = mid;
        }
        return find(arr, left, right, k);
    }

    /**
     * 对比两个数据i1,i2哪个更接近k。返回
     */
    private int find(int[] arr, int i1, int i2, int k) {
        if (Math.abs(arr[i1] - k) > Math.abs(arr[i2] - k)) {
            return i2;
        } else if (Math.abs(arr[i1] - k) <= Math.abs(arr[i2] - k)) {
            return i1;
        } else {
            return i1 > i2 ? i2 : i1;
        }
    }
}