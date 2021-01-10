package leetcode;

import java.util.*;

/**
 * 给你一个大小为 m * n 的矩阵 mat，矩阵由若干军人和平民组成，分别用 1 和 0 表示。
 * 请你返回矩阵中战斗力最弱的 k 行的索引，按从最弱到最强排序。
 * 如果第 i 行的军人数量少于第 j 行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。
 * 军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：mat =
 * [[1,1,0,0,0],
 * [1,1,1,1,0],
 * [1,0,0,0,0],
 * [1,1,0,0,0],
 * [1,1,1,1,1]],
 * k = 3
 * 输出：[2,0,3]
 * 解释：
 * 每行中的军人数目：
 * 行 0 -> 2
 * 行 1 -> 4
 * 行 2 -> 1
 * 行 3 -> 2
 * 行 4 -> 5
 * 从最弱到最强对这些行排序后得到 [2,0,3,1,4]
 * 示例 2：
 * <p>
 * 输入：mat =
 * [[1,0,0,0],
 *  [1,1,1,1],
 *  [1,0,0,0],
 *  [1,0,0,0]],
 * k = 2
 * 输出：[0,2]
 * 解释：
 * 每行中的军人数目：
 * 行 0 -> 1
 * 行 1 -> 4
 * 行 2 -> 1
 * 行 3 -> 1
 * 从最弱到最强对这些行排序后得到 [0,2,3,1]
 * <p>
 *
 * 题解思路：根据二分法找到对应的每行的值，然后进行排序。这里有个注意的如何排序。需要对map的value进行高低排序，返回对应的key信息。
 */
class SolutionLT1337 {

    public static void main(String[] args) {
        int[][] ints = new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}};
        ints = new int[][]{
                {1, 0},
                {0, 0},
                {1, 0}};
        ints = new int[][]{
                {1,1,1,1,1},
                {1,0,0,0,0},
                {1,1,0,0,0},
                {1,1,1,1,0},
                {1,1,1,1,1}};
        SolutionLT1337 lt = new SolutionLT1337();
        System.out.println(Arrays.toString(lt.kWeakestRows(ints, 3)));
    }


    public int[] kWeakestRows(int[][] mat, int k) {
        // TODO: 2021-01-10 未完成
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            // ints[i] = findLengh(mat[i]);
            map.put(i,findLengh(mat[i]));
        }
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue()-o2.getValue();
            }
        });
        int[] ints = new int[k];
        for (int i = 0; i <k; i++) {
            ints[i]=list.get(i).getKey();
        }
        return ints;
    }

    /**
     * 查找到数组的1的长度
     */
    private int findLengh(int[] ints) {
        int end = ints.length - 1;
        int start = 0;
        if(ints[start]==0){
            return 0;
        }

        if (ints[end]==1){
            return 1;
        }
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (ints[mid] == 1) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (ints[end] == 1) {
            return end + 1;
        } else {
            return start + 1;
        }
    }
}